package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class Ex3_EditTextActivity : AppCompatActivity() {
    private lateinit var etName:EditText
    private lateinit var tvDisplayName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex3_edit_text)
        etName = findViewById(R.id.etName)
        tvDisplayName= findViewById(R.id.tvDisplayName)
    }

    fun onSubmitClick(view: View) {
       // etName.setText("Bhav")
        tvDisplayName.text = etName.text.toString()
    }
}