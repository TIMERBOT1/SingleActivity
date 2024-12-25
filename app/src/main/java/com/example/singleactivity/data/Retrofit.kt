package com.example.singleactivity.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Character(
    var id: Int,
    var name: String,
    var status: String
)

data class Characters(
    val results: List<Character>
)

const val BASE_URL = "https://rickandmortyapi.com/api/"

interface APIService {
    @GET("character")
    suspend fun getTodos(): Characters

    companion object {
        var apiService: APIService? = null
        fun getInstance(): APIService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService::class.java)
            }
            return apiService!!
        }
    }
}