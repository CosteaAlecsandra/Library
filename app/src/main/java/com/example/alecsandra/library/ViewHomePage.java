package com.example.alecsandra.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ViewHomePage extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    /**
     * Called when user clicks VIEW MY BOOKS button
     * Redirect user to ViewBooks page
     */
    public void goToMyLibraryPage(View view)
    {
        //create new intent
        Intent goToViewBooksPage = new Intent(this, ViewBooks.class);
        startActivity(goToViewBooksPage);
    }

    /**
     * Called when user clicks ADD NEW BOOK button
     * Redirect user to AddNewBook page
     */
    public void goToAddNewBookPage(View view)
    {
        //create new intent
        Intent goToAddNewBookPage = new Intent(this, AddNewBook.class);
        startActivity(goToAddNewBookPage);
    }

    /**
     * Called when user clicks SEARCH BOOKS button
     * Redirect user to SearchBook page
     */
    public void goToSearchBookPage(View view)
    {
        //create new intent
        Intent goToSearchBookPage = new Intent(this, SearchBook.class);
        startActivity(goToSearchBookPage);
    }

    /**
     * Called when user clicks LOGOUT button
     * Logout and redirect the user to Login page
     */
    public void logout(View view)
    {
        //create a new intent
        Intent logout = new Intent(this, LoginActivity.class);
        startActivity(logout);
        //TODO: AC - here I think that I still need to do something more, not only the redirect
    }

    /**
     * Called when user clicks TRY OCR FROM IMG button
     * Redirect the user to ocrFromImage page
     */
    public void tryOcrFromImg(View view)
    {
        //create new intent
        Intent tryOcrFromImg = new Intent(this, ocrFromImage.class);
        startActivity(tryOcrFromImg);

    }
}
