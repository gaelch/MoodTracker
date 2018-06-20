package com.cheyrouse.gael.moodtracker.model;

import android.content.Context;

import com.cheyrouse.gael.moodtracker.R;
import com.cheyrouse.gael.moodtracker.controller.MainActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SaveMoodHelper {
    private ArrayList<Mood> prefsMoodStore;
    private Context context;


    public SaveMoodHelper(ArrayList<Mood> prefsMoodStore, MainActivity context) {
        this.prefsMoodStore = prefsMoodStore;
        this.context = context;
    }

    public Date getCurrentDate() {
        Date date;
        DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        date = Calendar.getInstance().getTime();
        date = new Date(outputFormatter.format(date));
        return date;
    }

    public void SaveCurrentMood(Mood currentMood) {
        currentMood.setDate(getCurrentDate());
        Prefs prefs = Prefs.get(context);
        ArrayList<Mood> prefsMoodStore = prefs.getMoodstore();
        if(prefsMoodStore == null){
            prefsMoodStore = new ArrayList<>();
        }
        if (prefsMoodStore.size() > 0 && (prefsMoodStore.get(prefsMoodStore.size()-1).getDate())==(getCurrentDate())) {
            prefsMoodStore.remove(prefsMoodStore.size() - 1);
        }
        prefsMoodStore.add(currentMood);
        prefs.storeMoodstore(prefsMoodStore);

        if (prefsMoodStore.size() == 7) {
            prefsMoodStore.remove(0);
        }

    }

    public void SaveMoodMidnight() {
        Prefs prefs = Prefs.get(context);
        ArrayList<Mood> prefsMoodStore = prefs.getMoodstore();
        if(prefsMoodStore == null){
            prefsMoodStore = new ArrayList<>();
        }
        if (prefsMoodStore.size() > 0 && (prefsMoodStore.get(prefsMoodStore.size()-1).getDate()) != getCurrentDate()) {
            Mood defaultMood = new Mood(R.drawable.smiley_happy, R.color.light_sage, 1, "", getCurrentDate());
            prefsMoodStore.add(defaultMood);
            prefs.storeMoodstore(prefsMoodStore);
        }

        if (prefsMoodStore.size() == 7) {
            prefsMoodStore.remove(0);
        }
    }

}


