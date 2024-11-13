package no.nrk.tv.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import no.nrk.tv.data.local.model.LiveItemLocalModel

@Dao
interface DirectDao {
    @Query("SELECT * FROM liveitem")
    suspend fun getAll(): List<LiveItemLocalModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<LiveItemLocalModel>)

    @Query("DELETE FROM liveitem")
    suspend fun deleteAll()

    @Query("SELECT COUNT(uid) FROM liveitem")
    suspend fun getCount(): Int
}