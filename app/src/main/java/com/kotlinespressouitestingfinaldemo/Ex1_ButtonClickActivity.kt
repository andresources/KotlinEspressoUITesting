package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Ex1_ButtonClickActivity : AppCompatActivity() {
    private lateinit var preferred_language: TextView
    private lateinit var english: Button
    private lateinit var german: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferred_language = findViewById(R.id.preferred_language)
        english = findViewById(R.id.english)
        german = findViewById(R.id.german)
        english.setOnClickListener {
            preferred_language.text = "English"
        }
        german.setOnClickListener {
            preferred_language.text = "German"
        }
    }

   /* fun onClick(view: View) {
        when(view.id){
            R.id.english ->
                preferred_language.text = "English"
            R.id.french -> preferred_language.text = "French"
            R.id.german -> preferred_language.text = "German"
            R.id.hindi -> preferred_language.text = "Hindi"
            R.id.urdu -> preferred_language.text = "Urdu"
        }
    }*/
}