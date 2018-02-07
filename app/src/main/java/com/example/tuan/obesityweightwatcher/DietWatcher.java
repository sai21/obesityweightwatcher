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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import com.example.tuan.obesityweightwatcher.data.AppDbHelper;

import com.example.tuan.obesityweightwatcher.data.AppContract.AppEntry;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.tuan.obesityweightwatcher.R.id.list;


/**
 * Created by tuan on 15/5/2017.
 */

public class DietWatcher extends AppCompatActivity  {

    private static final int APP_LOADER = 0;

    DataCursorAdapter mCursorAdapter;

    /** Database helper that will provide us access to the database */
    private AppDbHelper mDbHelper;


    private AppDbHelper db;
    ListView listView;
    ArrayList<postDetails>list;
    PostListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_watcher);


        /*
        ListView appListView = (ListView) findViewById(R.id.list_history_data);

        // Find and set empty view on the ListView, so that it only shows when the list has 0 items.
        View emptyView = findViewById(R.id.empty_view);
        appListView.setEmptyView(emptyView);

        mCursorAdapter = new DataCursorAdapter(this, null);

        appListView.setAdapter(mCursorAdapter);

        //Toast.makeText(getApplicationContext(),,Toast.LENGTH_LONG).show();
        */

        db = new AppDbHelper(this);

        listView = (ListView)findViewById(R.id.list_history_data);
        View emptyView = findViewById(R.id.empty_view);
        listView.setEmptyView(emptyView);

        list = new ArrayList<>();
        adapter = new PostListAdapter(this, R.layout.word_list_activity,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent jumpUserInfoIntent = new Intent(DietWatcher.this, DietWatcherDetails.class);

                startActivity(jumpUserInfoIntent);

                // Create new intent to go to {@link EditorActivity}
                //Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);

                // Form the content URI that represents the specific pet that was clicked on,
                // by appending the "id" (passed as input to this method) onto the
                // {@link PetEntry#CONTENT_URI}.
                // For example, the URI would be "content://com.example.android.pets/pets/2"
                // if the pet with ID 2 was clicked on.
                /////////Uri currentPetUri = ContentUris.withAppendedId(AppEntry.CONTENT_URI, id);

                // Set the URI on the data field of the intent
                /////////intent.setData(currentPetUri);

                // Launch the {@link EditorActivity} to display the data for the current pet.
                //////////startActivity(intent);
            }
        });

        Collections.reverse(list);
        Cursor cursor = db.getPostData();
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);

            String name = cursor.getString(1);
            String password = cursor.getString(2);
            String weight = cursor.getString(3);
            String height = cursor.getString(4);
            String bmiValue = cursor.getString(5);
            String date = cursor.getString(6);
            String bmiclass = cursor.getString(7);
            String caloriesloss = cursor.getString(13);


            list.add(new postDetails(id,name,password,weight,height,bmiValue,date,bmiclass,caloriesloss));
        }
        adapter.notifyDataSetChanged();






    }



}
