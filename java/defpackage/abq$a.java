package defpackage;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import java.lang.ref.WeakReference;

class abq$a implements abq$b, DeathRecipient {
    private final WeakReference<abc$a<?, ?>> a;
    private final WeakReference<xs> b;
    private final WeakReference<IBinder> c;

    private abq$a(abc$a<?, ?> abc_a___, xs xsVar, IBinder iBinder) {
        this.b = new WeakReference(xsVar);
        this.a = new WeakReference(abc_a___);
        this.c = new WeakReference(iBinder);
    }

    private void a() {
        abc$a abc_a = (abc$a) this.a.get();
        xs xsVar = (xs) this.b.get();
        if (!(xsVar == null || abc_a == null)) {
            xsVar.a(abc_a.a().intValue());
        }
        IBinder iBinder = (IBinder) this.c.get();
        if (this.c != null) {
            iBinder.unlinkToDeath(this, 0);
        }
    }

    public void a(abc$a<?, ?> abc_a___) {
        a();
    }

    public void binderDied() {
        a();
    }
}
