package com.carolinac.lifedogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carolinac.lifedogapp.repository.LifeDogRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}