package com.cheyrouse.gael.moodtracker.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cheyrouse.gael.moodtracker.R;
import com.cheyrouse.gael.moodtracker.view.ItemAdapter;
import com.cheyrouse.gael.moodtracker.model.Mood;
import com.cheyrouse.gael.moodtracker.model.Prefs;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ArrayList<Mood> list = Prefs.get(this).getMoodstore();

        RecyclerView recyclerView = findViewById(R.id.activity_history_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemAdapter mItemAdapter = new ItemAdapter(list, this);
        recyclerView.setAdapter(mItemAdapter);
    }


}
