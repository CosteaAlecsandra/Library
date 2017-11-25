package com.example.alecsandra.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewAllBooks extends AppCompatActivity {

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
            {"book3", "author3"},
            {"book4", "author4"},
            {"book5", "author5"},
            {"book6", "author6"},
            {"book7", "author7"},
            {"book8", "author8"},
            {"book9", "author9"},
            {"book10", "author10"},
            {"book11", "author11"},
            {"book12", "author12"},
            {"book13", "author13"},
            {"book14", "author14"},
            {"book15", "author15"},
    };
    ArrayList<HashMap<String,String>> booksList = new ArrayList<HashMap<String,String>>();
    private SimpleAdapter bookListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_books);
        HashMap<String,String> book;
        for(int i=0;i<booksAndAuthors.length;i++){
            book = new HashMap<String,String>();
            book.put( "book_title", booksAndAuthors[i][0]);
            book.put( "book_author", booksAndAuthors[i][1]);
            booksList.add( book );
        }
        booksView = (ListView)findViewById(R.id.allBooksListId);
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
        menu.add(0, v.getId(), 0, "Add to favorites");
        menu.add(0, v.getId(), 0, "Delete from library");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle() == "View description"){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            TextView textView = (TextView) info.targetView.findViewById(R.id.first_line);
            String text = textView.getText().toString();
            Toast.makeText(getApplicationContext(),"View description",Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
            //TODO: AC - redirect to a page with book description
        } else if(item.getTitle() == "Add to favorites") {
            Toast.makeText(getApplicationContext(),"Add to favorites",Toast.LENGTH_LONG).show();
            //TODO: AC - implement add to favorites option
        } else if(item.getTitle() == "Delete from library") {
            Toast.makeText(getApplicationContext(),"Delete from library",Toast.LENGTH_LONG).show();
            //TODO: AC - implement delete from list option
        } else {
            return false;
        }
        return true;


        //first solution to select a certain item info
        //AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
//        switch (item.getItemId()) {
//            case R.id.add:
//                TextView textView = (TextView) info.targetView.findViewById(R.id.yourItem);
//                String text = textView.getText().toString();
//                Toast.makeText(getApplicationContext(), "Selected " + text, Toast.LENGTH_LONG).show();
//            default:
//                return super.onContextItemSelected(item);
//        }
    }
}
