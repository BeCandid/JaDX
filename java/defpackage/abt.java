package defpackage;

import android.os.Process;

class abt implements Runnable {
    private final Runnable a;
    private final int b;

    public abt(Runnable runnable, int i) {
        this.a = runnable;
        this.b = i;
    }

    public void run() {
        Process.setThreadPriority(this.b);
        this.a.run();
    }
}
