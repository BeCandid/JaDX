package defpackage;

/* compiled from: AnswersEventsHandler */
class ro$5 implements Runnable {
    final /* synthetic */ ro a;

    ro$5(ro roVar) {
        this.a = roVar;
    }

    public void run() {
        try {
            this.a.b.c();
        } catch (Exception e) {
            akx.h().e("Answers", "Failed to flush events", e);
        }
    }
}
