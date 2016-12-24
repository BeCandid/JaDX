package defpackage;

import android.content.Context;
import android.support.v4.app.Fragment;
import butterknife.Unbinder;

/* compiled from: BaseMainTabFragment */
public abstract class ht extends Fragment {
    public Context a;
    public Unbinder b;
    public boolean c;

    public abstract void b();

    public abstract void c();

    public void onDestroyView() {
        super.onDestroyView();
        if (this.b != null) {
            this.b.unbind();
        }
    }

    public void a() {
        if (!this.c) {
            this.c = true;
        }
    }
}
