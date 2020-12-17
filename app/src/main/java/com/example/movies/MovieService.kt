package com.example.movies

import com.example.movies.models.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("nikoloz14/movies-db/movies")
    fun getMovies(): Call<List<Movie>>

    @GET("nikoloz14/movies-db/movies/{id}")
    fun getMovie(@Path(value="id", encoded = true) id: String): Call<Movie>
}