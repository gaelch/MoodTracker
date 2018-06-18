package com.cheyrouse.gael.moodtracker.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cheyrouse.gael.moodtracker.R;
import com.cheyrouse.gael.moodtracker.model.Mood;

import java.util.ArrayList;


public class ItemAdapter extends RecyclerView.Adapter<MyViewHolder>  {

    private final Context mContext;
    private ArrayList<Mood> lMoodstore; //variable locale à la classe ItemAdapter, accessible depuis toutes le fct de la classe

    public ItemAdapter(ArrayList<Mood> moods, Context context) {
        this.lMoodstore = moods;
        mContext = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.history_line_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        holder.mainLayout.setLayoutParams(new RelativeLayout.LayoutParams(230 + lMoodstore.get(position).getmId() * 215,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        final Mood item = lMoodstore.get(position);

        //put background colors items
        int idDrawable = lMoodstore.get(position).getmBackground();
        Drawable drawable = mContext.getResources().getDrawable(idDrawable);
        holder.textView.setBackground(drawable);
        holder.commentButton.setBackground(drawable);

        // put week days on textView
        holder.textView.setText(item.getDays(lMoodstore.size() - position));

        //if comment exist, comment icon set visible and comment show when user click
        if (lMoodstore.get(position).getmComment() != null){
            holder.commentButton.setVisibility(View.VISIBLE);
            final String comment = lMoodstore.get(position).getmComment();

            holder.commentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, comment, Toast.LENGTH_LONG).show();
                }
            });
        }else holder.commentButton.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        if (lMoodstore != null) {
            return lMoodstore.size();
        } else {
            return 0;
        }
    }

}
