package com.aloisio.criptomonitor.cripto.data.mappers

import com.aloisio.criptomonitor.cripto.data.network.dto.CoinDto
import com.aloisio.criptomonitor.cripto.data.network.dto.CoinPriceDto
import com.aloisio.criptomonitor.cripto.domain.Coin
import com.aloisio.criptomonitor.cripto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

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

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant.ofEpochMilli(time).atZone(ZoneId.of("UTC"))
    )
}