package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public abstract class yp<T extends IInterface> extends yi<T> implements xf$f {
    private final yl d;
    private final Set<Scope> e;
    private final Account f;

    protected yp(Context context, Looper looper, int i, yl ylVar, xh$b xh_b, xh$c xh_c) {
        this(context, looper, yq.a(context), xd.a(), i, ylVar, (xh$b) xz.a((Object) xh_b), (xh$c) xz.a((Object) xh_c));
    }

    protected yp(Context context, Looper looper, yq yqVar, xd xdVar, int i, yl ylVar, xh$b xh_b, xh$c xh_c) {
        super(context, looper, yqVar, xdVar, i, yp.a(xh_b), yp.a(xh_c), ylVar.d());
        this.d = ylVar;
        this.f = ylVar.a();
        this.e = b(ylVar.b());
    }

    private static yi$b a(xh$b xh_b) {
        return xh_b == null ? null : new yp$1(xh_b);
    }

    private static yi$c a(xh$c xh_c) {
        return xh_c == null ? null : new yp$2(xh_c);
    }

    private Set<Scope> b(Set<Scope> set) {
        Set<Scope> a = a((Set) set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    protected Set<Scope> a(Set<Scope> set) {
        return set;
    }

    public final Account m() {
        return this.f;
    }

    protected final Set<Scope> u() {
        return this.e;
    }
}
