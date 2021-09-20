package com.gits.authapp.ui.tvShow

import androidx.lifecycle.ViewModel
import com.gits.authapp.model.DataMovieTvshow
import com.gits.authapp.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvshow(): List<DataMovieTvshow> = DataDummy.getTvshow()
    fun detailTvShow(id: Int): DataMovieTvshow? = DataDummy.tvShowDetail(id)
}