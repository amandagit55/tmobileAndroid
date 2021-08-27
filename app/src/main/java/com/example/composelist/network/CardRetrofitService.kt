package com.example.composelist.network

import com.example.composelist.model.CardResponse
import com.example.composelist.util.ConstantStrings.Companion.EP
import com.example.composelist.util.ConstantStrings.Companion.URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CardRetrofitService {
    @GET(EP)
    suspend fun getCardsAsync(): CardResponse

    companion object{

        val cardService = createRetrofitInstance().create(CardRetrofitService::class.java)

        private fun createRetrofitInstance() = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}