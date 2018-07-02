package com.cheyrouse.gael.moodtracker.controller;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cheyrouse.gael.moodtracker.R;
import com.cheyrouse.gael.moodtracker.model.AlarmReceiver;
import com.cheyrouse.gael.moodtracker.model.Mood;
import com.cheyrouse.gael.moodtracker.model.MyRelativeLayout;
import com.cheyrouse.gael.moodtracker.model.Prefs;
import com.cheyrouse.gael.moodtracker.model.SaveMoodHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity implements OnGestureListener, View.OnClickListener, View.OnTouchListener {
    private static ArrayList<Mood> moodList;
    private ImageView mSmileyMood;
    private static int counter;
    private GestureDetector mDetector;
    private MyRelativeLayout mLayout;
    private ImageButton mHistoryButton;
    private ImageButton mNoteAddButton;
    private String mComment;
    Date date;
    SaveMoodHelper mSaveMoodHelper;
    private MediaPlayer mPlayer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mSaveMoodHelper = new SaveMoodHelper(this);

        initVars();

        initListener();

        initMoodsList();

        counter = 1;

        date = mSaveMoodHelper.getCurrentDate();

        AlarmMidnight(this);
    }

    //listeners initialization
    private void initListener() {

        mNoteAddButton.setOnClickListener(this);

        mHistoryButton.setOnClickListener(this);

        mDetector = new GestureDetector(MainActivity.this);

        mLayout.setOnTouchListener(this);

    }
    //Start HistoryActivity
    private void startHistoryActivity() {
        Intent historyActivityIntent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(historyActivityIntent);
    }
    //This method that show a dialog box that allows you to add a comment to the chosen mood
    private void showCommentDialog() {
        AlertDialog.Builder alertDialogBuilder;
        final EditText mCommentInput = new EditText(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        mCommentInput.setLayoutParams(lp);
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(mCommentInput);
        //set title on dialog box
        alertDialogBuilder.setTitle(R.string.commentaire);
        // set dialog message
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setPositiveButton(R.string.valider, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Prefs.get(MainActivity.this);
                mComment = mCommentInput.getText().toString();
                moodList.get(counter).setComment(mComment);
                Mood test = moodList.get(counter);
                mSaveMoodHelper.SaveCurrentMood(test);
            }
        });
        alertDialogBuilder.setNegativeButton(R.string.annuler, new DialogInterface.OnClickListener() {
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
    //Initialization of the mood list for the swipe
    private void initMoodsList() {
        Mood mood1 = new Mood(R.drawable.smiley_super_happy, R.color.banana_yellow, 4, mComment, date);
        Mood mood2 = new Mood(R.drawable.smiley_happy, R.color.light_sage, 3, mComment, date);
        Mood mood3 = new Mood(R.drawable.smiley_normal, R.color.cornflower_blue_65, 2, mComment, date);
        Mood mood4 = new Mood(R.drawable.smiley_disappointed, R.color.warm_grey, 1, mComment, date);
        Mood mood5 = new Mood(R.drawable.smiley_sad, R.color.faded_red, 0, mComment, date);

        moodList = new ArrayList<>();
        moodList.add(mood1);
        moodList.add(mood2);
        moodList.add(mood3);
        moodList.add(mood4);
        moodList.add(mood5);
    }
    //This method is used to display moods in the main layout
    private void updateDisplay() {
        if ((counter >= 0) && (counter < moodList.size())) {
            mSmileyMood.setImageDrawable(this.getResources().getDrawable(moodList.get(counter).getSmiley()));
            mLayout.setBackground(this.getResources().getDrawable(moodList.get(counter).getBackground()));
            mHistoryButton.setBackground(this.getResources().getDrawable(moodList.get(counter).getBackground()));
            mNoteAddButton.setBackground(this.getResources().getDrawable(moodList.get(counter).getBackground()));
        }
    }
    //Initialization of the variables
    private void initVars() {
        mLayout = findViewById(R.id.activity_main);
        mSmileyMood = findViewById(R.id.activity_main_mood_image);
        mHistoryButton = findViewById(R.id.activity_main_history_button);
        mNoteAddButton = findViewById(R.id.activity_main_note_add_button);
    }
    //method to play Sound on the swipe
    private void playSound(int resId) {
        if(mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }
        mPlayer = MediaPlayer.create(this, resId);
        mPlayer.start();
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

    //On the onPause, call the method SaveCurrentMood to save the current mood
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("MainActivity::onPause()");
        mSaveMoodHelper.SaveCurrentMood(moodList.get(counter));
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("MainActivity::onStop()");

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
    //This method is the Swipe
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getY() - e2.getY() > 30) {
            if (counter > 0) {
                counter--;
                playSound(R.raw.supermarioup);
            } else {
                counter = 0;
            }
        }
        if (e2.getY() - e1.getY() > 30) {
            if (counter < moodList.size() - 1) {
                counter++;
                playSound(R.raw.coin);
            } else {
                counter = moodList.size() - 1;
            }
        }
        updateDisplay();
        return true;
    }
    //This onclick call dialog box or HistoryActivity
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
    //method Called when a touch event is dispatched to a view.
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        v.performClick();
        return mDetector.onTouchEvent(event);
    }

    //At midnight, the alarm goes off to save the mood of the day
    private void AlarmMidnight(Context context) {
        AlarmManager alarmManager;
        PendingIntent pendingIntent;

        //in a current date at midnight, this property get an instance to calendar
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DATE, 1);

        //call AlarmReceiver class
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        //RTC-WAKEUP that will wake the device when it turns off.
        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        }

        //Resetting the mood list comment, and assigning the default smiley
        for(int i = 0; i<moodList.size(); i++)
        {
            moodList.get(i).setComment(null);
        }
        counter = 1;
    }
}


