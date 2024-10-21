package com.aloisio.criptomonitor.cripto.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aloisio.criptomonitor.core.domain.util.onError
import com.aloisio.criptomonitor.core.domain.util.onSuccess
import com.aloisio.criptomonitor.cripto.domain.CoinDataSource
import com.aloisio.criptomonitor.cripto.presentation.coin_list.CoinListAction
import com.aloisio.criptomonitor.cripto.presentation.coin_list.CoinListState
import com.aloisio.criptomonitor.cripto.presentation.models.toCoinUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoinListViewModel(
    private val coinDataSource: CoinDataSource
) : ViewModel() {

    private val _state = MutableStateFlow(CoinListState())
    val state = _state
        .onStart { loadCoins() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            CoinListState()
        )


    fun onAction(action: CoinListAction) {
        when(action) {
            is CoinListAction.OnCoinClick -> {

            }

        }
    }

    private fun loadCoins() {
        viewModelScope.launch {
            _state.update { it.copy(
                isLoading = true
            ) }

            coinDataSource
                .getCoins()
                .onSuccess { coins ->
                    _state.update { it.copy(
                        isLoading = false,
                        coins = coins.map { it.toCoinUi() }
                    ) }
                }
                .onError { error ->
                    _state.update { it.copy(isLoading = false) }
                }
        }
    }
}
