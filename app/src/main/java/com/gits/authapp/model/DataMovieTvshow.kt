package com.gits.authapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataMovieTvshow(
    var id: Int? = 0,
    var tittle: String? = null,
    var rating: String? = null,
    var genre: String? = null,
    var overview: String? = null,
    var poster: Int? = 0,
): Parcelable