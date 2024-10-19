package com.aloisio.criptomonitor.core.data.network

import com.aloisio.criptomonitor.core.domain.util.NetworkError
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> responseToResult(response:HttpResponse) :Result<T, NetworkError> {
    return when(response.status.value) {
        in 200..299 -> {

        }
    }
}