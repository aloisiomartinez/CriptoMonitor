package com.aloisio.criptomonitor.cripto.data.mappers

import com.aloisio.criptomonitor.cripto.data.network.dto.CoinDto
import com.aloisio.criptomonitor.cripto.domain.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}