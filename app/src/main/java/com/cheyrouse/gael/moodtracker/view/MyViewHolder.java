package com.cheyrouse.gael.moodtracker.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cheyrouse.gael.moodtracker.R;

//this class is used to initialize the views
public class MyViewHolder extends RecyclerView.ViewHolder {
    public final View mainLayout;
    public TextView textView;
    public ImageButton commentButton;

    //item adapter view initialization
    MyViewHolder(View itemView) {
        super(itemView);
        mainLayout = itemView;
        textView = itemView.findViewById(R.id.textView);
        commentButton = itemView.findViewById(R.id.commentButton);
    }
}


