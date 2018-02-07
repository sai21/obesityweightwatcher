package com.example.tuan.obesityweightwatcher;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.tuan.obesityweightwatcher.data.AppDbHelper;

import com.example.tuan.obesityweightwatcher.data.AppContract.AppEntry;

/**
 * Created by tuan on 13/5/2017.
 */

public class SignUp extends AppCompatActivity {

    /** Database helper that will provide us access to the database */
    private AppDbHelper mDbHelper;

    private EditText mNameEditText;

    private EditText mPasswordText;

    private EditText mRePasswordText;

    int errorMessage = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        // Find all relevant views that we will need to read user input from
        mNameEditText = (EditText) findViewById(R.id.newUserName);
        mPasswordText = (EditText) findViewById(R.id.newPassword);
        mRePasswordText = (EditText) findViewById(R.id.reNewPassword);

        // read from input field
        final String nameString = mNameEditText.getText().toString().trim();
        final String passwordString = mPasswordText.getText().toString().trim();
        final String rePasswordString = mRePasswordText.getText().toString().trim();

        // setup register button
        Button fab = (Button) findViewById(R.id.register);
        fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        Intent intent = new Intent(SignUp.this, MainActivity.class);
                        startActivity(intent);
                        saveUser();
                        finish();
                }
        });



    }

    private void saveUser() {

        // read from input field
        String nameString = mNameEditText.getText().toString().trim();
        String passwordString = mPasswordText.getText().toString().trim();

        // Create database helper
        AppDbHelper mDbHelper = new AppDbHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        //create ContentValue
        ContentValues values = new ContentValues();
        values.put(AppEntry.COLUMN_USER_NAME, nameString);
        values.put(AppEntry.COLUMN_USER_PASSWORD, passwordString);

        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(AppEntry.TABLE_NAME, null, values);

        //toast message
        Toast.makeText(this,nameString +", your registration is accepted. Please enter your user name and password.", Toast.LENGTH_SHORT).show();


    }

}
