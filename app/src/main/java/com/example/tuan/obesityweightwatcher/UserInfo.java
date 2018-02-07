package com.example.tuan.obesityweightwatcher;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
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
 * Created by tuan on 14/5/2017.
 */

public class UserInfo extends AppCompatActivity {

    /////file read cache file////
    String FileName = "myFile";
    Button BtnRead;
    /////////////////////////////


    String inputActivity;
    int myActivity = 2;//value when activity option is change
    //String name = "";
    //Double BmiValue;
    //String BmiClass;
    //Double CaloriesMaintain;
    //Double CaloriesLoss;
    //Double Weight6month;
    //Double Weightmonth;

    String test;

    Double num10 = 10.00;
    Double num100 = 100.00;
    Double num6 = 6.00;
    Double num4 = 4.00;

    Double num35 = 35.00;
    Double num22 = 22.50;
    Double num40 = 40.00;
    Double num45 = 45.00;
    Double num30 = 30.00;

    Double idealBmi = 21.70;



    static Double UserWeight;

    static Double UserHeight;

    static Double BmiValue;

    static String name;

    static Double Weight6month;
    static Double Weight1month;
    static Double Weight1week;

    static String BmiClass;
    static Double CaloriesMaintain;
    static Double CaloriesLoss;
    static Double idealWeight;

    int userAge;

    //static String getCache = test;




    /** EditText field to enter the pet's gender */
    private Spinner mGenderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);

        readFile();




        mGenderSpinner = (Spinner) findViewById(R.id.spinner_gender);
        setupSpinner();

        Button calculateMyInfo = (Button) findViewById(R.id.goCalculate);
        calculateMyInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //setContentView(R.layout.user_result);


                calculateInsert();
                Intent intent = new Intent(UserInfo.this, ResultUser.class);
                startActivity(intent);

            }
        });


    }



    public void calculateInsert() {


        //EditText input_name = (EditText) findViewById(R.id.inputName);
        //String userName = input_name.getText().toString().trim();
        //name = userName;




        /*

        EditText input_age = (EditText) findViewById(R.id.inputAge);
        String intAge = input_age.getText().toString().trim();
        Integer userAge= Integer.parseInt(intAge);
        //Double userAge = Double.parseDouble(intAge);

*/

        EditText input_weight = (EditText) findViewById(R.id.inputWeight);
        String intWeight = input_weight.getText().toString().trim();
        //userWeight = Integer.parseInt(intWeight);
        Double userWeight = Double.parseDouble(intWeight);

        EditText input_height = (EditText) findViewById(R.id.inputHeight);
        String intHeight = input_height.getText().toString().trim();
        Double userHeight = Double.parseDouble(intHeight);


        /*

        if (intAge.matches("")) {
            Toast.makeText(this, "You did not enter age", Toast.LENGTH_SHORT).show();
            return;
        }
        */



        /*

        if (TextUtils.isEmpty(intAge)){
            return;
        }
        */
        if (TextUtils.isEmpty(intWeight)){
            Intent intent = new Intent(UserInfo.this, UserInfo.class);
            startActivity(intent);
        }
        if (TextUtils.isEmpty(intHeight)){
            return;
        }



        //convert to readeble variable
        UserHeight = userHeight/num100;
        UserWeight = userWeight;

        //calculate BMI value
        BmiValue = (userWeight)/(userHeight * (UserHeight/num100));

        //weight for next 6 month
        Weight6month = userWeight - (num10/num100)*userWeight;

        //weight for next 1 month
        Weight1month = userWeight - ((num10/num100)/(num6))*userWeight;

        //weight for next 1 week
        Weight1week = userWeight - (((num10/num100)/(num6))/num4)*userWeight;



        //clasifaying BMI class
        if(BmiValue < 18.5) { BmiClass = " Under weight";}
        else if (BmiValue >= 18.5 && BmiValue < 25.0) {
            BmiClass = "Normal weight";

            //build notification
            NotificationCompat.Builder mBuilder =
                    (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                            .setSmallIcon(R.mipmap.watcher)
                            .setContentTitle("Achieve Your ideal weight !!!")
                            .setContentText("Congratulation, you have achieve your target weight.");
            // Gets an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            //to post your notification to the notification bar
            notificationManager.notify(0, mBuilder.build());
        }
        else if (BmiValue >= 25.0 && BmiValue < 30.0) {BmiClass = "Over weight \n(pre-obese)";}
        else if (BmiValue >= 30.0 && BmiValue < 35.0) {BmiClass = "Obese class I";}
        else if (BmiValue >= 35.0 && BmiValue < 40.0) {BmiClass = "Obese class II";}
        else {BmiClass = "Obese class III";}


        //calculate calories need to maintain current weight
        // myActivity % 3 == 1 is Sedentary Activity
        // myActivity % 3 == 2 is Moderate Activity
        // myActivity % 3 == 3 is Marked Activity
        if(myActivity % 3 == 1 && BmiValue < 18.5) {
            CaloriesMaintain = num35 * userWeight;
        }
        else if (myActivity % 3 == 1 && BmiValue >= 18.5 && BmiValue <= 25.0) {
            CaloriesMaintain = num30 * userWeight;
        }
        else if (myActivity % 3 == 1 && BmiValue > 25.0) {
            CaloriesMaintain = num22 * userWeight;
        }
        else if(myActivity % 3 == 2 && BmiValue < 18.5) {
            CaloriesMaintain = num40 * userWeight;
        }
        else if (myActivity % 3 == 2 && BmiValue >= 18.5 && BmiValue <= 25.0) {
            CaloriesMaintain = num35 * userWeight;
        }
        else if(myActivity % 3 == 3 && BmiValue < 18.5) {
            CaloriesMaintain = num45 * userWeight;
        }
        else {
            CaloriesMaintain = num40 * userWeight;
        }


        // find ideal weight
        idealWeight = (userHeight * (UserHeight/num100)) * idealBmi;


        // calories need for loss weight
        if(myActivity % 3 == 1) {
            CaloriesLoss = num30 * idealWeight;
        }
        else if(myActivity % 3 == 3) {
            CaloriesLoss = num40 * idealWeight;
        }
        else {
            CaloriesLoss = num35 * idealWeight;
        }

    }


    // this methode for activity option when clicked
    public void switchInputActivity(View view) {

        myActivity = myActivity + 1;

        if (myActivity % 3 == 1) {
            inputActivity = "Sedentary Activity";//0
            //Toast.makeText(this, "Sedentary behaviour refers unactive activity such as sitting at chair whole day.", Toast.LENGTH_LONG).show();
        } else if (myActivity % 3 == 2) {
            inputActivity = "Moderate Activity";//1
            //Toast.makeText(this, "Moderate behaviour refers to partial activity such as work at office and do some exercise.", Toast.LENGTH_LONG).show();
        } else if (myActivity % 3 == 0) {
            inputActivity = "Marked Activity";//2
            //Toast.makeText(this, "Marked behaviour refers to activite person like atlite.", Toast.LENGTH_LONG).show();

        }

        displayActivity(inputActivity);

    }

    // setup info button
    public void activityInfoButton (View view){

        if (myActivity % 3 == 1) {
            //Toast.makeText(this, "Sedentary behaviour refers unactive activity such as person that sitting at chair whole day.", Toast.LENGTH_LONG).show();

            // Create an AlertDialog.Builder and set the message, and click listeners
            // for the postivie and negative buttons on the dialog.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Sedentary behaviour refers unactive activity such as person that sitting at chair whole day.");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {


                }
            });

            // Create and show the AlertDialog
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else if (myActivity % 3 == 2) {
            //Toast.makeText(this, "Moderate behaviour refers to partial activity such as work at office and do some exercise at least 3 times per week.", Toast.LENGTH_LONG).show();
            // Create an AlertDialog.Builder and set the message, and click listeners
            // for the postivie and negative buttons on the dialog.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Moderate behaviour refers to partial activity such as work at office and do some exercise at least 3 times per week.");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });

            // Create and show the AlertDialog
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else if (myActivity % 3 == 0) {
            //Toast.makeText(this, "Marked behaviour refers to activite person like atlite.", Toast.LENGTH_LONG).show();
            // Create an AlertDialog.Builder and set the message, and click listeners
            // for the postivie and negative buttons on the dialog.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Marked behaviour refers to activite person like atlite.");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });

            // Create and show the AlertDialog
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

    }
    /**
     * Setup the dropdown spinner that allows the user to select the gender of the pet.
     */
    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mGenderSpinner.setAdapter(genderSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_male))) {
                        //mGender = AppContract.UserEntry.GENDER_MALE;
                    } else if (selection.equals(getString(R.string.gender_female))) {
                        //mGender = AppContract.UserEntry.GENDER_FEMALE;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //mGender = AppContract.UserEntry.GENDER_MALE;
            }
        });
    }




    /**
     * Displays the activity status inside activity option.
     */
    public void displayActivity(String inputActivity) {
        TextView activityView = (TextView) findViewById(R.id.inputActivity);
        activityView.setText(inputActivity);
    }


    ////////read cache file//////////////////////////////////////
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
            //Toast.makeText(this, "Current user : " + stringBuilder.toString(), Toast.LENGTH_SHORT).show();
            test = stringBuilder.toString();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////






}

