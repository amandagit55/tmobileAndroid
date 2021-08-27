package com.example.composelist

import com.example.composelist.repository.Repository

class TestRepo(apiService: TestNetworkService) : Repository(apiService) {
    override suspend fun getCards() = apiService.getCardsAsync()
}