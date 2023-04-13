package com.kotlinespressouitestingfinaldemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.kotlinespressouitestingfinaldemo.R
import com.kotlinespressouitestingfinaldemo.model.Book


/**
 * Adapter that provides views for the list
 */
class BookAdapter(context: Context?, items: ArrayList<Book>) : BaseAdapter() {

    private val items: ArrayList<Book>
    private lateinit var context : Context
    init {
        this.items = items
        if (context != null) {
            this.context = context
        }
        //inflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false)
       // var convertView = inflater.inflate(R.layout.item_book, parent, false)

        val bookTitle = convertView.findViewById<View>(R.id.book_title) as TextView
        bookTitle.setText(items[position].title)
        val bookAuthor = convertView.findViewById<View>(R.id.book_author) as TextView
        bookAuthor.text = "by " + items[position].author
        return convertView
    }
}