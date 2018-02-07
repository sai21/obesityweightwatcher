package com.example.tuan.obesityweightwatcher;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tuan on 14/5/2017.
 */

public class FoodList extends AppCompatActivity {


    String displayTotalCaloriesChoose = String.format(("%.2f"), myTotalCaloriesChoose);
    String displaymyTotalCaloriesRemain = String.format(("%.2f"), myTotalCaloriesRemain);


    static Double myTotalCaloriesChoose;
    static Double myTotalCaloriesRemain;


    private Spinner mFoodSpinner;
    String inputFood;
    int myFoood = 0;//value when activity option is change

    //////////
    Double totalCaloriesChoose = 0.00;

    Double totalCaloriesRemain = 0.00;

    Double targerCalories = 2150.00;
    //////////
    Integer valuef1 = 0;
    Integer valuef2 = 0;
    Integer valuef3 = 0;
    Integer valuef4 = 0;
    Integer valuef5 = 0;
    Integer valuef6 = 0;
    Integer valuef7 = 0;
    Integer valuef8 = 0;
    Integer valuef9 = 0;
    Integer valuef10 = 0;
    Integer valuef11 = 0;
    Integer valuef12 = 0;
    Integer valuef13 = 0;
    Integer valuef14 = 0;






    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12, checkBox13, checkBox14;

    ImageButton upf1,upf2,upf3, upf4, upf5, upf6, upf7, upf8, upf9, upf10, upf11, upf12, upf13, upf14;
    ImageButton downf1,downf2,downf3, downf4, downf5, downf6, downf7,downf8, downf9, downf10, downf11, downf12, downf13, downf14;

    private ScrollView myskrol1;
    private ScrollView myskrol2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.word_list);
        setContentView(R.layout.temp_dietary_module);


        //LinearLayout linearLayout = (LinearLayout) findViewById(R.id.food_list);
        //linearLayout.setVisibility(View.INVISIBLE);
        //ScrollView myskrol1 = (ScrollView) findViewById(R.id.skrol_1);
        //myskrol1.setVisibility(View.INVISIBLE);

        //ScrollView myskrol2 = (ScrollView) findViewById(R.id.skrol_2);







        /*
        //word list for food
        final ArrayList<Word> words = new ArrayList<Word>();
        //add value in array
        words.add(new Word("Nasi Dagang", "508.7 kcal"));
        words.add(new Word("Porridge", "203.5 kcal"));
        words.add(new Word("Beef Soup(Sup Daging)", "165.8 kcal"));
        words.add(new Word("Kuih Lapis", "131.8 kcal"));
        words.add(new Word("Kuih Tepung Pelita", "101.3 kcal"));
        words.add(new Word("Dragon Fruit", "53.5 kcal"));
        words.add(new Word("Mango Juice", "160 kcal"));
        words.add(new Word("Thai Chilli Beef (Pataya)", "98.5 kcal"));
        words.add(new Word("Egg,White Only(Telur Putih)", "15.3 kcal"));
        words.add(new Word("Telur (Whole)", "68.5 kcal"));
        words.add(new Word("Minyak Zaitun", "117.9 kcal"));
        words.add(new Word("Crab", "76 kcal"));
        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        calories_food_choose
        */


        //mFoodSpinner = (Spinner) findViewById(R.id.spinner_food);
        //setupSpinner();




        checkBox1 = (CheckBox) findViewById(R.id.checkBoxf1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBoxf2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBoxf3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBoxf4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBoxf5);
        checkBox6 = (CheckBox) findViewById(R.id.checkBoxf6);
        checkBox7 = (CheckBox) findViewById(R.id.checkBoxf7);
        checkBox8 = (CheckBox) findViewById(R.id.checkBoxf8);
        checkBox9 = (CheckBox) findViewById(R.id.checkBoxf9);
        checkBox10 = (CheckBox) findViewById(R.id.checkBoxf10);
        checkBox11 = (CheckBox) findViewById(R.id.checkBoxf11);
        checkBox12 = (CheckBox) findViewById(R.id.checkBoxf12);
        checkBox13 = (CheckBox) findViewById(R.id.checkBoxf13);
        checkBox14 = (CheckBox) findViewById(R.id.checkBoxf14);







        upf1 = (ImageButton) findViewById(R.id.upf1);
        downf1 = (ImageButton) findViewById(R.id.downf1);

        upf2 = (ImageButton) findViewById(R.id.upf2);
        downf2 = (ImageButton) findViewById(R.id.downf2);

        upf3 = (ImageButton) findViewById(R.id.upf3);
        downf3 = (ImageButton) findViewById(R.id.downf3);

        upf4 = (ImageButton) findViewById(R.id.upf4);
        downf4 = (ImageButton) findViewById(R.id.downf4);

        upf5 = (ImageButton) findViewById(R.id.upf5);
        downf5 = (ImageButton) findViewById(R.id.downf5);

        upf6 = (ImageButton) findViewById(R.id.upf6);
        downf6 = (ImageButton) findViewById(R.id.downf6);

        upf7 = (ImageButton) findViewById(R.id.upf7);
        downf7 = (ImageButton) findViewById(R.id.downf7);

        upf8 = (ImageButton) findViewById(R.id.upf8);
        downf8 = (ImageButton) findViewById(R.id.downf8);


        upf9 = (ImageButton) findViewById(R.id.upf9);
        downf9 = (ImageButton) findViewById(R.id.downf9);

        upf10 = (ImageButton) findViewById(R.id.upf10);
        downf10 = (ImageButton) findViewById(R.id.downf10);

        upf11 = (ImageButton) findViewById(R.id.upf11);
        downf11 = (ImageButton) findViewById(R.id.downf11);

        upf12 = (ImageButton) findViewById(R.id.upf12);
        downf12 = (ImageButton) findViewById(R.id.downf12);

        upf13 = (ImageButton) findViewById(R.id.upf13);
        downf13 = (ImageButton) findViewById(R.id.downf13);

        upf14 = (ImageButton) findViewById(R.id.upf14);
        downf14 = (ImageButton) findViewById(R.id.downf14);










    }


    /**
     * Setup the dropdown spinner that allows the user to select the gender of the pet.
     */
    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_food_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mFoodSpinner.setAdapter(genderSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mFoodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.food_A))) {
                        //mGender = PetEntry.GENDER_MALE;
                        //myskrol1.setVisibility(View.INVISIBLE);
                        //myskrol2.setVisibility(View.VISIBLE);
                    } else if (selection.equals(getString(R.string.food_B))) {
                        //mGender = PetEntry.GENDER_FEMALE;
                        //myskrol2.setVisibility(View.INVISIBLE);
                        //myskrol1.setVisibility(View.VISIBLE);
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

//    // this methode for activity option when clicked
//    public void switchMenu(View view) {
//
//        myFoood = myFoood + 1;
//
//        if (myFoood % 3 == 1) {
//            inputFood = "1";//0
//            //Toast.makeText(this, "Sedentary behaviour refers unactive activity such as sitting at chair whole day.", Toast.LENGTH_LONG).show();
//        } else if (myFoood % 3 == 2) {
//            inputFood = "2";//1
//            //Toast.makeText(this, "Moderate behaviour refers to partial activity such as work at office and do some exercise.", Toast.LENGTH_LONG).show();
//        } else if (myFoood % 3 == 0) {
//            inputFood = "3";//2
//            //Toast.makeText(this, "Marked behaviour refers to activite person like atlite.", Toast.LENGTH_LONG).show();
//
//        }
//
//        displayFood(inputFood);
//
//    }

    /**
     * Displays the activity status inside activity option.
     */
//    public void displayFood(String inputFood) {
//        TextView foodView = (TextView) findViewById(R.id.inputFood);
//        foodView.setText(inputFood);
//    }





    public void upf1(View view) {
        valuef1 = valuef1 + 1;
        displayf1(valuef1);
    }
    public void downf1(View view) {
        valuef1 = valuef1 - 1;
        if (valuef1<1){
            valuef1 = 0;
        }
        displayf1(valuef1);
    }
    public void displayf1(int score) {
        TextView f1View = (TextView) findViewById(R.id.viewf1);
        f1View.setText(String.valueOf(score));
    }




    public void upf2(View view) {
        valuef2 = valuef2 + 1;
        displayf2(valuef2);
    }
    public void downf2(View view) {
        valuef2 = valuef2 - 1;
        if (valuef2<1){
            valuef2 = 0;
        }
        displayf2(valuef2);
    }
    public void displayf2(int score) {

        TextView f2View = (TextView) findViewById(R.id.viewf2);
        f2View.setText(String.valueOf(score));
    }




    public void upf3(View view) {
        valuef3 = valuef3 + 1;
        displayf3(valuef3);
    }
    public void downf3(View view) {
        valuef3 = valuef3 - 1;
        if (valuef3<1){
            valuef3 = 0;
        }
        displayf3(valuef3);
    }
    public void displayf3(int score) {

        TextView f3View = (TextView) findViewById(R.id.viewf3);
        f3View.setText(String.valueOf(score));
    }



    public void upf4(View view) {
        valuef4 = valuef4 + 1;
        displayf4(valuef4);
    }
    public void downf4(View view) {
        valuef4 = valuef4 - 1;
        if (valuef4<1){
            valuef4 = 0;
        }
        displayf4(valuef4);
    }
    public void displayf4(int score) {

        TextView f4View = (TextView) findViewById(R.id.viewf4);
        f4View.setText(String.valueOf(score));
    }





    public void upf5(View view) {
        valuef5 = valuef5 + 1;
        displayf5(valuef5);
    }
    public void downf5(View view) {
        valuef5 = valuef5 - 1;
        if (valuef5<1){
            valuef5 = 0;
        }
        displayf5(valuef5);
    }
    public void displayf5(int score) {

        TextView f5View = (TextView) findViewById(R.id.viewf5);
        f5View.setText(String.valueOf(score));
    }







    public void upf6(View view) {
        valuef6 = valuef6 + 1;
        displayf6(valuef6);
    }
    public void downf6(View view) {
        valuef6 = valuef6 - 1;
        if (valuef6<1){
            valuef6 = 0;
        }
        displayf6(valuef6);
    }
    public void displayf6(int score) {

        TextView f6View = (TextView) findViewById(R.id.viewf6);
        f6View.setText(String.valueOf(score));
    }






    public void upf7(View view) {
        valuef7 = valuef7 + 1;
        displayf7(valuef7);
    }
    public void downf7(View view) {
        valuef7 = valuef7 - 1;
        if (valuef7<1){
            valuef7 = 0;
        }
        displayf7(valuef7);
    }
    public void displayf7(int score) {

        TextView f7View = (TextView) findViewById(R.id.viewf7);
        f7View.setText(String.valueOf(score));
    }




    public void upf8(View view) {
        valuef8 = valuef8 + 1;
        displayf8(valuef8);
    }
    public void downf8(View view) {
        valuef8 = valuef8 - 1;
        if (valuef8<1){
            valuef8 = 0;
        }
        displayf8(valuef8);
    }
    public void displayf8(int score) {

        TextView f8View = (TextView) findViewById(R.id.viewf8);
        f8View.setText(String.valueOf(score));
    }







    public void upf9(View view) {
        valuef9 = valuef9 + 1;
        displayf9(valuef9);
    }
    public void downf9(View view) {
        valuef9 = valuef9 - 1;
        if (valuef9<1){
            valuef9 = 0;
        }
        displayf9(valuef9);
    }
    public void displayf9(int score) {

        TextView f9View = (TextView) findViewById(R.id.viewf9);
        f9View.setText(String.valueOf(score));
    }










    public void upf10(View view) {
        valuef10 = valuef10 + 1;
        displayf10(valuef10);
    }
    public void downf10(View view) {
        valuef10 = valuef10 - 1;
        if (valuef10<1){
            valuef10 = 0;
        }
        displayf10(valuef10);
    }
    public void displayf10(int score) {

        TextView f10View = (TextView) findViewById(R.id.viewf10);
        f10View.setText(String.valueOf(score));
    }




    public void upf11(View view) {
        valuef11 = valuef11 + 1;
        displayf11(valuef11);
    }
    public void downf11(View view) {
        valuef11 = valuef11 - 1;
        if (valuef11<1){
            valuef11 = 0;
        }
        displayf11(valuef11);
    }
    public void displayf11(int score) {

        TextView f11View = (TextView) findViewById(R.id.viewf11);
        f11View.setText(String.valueOf(score));
    }





    public void upf12(View view) {
        valuef12 = valuef12 + 1;
        displayf12(valuef12);
    }
    public void downf12(View view) {
        valuef12 = valuef12 - 1;
        if (valuef12<1){
            valuef12 = 0;
        }
        displayf12(valuef12);
    }
    public void displayf12(int score) {

        TextView f12View = (TextView) findViewById(R.id.viewf12);
        f12View.setText(String.valueOf(score));
    }





    public void upf13(View view) {
        valuef13 = valuef13 + 1;
        displayf13(valuef13);
    }
    public void downf13(View view) {
        valuef13 = valuef13 - 1;
        if (valuef13<1){
            valuef13 = 0;
        }
        displayf13(valuef13);
    }
    public void displayf13(int score) {

        TextView f13View = (TextView) findViewById(R.id.viewf13);
        f13View.setText(String.valueOf(score));
    }






    public void upf14(View view) {
        valuef14 = valuef14 + 1;
        displayf14(valuef14);
    }
    public void downf14(View view) {
        valuef14 = valuef14 - 1;
        if (valuef14<1){
            valuef14 = 0;
        }
        displayf14(valuef14);
    }
    public void displayf14(int score) {

        TextView f14View = (TextView) findViewById(R.id.viewf14);
        f14View.setText(String.valueOf(score));
    }
















    public void refresh (View view) {

        //set 0
        totalCaloriesChoose = 0.00;
        totalCaloriesRemain = 0.00;

        if(checkBox1.isChecked() == true){
            totalCaloriesChoose = totalCaloriesChoose + 508.7*valuef1;
        }

        if (checkBox2.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 660.5*valuef2;
        }

        if (checkBox3.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 436.0*valuef3;
        }

        if (checkBox4.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 381.0*valuef4;
        }

        if (checkBox5.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 722.0*valuef5;
        }

        if (checkBox6.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 359.0*valuef6;
        }

        if (checkBox7.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 217.0*valuef7;
        }

        if (checkBox8.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 390.0*valuef8;
        }

        if (checkBox9.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 166.0*valuef9;
        }

        if (checkBox10.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 128.0*valuef10;
        }

        if (checkBox11.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 112.0*valuef11;
        }

        if (checkBox12.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 146.7*valuef12;
        }

        if (checkBox13.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 127.3*valuef13;
        }


        if (checkBox14.isChecked() == true) {
            totalCaloriesChoose = totalCaloriesChoose + 229.0*valuef14;
        }




        if(totalCaloriesChoose < 1200.0) {
            // Create an AlertDialog.Builder and set the message, and click listeners
            // for the postivie and negative buttons on the dialog.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Your food selection is unhealthy");
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
        else if(totalCaloriesChoose >= 1200 && totalCaloriesChoose <= 2000){
            // Create an AlertDialog.Builder and set the message, and click listeners
            // for the postivie and negative buttons on the dialog.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Your food selection fulfill your calories requirement for today.");
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
            builder.setMessage("Your food selection is exceed your need.");
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
        totalCaloriesRemain = targerCalories -  totalCaloriesChoose;




        displayForTeamA(totalCaloriesChoose);
        displayForTeamB(totalCaloriesRemain);
    }


    public void read (View view) {


    }


    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(Double score) {
        TextView scoreView = (TextView) findViewById(R.id.calories_food_choose);
        scoreView.setText(String.valueOf(score));

    }

    public void displayForTeamB(Double scoreb) {
        TextView scoreBView = (TextView) findViewById(R.id.calories_food_remain);
        scoreBView.setText(String.valueOf(scoreb));

    }
}
