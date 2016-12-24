package defpackage;

import com.facebook.LoggingBehavior;

/* compiled from: LikeActionController */
class ws$12$1 implements un$a {
    final /* synthetic */ ws$i a;
    final /* synthetic */ ws$d b;
    final /* synthetic */ ws$12 c;

    ws$12$1(ws$12 this$1, ws$i ws_i, ws$d ws_d) {
        this.c = this$1;
        this.a = ws_i;
        this.b = ws_d;
    }

    public void a(un batch) {
        if (this.a.a() == null && this.b.a() == null) {
            this.c.a.a(this.a.b(), this.b.e, this.b.f, this.b.g, this.b.h, this.a.c());
            return;
        }
        vx.a(LoggingBehavior.REQUESTS, ws.a, "Unable to refresh like state for id: '%s'", this.c.a.k);
    }
}
