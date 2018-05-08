package com.cheyrouse.gael.moodtracker.controller;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.cheyrouse.gael.moodtracker.R;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView mListItem;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mListItem = findViewById(R.id.activity_history_item);
    }
}
