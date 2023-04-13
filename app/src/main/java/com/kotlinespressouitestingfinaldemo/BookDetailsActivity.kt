package com.kotlinespressouitestingfinaldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BookDetailsActivity : AppCompatActivity() {
    private lateinit var book_title : TextView
    private lateinit var book_author : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        book_title = findViewById(R.id.book_title)
        book_author = findViewById(R.id.book_author)
        book_title.setText(intent.getStringExtra("title"))
        book_author.setText(intent.getStringExtra("author"))
    }
}