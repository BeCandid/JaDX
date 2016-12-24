package defpackage;

import java.util.HashMap;
import java.util.Map;

/* compiled from: TranscoderRegistry */
public class pg {
    private static final rh a = new rh();
    private final Map<rh, pf<?, ?>> b = new HashMap();

    public <Z, R> void a(Class<Z> decodedClass, Class<R> transcodedClass, pf<Z, R> transcoder) {
        this.b.put(new rh(decodedClass, transcodedClass), transcoder);
    }

    public <Z, R> pf<Z, R> a(Class<Z> decodedClass, Class<R> transcodedClass) {
        if (decodedClass.equals(transcodedClass)) {
            return ph.b();
        }
        synchronized (a) {
            a.a(decodedClass, transcodedClass);
            pf<Z, R> result = (pf) this.b.get(a);
        }
        if (result != null) {
            return result;
        }
        throw new IllegalArgumentException("No transcoder registered for " + decodedClass + " and " + transcodedClass);
    }
}
