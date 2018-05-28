package com.cheyrouse.gael.moodtracker.controller;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.cheyrouse.gael.moodtracker.R;
import com.cheyrouse.gael.moodtracker.model.Adapter;
import com.cheyrouse.gael.moodtracker.model.Mood;
import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RecyclerView recyclerView = findViewById(R.id.activity_history_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Mood> prefsMoodStore = getIntent().getParcelableArrayListExtra("preferences");
        Adapter mAdapter = new Adapter (prefsMoodStore);
        recyclerView.setAdapter(mAdapter);
    }




}
