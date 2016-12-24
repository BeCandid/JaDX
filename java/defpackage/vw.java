package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/* compiled from: LockOnGetVariable */
public class vw<T> {
    private T a;
    private CountDownLatch b = new CountDownLatch(1);

    public vw(Callable<T> callable) {
        ul.d().execute(new FutureTask(new vw$1(this, callable)));
    }

    public T a() {
        b();
        return this.a;
    }

    private void b() {
        if (this.b != null) {
            try {
                this.b.await();
            } catch (InterruptedException e) {
            }
        }
    }
}
