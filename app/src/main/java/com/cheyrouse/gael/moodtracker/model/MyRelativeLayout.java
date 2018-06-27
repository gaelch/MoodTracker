package com.cheyrouse.gael.moodtracker.model;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class MyRelativeLayout extends RelativeLayout {


    public MyRelativeLayout(Context context) {

        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //to call performClick on the OnTouch
    @Override
    public boolean performClick() {
        return super.performClick();
    }
}
