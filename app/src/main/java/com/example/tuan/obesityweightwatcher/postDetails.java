package com.example.tuan.obesityweightwatcher;

import java.security.PrivateKey;

/**
 * Created by tuan on 16/5/2017.
 */

public class postDetails {
    private int id;
    private String username;
    private String password;
    private String weight;
    private String height;
    private String bmivalue;
    private String date;
    private String bmiclass;
    private String caloriesloss;


    public postDetails(int id, String username, String password, String weight,String height, String bmivalue, String date, String bmiclass, String caloriesloss) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.bmivalue = bmivalue;
        this.date = date;
        this.bmiclass = bmiclass;
        this.caloriesloss = caloriesloss;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String location) {
        this.password = password;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBmiValue() {
        return bmivalue;
    }

    public void setBmiValue(String bmivalue) {
        this.bmivalue = bmivalue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBmiClass() {
        return bmiclass;
    }

    public void getBmiClass(String bmiclass) {
        this.bmiclass = bmiclass;
    }

    public String getCaloriesLoss() {
        return caloriesloss;
    }

    public void getCaloriesLoss(String caloriesloss) {
        this.caloriesloss = caloriesloss;
    }


}