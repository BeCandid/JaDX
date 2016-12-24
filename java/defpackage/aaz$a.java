package defpackage;

import android.os.DeadObjectException;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;

public final class aaz$a extends aaz {
    public final abc$a<? extends xk, xf$c> c;

    public void a(SparseArray<abq> sparseArray) {
        abq abq = (abq) sparseArray.get(this.a);
        if (abq != null) {
            abq.a(this.c);
        }
    }

    public void a(Status status) {
        this.c.a(status);
    }

    public void a(xf$c xf_c) throws DeadObjectException {
        this.c.a(xf_c);
    }

    public boolean a() {
        return this.c.g();
    }
}
