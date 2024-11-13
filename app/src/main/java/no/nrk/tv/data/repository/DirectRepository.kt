package no.nrk.tv.data.repository

import android.util.Log
import no.nrk.tv.common.TAG
import no.nrk.tv.data.asExternalModel
import no.nrk.tv.data.asLocalModel
import no.nrk.tv.data.local.DirectLocalDataSource
import no.nrk.tv.data.model.LiveItemModel
import no.nrk.tv.data.network.DirectNetworkDataSource
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class DirectRepository(
    private val directLocalDataSource: DirectLocalDataSource,
    private val directNetworkDataSource: DirectNetworkDataSource,
) {
    private val MAX_UPDATE_AGE_MINUTES = 5L
    private var updatedAt: LocalDateTime? = null

    suspend fun getFeed(): Result<List<LiveItemModel>> {
        if (isStale()) {
            sync()
                .onSuccess {
                    Log.d(TAG, "Feed synchronized")
                }
                .onFailure {
                    Log.e(TAG, "Unable to synchronize feed", it)
                    return Result.failure(it)
                }
        }

        return directLocalDataSource.getFeed().map { list -> list.map { it.asExternalModel() } }
    }

    suspend fun sync(): Result<Unit> {
        return runCatching {
            return directNetworkDataSource.fetchFeed()
                .map { feed ->
                    val feedLocalList = feed.map { it.asLocalModel() }
                    directLocalDataSource.deleteAll()
                    directLocalDataSource.insertAll(feedLocalList)
                    updatedAt = LocalDateTime.now()
                }
        }
    }

    suspend fun isStale(): Boolean {
        val hasLocalData = directLocalDataSource.hasFeed()

        val lastUpdated =
            if (updatedAt == null) MAX_UPDATE_AGE_MINUTES
            else ChronoUnit.MINUTES.between(updatedAt, LocalDateTime.now())

        return !hasLocalData || lastUpdated >= MAX_UPDATE_AGE_MINUTES
    }
}