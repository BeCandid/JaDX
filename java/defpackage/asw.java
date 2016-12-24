package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MultipleAssignmentSubscription */
public final class asw implements aps {
    final AtomicReference<asw$a> a = new AtomicReference(new asw$a(false, asy.a()));

    public boolean isUnsubscribed() {
        return ((asw$a) this.a.get()).a;
    }

    public void unsubscribe() {
        asw$a oldState;
        AtomicReference<asw$a> localState = this.a;
        do {
            oldState = (asw$a) localState.get();
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
        AtomicReference<asw$a> localState = this.a;
        asw$a oldState;
        do {
            oldState = (asw$a) localState.get();
            if (oldState.a) {
                s.unsubscribe();
                return;
            }
        } while (!localState.compareAndSet(oldState, oldState.a(s)));
    }
}
