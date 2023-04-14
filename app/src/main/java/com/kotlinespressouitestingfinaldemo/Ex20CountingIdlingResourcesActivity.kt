package com.kotlinespressouitestingfinaldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Ex20CountingIdlingResourcesActivity : AppCompatActivity() {
    private lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex20_counting_idling_resources)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@Ex20CountingIdlingResourcesActivity, WelcomeActivity::class.java)
            CountingIdlingResourceSingleton.increment()
            // I am using a kotlin coroutine to simulate a 3 second network request:
            val job = GlobalScope.launch {
                // our network call starts
                delay(3000)
            }
            job.invokeOnCompletion {
                // our network call ended!
                CountingIdlingResourceSingleton.decrement()
                startActivity(intent)
            }
        }
    }
}