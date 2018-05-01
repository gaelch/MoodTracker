package com.cheyrouse.gael.moodtracker.controller;



import com.cheyrouse.gael.moodtracker.model.Moods;

import java.util.List;

class MoodBank {

    private List<Moods> mMoodBank;

    public List getmMoodBank() {
        return mMoodBank;
    }

    public void setmMoodBank(List mMoodBank) {
        this.mMoodBank = mMoodBank;
    }
}
