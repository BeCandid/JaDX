package defpackage;

import com.facebook.GraphRequest.b;

/* compiled from: Utility */
class we$2 implements b {
    final /* synthetic */ we$c a;
    final /* synthetic */ String b;

    we$2(we$c we_c, String str) {
        this.a = we_c;
        this.b = str;
    }

    public void onCompleted(uo response) {
        if (response.a() != null) {
            this.a.a(response.a().g());
            return;
        }
        wb.a(this.b, response.b());
        this.a.a(response.b());
    }
}
