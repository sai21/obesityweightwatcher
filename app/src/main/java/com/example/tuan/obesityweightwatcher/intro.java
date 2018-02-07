package com.example.tuan.obesityweightwatcher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by tuan on 17/5/2017.
 */

public class intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);


        ImageView image = (ImageView) findViewById(R.id.intro_image);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation);
    }

    public void buttonIntro (View view) {
        //create new intent to open user info page
        Intent jumpUserIntroIntent = new Intent(intro.this, MainActivity.class);
        //strt user info
        startActivity(jumpUserIntroIntent);
    }
}
