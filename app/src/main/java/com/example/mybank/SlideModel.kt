package com.example.mybank

import java.io.Serializable

data class SlideModel(
    val title: String,
    val description: String,
    val imageRes: Int
): Serializable