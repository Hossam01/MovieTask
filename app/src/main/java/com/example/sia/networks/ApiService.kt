package com.example.sia.data.networks

import com.example.sia.model.MovieModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("movies")
    fun getMovies(): Single<MovieModel>
}