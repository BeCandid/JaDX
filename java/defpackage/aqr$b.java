package defpackage;

/* compiled from: EventLoopsScheduler */
final class aqr$b {
    final int a;
    final aqr$c[] b;
    long c;

    aqr$b(int maxThreads) {
        this.a = maxThreads;
        this.b = new aqr$c[maxThreads];
        for (int i = 0; i < maxThreads; i++) {
            this.b[i] = new aqr$c(aqr.b);
        }
    }

    public aqr$c a() {
        int c = this.a;
        if (c == 0) {
            return aqr.d;
        }
        aqr$c[] aqr_cArr = this.b;
        long j = this.c;
        this.c = 1 + j;
        return aqr_cArr[(int) (j % ((long) c))];
    }

    public void b() {
        for (aqr$c w : this.b) {
            w.unsubscribe();
        }
    }
}
