package defpackage;

/* compiled from: OperatorSubscribeOn */
class aqp$1$1$1 implements apn {
    final /* synthetic */ apn a;
    final /* synthetic */ aqp$1$1 b;

    aqp$1$1$1(aqp$1$1 aqp_1_1, apn apn) {
        this.b = aqp_1_1;
        this.a = apn;
    }

    public void a(long n) {
        if (this.b.a == Thread.currentThread()) {
            this.a.a(n);
        } else {
            this.b.b.b.a(new aqp$1$1$1$1(this, n));
        }
    }
}
