package com.example.alecsandra.library;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewMyFavoriteBooks extends AppCompatActivity {

    /**
     * Mock data
     * TODO: AC - 1) create a mock with class book
     * TODO: AC - 2) delete the mock
     * TODO: AC - 3) use real data
     */
    ListView booksView;
    private String[][] booksAndAuthors = {
            {"book1", "author1"},
            {"book2", "author2"},
            {"book3", "author3"}
    };
    ArrayList<HashMap<String,String>> booksList = new ArrayList<HashMap<String,String>>();
    private SimpleAdapter bookListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_favorite_books);

        HashMap<String,String> book;
        for(int i=0;i<booksAndAuthors.length;i++){
            book = new HashMap<String,String>();
            book.put( "book_title", booksAndAuthors[i][0]);
            book.put( "book_author", booksAndAuthors[i][1]);
            booksList.add( book );
        }
        booksView = (ListView)findViewById(R.id.favoritesBooksListId);
        bookListAdapter = new SimpleAdapter(this, booksList,
                R.layout.twoline_layout_for_books_lists,
                new String[] { "book_title","book_author" },
                new int[] {R.id.first_line, R.id.second_line});
        booksView.setAdapter(bookListAdapter);
        // Register the ListView  for Context menu
        registerForContextMenu(booksView);
    }

    @Override
    //TODO: AC - read more about ContextMenu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select an action");
        menu.add(0, v.getId(), 0, "View description");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "Delete from favorites");
        menu.add(0, v.getId(), 0, "Delete from library");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle() == "View description"){
            Toast.makeText(getApplicationContext(),"View description",Toast.LENGTH_LONG).show();
            //TODO: AC - redirect to a page with book description
        } else if(item.getTitle() == "Delete from favorites") {
            Toast.makeText(getApplicationContext(),"Delete from favorites",Toast.LENGTH_LONG).show();
            //TODO: AC - implement add to favorites option
        } else if(item.getTitle() == "Delete from library") {
            Toast.makeText(getApplicationContext(),"Delete from library",Toast.LENGTH_LONG).show();
            //TODO: AC - implement delete from list option
        } else {
            return false;
        }
        return true;
    }
}
