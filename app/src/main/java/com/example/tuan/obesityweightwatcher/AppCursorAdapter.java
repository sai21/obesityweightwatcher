package com.example.tuan.obesityweightwatcher;




import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.tuan.obesityweightwatcher.data.AppContract.AppEntry;
/**
 * Created by tuan on 22/5/2017.
 */

public class AppCursorAdapter extends CursorAdapter {


    public AppCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }



    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_user_data, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


        // Find individual views that we want to modify in the list item layout
        TextView userDateTextView = (TextView) view.findViewById(R.id.data_date);
        TextView userWeightTextView = (TextView) view.findViewById(R.id.data_weight);
        TextView userHeightTextView = (TextView) view.findViewById(R.id.data_Height);
        TextView userCaloriesLossTextView = (TextView) view.findViewById(R.id.data_calories_loss);
        TextView userBmiClassTextView = (TextView) view.findViewById(R.id.data_bmi_class);





        // Find the columns of pet attributes that we're interested in
        int userDateColumnIndex = cursor.getColumnIndex(AppEntry.COLUMN_DATE);
        int userWeightColumnIndex = cursor.getColumnIndex(AppEntry.COLUMN_USER_WEIGHT);
        int userHeightColumnIndex = cursor.getColumnIndex(AppEntry.COLUMN_USER_HEIGHT);
        int userCaloriesLossColumnIndex = cursor.getColumnIndex(AppEntry.COLUMN_CALORIES_LOSS);
        int userBmiClassColumnIndex = cursor.getColumnIndex(AppEntry.COLUMN_USER_BMI_CLASS);





        // Read the pet attributes from the Cursor for the current pet
        String userDate = cursor.getString(userDateColumnIndex);
        String userWeight = cursor.getString(userWeightColumnIndex);
        String userHeight = cursor.getString(userHeightColumnIndex);
        String userCaloriesLoss = cursor.getString(userCaloriesLossColumnIndex);
        String userBmiClass = cursor.getString(userBmiClassColumnIndex);



        // Update the TextViews with the attributes for the current pet
        userDateTextView.setText(userDate);
        userWeightTextView.setText(userWeight);
        userHeightTextView.setText(userHeight);
        userCaloriesLossTextView.setText(userCaloriesLoss);
        userBmiClassTextView.setText(userBmiClass);

    }
}
