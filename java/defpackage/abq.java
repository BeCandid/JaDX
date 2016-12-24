package defpackage;

import android.os.IBinder;
import android.os.RemoteException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class abq {
    private static final abc$a<?, ?>[] b = new abc$a[0];
    final Set<abc$a<?, ?>> a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final abq$b c = new abq$1(this);
    private final Map<xf$d<?>, xf$f> d = new dh();

    public abq(xf$d<?> xf_d_, xf$f xf_f) {
        this.d.put(xf_d_, xf_f);
    }

    private static void a(abc$a<?, ?> abc_a___, xs xsVar, IBinder iBinder) {
        if (abc_a___.e()) {
            abc_a___.a(new abq$a(abc_a___, xsVar, iBinder, null));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            abc_a___.a(null);
            abc_a___.f();
            xsVar.a(abc_a___.a().intValue());
        } else {
            Object abq_a = new abq$a(abc_a___, xsVar, iBinder, null);
            abc_a___.a((abq$b) abq_a);
            try {
                iBinder.linkToDeath(abq_a, 0);
            } catch (RemoteException e) {
                abc_a___.f();
                xsVar.a(abc_a___.a().intValue());
            }
        }
    }

    public void a() {
        for (abc$a abc_a : (abc$a[]) this.a.toArray(b)) {
            abc_a.a(null);
            if (abc_a.a() != null) {
                abc_a.c();
                abq.a(abc_a, null, ((xf$f) this.d.get(abc_a.b())).e());
                this.a.remove(abc_a);
            } else if (abc_a.g()) {
                this.a.remove(abc_a);
            }
        }
    }

    <A extends xf$c> void a(abc$a<? extends xk, A> abc_a__extends_xk__A) {
        this.a.add(abc_a__extends_xk__A);
        abc_a__extends_xk__A.a(this.c);
    }

    public boolean b() {
        for (abc$a e : (abc$a[]) this.a.toArray(b)) {
            if (!e.e()) {
                return true;
            }
        }
        return false;
    }
}
