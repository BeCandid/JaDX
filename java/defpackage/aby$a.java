package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aby$a extends aau {
    private static volatile aby$a[] e;
    public Integer b;
    public aby$e[] c;
    public aby$b[] d;

    public aby$a() {
        f();
    }

    public static aby$a[] e() {
        if (e == null) {
            synchronized (aat.c) {
                if (e == null) {
                    e = new aby$a[0];
                }
            }
        }
        return e;
    }

    public /* synthetic */ aau a(aas aas) throws IOException {
        return b(aas);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        int i = 0;
        if (this.b != null) {
            com_google_android_gms_internal_zzamc.a(1, this.b.intValue());
        }
        if (this.c != null && this.c.length > 0) {
            for (aau aau : this.c) {
                if (aau != null) {
                    com_google_android_gms_internal_zzamc.a(2, aau);
                }
            }
        }
        if (this.d != null && this.d.length > 0) {
            while (i < this.d.length) {
                aau aau2 = this.d[i];
                if (aau2 != null) {
                    com_google_android_gms_internal_zzamc.a(3, aau2);
                }
                i++;
            }
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aby$a b(aas aas) throws IOException {
        while (true) {
            int a = aas.a();
            int b;
            Object obj;
            switch (a) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPadding /*8*/:
                    this.b = Integer.valueOf(aas.g());
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    b = aaw.b(aas, 18);
                    a = this.c == null ? 0 : this.c.length;
                    obj = new aby$e[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new aby$e();
                        aas.a(obj[a]);
                        aas.a();
                        a++;
                    }
                    obj[a] = new aby$e();
                    aas.a(obj[a]);
                    this.c = obj;
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    b = aaw.b(aas, 26);
                    a = this.d == null ? 0 : this.d.length;
                    obj = new aby$b[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.d, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new aby$b();
                        aas.a(obj[a]);
                        aas.a();
                        a++;
                    }
                    obj[a] = new aby$b();
                    aas.a(obj[a]);
                    this.d = obj;
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
        int i = 0;
        int c = super.c();
        if (this.b != null) {
            c += zzamc.b(1, this.b.intValue());
        }
        if (this.c != null && this.c.length > 0) {
            int i2 = c;
            for (aau aau : this.c) {
                if (aau != null) {
                    i2 += zzamc.b(2, aau);
                }
            }
            c = i2;
        }
        if (this.d != null && this.d.length > 0) {
            while (i < this.d.length) {
                aau aau2 = this.d[i];
                if (aau2 != null) {
                    c += zzamc.b(3, aau2);
                }
                i++;
            }
        }
        return c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aby$a)) {
            return false;
        }
        aby$a aby_a = (aby$a) obj;
        if (this.b == null) {
            if (aby_a.b != null) {
                return false;
            }
        } else if (!this.b.equals(aby_a.b)) {
            return false;
        }
        return !aat.a(this.c, aby_a.c) ? false : aat.a(this.d, aby_a.d);
    }

    public aby$a f() {
        this.b = null;
        this.c = aby$e.e();
        this.d = aby$b.e();
        this.a = -1;
        return this;
    }

    public int hashCode() {
        return (((((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + aat.a(this.c)) * 31) + aat.a(this.d);
    }
}
