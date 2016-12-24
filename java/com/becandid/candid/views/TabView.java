package com.becandid.candid.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class TabView extends RelativeLayout {
    protected ViewGroup a;

    public TabView(Context context) {
        super(context);
    }

    protected void setContentView(int resourceId) {
        setContentView(LayoutInflater.from(getContext()).inflate(resourceId, this, false));
    }

    protected void setContentView(View v) {
        this.a = (ViewGroup) v;
        addView(v);
        v.setLayoutParams(new LayoutParams(-1, -1));
    }
}
