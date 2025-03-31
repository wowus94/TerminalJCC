package ru.shevrus.terminaljcc.data

import retrofit2.http.GET

interface ApiService {

    @GET("aggs/ticker/AAPL/range/1/day/2022-01-09/2024-01-09?adjusted=true&sort=desc&limit=50000&apiKey=kBUxto5bbygKNiBSyfpAO3KjTHsTsqDy")
    suspend fun loadBars(): Result
}