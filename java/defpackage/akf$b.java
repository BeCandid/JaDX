package defpackage;

import java.io.IOException;

/* compiled from: Phonemetadata */
public final class akf$b extends aki {
    private static volatile akf$b[] G;
    public akf$a[] A;
    public boolean B;
    public String C;
    public boolean D;
    public boolean E;
    public akf$d a;
    public akf$d b;
    public akf$d c;
    public akf$d d;
    public akf$d e;
    public akf$d f;
    public akf$d g;
    public akf$d h;
    public akf$d i;
    public akf$d j;
    public akf$d k;
    public akf$d l;
    public akf$d m;
    public akf$d n;
    public akf$d o;
    public akf$d p;
    public String q;
    public int r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public boolean y;
    public akf$a[] z;

    public /* synthetic */ aki b(akg akg) throws IOException {
        return a(akg);
    }

    public static akf$b[] a() {
        if (G == null) {
            synchronized (akh.a) {
                if (G == null) {
                    G = new akf$b[0];
                }
            }
        }
        return G;
    }

    public akf$b() {
        b();
    }

    public akf$b b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
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
        this.q = "";
        this.r = 0;
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = "";
        this.w = "";
        this.x = "";
        this.y = false;
        this.z = akf$a.a();
        this.A = akf$a.a();
        this.B = false;
        this.C = "";
        this.D = false;
        this.E = false;
        this.F = -1;
        return this;
    }

    public akf$b a(akg input) throws IOException {
        while (true) {
            int tag = input.a();
            int arrayLength;
            int i;
            akf$a[] newArray;
            switch (tag) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    if (this.a == null) {
                        this.a = new akf$d();
                    }
                    input.a(this.a);
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    if (this.b == null) {
                        this.b = new akf$d();
                    }
                    input.a(this.b);
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    if (this.c == null) {
                        this.c = new akf$d();
                    }
                    input.a(this.c);
                    continue;
                case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                    if (this.d == null) {
                        this.d = new akf$d();
                    }
                    input.a(this.d);
                    continue;
                case ha$a.AppCompatTheme_dialogTheme /*42*/:
                    if (this.e == null) {
                        this.e = new akf$d();
                    }
                    input.a(this.e);
                    continue;
                case ha$a.AppCompatTheme_buttonBarStyle /*50*/:
                    if (this.f == null) {
                        this.f = new akf$d();
                    }
                    input.a(this.f);
                    continue;
                case ha$a.AppCompatTheme_toolbarStyle /*58*/:
                    if (this.g == null) {
                        this.g = new akf$d();
                    }
                    input.a(this.g);
                    continue;
                case ha$a.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                    if (this.h == null) {
                        this.h = new akf$d();
                    }
                    input.a(this.h);
                    continue;
                case ha$a.AppCompatTheme_dropDownListViewStyle /*74*/:
                    this.q = input.e();
                    continue;
                case ha$a.AppCompatTheme_panelMenuListTheme /*80*/:
                    this.r = input.c();
                    continue;
                case ha$a.AppCompatTheme_controlBackground /*90*/:
                    this.s = input.e();
                    continue;
                case ha$a.AppCompatTheme_buttonBarNeutralButtonStyle /*98*/:
                    this.u = input.e();
                    continue;
                case ha$a.AppCompatTheme_ratingBarStyle /*106*/:
                    this.v = input.e();
                    continue;
                case 122:
                    this.w = input.e();
                    continue;
                case 130:
                    this.x = input.e();
                    continue;
                case 138:
                    this.t = input.e();
                    continue;
                case 144:
                    this.y = input.d();
                    continue;
                case 154:
                    arrayLength = akk.b(input, 154);
                    if (this.z == null) {
                        i = 0;
                    } else {
                        i = this.z.length;
                    }
                    newArray = new akf$a[(i + arrayLength)];
                    if (i != 0) {
                        System.arraycopy(this.z, 0, newArray, 0, i);
                    }
                    while (i < newArray.length - 1) {
                        newArray[i] = new akf$a();
                        input.a(newArray[i]);
                        input.a();
                        i++;
                    }
                    newArray[i] = new akf$a();
                    input.a(newArray[i]);
                    this.z = newArray;
                    continue;
                case 162:
                    arrayLength = akk.b(input, 162);
                    if (this.A == null) {
                        i = 0;
                    } else {
                        i = this.A.length;
                    }
                    newArray = new akf$a[(i + arrayLength)];
                    if (i != 0) {
                        System.arraycopy(this.A, 0, newArray, 0, i);
                    }
                    while (i < newArray.length - 1) {
                        newArray[i] = new akf$a();
                        input.a(newArray[i]);
                        input.a();
                        i++;
                    }
                    newArray[i] = new akf$a();
                    input.a(newArray[i]);
                    this.A = newArray;
                    continue;
                case 170:
                    if (this.i == null) {
                        this.i = new akf$d();
                    }
                    input.a(this.i);
                    continue;
                case 176:
                    this.B = input.d();
                    continue;
                case 186:
                    this.C = input.e();
                    continue;
                case 194:
                    if (this.p == null) {
                        this.p = new akf$d();
                    }
                    input.a(this.p);
                    continue;
                case 202:
                    if (this.j == null) {
                        this.j = new akf$d();
                    }
                    input.a(this.j);
                    continue;
                case 208:
                    this.D = input.d();
                    continue;
                case 218:
                    if (this.k == null) {
                        this.k = new akf$d();
                    }
                    input.a(this.k);
                    continue;
                case 226:
                    if (this.l == null) {
                        this.l = new akf$d();
                    }
                    input.a(this.l);
                    continue;
                case 234:
                    if (this.m == null) {
                        this.m = new akf$d();
                    }
                    input.a(this.m);
                    continue;
                case 242:
                    if (this.n == null) {
                        this.n = new akf$d();
                    }
                    input.a(this.n);
                    continue;
                case 250:
                    if (this.o == null) {
                        this.o = new akf$d();
                    }
                    input.a(this.o);
                    continue;
                case 256:
                    this.E = input.d();
                    continue;
                default:
                    if (!akk.a(input, tag)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
