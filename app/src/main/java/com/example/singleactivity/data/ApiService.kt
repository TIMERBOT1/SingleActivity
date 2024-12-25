package com.example.singleactivity.data
import retrofit2.http.GET
import retrofit2.Call
import java.util.Objects

data class CharacterResp(val results: List<Character>)

interface CharacterApiService{
    @GET("character/")
    suspend fun getChars(): CharacterResp

    @GET("character/")
    suspend fun getChars1(): Unit
}