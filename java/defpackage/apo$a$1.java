package defpackage;

import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler */
class apo$a$1 implements apy {
    long a;
    long b = this.d;
    long c = this.e;
    final /* synthetic */ long d;
    final /* synthetic */ long e;
    final /* synthetic */ asw f;
    final /* synthetic */ apy g;
    final /* synthetic */ long h;
    final /* synthetic */ apo$a i;

    apo$a$1(apo$a apo_a, long j, long j2, asw asw, apy apy, long j3) {
        this.i = apo_a;
        this.d = j;
        this.e = j2;
        this.f = asw;
        this.g = apy;
        this.h = j3;
    }

    public void call() {
        if (!this.f.isUnsubscribed()) {
            long nextTick;
            this.g.call();
            long nowNanos = TimeUnit.MILLISECONDS.toNanos(this.i.a());
            long j;
            long j2;
            if (apo.a + nowNanos < this.b || nowNanos >= (this.b + this.h) + apo.a) {
                nextTick = nowNanos + this.h;
                j = this.h;
                j2 = this.a + 1;
                this.a = j2;
                this.c = nextTick - (j * j2);
            } else {
                j = this.c;
                j2 = this.a + 1;
                this.a = j2;
                nextTick = j + (j2 * this.h);
            }
            this.b = nowNanos;
            this.f.a(this.i.a(this, nextTick - nowNanos, TimeUnit.NANOSECONDS));
        }
    }
}
