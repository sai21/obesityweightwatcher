package com.example.tuan.obesityweightwatcher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.tuan.obesityweightwatcher.data.AppDbHelper;

import com.example.tuan.obesityweightwatcher.data.AppContract.AppEntry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    /**
     * Database helper that will provide us access to the database
     */
    private AppDbHelper mDbHelper;

    // User name
    private EditText et_Username;
    // Password
    private EditText et_Password;

    int LoginMassage = 0;

    SharedPreferences sharedpreferences;

    public static final String mypreference = "mypref";

    public static final String Name = "nameKey";






    String FileName = "myFile";
    Button BtnSave, BtnRead;
    EditText editName;
    TextView readName;
    String name;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Initialization
        et_Username = (EditText) findViewById(R.id.userName);
        et_Password = (EditText) findViewById(R.id.passward);



        //button sign up
        Button signIn = (Button) findViewById(R.id.sign_in);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        mDbHelper = new AppDbHelper(this);

        //button log in
        Button logIn = (Button) findViewById(R.id.login);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Stores User name
                String username = et_Username.getText().toString();
                // Stores Password
                String password = et_Password.getText().toString();







                // Validates the User name and Password for admin, admin
                if (mDbHelper.varification(username, password)) {
                    //toast message

                    saveFile();
                    Intent intent = new Intent(MainActivity.this, MainMenu.class);
                    intent.putExtra("USERNAME",username);
                    startActivity(intent);
                    finish();

                    Toast.makeText(getApplicationContext(), "Welcome " + username, Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getApplicationContext(), "User name and Password is not match.", Toast.LENGTH_SHORT).show();
                }

            }
        });



        ////////
        //saveFile();
        //readFile();


    }

    /*
    public void login(){
        String username = et_Username.getText().toString();
        String pass = et_Password.getText().toString();
        if(mDbHelper.varification(username,pass)){
            Intent getUserDetail = new Intent(MainActivity.this,MainMenu.class);
            startActivity(getUserDetail);
            finish();
        }else{
            Toast.makeText(this,"Wrong....",Toast.LENGTH_LONG).show();
        }
    }
    */

    @Override
    protected void onStart() {
        super.onStart();

        //Toast.makeText(this, "Hello ", Toast.LENGTH_LONG).show();
    }

    private void readFile() {
        try {
            File file = new File(getCacheDir(), FileName);
            FileInputStream fin = new FileInputStream(file);

            InputStreamReader inputStream = new InputStreamReader(fin);
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            fin.close();
            inputStream.close();

            //readName.setText("Name: " + stringBuilder.toString());
            Toast.makeText(this, "Data Retrieved :" + stringBuilder.toString(), Toast.LENGTH_SHORT).show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }


    private void saveFile() {
        try { //To append the Data in the File use Context.MODE_APPEND
            File file = new File(getCacheDir(),FileName);
            FileOutputStream fos = new FileOutputStream(file);

            name = et_Username.getText().toString();

            fos.write(name.getBytes());
            fos.close();
            //Toast.makeText(this, "Data Saved in cache is :" + name, Toast.LENGTH_SHORT).show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }

    /*
    private void mycache() {

        //////my own cache file/////
        // Create database helper
        AppDbHelper mDbHelper = new AppDbHelper(this);
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        //create ContentValue
        ContentValues values = new ContentValues();
        values.put(AppEntry.COLUMN_USER_NAME, username);
        values.put(AppEntry.COLUMN_USER_PASSWORD, cachepass);

        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(AppEntry.TABLE_NAME, null, values);
        ////////////////////////////

        Toast.makeText(this, "Data Saved in cache is :" + username, Toast.LENGTH_SHORT).show();
    }
    */







}



/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnSave = (Button) findViewById(R.id.idBtnSave);
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        BtnRead = (Button) findViewById(R.id.idBtnRead);
        BtnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        editName = (EditText) findViewById(R.id.idName);
        readName = (TextView) findViewById(R.id.idReadtxt);
    }
*/





