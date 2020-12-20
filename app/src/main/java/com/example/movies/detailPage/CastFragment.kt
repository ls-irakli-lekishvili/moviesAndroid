package com.example.movies.detailPage

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.MainActivity
import com.example.movies.MovieService
import com.example.movies.R
import com.example.movies.models.Cast
import com.example.movies.models.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CastFragment : Fragment(R.layout.detail_page_cast) {
    private val TAG: String = "getMovieError"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = arguments?.getInt("movieId") as Int
        getMovieByID(movieId)
    }

    private fun getMovieByID(movieId: Int) {
        val movieService = MainActivity.RetrofitBuilder.retrofit.create(MovieService::class.java)
        movieService.getMovie(movieId.toString()).enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful) {
                    response.body()?.let {
                        attachAdapter(it.cast)
                    }
                }
            }
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.e(TAG, t.message.toString())
            }
        })
    }

    private fun attachAdapter(cast: List<Cast>) {
        view?.let {
            val recyclerView = it.findViewById<RecyclerView>(R.id.recycler_view_cast_page)
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = CastListAdapter(cast)
        }
    }
}