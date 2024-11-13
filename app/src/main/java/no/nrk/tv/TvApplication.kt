package no.nrk.tv

import android.app.Application
import no.nrk.tv.di.appModule
import no.nrk.tv.di.dataBaseModule
import no.nrk.tv.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class TvApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@TvApplication)
            modules(networkModule, dataBaseModule, appModule)
        }
    }
}