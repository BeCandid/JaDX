package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SerialSubscription */
public final class asx implements aps {
    final AtomicReference<asx$a> a = new AtomicReference(new asx$a(false, asy.a()));

    public boolean isUnsubscribed() {
        return ((asx$a) this.a.get()).a;
    }

    public void unsubscribe() {
        asx$a oldState;
        AtomicReference<asx$a> localState = this.a;
        do {
            oldState = (asx$a) localState.get();
            if (oldState.a) {
                return;
            }
        } while (!localState.compareAndSet(oldState, oldState.a()));
        oldState.b.unsubscribe();
    }

    public void a(aps s) {
        if (s == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        asx$a oldState;
        AtomicReference<asx$a> localState = this.a;
        do {
            oldState = (asx$a) localState.get();
            if (oldState.a) {
                s.unsubscribe();
                return;
            }
        } while (!localState.compareAndSet(oldState, oldState.a(s)));
        oldState.b.unsubscribe();
    }
}
