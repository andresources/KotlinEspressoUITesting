package com.kotlinespressouitestingfinaldemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Ex18ActionBarActivity : AppCompatActivity() {
    private lateinit var textView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex18_action_bar)
        textView = findViewById(R.id.textView)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_action_bar_example, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item : MenuItem): Boolean {
        when(item.itemId){
            R.id.action_settings -> textView.setText("Settings")
            R.id.action_about -> textView.setText("About")
        }
        return super.onOptionsItemSelected(item);
    }
}