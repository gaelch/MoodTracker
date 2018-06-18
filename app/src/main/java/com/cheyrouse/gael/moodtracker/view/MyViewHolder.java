package com.cheyrouse.gael.moodtracker.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cheyrouse.gael.moodtracker.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public View mainLayout;
    public TextView textView;
    public ImageButton commentButton;


    MyViewHolder(View itemView) {
        super(itemView);
        mainLayout = itemView.findViewById(R.id.main_lay);
        textView = itemView.findViewById(R.id.textView);
        commentButton = itemView.findViewById(R.id.commentButton);
    }
}


