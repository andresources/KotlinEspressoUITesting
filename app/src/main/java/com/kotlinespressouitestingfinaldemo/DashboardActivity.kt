package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
    lateinit var tvDetails: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        tvDetails = findViewById(R.id.tvDetails)
        tvDetails.text = "Welcome "+intent.getStringExtra("uname")
    }
}