package no.nrk.tv.data.network

import android.util.Log
import no.nrk.tv.api.DirectApi
import no.nrk.tv.common.TAG
import no.nrk.tv.data.network.model.LiveItemNetworkModel

class DirectNetworkDataSource(
    private val directApi: DirectApi
) {
    suspend fun fetchFeed(): Result<List<LiveItemNetworkModel>> {
        return runCatching {
            val directNetworkModel = directApi.getDirectFeed()
            return Result.success(directNetworkModel.liveItems)
        }.onFailure {
            Log.e(TAG, it.message, it)
        }
    }
}