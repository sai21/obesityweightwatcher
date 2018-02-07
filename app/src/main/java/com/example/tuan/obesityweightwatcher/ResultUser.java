package com.example.tuan.obesityweightwatcher;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;





import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;








import com.example.tuan.obesityweightwatcher.UserInfo;
import com.example.tuan.obesityweightwatcher.data.AppContract;

import com.example.tuan.obesityweightwatcher.data.AppContract.AppEntry;
import com.example.tuan.obesityweightwatcher.data.AppDbHelper;

import static android.R.attr.button;

/**
 * Created by tuan on 14/5/2017.
 */

public class ResultUser extends UserInfo {

    /** Content URI for the existing pet (null if it's a new pet) */
    private Uri mCurrentAppUri;

    String displayBmiValue = String.format(("%.2f"), UserInfo.BmiValue);
    String displayWeight = String.format(("%.2f"), UserInfo.UserWeight);
    String displayHeight = String.format(("%.2f"), UserInfo.UserHeight);
    String displayWeight6month = String.format(("%.2f"), UserInfo.Weight6month);
    String displayWeight1month = String.format(("%.2f"), UserInfo.Weight1month);
    String displayWeight1week = String.format(("%.2f"), UserInfo.Weight1week);
    String displayCaloriesMaintain = String.format(("%.0f"), UserInfo.CaloriesMaintain);
    String displayCaloriesLoss = String.format(("%.0f"), UserInfo.CaloriesLoss);
    String displayIdealWeight = String.format(("%.2f"), UserInfo.idealWeight);
    String displayBmiClass = String.format("%2$s", 32, UserInfo.BmiClass);


    //String displayName = String.format(("%.2f"), UserInfo.BmiClass);
    //String displayName = String.format(("%s"), UserInfo.name);
    //String displayName(UserInfo.name);//UserInfo.name;
    //String musicPlaying = UserInfo.name;
    //String displayName = String.format("%2$s", 32, UserInfo.name);

    private TextView username;

    private AppDbHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_result);

        db = new AppDbHelper(this);
        username = (TextView) findViewById(R.id.myUser);
        username.setText(db.getMyUsername());
        username.setVisibility(View.INVISIBLE);


        // Setup FAB to save result
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Your result has been saved.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ResultUser.this, UserInfo.class);
                startActivity(intent);
            }
        });
        */

        //import to bmi class
        TextView idealWeightView = (TextView) findViewById(R.id.ideal_weight);
        idealWeightView.setText(String.valueOf(displayIdealWeight));

        //import to bmi class
        TextView bmiClassView = (TextView) findViewById(R.id.bmi_class);
        bmiClassView.setText(String.valueOf(UserInfo.BmiClass));

        //import to bmi value id
        TextView bmiValueView = (TextView) findViewById(R.id.bmi_value);
        bmiValueView.setText(String.valueOf(displayBmiValue));

        /*
        //import to weight 6 month id
        TextView weight6MonthView = (TextView) findViewById(R.id.weight_6_month);
        weight6MonthView.setText(String.valueOf(displayWeight6month));

        //import to weight 1 month id
        TextView weight1MonthView = (TextView) findViewById(R.id.weight_1_month);
        weight1MonthView.setText(String.valueOf(displayWeight1month));

        //import to weight 1 week id
        TextView weight1WeekView = (TextView) findViewById(R.id.weight_1_week);
        weight1WeekView.setText(String.valueOf(displayWeight1week));

*/

        //import to maintain weight id
        TextView caloriesMaintain = (TextView) findViewById(R.id.calories_maintain);
        caloriesMaintain.setText(String.valueOf(displayCaloriesMaintain));

        //import to loss weight id
        TextView caloriesLoss = (TextView) findViewById(R.id.calories_loss);
        caloriesLoss.setText(String.valueOf(displayCaloriesLoss));

        ///import weight
        TextView myWeight = (TextView) findViewById(R.id.my_weight);
        myWeight.setText(String.valueOf(displayWeight));

        ///import height
        TextView myHeight = (TextView) findViewById(R.id.my_height);
        myHeight.setText(String.valueOf(displayHeight));


        //////////////////////






    }

    public void showUnsavedChangesDialog(
            DialogInterface.OnClickListener discardButtonClickListener) {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Save this result ?");
        builder.setPositiveButton("SAVE", discardButtonClickListener);
        builder.setNegativeButton("DISMISS", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Keep editing" button, so dismiss the dialog
                // and continue editing the pet.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }



    public void btnSave(View view){
        //Toast.makeText(getApplicationContext(), "Your information has been saved.", Toast.LENGTH_SHORT).show();
        showSaveConfirmationDialog();

    }

    /**
     * Prompt the user to confirm that they want to save information.
     */
    private void showSaveConfirmationDialog() {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Save this result?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Delete" button, so delete the pet.
                saveInfo();
                //toast message
                Toast.makeText(getApplicationContext(), "Your information has ben saved.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ResultUser.this, FoodList.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Cancel" button, so dismiss the dialog
                // and continue editing the pet.
                if (dialog != null) {
                    Intent intent = new Intent(ResultUser.this, UserInfo.class);
                    startActivity(intent);
                    dialog.dismiss();
                }
                Intent intent = new Intent(ResultUser.this, UserInfo.class);
                startActivity(intent);
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void InfoBmiIndex(View view) {

        // Create an AlertDialog.Builder and set the message, and click listeners//identify a simple screening parameter for reporting one's weight as a function of his/her height.
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("BMI VALUE INFO  identify a simple screening parameter for reporting one's weight as a function of his/her height.");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Delete" button, so delete the pet.
                //saveInfo();
                //toast message
                //Toast.makeText(getApplicationContext(), "okay jadi", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(ResultUser.this, UserInfo.class);
                //startActivity(intent);
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void InfoBmiClass(View view) {

        // Create an AlertDialog.Builder and set the message, and click listeners//identify a simple screening parameter for reporting one's weight as a function of his/her height.
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("BMI CLASS INFO  is a simple index of weight-for-height that is commonly used to classify  underweight, overweight and obesity in adults.\n\n(1)Under weight\n(2)Normal weight\n(3)Over weight\n(4)Obese class I\n(5)Obese class II\n(6)Obese class III");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Delete" button, so delete the pet.
                //saveInfo();
                //toast message
                //Toast.makeText(getApplicationContext(), "okay jadi", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(ResultUser.this, UserInfo.class);
                //startActivity(intent);
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void InfoIdealWeight(View view) {

        // Create an AlertDialog.Builder and set the message, and click listeners//identify a simple screening parameter for reporting one's weight as a function of his/her height.
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("healthy body weight range based on height, gender, and age.\n\nkg = kilogram ");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Delete" button, so delete the pet.
                //saveInfo();
                //toast message
                //Toast.makeText(getApplicationContext(), "okay jadi", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(ResultUser.this, UserInfo.class);
                //startActivity(intent);
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void InfoMaintainWeight(View view) {

        // Create an AlertDialog.Builder and set the message, and click listeners//identify a simple screening parameter for reporting one's weight as a function of his/her height.
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Based on your current weight, this calories value will effect your diet schedule. Please behave your food taken to avoid increasing of your weight.\n\nkcal = kilocalorie ");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Delete" button, so delete the pet.
                //saveInfo();
                //toast message
                //Toast.makeText(getApplicationContext(), "okay jadi", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(ResultUser.this, UserInfo.class);
                //startActivity(intent);
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void InfoLossWeight(View view) {

        // Create an AlertDialog.Builder and set the message, and click listeners//identify a simple screening parameter for reporting one's weight as a function of his/her height.
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("For healty diet life style, your should get this value of calories per day. \n\nkcal = kilocalorie ");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Delete" button, so delete the pet.
                //saveInfo();
                //toast message
                //Toast.makeText(getApplicationContext(), "okay jadi", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(ResultUser.this, UserInfo.class);
                //startActivity(intent);
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void saveInfo() {


        String Username = username.getText().toString();
        // Create database helper
        AppDbHelper mDbHelper = new AppDbHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppEntry.COLUMN_USER_NAME, Username);
        values.put(AppEntry.COLUMN_USER_WEIGHT, displayWeight);
        values.put(AppEntry.COLUMN_USER_HEIGHT, displayHeight);
        values.put(AppEntry.COLUMN_USER_BMI_VALUE, displayBmiValue);
        values.put(AppEntry.COLUMN_WEIGHT_SIX_MONTH, displayWeight6month);
        values.put(AppEntry.COLUMN_WEIGHT_ONE_MONTH, displayWeight1month);
        values.put(AppEntry.COLUMN_WEIGHT_ONE_WEEK, displayWeight1week);
        values.put(AppEntry.COLUMN_CALORIES_MAINTAIN, displayCaloriesMaintain);
        values.put(AppEntry.COLUMN_CALORIES_LOSS, displayCaloriesLoss);
        values.put(AppEntry.COLUMN_IDEAL_WEIGHT, displayIdealWeight);
        values.put(AppEntry.COLUMN_USER_BMI_CLASS, displayBmiClass);



        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(AppEntry.TABLE_NAME, null, values);


        ///////////


        // Insert a new row for pet in the database, returning the ID of that new row.
        //long newRowId = db.insert(AppEntry.TABLE_NAME, null, values);


    }

}

