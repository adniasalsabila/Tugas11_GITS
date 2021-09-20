package com.gits.authapp.ui.adapter

import android.content.Intent
import android.os.Build.ID
import android.view.LayoutInflater
import android.view.SoundEffectConstants.CLICK
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gits.authapp.R
import com.gits.authapp.model.DataMovieTvshow
import com.gits.authapp.ui.activity.DetailsActivity
import com.gits.authapp.ui.activity.DetailsActivity.Companion.CLICK
import com.gits.authapp.ui.activity.DetailsActivity.Companion.TITTLE
import kotlinx.android.synthetic.main.item_list.view.*

class DataAdapter(private val adapterId: Int) : RecyclerView.Adapter<DataAdapter.ListViewHolder>() {
    private var data = ArrayList<DataMovieTvshow>()

    fun setData(list: List<DataMovieTvshow>) {
        data.clear()
        data.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DataAdapter.ListViewHolder, position: Int) {
        val data = data[position]
        holder.bind(data)
    }

    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: DataMovieTvshow) {
            itemView.apply {
                Glide.with(itemView).load(data.poster).into(poster_list_data)
                view_tittle.text = data.tittle
                view_rating.text = data.rating
                view_genre.text = data.genre
                itemView.setOnClickListener {
                    val intent = Intent(context, DetailsActivity::class.java).apply {
                        putExtra(ID, data.id)
                        putExtra(TITTLE, data.tittle)
                        putExtra(DetailsActivity.CLICK, adapterId)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}

