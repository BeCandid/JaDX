package defpackage;

import android.os.Process;
import android.util.SparseArray;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicBoolean;

final class abg$b extends Thread {
    private final ReferenceQueue<xr<?>> a;
    private final SparseArray<abg$a> b;
    private final AtomicBoolean c = new AtomicBoolean();

    public abg$b(ReferenceQueue<xr<?>> referenceQueue, SparseArray<abg$a> sparseArray) {
        super("GoogleApiCleanup");
        this.a = referenceQueue;
        this.b = sparseArray;
    }

    public void run() {
        this.c.set(true);
        Process.setThreadPriority(10);
        while (this.c.get()) {
            try {
                abg$a abg_a = (abg$a) this.a.remove();
                this.b.remove(abg_a.b);
                abg_a.a();
            } catch (InterruptedException e) {
            } finally {
                this.c.set(false);
            }
        }
    }
}
