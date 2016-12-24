package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ConstructorConstructor */
class aiz$8 implements ajc<T> {
    final /* synthetic */ Constructor a;
    final /* synthetic */ aiz b;

    aiz$8(aiz this$0, Constructor constructor) {
        this.b = this$0;
        this.a = constructor;
    }

    public T a() {
        try {
            return this.a.newInstance(null);
        } catch (InstantiationException e) {
            throw new RuntimeException("Failed to invoke " + this.a + " with no args", e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException("Failed to invoke " + this.a + " with no args", e2.getTargetException());
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        }
    }
}
