package com.example.tuan.obesityweightwatcher;

/**
 * Created by tuan on 14/5/2017.
 */

public class Word {

    //for food name
    private String mFoodName;

    //for calories value contain in food
    private String mCaloriesValue;



    public Word (String foodName,String caloriesValue) {
        mFoodName = foodName;
        mCaloriesValue = caloriesValue;

    }
    //get food name of the word
    public String foodName() {
        return mFoodName;
    }

    //get calories value of the foo
    public String caloriesValue () {
        return mCaloriesValue;
    }




}

