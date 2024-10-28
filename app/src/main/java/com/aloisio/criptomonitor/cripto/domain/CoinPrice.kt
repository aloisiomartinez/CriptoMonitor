package com.aloisio.criptomonitor.cripto.domain

import java.time.ZonedDateTime

data class CoinPrice (
    val priceUsd: Double,
    val dateTime: ZonedDateTime
)