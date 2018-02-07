package com.example.tuan.obesityweightwatcher;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tuan.obesityweightwatcher.data.AppContract;


import com.example.tuan.obesityweightwatcher.data.AppContract.AppEntry;

/**
 * Created by tuan on 22/5/2017.
 */

public class ListDietWatcherEditor extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    Integer num0 = 0;


    /** Content URI for the existing pet (null if it's a new pet) */
    private Uri mCurrentAppUri;


    private TextView mUserWeightText;


    /** Boolean flag that keeps track of whether the pet has been edited (true) or not (false) */
    private boolean mApptHasChanged = false;

    /** Identifier for the pet data loader */
    private static final int EXISTING_APP_LOADER = 0;






    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mApptHasChanged = true;
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_weight_watcher);



        // Examine the intent that was used to launch this activity,
        // in order to figure out if we're creating a new pet or editing an existing one.
        Intent intent = getIntent();
        mCurrentAppUri = intent.getData();



        if (mCurrentAppUri == null) {

        }
        else {
            getLoaderManager().initLoader(EXISTING_APP_LOADER, null, this);
        }





        // Find all relevant views that we will need to read user input from
        mUserWeightText = (TextView) findViewById(R.id.watcher_weight);


        // Setup OnTouchListeners on all the input fields, so we can determine if the user
        // has touched or modified them. This will let us know if there are unsaved changes
        // or not, if the user tries to leave the editor without saving.
        mUserWeightText.setOnTouchListener(mTouchListener);




    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // Since the editor shows all pet attributes, define a projection that contains
        // all columns from the pet table
        String[] projection = {
                AppEntry._ID,
                AppEntry.COLUMN_USER_WEIGHT};

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                mCurrentAppUri,         // Query the content URI for the current pet
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        // Bail early if the cursor is null or there is less than 1 row in the cursor
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }


        // Proceed with moving to the first row of the cursor and reading data from it
        // (This should be the only row in the cursor)
        if (cursor.moveToFirst()) {
            int userWeightColumnIndex = cursor.getColumnIndex(AppEntry.COLUMN_USER_WEIGHT);


            // Extract out the value from the Cursor for the given column index
            int userWeight = cursor.getInt(userWeightColumnIndex);


            // Update the views on the screen with the values from the database
            mUserWeightText.setText(Integer.toString(userWeight));

        }


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mUserWeightText.setText("");
    }




}
