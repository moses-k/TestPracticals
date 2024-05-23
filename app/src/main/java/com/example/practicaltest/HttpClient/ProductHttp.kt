package com.example.practicaltest.HttpClient

import com.example.practicaltest.dataclass.Post
import com.example.practicaltest.repository.ProductServices
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.HttpClient
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class ProductServiceImpl @Inject constructor(
    private val httpClient: HttpClient,
) : ProductServices {
    override suspend fun getAllProducts():Flow<NetworkResult<List<Post>>> {
        return flow {
            Timber.tag("inside getCountries").w("inside getCountries")
            try {
                val response = httpRequest("/posts", HttpMethod.Get, null, httpClient)
                Timber.tag("Get Products Response").w(response.bodyAsText())

                if (response.status == HttpStatusCode.OK) {

                    val type = object : TypeToken<List<Post>>() {}.type
                    val data: List<Post> = Gson().fromJson(response.bodyAsText(), type)
                    emit(NetworkResult.Success(data))

                }

            } catch (e: Exception) {
                e.printStackTrace()
                Timber.tag("error in getCountries").w(e.toString())
            }
        }
    }

    override suspend fun getProductById(postId: String): Flow<NetworkResult<Post>> {
        return flow {
            Timber.tag("inside getCountries").w("inside getCountries")
            try {
                val response = httpRequest("/posts", HttpMethod.Get, null, httpClient)
                Timber.tag("Get Products Response").w(response.bodyAsText())

                if (response.status == HttpStatusCode.OK) {

                    val type = object : TypeToken<Post>() {}.type
                    val data: Post = Gson().fromJson(response.bodyAsText(), type)
                    emit(NetworkResult.Success(data))

                }

            } catch (e: Exception) {
                e.printStackTrace()
                Timber.tag("error in getCountries").w(e.toString())
            }
        }
    }

}

