package com.example.projectakhirdicoding

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Comic(
    val name: String,
    val description: String,
    val photo: String,
    val type: String,
    val author: String,
    val genre: String
) :Parcelable
