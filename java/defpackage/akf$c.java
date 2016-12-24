package defpackage;

import java.io.IOException;

/* compiled from: Phonemetadata */
public final class akf$c extends aki {
    public akf$b[] a;

    public /* synthetic */ aki b(akg akg) throws IOException {
        return a(akg);
    }

    public akf$c() {
        a();
    }

    public akf$c a() {
        this.a = akf$b.a();
        this.F = -1;
        return this;
    }

    public akf$c a(akg input) throws IOException {
        while (true) {
            int tag = input.a();
            switch (tag) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    int i;
                    int arrayLength = akk.b(input, 10);
                    if (this.a == null) {
                        i = 0;
                    } else {
                        i = this.a.length;
                    }
                    akf$b[] newArray = new akf$b[(i + arrayLength)];
                    if (i != 0) {
                        System.arraycopy(this.a, 0, newArray, 0, i);
                    }
                    while (i < newArray.length - 1) {
                        newArray[i] = new akf$b();
                        input.a(newArray[i]);
                        input.a();
                        i++;
                    }
                    newArray[i] = new akf$b();
                    input.a(newArray[i]);
                    this.a = newArray;
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
