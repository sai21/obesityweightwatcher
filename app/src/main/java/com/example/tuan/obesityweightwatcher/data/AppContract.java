package com.example.tuan.obesityweightwatcher.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by tuan on 13/5/2017.
 */

public class AppContract {

    private AppContract() {}

    /**
            * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.tuan.obesityweightwatcher";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.pets/pets/ is a valid path for
     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_APPS = "apps";









    public static final class AppEntry implements BaseColumns {


        /** The content URI to access the pet data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_APPS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_APPS;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_APPS;


        public final static String TABLE_NAME = "apps";
        public final static String _ID = BaseColumns._ID;
        //public final static String TYPE_USER_DATA ="userdata";
        public final static String COLUMN_USER_NAME ="name";
        public final static String COLUMN_USER_PASSWORD ="password";
        public final static String COLUMN_USER_WEIGHT ="weight";
        public final static String COLUMN_USER_HEIGHT ="height";
        public final static String COLUMN_USER_BMI_VALUE ="bmivalue";
        public final static String COLUMN_USER_BMI_CLASS="bmiclass";
        public final static String COLUMN_IDEAL_WEIGHT ="idealweight";
        public final static String COLUMN_DATE ="date";

        public final static String COLUMN_WEIGHT_SIX_MONTH ="weightsixmonth";
        public final static String COLUMN_WEIGHT_ONE_MONTH ="weightonemonth";
        public final static String COLUMN_WEIGHT_ONE_WEEK ="weightoneweek";
        public final static String COLUMN_CALORIES_MAINTAIN ="caloriesmaintain";
        public final static String COLUMN_CALORIES_LOSS ="caloriesloss";






        public final static String TYPE_FOOD_DATA ="fooddata";
        //public final static String TABLE_FOOD_NAME= "foods";
        public final static String COLUMN_FOOD_NAME ="foodname";
        public final static String COLUMN_FOOD_CALORIES ="foodcalories";




        public final static String TYPE_ACTIVITY_DATA ="userdata";
        //public final static String TABLE_ACTIVITY_NAME= "activity";
        public final static String COLUMN_ACTIVITY_NAME ="activityname";
        public final static String COLUMN_ACTIVITY_CALORIES ="activitycalories";








    }


}
