package defpackage;

import com.facebook.GraphRequest.e;

/* compiled from: RequestProgress */
class uw$1 implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ long b;
    final /* synthetic */ long c;
    final /* synthetic */ uw d;

    uw$1(uw this$0, e eVar, long j, long j2) {
        this.d = this$0;
        this.a = eVar;
        this.b = j;
        this.c = j2;
    }

    public void run() {
        this.a.a(this.b, this.c);
    }
}
