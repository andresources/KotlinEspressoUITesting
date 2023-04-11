package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class Ex5_ToastMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex5_toast_message)
    }

    fun showToast(view: View) {
        Toast.makeText(applicationContext,"This is toast",Toast.LENGTH_LONG).show()
    }
}