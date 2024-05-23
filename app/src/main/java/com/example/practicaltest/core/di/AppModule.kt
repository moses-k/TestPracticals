package com.coopbank.mcoopcash.HiltUtils

import android.content.Context
import com.example.practicaltest.HttpClient.ProductServiceImpl
import com.example.practicaltest.repository.ProductServices
import com.example.practicaltest.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

//@dagger.Module


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideProductService(
        httpClient: HttpClient,
    ): ProductServices = ProductServiceImpl(httpClient)

    @Singleton
    @Provides
    fun provideHttpClient(
    ): HttpClient {
        val baseUrl = BASE_URL
        return HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(DefaultRequest) {
                url(baseUrl)
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
            install(ContentNegotiation) {
                json(Json)
            }
        }
    }
}

