package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aca$e extends aau {
    private static volatile aca$e[] H;
    public Boolean A;
    public aca$a[] B;
    public String C;
    public Integer D;
    public Integer E;
    public Integer F;
    public String G;
    public Integer b;
    public aca$b[] c;
    public aca$g[] d;
    public Long e;
    public Long f;
    public Long g;
    public Long h;
    public Long i;
    public String j;
    public String k;
    public String l;
    public String m;
    public Integer n;
    public String o;
    public String p;
    public String q;
    public Long r;
    public Long s;
    public String t;
    public Boolean u;
    public String v;
    public Long w;
    public Integer x;
    public String y;
    public String z;

    public aca$e() {
        f();
    }

    public static aca$e[] e() {
        if (H == null) {
            synchronized (aat.c) {
                if (H == null) {
                    H = new aca$e[0];
                }
            }
        }
        return H;
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
            for (aau aau2 : this.d) {
                if (aau2 != null) {
                    com_google_android_gms_internal_zzamc.a(3, aau2);
                }
            }
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.b(4, this.e.longValue());
        }
        if (this.f != null) {
            com_google_android_gms_internal_zzamc.b(5, this.f.longValue());
        }
        if (this.g != null) {
            com_google_android_gms_internal_zzamc.b(6, this.g.longValue());
        }
        if (this.i != null) {
            com_google_android_gms_internal_zzamc.b(7, this.i.longValue());
        }
        if (this.j != null) {
            com_google_android_gms_internal_zzamc.a(8, this.j);
        }
        if (this.k != null) {
            com_google_android_gms_internal_zzamc.a(9, this.k);
        }
        if (this.l != null) {
            com_google_android_gms_internal_zzamc.a(10, this.l);
        }
        if (this.m != null) {
            com_google_android_gms_internal_zzamc.a(11, this.m);
        }
        if (this.n != null) {
            com_google_android_gms_internal_zzamc.a(12, this.n.intValue());
        }
        if (this.o != null) {
            com_google_android_gms_internal_zzamc.a(13, this.o);
        }
        if (this.p != null) {
            com_google_android_gms_internal_zzamc.a(14, this.p);
        }
        if (this.q != null) {
            com_google_android_gms_internal_zzamc.a(16, this.q);
        }
        if (this.r != null) {
            com_google_android_gms_internal_zzamc.b(17, this.r.longValue());
        }
        if (this.s != null) {
            com_google_android_gms_internal_zzamc.b(18, this.s.longValue());
        }
        if (this.t != null) {
            com_google_android_gms_internal_zzamc.a(19, this.t);
        }
        if (this.u != null) {
            com_google_android_gms_internal_zzamc.a(20, this.u.booleanValue());
        }
        if (this.v != null) {
            com_google_android_gms_internal_zzamc.a(21, this.v);
        }
        if (this.w != null) {
            com_google_android_gms_internal_zzamc.b(22, this.w.longValue());
        }
        if (this.x != null) {
            com_google_android_gms_internal_zzamc.a(23, this.x.intValue());
        }
        if (this.y != null) {
            com_google_android_gms_internal_zzamc.a(24, this.y);
        }
        if (this.z != null) {
            com_google_android_gms_internal_zzamc.a(25, this.z);
        }
        if (this.h != null) {
            com_google_android_gms_internal_zzamc.b(26, this.h.longValue());
        }
        if (this.A != null) {
            com_google_android_gms_internal_zzamc.a(28, this.A.booleanValue());
        }
        if (this.B != null && this.B.length > 0) {
            while (i < this.B.length) {
                aau aau3 = this.B[i];
                if (aau3 != null) {
                    com_google_android_gms_internal_zzamc.a(29, aau3);
                }
                i++;
            }
        }
        if (this.C != null) {
            com_google_android_gms_internal_zzamc.a(30, this.C);
        }
        if (this.D != null) {
            com_google_android_gms_internal_zzamc.a(31, this.D.intValue());
        }
        if (this.E != null) {
            com_google_android_gms_internal_zzamc.a(32, this.E.intValue());
        }
        if (this.F != null) {
            com_google_android_gms_internal_zzamc.a(33, this.F.intValue());
        }
        if (this.G != null) {
            com_google_android_gms_internal_zzamc.a(34, this.G);
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aca$e b(aas aas) throws IOException {
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
                    obj = new aca$b[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new aca$b();
                        aas.a(obj[a]);
                        aas.a();
                        a++;
                    }
                    obj[a] = new aca$b();
                    aas.a(obj[a]);
                    this.c = obj;
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    b = aaw.b(aas, 26);
                    a = this.d == null ? 0 : this.d.length;
                    obj = new aca$g[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.d, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new aca$g();
                        aas.a(obj[a]);
                        aas.a();
                        a++;
                    }
                    obj[a] = new aca$g();
                    aas.a(obj[a]);
                    this.d = obj;
                    continue;
                case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.e = Long.valueOf(aas.f());
                    continue;
                case ha$a.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    this.f = Long.valueOf(aas.f());
                    continue;
                case ha$a.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.g = Long.valueOf(aas.f());
                    continue;
                case ha$a.AppCompatTheme_dividerHorizontal /*56*/:
                    this.i = Long.valueOf(aas.f());
                    continue;
                case ha$a.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                    this.j = aas.i();
                    continue;
                case ha$a.AppCompatTheme_dropDownListViewStyle /*74*/:
                    this.k = aas.i();
                    continue;
                case ha$a.AppCompatTheme_colorPrimary /*82*/:
                    this.l = aas.i();
                    continue;
                case ha$a.AppCompatTheme_controlBackground /*90*/:
                    this.m = aas.i();
                    continue;
                case ha$a.AppCompatTheme_buttonBarPositiveButtonStyle /*96*/:
                    this.n = Integer.valueOf(aas.g());
                    continue;
                case ha$a.AppCompatTheme_ratingBarStyle /*106*/:
                    this.o = aas.i();
                    continue;
                case 114:
                    this.p = aas.i();
                    continue;
                case 130:
                    this.q = aas.i();
                    continue;
                case 136:
                    this.r = Long.valueOf(aas.f());
                    continue;
                case 144:
                    this.s = Long.valueOf(aas.f());
                    continue;
                case 154:
                    this.t = aas.i();
                    continue;
                case 160:
                    this.u = Boolean.valueOf(aas.h());
                    continue;
                case 170:
                    this.v = aas.i();
                    continue;
                case 176:
                    this.w = Long.valueOf(aas.f());
                    continue;
                case 184:
                    this.x = Integer.valueOf(aas.g());
                    continue;
                case 194:
                    this.y = aas.i();
                    continue;
                case 202:
                    this.z = aas.i();
                    continue;
                case 208:
                    this.h = Long.valueOf(aas.f());
                    continue;
                case 224:
                    this.A = Boolean.valueOf(aas.h());
                    continue;
                case 234:
                    b = aaw.b(aas, 234);
                    a = this.B == null ? 0 : this.B.length;
                    obj = new aca$a[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.B, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new aca$a();
                        aas.a(obj[a]);
                        aas.a();
                        a++;
                    }
                    obj[a] = new aca$a();
                    aas.a(obj[a]);
                    this.B = obj;
                    continue;
                case 242:
                    this.C = aas.i();
                    continue;
                case 248:
                    this.D = Integer.valueOf(aas.g());
                    continue;
                case 256:
                    this.E = Integer.valueOf(aas.g());
                    continue;
                case 264:
                    this.F = Integer.valueOf(aas.g());
                    continue;
                case 274:
                    this.G = aas.i();
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
        int i2 = 0;
        int c = super.c();
        if (this.b != null) {
            c += zzamc.b(1, this.b.intValue());
        }
        if (this.c != null && this.c.length > 0) {
            i = c;
            for (aau aau : this.c) {
                if (aau != null) {
                    i += zzamc.b(2, aau);
                }
            }
            c = i;
        }
        if (this.d != null && this.d.length > 0) {
            i = c;
            for (aau aau2 : this.d) {
                if (aau2 != null) {
                    i += zzamc.b(3, aau2);
                }
            }
            c = i;
        }
        if (this.e != null) {
            c += zzamc.c(4, this.e.longValue());
        }
        if (this.f != null) {
            c += zzamc.c(5, this.f.longValue());
        }
        if (this.g != null) {
            c += zzamc.c(6, this.g.longValue());
        }
        if (this.i != null) {
            c += zzamc.c(7, this.i.longValue());
        }
        if (this.j != null) {
            c += zzamc.b(8, this.j);
        }
        if (this.k != null) {
            c += zzamc.b(9, this.k);
        }
        if (this.l != null) {
            c += zzamc.b(10, this.l);
        }
        if (this.m != null) {
            c += zzamc.b(11, this.m);
        }
        if (this.n != null) {
            c += zzamc.b(12, this.n.intValue());
        }
        if (this.o != null) {
            c += zzamc.b(13, this.o);
        }
        if (this.p != null) {
            c += zzamc.b(14, this.p);
        }
        if (this.q != null) {
            c += zzamc.b(16, this.q);
        }
        if (this.r != null) {
            c += zzamc.c(17, this.r.longValue());
        }
        if (this.s != null) {
            c += zzamc.c(18, this.s.longValue());
        }
        if (this.t != null) {
            c += zzamc.b(19, this.t);
        }
        if (this.u != null) {
            c += zzamc.b(20, this.u.booleanValue());
        }
        if (this.v != null) {
            c += zzamc.b(21, this.v);
        }
        if (this.w != null) {
            c += zzamc.c(22, this.w.longValue());
        }
        if (this.x != null) {
            c += zzamc.b(23, this.x.intValue());
        }
        if (this.y != null) {
            c += zzamc.b(24, this.y);
        }
        if (this.z != null) {
            c += zzamc.b(25, this.z);
        }
        if (this.h != null) {
            c += zzamc.c(26, this.h.longValue());
        }
        if (this.A != null) {
            c += zzamc.b(28, this.A.booleanValue());
        }
        if (this.B != null && this.B.length > 0) {
            while (i2 < this.B.length) {
                aau aau3 = this.B[i2];
                if (aau3 != null) {
                    c += zzamc.b(29, aau3);
                }
                i2++;
            }
        }
        if (this.C != null) {
            c += zzamc.b(30, this.C);
        }
        if (this.D != null) {
            c += zzamc.b(31, this.D.intValue());
        }
        if (this.E != null) {
            c += zzamc.b(32, this.E.intValue());
        }
        if (this.F != null) {
            c += zzamc.b(33, this.F.intValue());
        }
        return this.G != null ? c + zzamc.b(34, this.G) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aca$e)) {
            return false;
        }
        aca$e aca_e = (aca$e) obj;
        if (this.b == null) {
            if (aca_e.b != null) {
                return false;
            }
        } else if (!this.b.equals(aca_e.b)) {
            return false;
        }
        if (!aat.a(this.c, aca_e.c)) {
            return false;
        }
        if (!aat.a(this.d, aca_e.d)) {
            return false;
        }
        if (this.e == null) {
            if (aca_e.e != null) {
                return false;
            }
        } else if (!this.e.equals(aca_e.e)) {
            return false;
        }
        if (this.f == null) {
            if (aca_e.f != null) {
                return false;
            }
        } else if (!this.f.equals(aca_e.f)) {
            return false;
        }
        if (this.g == null) {
            if (aca_e.g != null) {
                return false;
            }
        } else if (!this.g.equals(aca_e.g)) {
            return false;
        }
        if (this.h == null) {
            if (aca_e.h != null) {
                return false;
            }
        } else if (!this.h.equals(aca_e.h)) {
            return false;
        }
        if (this.i == null) {
            if (aca_e.i != null) {
                return false;
            }
        } else if (!this.i.equals(aca_e.i)) {
            return false;
        }
        if (this.j == null) {
            if (aca_e.j != null) {
                return false;
            }
        } else if (!this.j.equals(aca_e.j)) {
            return false;
        }
        if (this.k == null) {
            if (aca_e.k != null) {
                return false;
            }
        } else if (!this.k.equals(aca_e.k)) {
            return false;
        }
        if (this.l == null) {
            if (aca_e.l != null) {
                return false;
            }
        } else if (!this.l.equals(aca_e.l)) {
            return false;
        }
        if (this.m == null) {
            if (aca_e.m != null) {
                return false;
            }
        } else if (!this.m.equals(aca_e.m)) {
            return false;
        }
        if (this.n == null) {
            if (aca_e.n != null) {
                return false;
            }
        } else if (!this.n.equals(aca_e.n)) {
            return false;
        }
        if (this.o == null) {
            if (aca_e.o != null) {
                return false;
            }
        } else if (!this.o.equals(aca_e.o)) {
            return false;
        }
        if (this.p == null) {
            if (aca_e.p != null) {
                return false;
            }
        } else if (!this.p.equals(aca_e.p)) {
            return false;
        }
        if (this.q == null) {
            if (aca_e.q != null) {
                return false;
            }
        } else if (!this.q.equals(aca_e.q)) {
            return false;
        }
        if (this.r == null) {
            if (aca_e.r != null) {
                return false;
            }
        } else if (!this.r.equals(aca_e.r)) {
            return false;
        }
        if (this.s == null) {
            if (aca_e.s != null) {
                return false;
            }
        } else if (!this.s.equals(aca_e.s)) {
            return false;
        }
        if (this.t == null) {
            if (aca_e.t != null) {
                return false;
            }
        } else if (!this.t.equals(aca_e.t)) {
            return false;
        }
        if (this.u == null) {
            if (aca_e.u != null) {
                return false;
            }
        } else if (!this.u.equals(aca_e.u)) {
            return false;
        }
        if (this.v == null) {
            if (aca_e.v != null) {
                return false;
            }
        } else if (!this.v.equals(aca_e.v)) {
            return false;
        }
        if (this.w == null) {
            if (aca_e.w != null) {
                return false;
            }
        } else if (!this.w.equals(aca_e.w)) {
            return false;
        }
        if (this.x == null) {
            if (aca_e.x != null) {
                return false;
            }
        } else if (!this.x.equals(aca_e.x)) {
            return false;
        }
        if (this.y == null) {
            if (aca_e.y != null) {
                return false;
            }
        } else if (!this.y.equals(aca_e.y)) {
            return false;
        }
        if (this.z == null) {
            if (aca_e.z != null) {
                return false;
            }
        } else if (!this.z.equals(aca_e.z)) {
            return false;
        }
        if (this.A == null) {
            if (aca_e.A != null) {
                return false;
            }
        } else if (!this.A.equals(aca_e.A)) {
            return false;
        }
        if (!aat.a(this.B, aca_e.B)) {
            return false;
        }
        if (this.C == null) {
            if (aca_e.C != null) {
                return false;
            }
        } else if (!this.C.equals(aca_e.C)) {
            return false;
        }
        if (this.D == null) {
            if (aca_e.D != null) {
                return false;
            }
        } else if (!this.D.equals(aca_e.D)) {
            return false;
        }
        if (this.E == null) {
            if (aca_e.E != null) {
                return false;
            }
        } else if (!this.E.equals(aca_e.E)) {
            return false;
        }
        if (this.F == null) {
            if (aca_e.F != null) {
                return false;
            }
        } else if (!this.F.equals(aca_e.F)) {
            return false;
        }
        return this.G == null ? aca_e.G == null : this.G.equals(aca_e.G);
    }

    public aca$e f() {
        this.b = null;
        this.c = aca$b.e();
        this.d = aca$g.e();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = aca$a.e();
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.F == null ? 0 : this.F.hashCode()) + (((this.E == null ? 0 : this.E.hashCode()) + (((this.D == null ? 0 : this.D.hashCode()) + (((this.C == null ? 0 : this.C.hashCode()) + (((((this.A == null ? 0 : this.A.hashCode()) + (((this.z == null ? 0 : this.z.hashCode()) + (((this.y == null ? 0 : this.y.hashCode()) + (((this.x == null ? 0 : this.x.hashCode()) + (((this.w == null ? 0 : this.w.hashCode()) + (((this.v == null ? 0 : this.v.hashCode()) + (((this.u == null ? 0 : this.u.hashCode()) + (((this.t == null ? 0 : this.t.hashCode()) + (((this.s == null ? 0 : this.s.hashCode()) + (((this.r == null ? 0 : this.r.hashCode()) + (((this.q == null ? 0 : this.q.hashCode()) + (((this.p == null ? 0 : this.p.hashCode()) + (((this.o == null ? 0 : this.o.hashCode()) + (((this.n == null ? 0 : this.n.hashCode()) + (((this.m == null ? 0 : this.m.hashCode()) + (((this.l == null ? 0 : this.l.hashCode()) + (((this.k == null ? 0 : this.k.hashCode()) + (((this.j == null ? 0 : this.j.hashCode()) + (((this.i == null ? 0 : this.i.hashCode()) + (((this.h == null ? 0 : this.h.hashCode()) + (((this.g == null ? 0 : this.g.hashCode()) + (((this.f == null ? 0 : this.f.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((((((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + aat.a(this.c)) * 31) + aat.a(this.d)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + aat.a(this.B)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.G != null) {
            i = this.G.hashCode();
        }
        return hashCode + i;
    }
}
