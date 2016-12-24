package defpackage;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
class ajf$3 extends ajf {
    final /* synthetic */ Method a;

    ajf$3(Method method) {
        this.a = method;
    }

    public <T> T a(Class<T> c) throws Exception {
        return this.a.invoke(null, new Object[]{c, Object.class});
    }
}
