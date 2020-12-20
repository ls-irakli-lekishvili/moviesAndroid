package com.example.movies.detailPage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.models.Cast
import com.squareup.picasso.Picasso

class CastListAdapter(
    private val casts: List<Cast>
): RecyclerView.Adapter<CastListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_cast, null)
        return CastListViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: CastListViewHolder, position: Int) {
        holder.setData(casts[position])
    }

    override fun getItemCount(): Int = casts.size
}


class CastListViewHolder(itemView: View, private val context: Context): RecyclerView.ViewHolder(itemView) {
    private val actorImage = itemView.findViewById<ImageView>(R.id.actor_image)
    private val actorRealName = itemView.findViewById<TextView>(R.id.actor_real_name)
    private val actorMovieName = itemView.findViewById<TextView>(R.id.actor_in_movie_name)

    fun setData(cast: Cast) {
        Picasso.with(context)
            .load(cast.imageUrl)
            .into(actorImage)

        actorRealName.text = cast.fullName
        actorMovieName.text = cast.role

    }
}