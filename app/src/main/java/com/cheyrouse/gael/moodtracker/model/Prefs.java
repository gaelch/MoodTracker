package com.cheyrouse.gael.moodtracker.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Prefs  {

    private static Prefs instance;
    private static String Moods = "Mood";
    public static ArrayList<Mood> get;


    public SharedPreferences getPrefs() {
        return prefs;
    }

    public void setPrefs(SharedPreferences prefs) {
        Prefs.prefs = prefs;
    }

    private static SharedPreferences prefs;
    private Mood mood;


    private Prefs(Context context) {

        String PREFS_MOODSTORE = "Moodstore";
        prefs = context.getSharedPreferences(PREFS_MOODSTORE, Activity.MODE_PRIVATE);

    }

    public static Prefs get(Context context) {
        if (instance == null)
            instance = new Prefs(context);
        return instance;
    }

    public void storeMoodstore(ArrayList<Mood> moodstore) {
        //start writing (open the file)
        SharedPreferences.Editor editor = prefs.edit();
        //put the data
        Gson gson = new Gson();
        String json = gson.toJson(moodstore);
        editor.putString(Moods, json);
        //close the file
        editor.apply();
    }

    public ArrayList<Mood> getMoodstore() {
        Gson gson = new Gson();
        String json = prefs.getString(Moods, "");

        ArrayList<Mood> moodstore;

        if (json.length() < 1) {
            moodstore = new ArrayList<>();
        } else {
            Type type = new TypeToken<ArrayList<Mood>>() {
            }.getType();
            moodstore = gson.fromJson(json, type);
        }

        //return the value that was stored under the key
        //"NAME". If there was no value stored under this key, return null.
        return moodstore;
    }
}


