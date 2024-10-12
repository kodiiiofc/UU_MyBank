package com.kodiiiofc.urbanuniversity.mybank

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var mainCL: ConstraintLayout
    private lateinit var introVP2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        introVP2 = findViewById(R.id.vp2_intro)
        val adapter = ViewPagerIntroAdapter(this, IntroViewModel.list)
        introVP2.adapter = adapter

    }
}