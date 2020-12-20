package com.example.movies.detailPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class DetailsViewPagerAdapter(fragmentManager: FragmentManager, val movieId: Int) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        val bundle = Bundle()
            .apply {
                putInt("movieId", movieId)
            }
        return when (position) {
            0 -> InfoFragment().apply {
                arguments = bundle
            }
            else -> CastFragment().apply {
                arguments = bundle
            }
        }
    }
    override fun getPageTitle(position: Int): CharSequence =
        when (position) {
            0 -> "INFO"
            else -> "CAST"
        }

}