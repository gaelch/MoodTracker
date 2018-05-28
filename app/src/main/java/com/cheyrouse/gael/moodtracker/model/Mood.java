package com.cheyrouse.gael.moodtracker.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Mood implements Parcelable {

    private int mSmiley;
    private int mBackground;
    private String mComment;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    private int mId;

    public int getmSmiley() {
        return mSmiley;
    }

    public int getmBackground() {
        return mBackground;
    }

    public  String getmComment() {
        return mComment;
    }

    public static void setmComment(String mComment) {
    }

    @Override
    public String toString() {
        return "Mood{" +
                "mComment='" + mComment + '\'' +
                '}';
    }

    public Mood(int smiley, int background, int id, String comment) {

        mSmiley = smiley;
        mBackground = background;
        mId = id;
        mComment = comment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mSmiley);
        dest.writeInt(this.mBackground);
        dest.writeString(this.mComment);
    }

    private Mood(Parcel in) {
        this.mSmiley = in.readInt();
        this.mBackground = in.readInt();
        this.mComment = in.readString();
    }

    public static final Parcelable.Creator<Mood> CREATOR = new Parcelable.Creator<Mood>() {
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

