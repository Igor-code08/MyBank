package com.example.mybank

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SliderAdapter(
    fragmentActivity: FragmentActivity,
    private val slides: List<SlideModel>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = slides.size

    override fun createFragment(position: Int): Fragment {
        val fragment = SliderFragment()
        fragment.arguments = Bundle().apply {
            putString("title", slides[position].title)
            putString("description", slides[position].description)
            putInt("imageRes", slides[position].imageRes)
            putBoolean("isLastSlide", position == slides.size - 1)
        }
        return fragment
    }
}