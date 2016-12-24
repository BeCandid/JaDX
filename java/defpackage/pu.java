package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import java.util.HashSet;

/* compiled from: SupportRequestManagerFragment */
public class pu extends Fragment {
    private jz a;
    private final pi b;
    private final ps c;
    private final HashSet<pu> d;
    private pu e;

    public pu() {
        this(new pi());
    }

    @SuppressLint({"ValidFragment"})
    public pu(pi lifecycle) {
        this.c = new pu$a();
        this.d = new HashSet();
        this.b = lifecycle;
    }

    public void a(jz requestManager) {
        this.a = requestManager;
    }

    pi a() {
        return this.b;
    }

    public jz b() {
        return this.a;
    }

    public ps c() {
        return this.c;
    }

    private void a(pu child) {
        this.d.add(child);
    }

    private void b(pu child) {
        this.d.remove(child);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.e = pr.a().a(getActivity().getSupportFragmentManager());
        if (this.e != this) {
            this.e.a(this);
        }
    }

    public void onDetach() {
        super.onDetach();
        if (this.e != null) {
            this.e.b(this);
            this.e = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.b.a();
    }

    public void onStop() {
        super.onStop();
        this.b.b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.b.c();
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.a != null) {
            this.a.a();
        }
    }
}
