package com.kotlinespressouitestingfinaldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ex10BackbuttonPressedActivity : AppCompatActivity() {
    private lateinit var button_next_activity : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex10_backbutton_pressed)
        button_next_activity = findViewById(R.id.button_next_activity)
        button_next_activity.setOnClickListener {
            val intent = Intent(this, Ex10BackbuttonPressedSecondActivity::class.java)
            startActivity(intent)
        }
    }
}