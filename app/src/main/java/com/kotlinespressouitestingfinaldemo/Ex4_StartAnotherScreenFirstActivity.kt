package com.kotlinespressouitestingfinaldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Ex4_StartAnotherScreenFirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex4_start_another_screen_first)
    }

    fun ClickMe(view: View) {
        startActivity( Intent(applicationContext,Ex4_StartAnotherScreenSecondActivity::class.java))
    }
}