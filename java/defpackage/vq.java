package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

/* compiled from: FragmentWrapper */
public class vq {
    private Fragment a;
    private android.app.Fragment b;

    public vq(Fragment fragment) {
        wf.a((Object) fragment, "fragment");
        this.a = fragment;
    }

    public vq(android.app.Fragment fragment) {
        wf.a((Object) fragment, "fragment");
        this.b = fragment;
    }

    public android.app.Fragment a() {
        return this.b;
    }

    public Fragment b() {
        return this.a;
    }

    public void a(Intent intent, int requestCode) {
        if (this.a != null) {
            this.a.startActivityForResult(intent, requestCode);
        } else {
            this.b.startActivityForResult(intent, requestCode);
        }
    }

    public final Activity c() {
        if (this.a != null) {
            return this.a.getActivity();
        }
        return this.b.getActivity();
    }
}
