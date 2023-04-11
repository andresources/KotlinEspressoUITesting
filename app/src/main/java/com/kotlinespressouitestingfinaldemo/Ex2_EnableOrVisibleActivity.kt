package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Ex2_EnableOrVisibleActivity : AppCompatActivity() {
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex2_enable_or_visible)
        tv = findViewById(R.id.tv)
    }

    fun ClickMe(view: View) {
        tv.visibility = View.VISIBLE
    }
}