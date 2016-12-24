package defpackage;

/* compiled from: CrashlyticsExecutorServiceWrapper */
class ta$1 implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ta b;

    ta$1(ta taVar, Runnable runnable) {
        this.b = taVar;
        this.a = runnable;
    }

    public void run() {
        try {
            this.a.run();
        } catch (Exception e) {
            akx.h().e("CrashlyticsCore", "Failed to execute task.", e);
        }
    }
}
