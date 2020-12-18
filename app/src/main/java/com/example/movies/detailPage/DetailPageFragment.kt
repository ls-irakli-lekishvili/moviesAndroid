package com.example.movies.detailPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.movies.MainActivity
import com.example.movies.R
import com.example.movies.models.Movie

class DetailPageFragment: Fragment() {
    lateinit var movieInfo: Movie
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        movieInfo = arguments?.getParcelable<Movie>("movieData") as Movie
        return inflater.inflate(R.layout.detail_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val activity = context as MainActivity
        val viewPager = view.findViewById<ViewPager>(R.id.details_view_pager)
        val adapter = DetailsViewPagerAdapter(activity.supportFragmentManager)
        viewPager.adapter = adapter

        val text = view.findViewById<TextView>(R.id.testing)
        text.text = movieInfo.title
    }
}