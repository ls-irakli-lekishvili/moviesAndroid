package com.example.movies.landingPage

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.models.Movie
import com.squareup.picasso.Picasso

class MovieListAdapter(
    private val list: List<Movie>
): RecyclerView.Adapter<MovieListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, null)
        return MovieListViewHolder(view, parent.context);
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.setContent(list[position])
    }

    override fun getItemCount(): Int = list.size
}

class MovieListViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {
    private val movieImage = itemView.findViewById<ImageView>(R.id.movie_image)
    private val movieName = itemView.findViewById<TextView>(R.id.movie_name)

    fun setContent(movieInfo: Movie) {
        Picasso.with(context)
            .load(movieInfo.imageUrl)
            .into(movieImage)

        movieName.setTextColor(Color.parseColor("#ff00ff"))
        movieName.text = movieInfo.title
    }

}