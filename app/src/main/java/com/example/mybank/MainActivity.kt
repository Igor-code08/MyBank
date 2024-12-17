package com.example.mybank

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        // Список данных для слайдера
        val slides = listOf(
            SlideModel("Добро пожаловать", "Приложение вашего банка", R.drawable.image1),
            SlideModel("Удобство", "Управляйте финансами легко", R.drawable.image2),
            SlideModel("Начнем работу!", "Нажмите кнопку ниже", R.drawable.image3)
        )

        // Установка адаптера
        val adapter = SliderAdapter(this, slides)
        viewPager.adapter = adapter
    }
}