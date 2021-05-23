package com.app.newsifyapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Constants {

    public static String BASE_URL = "https://api.nytimes.com/svc/";

    public static String API_KEY = "x3QG3u0F0XAdC10Osma8LUkC1TZzeHUL";
    public static String BUNDLE_TOP_DATA = "TopStoriesData";
    public static String BUNDLE_MOST_DATA = "MostPopularData";

    public static boolean isInternetConnected(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static String getCurrentTimeStamp(String d) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a", Locale.ENGLISH);
        Date date = null;

        try {
            date = inputFormat.parse(d);
        } catch (ParseException e) {
            return null;
        }

        return outputFormat.format(date);

    }

    static String getCurrentTimeStamp2(String d) {

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a", Locale.ENGLISH);
        Date date = null;
        try {
            date = inputFormat.parse(d);
        } catch (ParseException e) {
            return null;
        }

        return outputFormat.format(date);

    }

    public static String getCurrentTimeStamp3(String d) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = inputFormat.parse(d);
        } catch (ParseException e) {
            return null;
        }

        return outputFormat.format(date);
    }
}
