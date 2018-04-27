package com.cheyrouse.gael.moodtracker.model;

public class Moods {

    private String mSmiley;
    private String mBackground;
    private String mComment;

    public String getmBackground() {
        return mBackground;
    }

    public void setmBackground(String mBackground) {
        this.mBackground = mBackground;
    }

    public String getmSmiley() {

        return mSmiley;
    }

    public void setmSmiley(String mSmiley) {
        this.mSmiley = mSmiley;
    }

    public String getmComment() {
        return mComment;
    }

    public void setmComent(String mComment) {
        this.mComment = mComment;
    }

    public Moods(){
        mSmiley = "";
        mBackground = "";
        mComment = "";

    }
}
