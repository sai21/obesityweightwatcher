package com.example.tuan.obesityweightwatcher;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuan.obesityweightwatcher.data.AppDbHelper;

/**
 * Created by tuan on 13/5/2017.
 */

public class MainMenu extends AppCompatActivity {

    private AppDbHelper db;

    private TextView userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        db = new AppDbHelper(this);

        TextView username = (TextView) findViewById(R.id.current_user);
        username.setText(db.getMyUsername ());
        username.setVisibility(View.INVISIBLE);

    }



    public void userInfo (View view) {
        //create new intent to open user info page
        Intent jumpUserInfoIntent = new Intent(MainMenu.this, UserInfo.class);
        //strt user info
        startActivity(jumpUserInfoIntent);
    }

    public void userDietary (View view) {
        //create new intent to open user info page
        Intent jumpFoodListIntent = new Intent(MainMenu.this, FoodList.class);
        //strt user info
        startActivity(jumpFoodListIntent);

    }

    public void userFitness (View view) {
        //create new intent to open user info page
        Intent jumpActivityListIntent = new Intent(MainMenu.this, ActivityList.class);
        //strt user info
        startActivity(jumpActivityListIntent);

        //Toast.makeText(getApplicationContext(),"This is user fitness",Toast.LENGTH_LONG).show();
    }
    public void userWatcher (View view) {
        //create new intent to open user info page
        Intent jumpWeightWatcherIntent = new Intent(MainMenu.this, ListDietWatcher.class);
        //strt user info
        startActivity(jumpWeightWatcherIntent);

        //Toast.makeText(getApplicationContext(),"This is user fitness",Toast.LENGTH_LONG).show();
    }

    public void healthInformation (View view) {

        //create new intent to open user info page
        Intent jumpHealthInfoIntent = new Intent(MainMenu.this, HealthInfo.class);
        //strt user info
        startActivity(jumpHealthInfoIntent);

    }

    public void userLogout (View view) {
        //create new intent to open user info page
        Intent jumpLogoutIntent = new Intent(MainMenu.this, MainActivity.class);
        //strt user info
        startActivity(jumpLogoutIntent);

        //Toast.makeText(getApplicationContext(),"This is user fitness",Toast.LENGTH_LONG).show();
    }


}

