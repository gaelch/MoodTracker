package com.cheyrouse.gael.moodtracker.controller;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cheyrouse.gael.moodtracker.R;


public class HistoryFragment extends Fragment {

    RecyclerView mListItem;


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        findViews (view);
        return view;

    }
    private void findViews(View view) {
        mListItem = view.findViewById(R.id.fragment_mood_image);

    }


}
