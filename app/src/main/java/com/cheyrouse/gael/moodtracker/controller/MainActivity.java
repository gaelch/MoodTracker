package com.cheyrouse.gael.moodtracker.controller;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.cheyrouse.gael.moodtracker.R;
import com.cheyrouse.gael.moodtracker.model.Mood;
import com.cheyrouse.gael.moodtracker.model.Prefs;
import java.util.ArrayList;

import static com.cheyrouse.gael.moodtracker.model.Prefs.getMoodstore;


public class MainActivity extends Activity implements OnGestureListener, View.OnClickListener, View.OnTouchListener {

    private ImageView mSmileyMood;
    private ArrayList<Mood> moodLst;
    private ArrayList<Mood> prefsMoodStore;
    private int counter;
    private GestureDetector mDetector;
    private RelativeLayout mLayout;
    private ImageButton mHistoryButton;
    private ImageButton mNoteAddButton;
    private String mComment;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVars();

        initListener();

        Mood mood2 = initMoodsList();

        counter = 1;

        saveDefaultMood(mood2);
    }

    private void saveDefaultMood(Mood mood2) {
       //if(prefsMoodStore != null) {
            Prefs prefs = Prefs.get(this);
            prefsMoodStore = getMoodstore();
            prefsMoodStore.add(mood2);
            prefs.storeMoodstore(prefsMoodStore);
        //}
    }




    private void initListener() {
        mNoteAddButton.setOnClickListener(this);

        mHistoryButton.setOnClickListener(this);

        mDetector = new GestureDetector(MainActivity.this);

        mLayout.setOnTouchListener(this);
    }


    private void startHistoryActivity() {
        Intent historyActivityIntent = new Intent(MainActivity.this, HistoryActivity.class);
        historyActivityIntent.putExtra("preferences", prefsMoodStore);
        startActivity(historyActivityIntent);

        //Au lancement de l'historique, initialiser l'adapter en lui fournissant la liste des humeurs
        //appel au constructeur Adapteur(Pref pref){mPref = pref}: Adapteur(Prefs.get(this))
    }

    private void showCommentDialog() {
        AlertDialog.Builder alertDialogBuilder;
        final EditText input = new EditText(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(input);
        //set title on dialog box
        alertDialogBuilder.setTitle("Commentaire");
        // set dialog message
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setPositiveButton("VALIDER", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                saveComment();
            }
        });
        alertDialogBuilder.setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
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

    private void saveComment(){
        final EditText input = new EditText(MainActivity.this);
        Prefs prefs = Prefs.get(MainActivity.this);
        String mComment = input.getText().toString();
        Mood.setmComment(mComment);
        prefs.Moods(mComment);
    }


    @NonNull
    private Mood initMoodsList() {
        Mood mood1 = new Mood(R.drawable.smiley_super_happy, R.color.banana_yellow, 0, mComment);
        Mood mood2 = new Mood(R.drawable.smiley_happy, R.color.light_sage, 1, mComment);
        Mood mood3 = new Mood(R.drawable.smiley_normal, R.color.cornflower_blue_65, 2, mComment);
        Mood mood4 = new Mood(R.drawable.smiley_disappointed, R.color.warm_grey, 3, mComment);
        Mood mood5 = new Mood(R.drawable.smiley_sad, R.color.faded_red, 4, mComment);

        moodLst = new ArrayList<>();
        moodLst.add(mood1);
        moodLst.add(mood2);
        moodLst.add(mood3);
        moodLst.add(mood4);
        moodLst.add(mood5);
        return mood2;
    }

    public void updateDisplay() {
        if ((counter >= 0) && (counter < moodLst.size())) {
            mSmileyMood.setImageDrawable(this.getResources().getDrawable(moodLst.get(counter).getmSmiley()));
            mSmileyMood.setBackground(this.getResources().getDrawable(moodLst.get(counter).getmBackground()));
            mLayout.setBackground(this.getResources().getDrawable(moodLst.get(counter).getmBackground()));
            mHistoryButton.setBackground(this.getResources().getDrawable(moodLst.get(counter).getmBackground()));
            mNoteAddButton.setBackground(this.getResources().getDrawable(moodLst.get(counter).getmBackground()));
        }
    }


    private void initVars() {
        mLayout = findViewById(R.id.activity_main);
        mSmileyMood = findViewById(R.id.activity_main_mood_image);
        mHistoryButton = findViewById(R.id.activity_main_history_button);
        mNoteAddButton = findViewById(R.id.activity_main_note_add_button);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("MainActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("MainActivity::onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("MainActivity::onStop()");
        saveCurrentMood();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActivity::onDestroy()");
    }

    @Override
    public boolean onDown(MotionEvent e) {
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
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getY() - e2.getY() > 30) {
            if (counter > 0) {
                counter--;
            } else {
                counter = 0;
            }
        }
        if (e2.getY() - e1.getY() > 30) {
            if (counter < moodLst.size() - 1) {
                counter++;
            } else {
                counter = moodLst.size() - 1;
            }
        }
        updateDisplay();
        return true;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.activity_main_note_add_button:

                showCommentDialog();

                break;

            case R.id.activity_main_history_button:

                startHistoryActivity();

                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }

    private void saveCurrentMood() {
        Prefs prefs = Prefs.get(this);
        prefsMoodStore = getMoodstore();
        if (prefsMoodStore != null) {
            prefsMoodStore.remove(0);
            prefsMoodStore.add(moodLst.get(counter));
            prefs.storeMoodstore(prefsMoodStore);
        }
    }
}
