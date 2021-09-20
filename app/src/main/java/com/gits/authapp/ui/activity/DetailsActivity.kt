package com.gits.authapp.ui.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.gits.authapp.R
import com.gits.authapp.model.DataMovieTvshow
import com.gits.authapp.ui.movie.MovieFragment.Companion.CLICK_MOVIE
import com.gits.authapp.ui.movie.MovieViewModel
import com.gits.authapp.ui.tvShow.TvShowFragment.Companion.CLICK_TV_SHOW
import com.gits.authapp.ui.tvShow.TvShowViewModel
import com.gits.authapp.utils.DataBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity(), DataBinding {
    companion object {
        const val ID = "id"
        const val TITTLE = "tittle"
        const val CLICK = "click"
    }

    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        collapseToolbarConfiguration()

        val movieViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
        val tvShowViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]

        when (intent.getIntExtra(CLICK, 0)) {
            CLICK_MOVIE -> setBinding(movieViewModel.detailMovie(intent.getIntExtra(ID, 0))!!)
            CLICK_TV_SHOW -> setBinding(tvShowViewModel.detailTvShow(intent.getIntExtra(ID, 0))!!)

        }
    }

    private fun collapseToolbarConfiguration() {
        collapsingToolbarLayout = findViewById(R.id.collapseToolbar)
        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            if (collapseToolbar.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(collapsingToolbarLayout)) {
                collapseToolbar.setCollapsedTitleTextColor(Color.BLACK)
                toolbar.apply {
                    setBackgroundColor(Color.WHITE)
                    title = intent.getStringExtra(TITTLE)
                    visibility = View.VISIBLE
                }
            } else {
                collapseToolbar.setExpandedTitleColor(Color.BLACK)
                toolbar.setBackgroundColor(Color.TRANSPARENT)
                toolbar.visibility = View.GONE
            }
        })
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    override fun setBinding(data: DataMovieTvshow) {
        multipleGlide(header_poster, poster, data)
        view_title.text = data.tittle
        rating.text = data.rating
        genre.text = data.genre
        view_overview.text = data.overview
    }

    override fun multipleGlide(
        firstImage: ImageView,
        secondImage: ImageView,
        data: DataMovieTvshow
    ) {
        Glide.with(this).load(data.poster).into(firstImage)
        Glide.with(this).load(data.poster).into(secondImage)
    }
}