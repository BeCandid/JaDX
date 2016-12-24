package defpackage;

import java.util.HashMap;
import java.util.Map;

/* compiled from: DataLoadProviderRegistry */
public class pz {
    private static final rh a = new rh();
    private final Map<rh, py<?, ?>> b = new HashMap();

    public <T, Z> void a(Class<T> dataClass, Class<Z> resourceClass, py<T, Z> provider) {
        this.b.put(new rh(dataClass, resourceClass), provider);
    }

    public <T, Z> py<T, Z> a(Class<T> dataClass, Class<Z> resourceClass) {
        synchronized (a) {
            a.a(dataClass, resourceClass);
            py<?, ?> result = (py) this.b.get(a);
        }
        if (result == null) {
            return qa.e();
        }
        return result;
    }
}
