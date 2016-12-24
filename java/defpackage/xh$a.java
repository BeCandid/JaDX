package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class xh$a {
    private Account a;
    private final Set<Scope> b = new HashSet();
    private final Set<Scope> c = new HashSet();
    private int d;
    private View e;
    private String f;
    private String g;
    private final Map<xf<?>, yl$a> h = new dh();
    private final Context i;
    private final Map<xf<?>, xf$a> j = new dh();
    private int k = -1;
    private Looper l;
    private xd m = xd.a();
    private xf$b<? extends acc, acd> n = acb.c;
    private final ArrayList<xh$b> o = new ArrayList();
    private final ArrayList<xh$c> p = new ArrayList();

    public xh$a(Context context) {
        this.i = context;
        this.l = context.getMainLooper();
        this.f = context.getPackageName();
        this.g = context.getClass().getName();
    }

    public yl a() {
        acd acd = acd.a;
        if (this.j.containsKey(acb.g)) {
            acd = (acd) this.j.get(acb.g);
        }
        return new yl(this.a, this.b, this.h, this.d, this.e, this.f, this.g, acd);
    }
}
