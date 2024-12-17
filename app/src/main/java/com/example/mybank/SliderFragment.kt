package com.example.mybank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SliderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_slider, container, false)

        val title = arguments?.getString("title")
        val description = arguments?.getString("description")
        val imageRes = arguments?.getInt("imageRes")
        val isLastSlide = arguments?.getBoolean("isLastSlide") ?: false
        view.findViewById<TextView>(R.id.titleTextView).text = title
        view.findViewById<TextView>(R.id.descriptionTextView).text = description
        view.findViewById<ImageView>(R.id.imageView).setImageResource(imageRes ?: 0)

        val startButton = view.findViewById<Button>(R.id.startButton)
        if (isLastSlide) {
            startButton.visibility = View.VISIBLE
            startButton.setOnClickListener {
                findNavController().navigate(R.id.action_slider_to_registration)
            }
        } else {
            startButton.visibility = View.GONE
        }

        return view
    }
}