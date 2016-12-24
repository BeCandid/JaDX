package defpackage;

class agh$1 implements Runnable {
    final /* synthetic */ ahk a;
    final /* synthetic */ int b;
    final /* synthetic */ ahd c;
    final /* synthetic */ agh d;

    agh$1(agh agh, ahk ahk, int i, ahd ahd) {
        this.d = agh;
        this.a = ahk;
        this.b = i;
        this.c = ahd;
    }

    public void run() {
        this.a.J();
        this.a.H();
        this.d.a.post(new agh$1$1(this));
    }
}
