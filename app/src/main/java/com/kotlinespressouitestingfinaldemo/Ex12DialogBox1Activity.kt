package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Ex12DialogBox1Activity : AppCompatActivity() {
    private lateinit var btnShowDialog: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex12_dialog_box)
        btnShowDialog = findViewById(R.id.btnShowDialog)
        btnShowDialog.setOnClickListener {
            showDialog()
        }
    }

    fun showDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("This is title")
        builder.setMessage("This is message")

        builder.setPositiveButton("Yes") { dialog, which ->
            Toast.makeText(applicationContext, android.R.string.yes, Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton("No") { dialog, which ->
            dialog.dismiss()
        }

        builder.setNeutralButton("Maybe") { dialog, which ->
            Toast.makeText(applicationContext,
                "Maybe", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }
}