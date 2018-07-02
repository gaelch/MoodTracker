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

//Adapters provide a binding from an app-specific data set that is displayed within a RecyclerView.
public class ItemAdapter extends RecyclerView.Adapter<MyViewHolder>  {
    private final Context mContext;
    private ArrayList<Mood> lMoodStore; // local variable to the ItemAdapter class, accessible from all functions of the class


    //adapter constructor
    public ItemAdapter(ArrayList<Mood> moods, Context context) {
        this.lMoodStore = moods;
        mContext = context;
    }

    //Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.history_line_layout, parent, false);
        return new MyViewHolder(view);
    }

    //This method internally calls onBindViewHolder(ViewHolder, int) to update the RecyclerView.ViewHolder
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        holder.mainLayout.setLayoutParams(new RelativeLayout.LayoutParams(230 + lMoodStore.get(position).getId() * 215,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        //call ArrayList items position to display them
        final Mood item = lMoodStore.get(position);

        //put background colors items
        int idDrawable = lMoodStore.get(position).getBackground();
        Drawable drawable = mContext.getResources().getDrawable(idDrawable);
        holder.textView.setBackground(drawable);
        holder.commentButton.setBackground(drawable);

        // put week days on textView
        holder.textView.setText(item.getDays(lMoodStore.size() - position));

        //if comment exist, comment icon set visible and comment show when user click
        if (lMoodStore.get(position).getComment() != null){
            holder.commentButton.setVisibility(View.VISIBLE);
            final String comment = lMoodStore.get(position).getComment();

            holder.commentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, comment, Toast.LENGTH_LONG).show();
                }
            });
        }else holder.commentButton.setVisibility(View.INVISIBLE);
    }

    //Returns the total number of items in the data set held by the adapter
    @Override
    public int getItemCount() {
        if (lMoodStore != null) {
            return lMoodStore.size();
        } else {
            return 0;
        }
    }

}
