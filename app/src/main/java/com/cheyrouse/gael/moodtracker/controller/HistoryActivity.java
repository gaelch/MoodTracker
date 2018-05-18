package com.cheyrouse.gael.moodtracker.controller;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.cheyrouse.gael.moodtracker.R;
import com.cheyrouse.gael.moodtracker.model.Adapter;
import com.cheyrouse.gael.moodtracker.model.Moods;
import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        final RecyclerView ListItem = findViewById(R.id.activity_history_item);
        ListItem.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        ArrayList<Moods> PrefsMoodStore = intent.getParcelableExtra("preferences");
        Adapter mAdapter = new Adapter (PrefsMoodStore);
        ListItem.setAdapter(mAdapter);
    }
}
