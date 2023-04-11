package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class Ex3_EditTextActivity : AppCompatActivity() {
    private lateinit var etName:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex3_edit_text)
        etName = findViewById(R.id.etName)
    }

    fun onSubmitClick(view: View) {
        etName.setText("Bhav")
    }
}