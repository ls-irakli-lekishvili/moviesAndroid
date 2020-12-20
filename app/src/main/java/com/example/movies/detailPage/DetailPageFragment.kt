package com.example.movies.detailPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.movies.MainActivity
import com.example.movies.R
import com.example.movies.models.Movie
import com.google.android.material.tabs.TabLayout
import kotlin.properties.Delegates

class DetailPageFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val movieId = requireArguments().getInt("movieId")
        val viewPager = view.findViewById<ViewPager>(R.id.details_view_pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)

        val activity = context as MainActivity
        val adapter = DetailsViewPagerAdapter(activity.supportFragmentManager, movieId)
        viewPager.adapter = adapter

        tabLayout.setupWithViewPager(viewPager)
    }
}