package com.aloisio.criptomonitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aloisio.criptomonitor.cripto.presentation.coin_list.CoinListScreen
import com.aloisio.criptomonitor.cripto.presentation.coin_list.CoinListState
import com.aloisio.criptomonitor.cripto.presentation.coin_list.components.previewCoin
import com.aloisio.criptomonitor.ui.theme.CryptoMonitorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoMonitorTheme {
                val coinsMock = CoinListState(
                    coins = (1..100).map {
                        previewCoin.copy(id = it.toString())
                    }
                )

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoinListScreen(state = coinsMock, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CryptoMonitorTheme {
        Greeting("Android")
    }
}