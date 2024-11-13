package no.nrk.tv.di

import android.app.Application
import androidx.room.Room
import no.nrk.tv.data.local.AppDatabase
import no.nrk.tv.data.local.dao.DirectDao
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun provideDatabase(application: Application): AppDatabase =
    Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "tv-app-database"
    ).build()

fun provideDirectDao(appDatabase: AppDatabase): DirectDao = appDatabase.directDao()

val dataBaseModule = module {
    singleOf(::provideDatabase)
    singleOf(::provideDirectDao)
}