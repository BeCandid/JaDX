package defpackage;

import android.os.Bundle;

/* compiled from: LikeActionController */
class ws$11 implements un$a {
    final /* synthetic */ ws$l a;
    final /* synthetic */ Bundle b;
    final /* synthetic */ ws c;

    ws$11(ws this$0, ws$l ws_l, Bundle bundle) {
        this.c = this$0;
        this.a = ws_l;
        this.b = bundle;
    }

    public void a(un batch) {
        this.c.v = false;
        if (this.a.a() != null) {
            this.c.a(true);
            return;
        }
        this.c.r = null;
        this.c.u = false;
        this.c.l().a("fb_like_control_did_unlike", null, this.b);
        this.c.e(this.b);
    }
}
