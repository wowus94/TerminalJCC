package ru.shevrus.terminaljcc.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("aggs/ticker/AAPL/range/{timeFrame}/2022-01-09/2024-01-09?adjusted=true&sort=desc&limit=50000&apiKey=kBUxto5bbygKNiBSyfpAO3KjTHsTsqDy")
    suspend fun loadBars(
        @Path("timeFrame") timeFrame: String
    ): Result
}