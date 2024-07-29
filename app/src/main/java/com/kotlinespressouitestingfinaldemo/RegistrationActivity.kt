package com.kotlinespressouitestingfinaldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegistrationActivity : AppCompatActivity() {
    lateinit var etUserName: EditText
    lateinit var btnSubmit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        etUserName = findViewById(R.id.etUserName)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
        var intent = Intent(this,DashboardActivity::class.java)
            intent.putExtra("uname",etUserName.text.toString())
            startActivity(intent)
        }

    }
}