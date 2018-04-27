package com.cheyrouse.gael.moodtracker.controller;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.cheyrouse.gael.moodtracker.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoodFragment extends Fragment {

    private ImageView mSmileyMood;
    private ImageButton mHistoryButton;
    private ImageButton mNoteAddButton;
    private EditText mAddComment;



    public MoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mood, container, false);
        findViews(view);

        mNoteAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddComment.setText("commentaire");
                Editable comment = mAddComment.getText();
            }
        });

        mHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager frman = getFragmentManager();
                FragmentTransaction ftran = frman.beginTransaction();
                Fragment ffrag = new Fragment();
                ftran.replace(R.id.fragment_history_item, ffrag);
                ftran.commit();
            }
        });

        return view;
    }
    private void findViews (View view){
        mSmileyMood = view.findViewById(R.id.fragment_mood_image);
        mHistoryButton = view.findViewById(R.id.fragment_mood_button);
        mNoteAddButton = view.findViewById(R.id.fragment_note_add_button);
    }

}




