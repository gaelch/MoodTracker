package com.cheyrouse.gael.moodtracker.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Moods implements Parcelable {

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

    public String getmComment() {
        return mComment;
    }

    public void setmComent(String mComment) {
        this.mComment = mComment;
    }


    public Moods(int smiley, int background, int id) {

        mSmiley = smiley;
        mBackground = background;
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

    private Moods(Parcel in) {
        this.mSmiley = in.readInt();
        this.mBackground = in.readInt();
        this.mComment = in.readString();
    }

    public static final Parcelable.Creator<Moods> CREATOR = new Parcelable.Creator<Moods>() {
        @Override
        public Moods createFromParcel(Parcel source) {
            return new Moods(source);
        }

        @Override
        public Moods[] newArray(int size) {
            return new Moods[size];
        }
    };
}

