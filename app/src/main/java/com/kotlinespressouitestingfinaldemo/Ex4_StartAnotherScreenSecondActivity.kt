package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Ex4_StartAnotherScreenSecondActivity : AppCompatActivity() {
    private lateinit var tvName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex4_start_another_screen_second)
        tvName = findViewById(R.id.tvName)
        tvName. text = "KSR"
    }
}