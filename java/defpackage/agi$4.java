package defpackage;

class agi$4 implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ agi b;

    agi$4(agi agi, long j) {
        this.b = agi;
        this.a = j;
    }

    public void run() {
        this.b.a(this.a);
    }
}
