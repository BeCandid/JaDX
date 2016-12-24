package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class aaf$4 implements aaf$a {
    final /* synthetic */ FrameLayout a;
    final /* synthetic */ LayoutInflater b;
    final /* synthetic */ ViewGroup c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ aaf e;

    aaf$4(aaf aaf, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = aaf;
        this.a = frameLayout;
        this.b = layoutInflater;
        this.c = viewGroup;
        this.d = bundle;
    }

    public int a() {
        return 2;
    }

    public void a(aae aae) {
        this.a.removeAllViews();
        this.a.addView(this.e.a.a(this.b, this.c, this.d));
    }
}
