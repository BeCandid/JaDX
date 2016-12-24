package defpackage;

import rx.internal.util.RxThreadFactory;

/* compiled from: NewThreadScheduler */
public final class aso extends apo {
    private static final RxThreadFactory b = new RxThreadFactory("RxNewThreadScheduler-");
    private static final aso c = new aso();

    public static aso a() {
        return c;
    }

    private aso() {
    }

    public apo$a createWorker() {
        return new aqt(b);
    }
}
