package defpackage;

/* compiled from: AnswersEventsHandler */
class ro$2 implements Runnable {
    final /* synthetic */ ro a;

    ro$2(ro roVar) {
        this.a = roVar;
    }

    public void run() {
        try {
            sg prevStrategy = this.a.b;
            this.a.b = new rv();
            prevStrategy.b();
        } catch (Exception e) {
            akx.h().e("Answers", "Failed to disable events", e);
        }
    }
}
