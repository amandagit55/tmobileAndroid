package com.example.composelist.repository

import com.example.composelist.network.CardRetrofitService
//Adding repository to allow for caching in future
open class Repository(val apiService: CardRetrofitService) {
    open suspend fun getCards() = apiService.getCardsAsync()
}