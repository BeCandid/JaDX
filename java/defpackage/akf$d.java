package defpackage;

import java.io.IOException;

/* compiled from: Phonemetadata */
public final class akf$d extends aki {
    public String a;
    public String b;
    public String c;

    public /* synthetic */ aki b(akg akg) throws IOException {
        return a(akg);
    }

    public akf$d() {
        a();
    }

    public akf$d a() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.F = -1;
        return this;
    }

    public akf$d a(akg input) throws IOException {
        while (true) {
            int tag = input.a();
            switch (tag) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.a = input.e();
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    this.b = input.e();
                    continue;
                case ha$a.AppCompatTheme_buttonBarStyle /*50*/:
                    this.c = input.e();
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
