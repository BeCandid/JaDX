package defpackage;

/* compiled from: AnswersEventsHandler */
class ro$3 implements Runnable {
    final /* synthetic */ ro a;

    ro$3(ro roVar) {
        this.a = roVar;
    }

    public void run() {
        try {
            this.a.b.a();
        } catch (Exception e) {
            akx.h().e("Answers", "Failed to send events files", e);
        }
    }
}
