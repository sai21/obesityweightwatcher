package com.example.tuan.obesityweightwatcher.data;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.widget.Toast;

import com.example.tuan.obesityweightwatcher.data.AppContract.AppEntry;

import com.example.tuan.obesityweightwatcher.data.AppDbHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;

/**
 * Created by tuan on 13/5/2017.
 */

public class AppDbHelper extends SQLiteOpenHelper {


    /////file read cache file////
    String FileName = "myFile";
    Button BtnRead;
    /////////////////////////////



    public static final String LOG_TAG = AppDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;



    /**
     * Constructs a new instance of {@link AppDbHelper}.
     *
     * @param context of the app
     */
    public AppDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + AppEntry.TABLE_NAME + " ("
                + AppEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                //+ AppEntry.TYPE_USER_DATA + " TEXT, "
                + AppEntry.COLUMN_USER_NAME + " TEXT, "
                + AppEntry.COLUMN_USER_PASSWORD + " TEXT, "
                + AppEntry.COLUMN_USER_WEIGHT + " REAL DEFAULT 0, "
                + AppEntry.COLUMN_USER_HEIGHT + " REAL DEFAULT 0, "
                + AppEntry.COLUMN_USER_BMI_VALUE + " REAL DEFAULT 0, "//DATETIME DEFAULT CURRENT_TIMESTAMP
                + AppEntry.COLUMN_DATE + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
                + AppEntry.COLUMN_USER_BMI_CLASS + " TEXT, "
                + AppEntry.COLUMN_IDEAL_WEIGHT + " REAL DEFAULT 0, "
                + AppEntry.COLUMN_WEIGHT_SIX_MONTH + " REAL DEFAULT 0, "
                + AppEntry.COLUMN_WEIGHT_ONE_MONTH + " REAL DEFAULT 0, "
                + AppEntry.COLUMN_WEIGHT_ONE_WEEK + " REAL DEFAULT 0, "
                + AppEntry.COLUMN_CALORIES_MAINTAIN + " REAL DEFAULT 0, "
                + AppEntry.COLUMN_CALORIES_LOSS + " REAL DEFAULT 0, "



                + AppEntry.TYPE_FOOD_DATA + " TEXT, "
                + AppEntry.COLUMN_FOOD_NAME + " TEXT, "
                + AppEntry.COLUMN_FOOD_CALORIES + " REAL DEFAULT 0, "


                + AppEntry.TYPE_ACTIVITY_DATA + " TEXT, "
                + AppEntry.COLUMN_ACTIVITY_NAME + " TEXT, "
                + AppEntry.COLUMN_ACTIVITY_CALORIES + " REAL DEFAULT 0);";



        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

    }



    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }

    // varifiy user name and password in login
    public boolean varification(String username,String password){
        String varified = "SELECT * FROM apps WHERE "+AppEntry.COLUMN_USER_NAME+ " = " + "'"+ username + "'" + " AND "
                + AppEntry.COLUMN_USER_PASSWORD + " = " + "'"  +password + "'" + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(varified,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }


    public void listData(String username){
        String varified = "SELECT * FROM apps WHERE "+AppEntry.COLUMN_USER_NAME+ " = " + "'"+ username + "'" + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(varified,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            return ;
        }
        cursor.close();
        db.close();
        return ;
    }




    // varifiy user name and password in login
    public boolean existUserName(String nameString){
        String checkExist = "SELECT * FROM apps WHERE "+AppEntry.COLUMN_USER_NAME+ " = " + "'"+ nameString + "'" + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(checkExist,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

    public Cursor getPostData(){

        //String dataPost = "SELECT * FROM " + "apps WHERE name = " + +";";
        String dataPost = "SELECT * FROM " + "apps;";
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(dataPost,null);
        cursor.moveToFirst();
        return cursor;

    }


    public Cursor getFilterData(String User){

        //String dataPost = "SELECT * FROM " + "apps WHERE name = " + +";";
        String dataPost = "SELECT * FROM " + "apps WHERE weight != 0 AND name = '"+User+"';";
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(dataPost,null);
        cursor.moveToFirst();
        return cursor;

    }





    public String getMyUsername () throws SQLException{
        String username = "";
        Cursor cursor = this.getReadableDatabase().query(
                AppEntry.TABLE_NAME,new String[]{AppEntry.COLUMN_USER_NAME} ,
                null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                username = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return username;
    }


}
