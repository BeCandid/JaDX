package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public abstract class aau {
    protected volatile int a = -1;

    public int a() {
        if (this.a < 0) {
            b();
        }
        return this.a;
    }

    public abstract aau a(aas aas) throws IOException;

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
    }

    public int b() {
        int c = c();
        this.a = c;
        return c;
    }

    protected int c() {
        return 0;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return d();
    }

    public aau d() throws CloneNotSupportedException {
        return (aau) super.clone();
    }

    public String toString() {
        return aav.a(this);
    }
}
