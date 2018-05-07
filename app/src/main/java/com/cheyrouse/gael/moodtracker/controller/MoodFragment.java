package com.cheyrouse.gael.moodtracker.controller;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cheyrouse.gael.moodtracker.R;
import com.cheyrouse.gael.moodtracker.model.Moods;

import java.util.ArrayList;

import static android.view.GestureDetector.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoodFragment extends Fragment implements OnGestureListener {

    private ImageView mSmileyMood;
    private ImageButton mHistoryButton;
    private ImageButton mNoteAddButton;
    private EditText input;
    private Moods moods;
    private ArrayList<Moods> moodsLst;
    private int counter;
    private GestureDetector mDetector;


    public MoodFragment() {
        // Required empty public constructor
    }

    Activity MyActivity;


    public void onAttach(Activity activity) {
        super.onAttach(activity);
        MyActivity = activity;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_mood, container, false);
        findViews(view);


        mNoteAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder;
                final EditText input = new EditText(MyActivity);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);

                alertDialogBuilder = new AlertDialog.Builder(MyActivity);
                alertDialogBuilder.setView(input);
                //set title on dialog box
                alertDialogBuilder.setTitle("Commentaire");


                // set dialog message
                alertDialogBuilder
                        .setCancelable(true)
                        .setPositiveButton("VALIDER", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                        .setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }

        });

        mHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.MainFragment, new HistoryFragment())
                        .commit();
            }
        });

        return view;
    }


    private void findViews(View view) {
        mSmileyMood = view.findViewById(R.id.fragment_mood_image);
        mHistoryButton = view.findViewById(R.id.fragment_mood_button);
        mNoteAddButton = view.findViewById(R.id.fragment_note_add_button);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Moods moods1 = new Moods(R.drawable.smiley_happy, R.color.light_sage, 0);
        Moods moods2 = new Moods(R.drawable.smiley_super_happy, R.color.banana_yellow, 0);
        Moods moods3 = new Moods(R.drawable.smiley_normal, R.color.cornflower_blue_65, 0);
        Moods moods4 = new Moods(R.drawable.smiley_disappointed, R.color.warm_grey, 0);
        Moods moods5 = new Moods(R.drawable.smiley_sad, R.color.faded_red, 0);

        moodsLst = new ArrayList<>();
        moodsLst.add(moods1);
        moodsLst.add(moods2);
        moodsLst.add(moods3);
        moodsLst.add(moods4);
        moodsLst.add(moods5);

        final GestureDetector mDetector = new GestureDetector(this);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mDetector.onTouchEvent(event);
            }
        });
    }

    @Override
    public boolean onDown(MotionEvent e) {
        //always return true since all gestures always begin with onDown and

        //if this returns false, the framework won't try to pick up onFling for example.
        return true;
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

        if (moodsLst != null && moodsLst.size() > 0){
            if (motionEvent1.getY() - motionEvent2.getY() > 50) {

                mSmileyMood.setImageDrawable(getActivity().getResources().getDrawable(moodsLst.get(counter).getmSmiley()));
                mSmileyMood.setBackground(getActivity().getResources().getDrawable(moodsLst.get(counter).getmBackground()));

                counter--;

                return true;
            }

            if (motionEvent2.getY() - motionEvent1.getY() > 50) {

                mSmileyMood.setImageDrawable(getActivity().getResources().getDrawable(moodsLst.get(counter).getmSmiley()));
                mSmileyMood.setBackground(getActivity().getResources().getDrawable(moodsLst.get(counter).getmBackground()));
                counter++;

                return true;
            }

            return false;
        }

        return false;
    }

}








