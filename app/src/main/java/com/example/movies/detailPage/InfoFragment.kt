package com.example.movies.detailPage

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.movies.MainActivity.RetrofitBuilder.retrofit
import com.example.movies.MovieService
import com.example.movies.R
import com.example.movies.models.Movie
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoFragment : Fragment(R.layout.detail_page_info) {
    private val TAG: String = "getMovieError"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = arguments?.getInt("movieId") as Int
        getMovieByID(movieId)
    }

    private fun getMovieByID(movieId: Int) {
        val movieService = retrofit.create(MovieService::class.java)
        movieService.getMovie(movieId.toString()).enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful) {
                    response.body()?.let {
                        showMovieInfo(it)
                    }
                }
            }
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.e(TAG, t.message.toString())
            }
        })
    }

    private fun showMovieInfo(movie: Movie) {
        view?.let {
            val imageView = it.findViewById<ImageView>(R.id.movie_image_big)
            val originalTitleResult = it.findViewById<TextView>(R.id.original_title_result)
            val releaseDateResult = it.findViewById<TextView>(R.id.release_date_result)
            val languageResult = it.findViewById<TextView>(R.id.language_result)
            val seasonResult = it.findViewById<TextView>(R.id.season_result)


            Picasso.with(context)
                .load(movie.imageUrl)
                .into(imageView)

            originalTitleResult.text = movie.title
            releaseDateResult.text = movie.date
            languageResult.text = movie.language
            seasonResult.text = movie.seasons.toString()

        }


    }

}