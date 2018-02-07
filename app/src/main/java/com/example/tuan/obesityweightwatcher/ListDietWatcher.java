package com.example.tuan.obesityweightwatcher;

import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tuan.obesityweightwatcher.data.AppContract;

import com.example.tuan.obesityweightwatcher.data.AppContract.AppEntry;
import com.example.tuan.obesityweightwatcher.data.AppDbHelper;

import java.util.ArrayList;

import static com.example.tuan.obesityweightwatcher.R.id.list;

/**
 * Created by tuan on 22/5/2017.
 */

public class ListDietWatcher extends AppCompatActivity  {

    private static final int APP_LOADER = 0;

    AppCursorAdapter mCursorAdapter;

    Spinner spinner;

    private AppDbHelper db;

    ArrayList<postDetails>list;

    PostListAdapter adapter = null;
    private TextView faridUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_diet_watcher);



        //ListView listView = (ListView) findViewById(R.id.list_user_data);
        //appListView.setVisibility(View.INVISIBLE);


        String username = "username";

        db = new AppDbHelper(this);
        //Cursor cursor = db.listData(username);


        TextView faridUser = (TextView) findViewById(R.id.watcherUsername);
        faridUser.setText(db.getMyUsername());
        String nama = faridUser.getText().toString();
        faridUser.setVisibility(View.INVISIBLE);

        ListView appListView = (ListView) findViewById(R.id.list_user_data);


        //mCursorAdapter = new AppCursorAdapter(this, null);
        //appListView.setAdapter(mCursorAdapter);
        //Cursor cursor = db.getFilterData();
        list = new ArrayList<>();
        adapter = new PostListAdapter(this, R.layout.word_list_activity, list);
        appListView.setAdapter(adapter);
        Cursor cursor = db.getFilterData(nama);
        list.clear();
        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String newusername = cursor.getString(1);
            String newpassword = cursor.getString(2);
            String newweight = cursor.getString(3);
            String newheight = cursor.getString(4);
            String newbmivalue = cursor.getString(5);
            String newdate = cursor.getString(6);
            String newbmiclass = cursor.getString(7);
            String newcaloriesloss = cursor.getString(13);

            list.add(new postDetails(id,newusername,newpassword,newweight+" Kg",newheight+" meter",newbmivalue,newdate, newbmiclass, newcaloriesloss+ " kcal"));

        }

        adapter.notifyDataSetChanged();






        spinner = (Spinner) findViewById(R.id.idSpinner);
        String[] countries = {"MAY"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countries);
        spinner.setAdapter(adapter);


        if (countries.equals("JUN")) {

            //appListView.setVisibility(View.VISIBLE);
            //appListView.setVisibility(View.INVISIBLE);
        }
        else {

        }

        /////
        //put on click function here

        /*

        appListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {



                // Create new intent to go to {@link EditorActivity}
                Intent intent = new Intent(ListDietWatcher.this, ListDietWatcherEditor.class);

                // Form the content URI that represents the specific pet that was clicked on,
                // by appending the "id" (passed as input to this method) onto the
                // {@link PetEntry#CONTENT_URI}.
                // For example, the URI would be "content://com.example.android.pets/pets/2"
                // if the pet with ID 2 was clicked on.
                Uri currentAppUri = ContentUris.withAppendedId(AppEntry.CONTENT_URI, id);

                // Set the URI on the data field of the intent
                intent.setData(currentAppUri);

                // Launch the {@link EditorActivity} to display the data for the current pet.
                startActivity(intent);

                //Toast.makeText(getApplicationContext(), "i get : " + PetCursorAdapter.myFoodQuantity, Toast.LENGTH_SHORT).show();
            }
        });
        */
        /////

        //getLoaderManager().initLoader(APP_LOADER, null, this);

    }











/*
    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                AppEntry._ID,
                AppEntry.COLUMN_DATE,
                AppEntry.COLUMN_USER_WEIGHT,
                AppEntry.COLUMN_USER_HEIGHT,
                AppEntry.COLUMN_USER_BMI_VALUE,
                AppEntry.COLUMN_USER_BMI_CLASS,
                AppEntry.COLUMN_CALORIES_MAINTAIN,
                AppEntry.COLUMN_CALORIES_LOSS};

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                AppEntry.CONTENT_URI,   // Provider content URI to query
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Update {@link PetCursorAdapter} with this new cursor containing updated pet data
        mCursorAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // Callback called when the data needs to be deleted
        mCursorAdapter.swapCursor(null);

    }*/
}
