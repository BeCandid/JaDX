package defpackage;

import java.io.IOException;
import rx.exceptions.CompositeException;

/* compiled from: ErrorAction1Handler */
public class ii implements apz<Throwable> {
    String a;

    public /* synthetic */ void call(Object obj) {
        a((Throwable) obj);
    }

    public ii(String methodName) {
        this.a = methodName;
    }

    public void a(Throwable throwable) {
        if (!(throwable instanceof IOException) && (throwable instanceof CompositeException)) {
            ix.a().a(new in$ap());
        }
        rj.a(throwable);
    }
}
