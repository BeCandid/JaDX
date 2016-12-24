package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: RxAndroidPlugins */
public final class apt {
    private static final apt a = new apt();
    private final AtomicReference<apu> b = new AtomicReference();

    public static apt a() {
        return a;
    }

    apt() {
    }

    public apu b() {
        if (this.b.get() == null) {
            this.b.compareAndSet(null, apu.a());
        }
        return (apu) this.b.get();
    }
}
