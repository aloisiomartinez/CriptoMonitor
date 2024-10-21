package com.aloisio.criptomonitor.cripto.data.network

import com.aloisio.criptomonitor.core.data.network.constructUrl
import com.aloisio.criptomonitor.core.data.network.safeCall
import com.aloisio.criptomonitor.core.domain.util.NetworkError
import com.aloisio.criptomonitor.core.domain.util.Result
import com.aloisio.criptomonitor.core.domain.util.map
import com.aloisio.criptomonitor.cripto.data.mappers.toCoin
import com.aloisio.criptomonitor.cripto.data.network.dto.CoinsResponseDto
import com.aloisio.criptomonitor.cripto.domain.Coin
import com.aloisio.criptomonitor.cripto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {

    override suspend fun getCoin(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets"),
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }
}