package com.cheyrouse.gael.moodtracker.controller;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.cheyrouse.gael.moodtracker.R;

import static android.view.GestureDetector.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoodFragment extends Fragment implements OnGestureListener {

    private ImageView mSmileyMood;
    private ImageButton mHistoryButton;
    private ImageButton mNoteAddButton;
    private EditText mAddComment;
    private MoodBank mMoodBank;






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


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GestureDetector gestureDetector;

        gestureDetector = new GestureDetector(this);

        }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
        public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {

            if (motionEvent1.getY() - motionEvent2.getY() > 50) {

                return true;
            }

            if (motionEvent2.getY() - motionEvent1.getY() > 50) {

                return true;
            }

            return false;
        }

        private void generateMood()  {

            Mood mood1 = new Mood (){};
        }
}




