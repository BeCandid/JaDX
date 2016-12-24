package defpackage;

/* compiled from: AnswersEventsHandler */
class ro$1 implements Runnable {
    final /* synthetic */ anl a;
    final /* synthetic */ String b;
    final /* synthetic */ ro c;

    ro$1(ro roVar, anl anl, String str) {
        this.c = roVar;
        this.a = anl;
        this.b = str;
    }

    public void run() {
        try {
            this.c.b.a(this.a, this.b);
        } catch (Exception e) {
            akx.h().e("Answers", "Failed to set analytics settings data", e);
        }
    }
}
