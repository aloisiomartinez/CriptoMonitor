package com.aloisio.criptomonitor.cripto.domain

import com.aloisio.criptomonitor.core.domain.util.NetworkError
import com.aloisio.criptomonitor.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}