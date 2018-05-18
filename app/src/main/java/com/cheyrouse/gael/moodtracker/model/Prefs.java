package com.cheyrouse.gael.moodtracker.model;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.cheyrouse.gael.moodtracker.controller.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Prefs  {
    @SuppressLint("StaticFieldLeak")
    private static Prefs instance;
    private static String PREFS_MOODSTORE = "Moodstore";
    private static String Moods = "Moods";
    public static ArrayList<com.cheyrouse.gael.moodtracker.model.Moods> get;

    private Context context;

    public SharedPreferences getPrefs() {
        return prefs;
    }

    public void setPrefs(SharedPreferences prefs) {
        Prefs.prefs = prefs;
    }

    private static SharedPreferences prefs;
    private Moods moods;


    private Prefs(Context context) {
        this.context = context;

        prefs = context.getSharedPreferences(PREFS_MOODSTORE, Activity.MODE_PRIVATE);

    }

    public static Prefs get(MainActivity context) {
        if (instance == null)
            instance = new Prefs(context);
        return instance;
    }

    public void storeMoodstore(ArrayList<Moods> moodstore) {
        //start writing (open the file)
        SharedPreferences.Editor editor = prefs.edit();
        //put the data
        Gson gson = new Gson();
        String json = gson.toJson(moodstore);
        editor.putString(Moods, json);
        //close the file
        editor.apply();
    }

    public static ArrayList<Moods> getMoodstore() {
        Gson gson = new Gson();
        String json = prefs.getString(Moods, "");

        ArrayList<Moods> moodstore;

        if (json.length() < 1) {
            moodstore = new ArrayList<>();
        } else {
            Type type = new TypeToken<ArrayList<Moods>>() {
            }.getType();
            moodstore = gson.fromJson(json, type);
        }

        //return the value that was stored under the key
        //"NAME". If there was no value stored under this key, return null.
        return moodstore;
    }
}


