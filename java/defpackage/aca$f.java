package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aca$f extends aau {
    public long[] b;
    public long[] c;

    public aca$f() {
        e();
    }

    public /* synthetic */ aau a(aas aas) throws IOException {
        return b(aas);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        int i = 0;
        if (this.b != null && this.b.length > 0) {
            for (long a : this.b) {
                com_google_android_gms_internal_zzamc.a(1, a);
            }
        }
        if (this.c != null && this.c.length > 0) {
            while (i < this.c.length) {
                com_google_android_gms_internal_zzamc.a(2, this.c[i]);
                i++;
            }
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aca$f b(aas aas) throws IOException {
        while (true) {
            int a = aas.a();
            int b;
            Object obj;
            int c;
            Object obj2;
            switch (a) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPadding /*8*/:
                    b = aaw.b(aas, 8);
                    a = this.b == null ? 0 : this.b.length;
                    obj = new long[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = aas.e();
                        aas.a();
                        a++;
                    }
                    obj[a] = aas.e();
                    this.b = obj;
                    continue;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    c = aas.c(aas.j());
                    b = aas.p();
                    a = 0;
                    while (aas.n() > 0) {
                        aas.e();
                        a++;
                    }
                    aas.e(b);
                    b = this.b == null ? 0 : this.b.length;
                    obj2 = new long[(a + b)];
                    if (b != 0) {
                        System.arraycopy(this.b, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = aas.e();
                        b++;
                    }
                    this.b = obj2;
                    aas.d(c);
                    continue;
                case ha$a.Toolbar_titleMarginBottom /*16*/:
                    b = aaw.b(aas, 16);
                    a = this.c == null ? 0 : this.c.length;
                    obj = new long[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = aas.e();
                        aas.a();
                        a++;
                    }
                    obj[a] = aas.e();
                    this.c = obj;
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    c = aas.c(aas.j());
                    b = aas.p();
                    a = 0;
                    while (aas.n() > 0) {
                        aas.e();
                        a++;
                    }
                    aas.e(b);
                    b = this.c == null ? 0 : this.c.length;
                    obj2 = new long[(a + b)];
                    if (b != 0) {
                        System.arraycopy(this.c, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = aas.e();
                        b++;
                    }
                    this.c = obj2;
                    aas.d(c);
                    continue;
                default:
                    if (!aaw.a(aas, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    protected int c() {
        int i;
        int i2;
        int i3 = 0;
        int c = super.c();
        if (this.b == null || this.b.length <= 0) {
            i = c;
        } else {
            i2 = 0;
            for (long c2 : this.b) {
                i2 += zzamc.c(c2);
            }
            i = (c + i2) + (this.b.length * 1);
        }
        if (this.c == null || this.c.length <= 0) {
            return i;
        }
        i2 = 0;
        while (i3 < this.c.length) {
            i2 += zzamc.c(this.c[i3]);
            i3++;
        }
        return (i + i2) + (this.c.length * 1);
    }

    public aca$f e() {
        this.b = aaw.b;
        this.c = aaw.b;
        this.a = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aca$f)) {
            return false;
        }
        aca$f aca_f = (aca$f) obj;
        return !aat.a(this.b, aca_f.b) ? false : aat.a(this.c, aca_f.c);
    }

    public int hashCode() {
        return ((((getClass().getName().hashCode() + 527) * 31) + aat.a(this.b)) * 31) + aat.a(this.c);
    }
}
