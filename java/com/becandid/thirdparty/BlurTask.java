package com.becandid.thirdparty;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import defpackage.in$b;
import defpackage.in$c;
import defpackage.in$d;
import defpackage.ix;
import defpackage.jl;
import defpackage.jm;

public class BlurTask extends AsyncTask<Void, Void, Void> {
    private Activity a;
    private int b;
    private Bitmap c;
    private String d;
    private String e;
    private BadgeType f;
    private View g;
    private String h;
    private String i;
    private String j;

    public enum BadgeType {
        BADGE,
        MOD,
        POST_QUALITY_SCORE,
        ME_QUALITY_SCORE,
        MESSAGE_ENABLED_NEW,
        MESSAGE_ENABLED_TAB,
        MESSAGE_ADD_NICKNAME,
        MESSAGE_SECOND_NICKNAME
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }

    public BlurTask(Activity activity, int layoutId) {
        this.a = activity;
        this.b = layoutId;
    }

    public BlurTask(Activity activity, int layoutId, String badgeName) {
        this.a = activity;
        this.b = layoutId;
        this.e = badgeName;
    }

    public BlurTask(Activity activity, View layoutView, BadgeType type, String modTitle, String modDesc) {
        this.a = activity;
        this.g = layoutView;
        this.f = type;
        this.i = modTitle;
        this.j = modDesc;
    }

    public BlurTask(Activity activity, View layoutView, String score, BadgeType type, String scoreTitle, String scoreDesc) {
        this.a = activity;
        this.g = layoutView;
        this.f = type;
        this.h = score;
        this.i = scoreTitle;
        this.j = scoreDesc;
    }

    public BlurTask(Activity activity, View layoutView, BadgeType type) {
        this.a = activity;
        this.g = layoutView;
        this.f = type;
    }

    private View a() {
        return this.a.findViewById(this.b);
    }

    protected Void a(Void... params) {
        this.d = b();
        return null;
    }

    protected void onPreExecute() {
        if (this.g == null) {
            this.g = a();
        }
        this.c = jm.a(this.g, Color.parseColor("#FF000000"));
    }

    protected void a(Void aVoid) {
        if (this.e != null) {
            ix.a().a(new in$c(this.d, this.e));
        } else if (this.f != null) {
            ix.a().a(new in$b(this.d, this.f, this.h, this.i, this.j));
        } else {
            ix.a().a(new in$d(this.d));
        }
    }

    private String b() {
        Bitmap localBitmap = jl.a(this.a, this.c, 24);
        String str = jm.a(this.a, localBitmap);
        this.c.recycle();
        localBitmap.recycle();
        return str;
    }
}
