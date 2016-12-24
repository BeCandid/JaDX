package defpackage;

import com.crashlytics.android.answers.SessionEvent.a;

/* compiled from: AnswersEventsHandler */
class ro$6 implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ro c;

    ro$6(ro roVar, a aVar, boolean z) {
        this.c = roVar;
        this.a = aVar;
        this.b = z;
    }

    public void run() {
        try {
            this.c.b.a(this.a);
            if (this.b) {
                this.c.b.c();
            }
        } catch (Exception e) {
            akx.h().e("Answers", "Failed to process event", e);
        }
    }
}
