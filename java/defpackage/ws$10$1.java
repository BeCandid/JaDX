package defpackage;

/* compiled from: LikeActionController */
class ws$10$1 implements un$a {
    final /* synthetic */ ws$k a;
    final /* synthetic */ ws$10 b;

    ws$10$1(ws$10 this$1, ws$k ws_k) {
        this.b = this$1;
        this.a = ws_k;
    }

    public void a(un batch) {
        this.b.b.v = false;
        if (this.a.a() != null) {
            this.b.b.a(false);
            return;
        }
        this.b.b.r = we.a(this.a.e, null);
        this.b.b.u = true;
        this.b.b.l().a("fb_like_control_did_like", null, this.b.a);
        this.b.b.e(this.b.a);
    }
}
