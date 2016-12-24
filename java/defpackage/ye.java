package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class ye<T extends IInterface> extends yp<T> {
    private final xf$h<T> d;

    public ye(Context context, Looper looper, int i, xh$b xh_b, xh$c xh_c, yl ylVar, xf$h<T> xf_h_T) {
        super(context, looper, i, ylVar, xh_b, xh_c);
        this.d = xf_h_T;
    }

    protected T a(IBinder iBinder) {
        return this.d.a(iBinder);
    }

    protected void a(int i, T t) {
        this.d.a(i, t);
    }

    protected String f() {
        return this.d.a();
    }

    protected String g() {
        return this.d.b();
    }

    public xf$h<T> h() {
        return this.d;
    }
}
