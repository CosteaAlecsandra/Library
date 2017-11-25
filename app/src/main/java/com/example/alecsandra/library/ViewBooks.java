package com.example.alecsandra.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ViewBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_books);
    }

    /**
     * Called when user clicks FAVORITES BOOKS button
     * Redirect user to ViewMyFavoriteBooks
     * @param view
     */
    public void goToMyFavoritesBooksPage(View view)
    {
        //create new intent
        Intent goToMyFavoritesBooksPage = new Intent(this, ViewMyFavoriteBooks.class);
        startActivity(goToMyFavoritesBooksPage);
    }

    public void goToAllBooksPage(View view)
    {
        //create new intent
        Intent goToAllBooksPage = new Intent(this, ViewAllBooks.class);
        startActivity(goToAllBooksPage);
    }
}
