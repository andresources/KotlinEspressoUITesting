package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Ex1_ButtonClickActivity : AppCompatActivity() {
    private lateinit var preferred_language: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferred_language = findViewById(R.id.preferred_language)
    }

    fun onClick(view: View) {
        when(view.id){
            R.id.english -> preferred_language.text = "English"
            R.id.french -> preferred_language.text = "French"
            R.id.german -> preferred_language.text = "German"
            R.id.hindi -> preferred_language.text = "Hindi"
            R.id.urdu -> preferred_language.text = "Urdu"
        }
    }
}