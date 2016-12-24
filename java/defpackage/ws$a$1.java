package defpackage;

import com.facebook.GraphRequest.b;

/* compiled from: LikeActionController */
class ws$a$1 implements b {
    final /* synthetic */ ws$a a;

    ws$a$1(ws$a this$1) {
        this.a = this$1;
    }

    public void onCompleted(uo response) {
        this.a.c = response.a();
        if (this.a.c != null) {
            this.a.a(this.a.c);
        } else {
            this.a.a(response);
        }
    }
}
