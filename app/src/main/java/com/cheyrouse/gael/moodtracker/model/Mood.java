package com.cheyrouse.gael.moodtracker.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.Hashtable;

public class Mood implements Parcelable {

    private int mSmiley;
    private int mBackground;
    private String mComment;
    private Date date;
    private int mId;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmSmiley() {
        return mSmiley;
    }

    public void setmSmiley(int mSmiley) {
        this.mSmiley = mSmiley;
    }

    public int getmBackground() {
        return mBackground;
    }

    public void setmBackground(int mBackground) {
        this.mBackground = mBackground;
    }

    public String getmComment() {
        return mComment;
    }

    public void setmComment(String comment) {
        this.mComment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Mood(int mSmiley, int mBackground, int Id, String mComment, Date date) {

        this.mSmiley = mSmiley;
        this.mBackground = mBackground;
        this.mId = Id;
        this.mComment = mComment;
        this.date = date;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mSmiley);
        dest.writeInt(this.mBackground);
        dest.writeInt(this.mId);
        dest.writeString(this.mComment);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
    }

    protected Mood(Parcel in) {
        this.mSmiley = in.readInt();
        this.mBackground = in.readInt();
        this.mId = in.readInt();
        this.mComment = in.readString();
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
    }

    public static final Creator<Mood> CREATOR = new Creator<Mood>() {
        @Override
        public Mood createFromParcel(Parcel source) {
            return new Mood(source);
        }

        @Override
        public Mood[] newArray(int size) {
            return new Mood[size];
        }
    };
}

