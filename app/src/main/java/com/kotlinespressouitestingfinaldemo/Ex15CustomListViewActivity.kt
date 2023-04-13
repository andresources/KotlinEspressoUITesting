package com.kotlinespressouitestingfinaldemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.kotlinespressouitestingfinaldemo.adapters.BookAdapter
import com.kotlinespressouitestingfinaldemo.model.Book

class Ex15CustomListViewActivity : AppCompatActivity() {
    var list= ArrayList<Book>()
    private lateinit var lv: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex15_custom_list_view)
        lv = findViewById(R.id.lv)
        prepareData()
        if(list!=null&&list.size>0) {
            lv.setAdapter(BookAdapter(this, list))
        }
        lv.setOnItemClickListener(object : OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val intent = Intent(this@Ex15CustomListViewActivity,BookDetailsActivity::class.java).apply {
                    putExtra("title",list.get(position).title)
                    putExtra("author",list.get(position).author)
                }
                startActivity(intent)
            }

        })
    }
    fun prepareData(){
        list.add(Book(1, "Clean Code", "Robert C. Martin"))
        list.add(Book(2, "The Clean Coder", "Robert C. Martin"))
        list.add(Book(3, "Code Complete 2", "Steve McConnell"))
        list.add(Book(4, "Effective Java ", "Joshua Bloch"))
        list.add(Book(9, "Refactoring: Improving the Design of Existing Code", "Martin Fowler"))
        list.add(Book(5, "Java Concurrency in Practice", "Brian Goetz"))
        list.add(Book(6, "Essential Algorithms", "Rod Stephens"))
        list.add(Book(7, "Algorithms", "Robert Sedgewick"))
        list.add(Book(8, "The Passionate Programmer", "Chad Fowler"))
        list.add(Book(10, "The Pragmatic Programmer", "Andrew Hunt"))
        list.add(Book(11, "Seven Languages in Seven Weeks", "Bruce A. Tate"))
        list.add(Book(12, "The Ruby Programming Language", "David Flanagan"))
        list.add(Book(13, "Agile Web Development with Rails 4 ", "Sam Ruby"))
    }
}