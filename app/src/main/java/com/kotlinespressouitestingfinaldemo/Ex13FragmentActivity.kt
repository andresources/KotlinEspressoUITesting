package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ex13FragmentActivity : AppCompatActivity() {
    private lateinit var btnSubmit : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex13_fragment)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl, Ex13MyFragment(), "TAG")
                .addToBackStack("TAG")
                .commit();
        }
    }
}