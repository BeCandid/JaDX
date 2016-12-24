package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.atomic.AtomicReference;

public abstract class abc$a<R extends xk, A extends xf$c> extends abe<R> {
    private final xf$d<A> d;
    private AtomicReference<abq$b> e;

    private void a(RemoteException remoteException) {
        a(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    public void a(abq$b abq_b) {
        this.e.set(abq_b);
    }

    public final void a(Status status) {
        xz.b(!status.f(), "Failed result must not be success");
        xk b = b(status);
        b(b);
        a(b);
    }

    public final void a(A a) throws DeadObjectException {
        try {
            b(a);
        } catch (RemoteException e) {
            a(e);
            throw e;
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    protected void a(R r) {
    }

    public final xf$d<A> b() {
        return this.d;
    }

    protected abstract void b(A a) throws RemoteException;

    public void c() {
        a(null);
    }

    protected void d() {
        abq$b abq_b = (abq$b) this.e.getAndSet(null);
        if (abq_b != null) {
            abq_b.a(this);
        }
    }
}
