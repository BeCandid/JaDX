package defpackage;

import java.io.IOException;

/* compiled from: Phonemetadata */
public final class akf$a extends aki {
    private static volatile akf$a[] g;
    public String a;
    public String b;
    public String[] c;
    public String d;
    public boolean e;
    public String f;

    public /* synthetic */ aki b(akg akg) throws IOException {
        return a(akg);
    }

    public static akf$a[] a() {
        if (g == null) {
            synchronized (akh.a) {
                if (g == null) {
                    g = new akf$a[0];
                }
            }
        }
        return g;
    }

    public akf$a() {
        b();
    }

    public akf$a b() {
        this.a = "";
        this.b = "";
        this.c = akk.f;
        this.d = "";
        this.e = false;
        this.f = "";
        this.F = -1;
        return this;
    }

    public akf$a a(akg input) throws IOException {
        while (true) {
            int tag = input.a();
            switch (tag) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    this.a = input.e();
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.b = input.e();
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    int arrayLength = akk.b(input, 26);
                    int i = this.c == null ? 0 : this.c.length;
                    String[] newArray = new String[(i + arrayLength)];
                    if (i != 0) {
                        System.arraycopy(this.c, 0, newArray, 0, i);
                    }
                    while (i < newArray.length - 1) {
                        newArray[i] = input.e();
                        input.a();
                        i++;
                    }
                    newArray[i] = input.e();
                    this.c = newArray;
                    continue;
                case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.d = input.e();
                    continue;
                case ha$a.AppCompatTheme_dialogTheme /*42*/:
                    this.f = input.e();
                    continue;
                case ha$a.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.e = input.d();
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
