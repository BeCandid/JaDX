package defpackage;

import com.facebook.FacebookRequestError;
import com.facebook.LoggingBehavior;

/* compiled from: LikeActionController */
class ws$3 implements un$a {
    final /* synthetic */ ws$e a;
    final /* synthetic */ ws$g b;
    final /* synthetic */ ws$m c;
    final /* synthetic */ ws d;

    ws$3(ws this$0, ws$e ws_e, ws$g ws_g, ws$m ws_m) {
        this.d = this$0;
        this.a = ws_e;
        this.b = ws_g;
        this.c = ws_m;
    }

    public void a(un batch) {
        this.d.s = this.a.e;
        if (we.a(this.d.s)) {
            this.d.s = this.b.e;
            this.d.t = this.b.f;
        }
        if (we.a(this.d.s)) {
            FacebookRequestError a;
            vx.a(LoggingBehavior.DEVELOPER_ERRORS, ws.a, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", this.d.k);
            ws wsVar = this.d;
            String str = "get_verified_id";
            if (this.b.a() != null) {
                a = this.b.a();
            } else {
                a = this.a.a();
            }
            wsVar.a(str, a);
        }
        if (this.c != null) {
            this.c.a();
        }
    }
}
