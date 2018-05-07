package com.cheyrouse.gael.moodtracker.model;



public class Moods {

    private final int mId;
    private int mSmiley;
    private int mBackground;
    private String mComment;

    public int getmSmiley() {
        return mSmiley;
    }

    public int getmBackground() {
        return mBackground;
    }

    public String getmComment() {
        return mComment;
    }

    public void setmComent(String mComment) {
        this.mComment = mComment;
    }

    public Moods(int smiley, int background, int id){
        mSmiley = smiley;
        mBackground = background;
        mId = id;

    }
}
