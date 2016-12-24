package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Fabric */
public class akx$a {
    private final Context a;
    private alc[] b;
    private amj c;
    private Handler d;
    private alf e;
    private boolean f;
    private String g;
    private String h;
    private ala<akx> i;

    public akx$a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.a = context.getApplicationContext();
    }

    public akx$a a(alc... kits) {
        if (this.b != null) {
            throw new IllegalStateException("Kits already set.");
        }
        this.b = kits;
        return this;
    }

    public akx a() {
        Map<Class<? extends alc>, alc> kitMap;
        if (this.c == null) {
            this.c = amj.a();
        }
        if (this.d == null) {
            this.d = new Handler(Looper.getMainLooper());
        }
        if (this.e == null) {
            if (this.f) {
                this.e = new akw(3);
            } else {
                this.e = new akw();
            }
        }
        if (this.h == null) {
            this.h = this.a.getPackageName();
        }
        if (this.i == null) {
            this.i = ala.d;
        }
        if (this.b == null) {
            kitMap = new HashMap();
        } else {
            kitMap = akx.b(Arrays.asList(this.b));
        }
        return new akx(this.a, kitMap, this.c, this.d, this.e, this.f, this.i, new IdManager(this.a, this.h, this.g, kitMap.values()));
    }
}
