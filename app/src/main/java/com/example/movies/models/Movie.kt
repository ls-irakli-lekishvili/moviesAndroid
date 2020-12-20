package com.example.movies.models

data class Movie (
    val id: Int,
    val title: String,
    val date: String,
    val language: String,
    val seasons: Int,
    val imageUrl: String,
    val cast: List<Cast>
        )