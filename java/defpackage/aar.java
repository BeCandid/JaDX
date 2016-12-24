package defpackage;

import android.content.Context;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class aar {
    private static final AtomicReference<aar> a = new AtomicReference();

    aar(Context context) {
    }

    public static aar a() {
        return (aar) a.get();
    }

    public static aar a(Context context) {
        a.compareAndSet(null, new aar(context));
        return (aar) a.get();
    }

    public void a(ahv ahv) {
    }

    public Set<String> b() {
        return Collections.emptySet();
    }
}
