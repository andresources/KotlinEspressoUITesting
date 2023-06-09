package com.kotlinespressouitestingfinaldemo.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.kotlinespressouitestingfinaldemo.BookDetailsActivity;
import com.kotlinespressouitestingfinaldemo.Database;
import com.kotlinespressouitestingfinaldemo.R;
import com.kotlinespressouitestingfinaldemo.model.Book;


/**
 * The adapter used by RecyclerView to display books.
 *
 * @author vgrec, created on 3/30/15.
 */
public class RecyclerBooksAdapter extends RecyclerView.Adapter<RecyclerBooksAdapter.RowHolder> {

    private LayoutInflater inflater;

    public RecyclerBooksAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RowHolder(inflater.inflate(R.layout.item_book, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RowHolder rowHolder, int i) {
        rowHolder.bindModel(Database.ALL_BOOKS.get(i));
    }

    @Override
    public int getItemCount() {
        return Database.ALL_BOOKS.size();
    }

    public static class RowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTextView;
        TextView authorTextView;

        public RowHolder(View row) {
            super(row);
            titleTextView = (TextView) row.findViewById(R.id.book_title);
            authorTextView = (TextView) row.findViewById(R.id.book_author);
            row.setOnClickListener(this);
        }

        public void bindModel(Book book) {
            titleTextView.setText(book.getTitle());
            authorTextView.setText(book.getAuthor());
        }

        @Override
        public void onClick(View v) {
            Book book = Database.ALL_BOOKS.get(getPosition());

            Intent intent = new Intent(v.getContext(), BookDetailsActivity.class);
            intent.putExtra("title", book.getTitle());
            intent.putExtra("author", book.getAuthor());
            v.getContext().startActivity(intent);
        }
    }
}
