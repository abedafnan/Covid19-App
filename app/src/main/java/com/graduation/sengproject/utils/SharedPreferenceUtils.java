package com.graduation.sengproject.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.graduation.sengproject.models.Country;

public class SharedPreferenceUtils {

    private static SharedPreferenceUtils instance;
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String IS_DARK_MODE_ON = "isDarkModeOn";
    private static final String COUNTRY = "country";

    private SharedPreferenceUtils(Context context) {
        this.context = context;
        if (context != null) {
            sharedPreferences = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
    }

    public static SharedPreferenceUtils getInstance(Context context) {
        if (instance == null)
            return new SharedPreferenceUtils(context);

        return instance;
    }

    public boolean isDarkModeOn() {
        return sharedPreferences.getBoolean(IS_DARK_MODE_ON, false);
    }

    public void setDarkMode(boolean isOn) {
        editor.putBoolean(IS_DARK_MODE_ON, isOn);
        editor.commit();
    }

    public Country getCountry() {
        String countryString = sharedPreferences.getString(COUNTRY, "");
        return new Gson().fromJson(countryString, Country.class);
    }

    public void setCountry(Country country) {
        editor.putString(COUNTRY, new Gson().toJson(country));
        editor.commit();
    }
}
