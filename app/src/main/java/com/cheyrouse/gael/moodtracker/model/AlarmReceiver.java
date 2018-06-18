package com.cheyrouse.gael.moodtracker.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public class AlarmReceiver extends BroadcastReceiver {

    SaveMoodHelper mSaveMoodHelper;

    @Override
    public void onReceive(Context context, Intent intent) {
        mSaveMoodHelper.SaveMoodMidnight();
    }
}
