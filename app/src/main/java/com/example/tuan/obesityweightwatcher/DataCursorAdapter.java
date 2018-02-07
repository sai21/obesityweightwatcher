package com.example.tuan.obesityweightwatcher;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.tuan.obesityweightwatcher.data.AppContract;

import com.example.tuan.obesityweightwatcher.data.AppContract.AppEntry;
import com.example.tuan.obesityweightwatcher.data.AppDbHelper;

/**
 * Created by tuan on 15/5/2017.
 */

public class DataCursorAdapter extends CursorAdapter {


    public DataCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }


    private AppDbHelper db;

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.word_list_activity, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        //db = new AppDbHelper(this);
        //cursor = db.getFilterData();

        // Find individual views that we want to modify in the list item layout
        TextView data1TextView = (TextView) view.findViewById(R.id.data_1);
        TextView data2TextView = (TextView) view.findViewById(R.id.data_2);
        //TextView data3TextView = (TextView) view.findViewById(R.id.data_3);

        // Find the columns of pet attributes that we're interested in
        int data1ColumnIndex = cursor.getColumnIndex(AppEntry.COLUMN_USER_WEIGHT);
        int data2ColumnIndex = cursor.getColumnIndex(AppEntry.COLUMN_USER_HEIGHT);
        //int data3ColumnIndex = cursor.getColumnIndex(AppEntry.COLUMN_USER_BMI_VALUE);

        // Read the pet attributes from the Cursor for the current pet
        String appdata1 = cursor.getString(data1ColumnIndex);
        String appdata2= cursor.getString(data2ColumnIndex);
        //String appdata3= cursor.getString(data3ColumnIndex);

        // Update the TextViews with the attributes for the current pet
        data1TextView.setText(appdata1);
        data2TextView.setText(appdata2);
        //data3TextView.setText(appdata3);

    }
}
