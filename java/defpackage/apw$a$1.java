package defpackage;

import rx.internal.schedulers.ScheduledAction;

/* compiled from: HandlerScheduler */
class apw$a$1 implements apy {
    final /* synthetic */ ScheduledAction a;
    final /* synthetic */ apw$a b;

    apw$a$1(apw$a apw_a, ScheduledAction scheduledAction) {
        this.b = apw_a;
        this.a = scheduledAction;
    }

    public void call() {
        this.b.a.removeCallbacks(this.a);
    }
}
