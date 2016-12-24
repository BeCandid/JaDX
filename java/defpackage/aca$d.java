package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aca$d extends aau {
    public aca$e[] b;

    public aca$d() {
        e();
    }

    public /* synthetic */ aau a(aas aas) throws IOException {
        return b(aas);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        if (this.b != null && this.b.length > 0) {
            for (aau aau : this.b) {
                if (aau != null) {
                    com_google_android_gms_internal_zzamc.a(1, aau);
                }
            }
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aca$d b(aas aas) throws IOException {
        while (true) {
            int a = aas.a();
            switch (a) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    int b = aaw.b(aas, 10);
                    a = this.b == null ? 0 : this.b.length;
                    Object obj = new aca$e[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new aca$e();
                        aas.a(obj[a]);
                        aas.a();
                        a++;
                    }
                    obj[a] = new aca$e();
                    aas.a(obj[a]);
                    this.b = obj;
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
        int c = super.c();
        if (this.b != null && this.b.length > 0) {
            for (aau aau : this.b) {
                if (aau != null) {
                    c += zzamc.b(1, aau);
                }
            }
        }
        return c;
    }

    public aca$d e() {
        this.b = aca$e.e();
        this.a = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aca$d)) {
            return false;
        }
        return aat.a(this.b, ((aca$d) obj).b);
    }

    public int hashCode() {
        return ((getClass().getName().hashCode() + 527) * 31) + aat.a(this.b);
    }
}
