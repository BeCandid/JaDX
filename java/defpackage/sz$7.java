package defpackage;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;

/* compiled from: CrashlyticsCore */
class sz$7 implements Runnable {
    final /* synthetic */ Activity a;
    final /* synthetic */ sz$c b;
    final /* synthetic */ tj c;
    final /* synthetic */ any d;
    final /* synthetic */ sz e;

    sz$7(sz szVar, Activity activity, sz$c sz_c, tj tjVar, any any) {
        this.e = szVar;
        this.a = activity;
        this.b = sz_c;
        this.c = tjVar;
        this.d = any;
    }

    public void run() {
        Builder builder = new Builder(this.a);
        OnClickListener sendClickListener = new sz$7$1(this);
        float density = this.a.getResources().getDisplayMetrics().density;
        int textViewPadding = sz.b(density, 5);
        TextView textView = new TextView(this.a);
        textView.setAutoLinkMask(15);
        textView.setText(this.c.b());
        textView.setTextAppearance(this.a, 16973892);
        textView.setPadding(textViewPadding, textViewPadding, textViewPadding, textViewPadding);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(this.a);
        scrollView.setPadding(sz.b(density, 14), sz.b(density, 2), sz.b(density, 10), sz.b(density, 12));
        scrollView.addView(textView);
        builder.setView(scrollView).setTitle(this.c.a()).setCancelable(false).setNeutralButton(this.c.c(), sendClickListener);
        if (this.d.d) {
            builder.setNegativeButton(this.c.e(), new sz$7$2(this));
        }
        if (this.d.f) {
            builder.setPositiveButton(this.c.d(), new sz$7$3(this));
        }
        builder.show();
    }
}
