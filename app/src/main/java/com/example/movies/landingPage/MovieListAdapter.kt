package com.example.movies.landingPage

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.MainActivity
import com.example.movies.R
import com.example.movies.detailPage.DetailPageFragment
import com.example.movies.models.Movie
import com.squareup.picasso.Picasso

class MovieListAdapter(
    private val list: List<Movie>
) : RecyclerView.Adapter<MovieListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, null)
        return MovieListViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.setContent(list[position])
    }

    override fun getItemCount(): Int = list.size
}

class MovieListViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {
    private val movieImage = itemView.findViewById<ImageView>(R.id.movie_image)
    private val movieName = itemView.findViewById<TextView>(R.id.movie_name)

    fun setContent(movieInfo: Movie) {
        val width = Resources.getSystem().displayMetrics.widthPixels

        Picasso.with(context)
            .load(movieInfo.imageUrl)
            .resize(width, 500)
            .into(movieImage)

        movieName.setTextColor(Color.parseColor("#ff00ff"))
        movieName.text = movieInfo.title

        setClickEvent(movieInfo)
    }

    private fun setClickEvent(movieInfo: Movie) {
        movieImage.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("movieId", movieInfo.id)
            }
            val fragment = DetailPageFragment()
            fragment.arguments = bundle
            val activity = context as MainActivity
            activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

}