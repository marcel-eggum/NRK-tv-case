package no.nrk.tv.di

import org.koin.core.module.dsl.singleOf
import no.nrk.tv.data.network.DirectNetworkDataSource
import no.nrk.tv.data.local.DirectLocalDataSource
import no.nrk.tv.data.repository.DirectRepository
import no.nrk.tv.ui.direct.DirectViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::DirectNetworkDataSource)
    singleOf(::DirectLocalDataSource)
    singleOf(::DirectRepository)

    viewModelOf(::DirectViewModel)
}