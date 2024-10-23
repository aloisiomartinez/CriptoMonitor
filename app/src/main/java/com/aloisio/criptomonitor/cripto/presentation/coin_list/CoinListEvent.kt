package com.aloisio.criptomonitor.cripto.presentation.coin_list

import com.aloisio.criptomonitor.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}