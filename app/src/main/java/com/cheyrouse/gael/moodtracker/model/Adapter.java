package com.cheyrouse.gael.moodtracker.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.cheyrouse.gael.moodtracker.R;
import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>  {


    private ArrayList<Mood> lMoodstore; //variable locale à la classe Adapter, accessible depuis toutes le fct de la classe
    private Context context;

    /*public Adapter(Adapter savedMoods) {
        lMoodstore = savedMoods; //on stock les humeurs fournies en parametres dans la variable locale à la classe
    }

    ou*/

    public Adapter(ArrayList<Mood> moods) {
        lMoodstore = moods;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_history, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        if (lMoodstore.get(position).getmComment() != null){
            holder.commentButton.setVisibility(View.VISIBLE);

            holder.commentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, holder.getAdapterPosition(), Toast.LENGTH_LONG).show();
                }
            });
        }//else holder.commentButton.setVisibility(View.INVISIBLE);
    }


    @Override
    public int getItemCount() {
        return lMoodstore.size();
    }





    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //public static ImageView imageView;
        public TextView textView;
        public ImageButton commentButton;

        MyViewHolder(View itemView) {
            super(itemView);
            //imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            commentButton = itemView.findViewById(R.id.commentButton);
        }
    }

}
