package com.example.movies.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Cast (
    val id: Int,
    val fullName: String,
    val role: String,
    val imageUrl: String
    ): Parcelable