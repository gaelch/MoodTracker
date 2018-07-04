package com.cheyrouse.gael.moodtracker.model;

import android.content.Context;

import com.cheyrouse.gael.moodtracker.R;
import com.cheyrouse.gael.moodtracker.controller.MainActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SaveMoodHelper {
    private Context context;

    //SaveMoodHelper builder
    public SaveMoodHelper( MainActivity context) {

        this.context = context;
    }

    //to recover the current date
    public Date getCurrentDate() {
        Date date;
        DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        date = Calendar.getInstance().getTime();
        date = new Date(outputFormatter.format(date));
        return date;
    }
    //this method is called to save current mood
    public void SaveCurrentMood(Mood currentMood) {
        currentMood.setDate(getCurrentDate());
        Prefs prefs = Prefs.get(context);
        ArrayList<Mood> prefsMoodStore = prefs.getMoodStore();
        if(prefsMoodStore == null){
            prefsMoodStore = new ArrayList<>();
        }
        if (prefsMoodStore.size() > 0 && (prefsMoodStore.get(prefsMoodStore.size()-1).getDate()).equals(getCurrentDate())) {
            prefsMoodStore.remove(prefsMoodStore.size() - 1);
        }
        prefsMoodStore.add(currentMood);

        if (prefsMoodStore.size() > 8) {
            prefsMoodStore.remove(0);
            System.out.println(prefsMoodStore.size());
        }

        prefs.storeMoodStore(prefsMoodStore);
    }
    //method called by AlarmMidnight to save current mood or default mood if MoodTracker is not started in the day
    public void SaveMoodMidnight() {
        Prefs prefs = Prefs.get(context);
        ArrayList<Mood> prefsMoodStore = prefs.getMoodStore();
        if(prefsMoodStore == null){
            prefsMoodStore = new ArrayList<>();
        }
        if (prefsMoodStore.size() > 0 && (prefsMoodStore.get(prefsMoodStore.size()-1).getDate()) != getCurrentDate()) {
            Mood defaultMood = new Mood(R.drawable.smiley_happy, R.color.light_sage, 1, "", getCurrentDate());
            prefsMoodStore.add(defaultMood);
        }

        if (prefsMoodStore.size() > 7) {
            prefsMoodStore.remove(0);
        }

        prefs.storeMoodStore(prefsMoodStore);
    }

}


