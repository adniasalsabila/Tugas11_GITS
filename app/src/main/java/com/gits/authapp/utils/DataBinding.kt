package com.gits.authapp.utils

import android.widget.ImageView
import com.gits.authapp.model.DataMovieTvshow

interface DataBinding {
    fun setBinding(data: DataMovieTvshow)
    fun multipleGlide(firstImage: ImageView, secondImage: ImageView, data: DataMovieTvshow)
}