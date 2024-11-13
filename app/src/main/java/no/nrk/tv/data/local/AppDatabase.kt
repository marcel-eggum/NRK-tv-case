package no.nrk.tv.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import no.nrk.tv.data.local.dao.DirectDao
import no.nrk.tv.data.local.model.LiveItemLocalModel

@Database(entities = [LiveItemLocalModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun directDao(): DirectDao
}