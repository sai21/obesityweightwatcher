package com.example.tuan.obesityweightwatcher;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.tuan.obesityweightwatcher.MainActivity.Name;

/**
 * Created by tuan on 15/5/2017.
 */

public class ActivityList extends AppCompatActivity {


    private Spinner mActivitySpinner;

    String inputExercise;
    int myExercise = 0;//value when activity option is change



    TextView name;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";

    //////////
    Double totalActivityChoose = 0.00;

    Double totalActivityCaloriesRemain = 0.00;

    Double targerActivityCalories = 2150.00;
    //////////
    Integer valuea1 = 0;
    Integer valuea2 = 0;
    Integer valuea3 = 0;
    Integer valuea4 = 0;
    Integer valuea5 = 0;
    Integer valuea6 = 0;
    Integer valuea7 = 0;


    CheckBox checkBoxa1, checkBoxa2, checkBoxa3, checkBoxa4, checkBoxa5, checkBoxa6, checkBoxa7;

    ImageButton upa1, upa2, upa3, upa4, upa5, upa6, upa7;
    ImageButton downa1, downa2, downa3, downa4, downa5, downa6, downa7;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fitness_module);
        setContentView(R.layout.temp_fitness_module);

        /*
        //word list for food
        final ArrayList<Word> words = new ArrayList<Word>();

        //add value in array
        words.add(new Word("Bicycling for 20 minutes", "272 kcal"));
        words.add(new Word("Running (jogging) for 20 minutes", "320 kcal"));
        words.add(new Word("Swimming for 20 minutes", "200 kcal"));
        words.add(new Word("Hiking, climbing hills for 20 minutes", "161 kcal"));
        words.add(new Word("Cleaning for 20 minutes", "57 kcal"));
        words.add(new Word("Snorkeling for 20 minutes", "113 kcal"));
        words.add(new Word("Handball 20 minutes", "272 kcal"));
        words.add(new Word("Badminton for 20 minutes", "159 kcal"));
        words.add(new Word("Walking for 20 minutes", "181 kcal"));
        words.add(new Word("Football for 20 minutes", "181 kcal"));
        words.add(new Word("Rugby for 20 minutes", "227 kcal"));
        words.add(new Word("Basketball for 20 minutes", "102 kcal"));
        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        */

        //mActivitySpinner = (Spinner) findViewById(R.id.spinner_activity);
        //setupSpinner();

        checkBoxa1 = (CheckBox) findViewById(R.id.checkBoxa1);
        checkBoxa2 = (CheckBox) findViewById(R.id.checkBoxa2);
        checkBoxa3 = (CheckBox) findViewById(R.id.checkBoxa3);
        checkBoxa4 = (CheckBox) findViewById(R.id.checkBoxa4);
        checkBoxa5 = (CheckBox) findViewById(R.id.checkBoxa5);
        checkBoxa6 = (CheckBox) findViewById(R.id.checkBoxa6);
        checkBoxa7 = (CheckBox) findViewById(R.id.checkBoxa7);

        upa1 = (ImageButton) findViewById(R.id.upa1);
        downa1 = (ImageButton) findViewById(R.id.downa1);

        upa2 = (ImageButton) findViewById(R.id.upa2);
        downa2 = (ImageButton) findViewById(R.id.downa2);

        upa3 = (ImageButton) findViewById(R.id.upa3);
        downa3 = (ImageButton) findViewById(R.id.downa3);

        upa4 = (ImageButton) findViewById(R.id.upa4);
        downa4 = (ImageButton) findViewById(R.id.downa4);

        upa5 = (ImageButton) findViewById(R.id.upa5);
        downa5 = (ImageButton) findViewById(R.id.downa5);

        upa6 = (ImageButton) findViewById(R.id.upa6);
        downa6 = (ImageButton) findViewById(R.id.downa6);

        upa7 = (ImageButton) findViewById(R.id.upa7);
        downa7 = (ImageButton) findViewById(R.id.downa7);




        /*name = (TextView) findViewById(R.id.name_ku);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        name.setText(sharedpreferences.getString(Name, ""));*/

    }


    /**
     * Setup the dropdown spinner that allows the user to select the gender of the pet.
     */
    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_activity_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mActivitySpinner.setAdapter(genderSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mActivitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.activity_A))) {
                        //mGender = PetEntry.GENDER_MALE;
                    } else if (selection.equals(getString(R.string.activity_B))) {
                        //mGender = PetEntry.GENDER_FEMALE;
                    } else {
                        //mGender = PetEntry.GENDER_UNKNOWN;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //mGender = PetEntry.GENDER_UNKNOWN;
            }
        });
    }


    /*// this methode for activity option when clicked
    public void switchExercise(View view) {

        myExercise = myExercise + 1;

        if (myExercise % 3 == 1) {
            inputExercise = "1";//0
            //Toast.makeText(this, "Sedentary behaviour refers unactive activity such as sitting at chair whole day.", Toast.LENGTH_LONG).show();
        } else if (myExercise % 3 == 2) {
            inputExercise = "2";//1
            //Toast.makeText(this, "Moderate behaviour refers to partial activity such as work at office and do some exercise.", Toast.LENGTH_LONG).show();
        } else if (myExercise % 3 == 0) {
            inputExercise = "3";//2
            //Toast.makeText(this, "Marked behaviour refers to activite person like atlite.", Toast.LENGTH_LONG).show();

        }

        displayExercise(inputExercise);

    }
*/
    /**
     * Displays the activity status inside activity option.
     */
    /*public void displayExercise(String inputFood) {
        TextView exerciseView = (TextView) findViewById(R.id.inputExercise);
        exerciseView.setText(inputExercise);
    }*/







    public void upa1(View view) {
        valuea1 = valuea1 + 1;
        displaya1(valuea1);
    }
    public void downa1(View view) {
        valuea1 = valuea1 - 1;
        if (valuea1<1){
            valuea1 = 0;
        }
        displaya1(valuea1);
    }
    public void displaya1(int score) {
        TextView a1View = (TextView) findViewById(R.id.viewa1);
        a1View.setText(String.valueOf(score));
    }









    public void upa2(View view) {
        valuea2 = valuea2 + 1;
        displaya2(valuea2);
    }
    public void downa2(View view) {
        valuea2 = valuea2 - 1;
        if (valuea2<1){
            valuea2 = 0;
        }
        displaya2(valuea2);
    }
    public void displaya2(int score) {
        TextView a2View = (TextView) findViewById(R.id.viewa2);
        a2View.setText(String.valueOf(score));
    }





    public void upa3(View view) {
        valuea3 = valuea3 + 1;
        displaya3(valuea3);
    }
    public void downa3(View view) {
        valuea3 = valuea3 - 1;
        if (valuea3<1){
            valuea3 = 0;
        }
        displaya3(valuea3);
    }
    public void displaya3(int score) {
        TextView a3View = (TextView) findViewById(R.id.viewa3);
        a3View.setText(String.valueOf(score));
    }






    public void upa4(View view) {
        valuea4 = valuea4 + 1;
        displaya4(valuea4);
    }
    public void downa4(View view) {
        valuea4 = valuea4 - 1;
        if (valuea4<1){
            valuea4 = 0;
        }
        displaya4(valuea4);
    }
    public void displaya4(int score) {
        TextView a4View = (TextView) findViewById(R.id.viewa4);
        a4View.setText(String.valueOf(score));
    }



    public void upa5(View view) {
        valuea5 = valuea5 + 1;
        displaya5(valuea5);
    }
    public void downa5(View view) {
        valuea5 = valuea5 - 1;
        if (valuea5<1){
            valuea5 = 0;
        }
        displaya5(valuea5);
    }
    public void displaya5(int score) {
        TextView a5View = (TextView) findViewById(R.id.viewa5);
        a5View.setText(String.valueOf(score));
    }



    public void upa6(View view) {
        valuea6 = valuea6 + 1;
        displaya6(valuea6);
    }
    public void downa6(View view) {
        valuea6 = valuea6 - 1;
        if (valuea6<1){
            valuea6 = 0;
        }
        displaya6(valuea6);
    }
    public void displaya6(int score) {
        TextView a6View = (TextView) findViewById(R.id.viewa6);
        a6View.setText(String.valueOf(score));
    }







    public void upa7(View view) {
        valuea7 = valuea7 + 1;
        displaya7(valuea7);
    }
    public void downa7(View view) {
        valuea7 = valuea7 - 1;
        if (valuea7<1){
            valuea7 = 0;
        }
        displaya7(valuea7);
    }
    public void displaya7(int score) {
        TextView a7View = (TextView) findViewById(R.id.viewa7);
        a7View.setText(String.valueOf(score));
    }















    public void refreshActivity (View view) {

        totalActivityChoose = 0.00;

        totalActivityCaloriesRemain = 0.00;

        if(checkBoxa1.isChecked() == true){
            totalActivityChoose = totalActivityChoose + 98.0*valuea1;
        }

        if (checkBoxa2.isChecked() == true) {
            totalActivityChoose = totalActivityChoose + 98.3*valuea2;
        }

        if (checkBoxa3.isChecked() == true) {
            totalActivityChoose = totalActivityChoose + 85.0*valuea3;
        }

        if (checkBoxa4.isChecked() == true) {
            totalActivityChoose = totalActivityChoose + 80.0*valuea4;
        }

        if (checkBoxa5.isChecked() == true) {
            totalActivityChoose = totalActivityChoose + 76.7*valuea5;
        }

        if (checkBoxa6.isChecked() == true) {
            totalActivityChoose = totalActivityChoose + 73.3*valuea6;
        }

        if (checkBoxa7.isChecked() == true) {
            totalActivityChoose = totalActivityChoose + 85.3*valuea7;
        }




        if(totalActivityChoose < 600.0) {
            // Create an AlertDialog.Builder and set the message, and click listeners
            // for the postivie and negative buttons on the dialog.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Your life style is unhealthy.");
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

        else {
            // Create an AlertDialog.Builder and set the message, and click listeners
            // for the postivie and negative buttons on the dialog.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("your lifestyle is healthy.");
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





        //display remain calories
        totalActivityCaloriesRemain = targerActivityCalories -  totalActivityChoose;






        displayForTeamB(totalActivityChoose);

        displayForTeamC(totalActivityCaloriesRemain);
    }




    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamB(Double score) {
        TextView scoreView = (TextView) findViewById(R.id.calories_activity_choose);
        scoreView.setText(String.valueOf(score));

    }



    public void displayForTeamC(Double scoreb) {
        TextView scoreBView = (TextView) findViewById(R.id.calories_activity_remain);
        scoreBView.setText(String.valueOf(scoreb));

    }



}
