package com.example.alecsandra.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * Called when the user clicks LOGIN button
     * Validate the user credentials
     */
    public void validateCredentials(View view)
    {

        //create a new intent
        Intent goToHomePage = new Intent(this, ViewHomePage.class);

        //get input data
        EditText usernameText = (EditText) findViewById(R.id.usernameId);
        String username = usernameText.getText().toString();

        EditText passwordText = (EditText) findViewById(R.id.passwordId);
        String password = passwordText.getText().toString();

        //perform user credential verification
        //mock verification - TODO: AC - replace mock verification with real one
        if(username.equals("ale") && password.equals("123")) {
            //go to home page
            startActivity(goToHomePage);
        } else {
            //alert a failure message
            //display Toast with error message
            Toast.makeText(getApplicationContext(),
                    "Incorrect credentials! Try again!",
                    Toast.LENGTH_SHORT
            ).show();
            //put empty strings as default for username & password
            //TODO - AC - version 1
//            usernameText.setText("");
//            passwordText.setText("");
            //TODO - AC - version 1

            //TODO - AC - version 2
            usernameText.getText().clear();
            passwordText.getText().clear();
        }

    }
}
