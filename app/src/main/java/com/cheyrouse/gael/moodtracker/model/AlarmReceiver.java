package com.cheyrouse.gael.moodtracker.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

//
//receive an intent from the method alarmMidnight to call SaveMoodHelper
public class AlarmReceiver extends BroadcastReceiver {

    private SaveMoodHelper mSaveMoodHelper;
    //when AlarmMidnight start, this method call method SaveMoodMidnight
    @Override
    public void onReceive(Context context, Intent intent) {
        mSaveMoodHelper.SaveMoodMidnight();
    }
}
