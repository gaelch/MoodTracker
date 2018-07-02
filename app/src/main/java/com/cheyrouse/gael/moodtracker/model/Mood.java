package com.cheyrouse.gael.moodtracker.model;


import java.util.Date;
import java.util.Hashtable;

//creating the mood and these parameters
public class Mood  {
    private int mSmiley;
    private int mBackground;
    private String mComment;
    private Date date;
    private int mId;

    public int getId() {
        return mId;
    }

    public int getSmiley() {
        return mSmiley;
    }

    public int getBackground() {
        return mBackground;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        this.mComment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //Mood constructor
    public Mood(int mSmiley, int mBackground, int Id, String mComment, Date date) {
        this.mSmiley = mSmiley;
        this.mBackground = mBackground;
        this.mId = Id;
        this.mComment = mComment;
        this.date = date;
    }

    //This Hash table is called for display days on adapter
    public String getDays(int days) {
        Hashtable<Integer, String> weekDays = new Hashtable<>();
        weekDays.put(7, "Il y a une semaine");
        weekDays.put(6, "Il y a 6 jours");
        weekDays.put(5, "Il y a 5 jours");
        weekDays.put(4, "Il y a 4 jours");
        weekDays.put(3, "Il y a 3 jours");
        weekDays.put(2, "Avant-hier");
        weekDays.put(1, "Hier");

        return weekDays.get(days);
    }
}

