package defpackage;

import android.os.Handler;
import java.util.concurrent.TimeUnit;
import rx.internal.schedulers.ScheduledAction;

/* compiled from: HandlerScheduler */
class apw$a extends apo$a {
    private final Handler a;
    private final asv b = new asv();

    apw$a(Handler handler) {
        this.a = handler;
    }

    public void unsubscribe() {
        this.b.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.b.isUnsubscribed();
    }

    public aps a(apy action, long delayTime, TimeUnit unit) {
        if (this.b.isUnsubscribed()) {
            return asy.b();
        }
        aps scheduledAction = new ScheduledAction(apt.a().b().a(action));
        scheduledAction.a(this.b);
        this.b.a(scheduledAction);
        this.a.postDelayed(scheduledAction, unit.toMillis(delayTime));
        scheduledAction.a(asy.a(new apw$a$1(this, scheduledAction)));
        return scheduledAction;
    }

    public aps a(apy action) {
        return a(action, 0, TimeUnit.MILLISECONDS);
    }
}
