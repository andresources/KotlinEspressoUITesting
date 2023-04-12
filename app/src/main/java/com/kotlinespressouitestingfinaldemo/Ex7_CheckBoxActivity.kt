package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Toast

class Ex7_CheckBoxActivity : AppCompatActivity() {
    private lateinit var cb1 : CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex7_check_box)
        cb1 = findViewById(R.id.cb1)
        cb1.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this,isChecked.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}