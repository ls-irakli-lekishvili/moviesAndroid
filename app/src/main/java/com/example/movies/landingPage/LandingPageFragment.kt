package com.example.movies.landingPage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.MainActivity.RetrofitBuilder.retrofit
import com.example.movies.MovieService
import com.example.movies.R
import com.example.movies.models.Movie
import retrofit2.Callback

class LandingPageFragment : Fragment() {
    private val TAG: String = "getMovieError"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.landing_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val movies = getMovies()
    }

    private fun getMovies(){
        val movieService = retrofit.create(MovieService::class.java)
        movieService.getMovies().enqueue(object : Callback<List<Movie>> {
            override fun onFailure(call: retrofit2.Call<List<Movie>>, t: Throwable) {
                Log.e(TAG, t.message.toString())
            }

            override fun onResponse(
                call: retrofit2.Call<List<Movie>>,
                response: retrofit2.Response<List<Movie>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        showMovies(it)
                    }
                } else {
                    Toast.makeText(activity, "response error", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun showMovies(movies: List<Movie>) {
        view?.let {
            val recyclerView = it.findViewById<RecyclerView>(R.id.recycler_view_main_page)
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = MovieListAdapter(movies)
        }

    }

}