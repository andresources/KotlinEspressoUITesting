package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.afollestad.materialdialogs.MaterialDialog

class Ex12DialogBoxActivity : AppCompatActivity() {
    private lateinit var btnShowDialog : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex12_dialog_box)
        btnShowDialog = findViewById(R.id.btnShowDialog)
        btnShowDialog.setOnClickListener {
            showDialog()
        }
    }
    private fun showDialog(){
        MaterialDialog(this)
            .show {
                title(R.string.text_title_of_dialog)
                message(R.string.text_some_information)
                positiveButton(R.string.text_ok)
            }
    }
}