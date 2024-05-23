package com.example.practicaltest.HttpClient

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.content.TextContent
import io.ktor.http.encodedPath
import io.ktor.util.InternalAPI
import timber.log.Timber

sealed class NetworkResult<T>(
    val data: T? = null,
    val error: String? = null,
    val loading: Boolean = false,
    val unauthorized: String? = null
) {
    class Success<T>(result: T) : NetworkResult<T>(data = result)
    class Error<T>(error: String) : NetworkResult<T>(error = error)
    class Unauthorized<T>(errorMessage: String) : NetworkResult<T>(unauthorized = errorMessage)

}

@OptIn(InternalAPI::class)
suspend fun httpRequest(
    url: String,
    httpMethod: HttpMethod,
    requestBody: String?,
    httpClient: HttpClient
): HttpResponse {
    val request = HttpRequestBuilder()
    request.url {
        encodedPath = url
    }
    request.method = httpMethod // Set the HTTP method (e.g., GET, POST, etc.)
    if (httpMethod == HttpMethod.Post) {
        request.body = TextContent(requestBody!!, ContentType.Application.Json)
    }
    Timber.tag("Get Products Request").w("Get Products Request "+request)

    return httpClient.request(request)
}