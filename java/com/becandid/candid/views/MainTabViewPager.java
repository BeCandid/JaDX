package com.becandid.candid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MainTabViewPager extends TabViewPager {
    private boolean a;

    public MainTabViewPager(Context context) {
        super(context);
    }

    public MainTabViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        return this.a && super.onTouchEvent(ev);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.a && super.onInterceptTouchEvent(ev);
    }

    public void setSwipeEnabled(boolean swipeEnabled) {
        this.a = swipeEnabled;
    }
}
