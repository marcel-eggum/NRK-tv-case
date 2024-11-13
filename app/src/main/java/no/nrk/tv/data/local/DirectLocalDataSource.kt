package no.nrk.tv.data.local

import no.nrk.tv.data.local.dao.DirectDao
import no.nrk.tv.data.local.model.LiveItemLocalModel

class DirectLocalDataSource(
    private val directDao: DirectDao
) {
    suspend fun getFeed(): Result<List<LiveItemLocalModel>> {
        return runCatching {
            return Result.success(directDao.getAll())
        }
    }

    suspend fun hasFeed(): Boolean {
        return directDao.getCount() > 0
    }

    suspend fun insertAll(items: List<LiveItemLocalModel>): Result<Boolean> {
        return runCatching {
            directDao.insertAll(items)
            return Result.success(true)
        }
    }

    suspend fun deleteAll(): Result<Boolean> {
        return runCatching {
            directDao.deleteAll()
            return Result.success(true)
        }
    }
}