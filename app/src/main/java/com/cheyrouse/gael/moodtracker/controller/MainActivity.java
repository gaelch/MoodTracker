package com.cheyrouse.gael.moodtracker.controller;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.cheyrouse.gael.moodtracker.model.Moods;
import java.util.ArrayList;

public class MainActivity extends Activity implements OnGestureListener{

    private ImageView mSmileyMood;
    private EditText input;
    private Moods moods;
    private ArrayList<Moods> moodsLst;
    private int counter;
    private GestureDetector mDetector;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSmileyMood = findViewById(R.id.activity_main_mood_image);
        ImageButton mHistoryButton = findViewById(R.id.activity_main_history_button);
        ImageButton mNoteAddButton = findViewById(R.id.activity_main_note_add_button);


        mNoteAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                Intent historyActivityIntent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(historyActivityIntent);
            }
        });


        Moods moods1 = new Moods(R.drawable.smiley_happy, R.color.light_sage, 0);
        Moods moods2 = new Moods(R.drawable.smiley_super_happy, R.color.banana_yellow, 1);
        Moods moods3 = new Moods(R.drawable.smiley_normal, R.color.cornflower_blue_65, 2);
        Moods moods4 = new Moods(R.drawable.smiley_disappointed, R.color.warm_grey, 3);
        Moods moods5 = new Moods(R.drawable.smiley_sad, R.color.faded_red, 4);

        moodsLst = new ArrayList<>();
        moodsLst.add(moods1);
        moodsLst.add(moods2);
        moodsLst.add(moods3);
        moodsLst.add(moods4);
        moodsLst.add(moods5);

        final GestureDetector mDetector = new GestureDetector(MainActivity.this);

        mSmileyMood.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return mDetector.onTouchEvent(event);

            }
        });

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
        return false;
    }
}
