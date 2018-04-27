package com.cheyrouse.gael.moodtracker.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.cheyrouse.gael.moodtracker.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.MainFragment, new MoodFragment())
                .commit()
        ;

    }
}
