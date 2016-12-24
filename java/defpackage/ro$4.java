package defpackage;

/* compiled from: AnswersEventsHandler */
class ro$4 implements Runnable {
    final /* synthetic */ ro a;

    ro$4(ro roVar) {
        this.a = roVar;
    }

    public void run() {
        try {
            sh metadata = this.a.f.a();
            sd filesManager = this.a.e.a();
            filesManager.a(this.a);
            this.a.b = new rw(this.a.c, this.a.d, this.a.a, filesManager, this.a.g, metadata);
        } catch (Exception e) {
            akx.h().e("Answers", "Failed to enable events", e);
        }
    }
}
