package com.aloisio.criptomonitor.cripto.presentation.coin_list

import com.aloisio.criptomonitor.cripto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
}