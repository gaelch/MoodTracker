package com.cheyrouse.gael.moodtracker.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cheyrouse.gael.moodtracker.R;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


    private ArrayList<Moods> lMoodstore; //variable locale à la classe Adapter, accessible depuis toutes le fct de la classe

    /*public Adapter(Adapter savedMoods) {
        lMoodstore = savedMoods; //on stocke les humeurs fournies en parametres dans la variable locale à la classe
    }

    ou*/

    public Adapter(ArrayList<Moods> pref) {
        lMoodstore = Prefs.getMoodstore();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_history, parent, false);
        return new MyViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       // lMoodstore.get(position);
       // LinearLayout.setBackground(lMoodstore.get(position).getmBackground());
        MyViewHolder.imageView.setImageResource(R.drawable.ic_comment_black_48px);
    }

    @Override
    public int getItemCount() {
        return lMoodstore.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public static ImageView imageView;
        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

}
