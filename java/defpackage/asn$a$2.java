package defpackage;

import rx.internal.schedulers.ScheduledAction;

/* compiled from: ExecutorScheduler */
class asn$a$2 implements apy {
    final /* synthetic */ asw a;
    final /* synthetic */ apy b;
    final /* synthetic */ aps c;
    final /* synthetic */ asn$a d;

    asn$a$2(asn$a asn_a, asw asw, apy apy, aps aps) {
        this.d = asn_a;
        this.a = asw;
        this.b = apy;
        this.c = aps;
    }

    public void call() {
        if (!this.a.isUnsubscribed()) {
            aps s2 = this.d.a(this.b);
            this.a.a(s2);
            if (s2.getClass() == ScheduledAction.class) {
                ((ScheduledAction) s2).a(this.c);
            }
        }
    }
}
