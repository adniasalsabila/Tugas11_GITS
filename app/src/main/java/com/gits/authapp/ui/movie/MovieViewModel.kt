package com.gits.authapp.ui.movie

import androidx.lifecycle.ViewModel
import com.gits.authapp.model.DataMovieTvshow
import com.gits.authapp.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovie(): List<DataMovieTvshow> = DataDummy.getMovie()
    fun detailMovie(id: Int): DataMovieTvshow? = DataDummy.movieDetail(id)
}