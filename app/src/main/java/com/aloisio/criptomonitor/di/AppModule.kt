package com.aloisio.criptomonitor.di

import com.aloisio.criptomonitor.core.data.network.HttpClientFactory
import com.aloisio.criptomonitor.cripto.data.network.RemoteCoinDataSource
import com.aloisio.criptomonitor.cripto.domain.CoinDataSource
import com.aloisio.criptomonitor.cripto.presentation.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single {  HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}