package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BooleanSubscription */
public final class asu implements aps {
    static final apy b = new asu$1();
    final AtomicReference<apy> a;

    public asu() {
        this.a = new AtomicReference();
    }

    private asu(apy action) {
        this.a = new AtomicReference(action);
    }

    public static asu a() {
        return new asu();
    }

    public static asu a(apy onUnsubscribe) {
        return new asu(onUnsubscribe);
    }

    public boolean isUnsubscribed() {
        return this.a.get() == b;
    }

    public final void unsubscribe() {
        if (((apy) this.a.get()) != b) {
            apy action = (apy) this.a.getAndSet(b);
            if (action != null && action != b) {
                action.call();
            }
        }
    }
}
