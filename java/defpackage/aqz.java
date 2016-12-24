package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* compiled from: SubscriptionList */
public final class aqz implements aps {
    private LinkedList<aps> a;
    private volatile boolean b;

    public aqz(aps... subscriptions) {
        this.a = new LinkedList(Arrays.asList(subscriptions));
    }

    public aqz(aps s) {
        this.a = new LinkedList();
        this.a.add(s);
    }

    public boolean isUnsubscribed() {
        return this.b;
    }

    public void a(aps s) {
        if (!s.isUnsubscribed()) {
            if (!this.b) {
                synchronized (this) {
                    if (!this.b) {
                        LinkedList<aps> subs = this.a;
                        if (subs == null) {
                            subs = new LinkedList();
                            this.a = subs;
                        }
                        subs.add(s);
                        return;
                    }
                }
            }
            s.unsubscribe();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(defpackage.aps r4) {
        /*
        r3 = this;
        r2 = r3.b;
        if (r2 != 0) goto L_0x000f;
    L_0x0004:
        r1 = 0;
        monitor-enter(r3);
        r0 = r3.a;	 Catch:{ all -> 0x001b }
        r2 = r3.b;	 Catch:{ all -> 0x001b }
        if (r2 != 0) goto L_0x000e;
    L_0x000c:
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x001b }
    L_0x000f:
        return;
    L_0x0010:
        r1 = r0.remove(r4);	 Catch:{ all -> 0x001b }
        monitor-exit(r3);	 Catch:{ all -> 0x001b }
        if (r1 == 0) goto L_0x000f;
    L_0x0017:
        r4.unsubscribe();
        goto L_0x000f;
    L_0x001b:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x001b }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: aqz.b(aps):void");
    }

    public void unsubscribe() {
        if (!this.b) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                this.b = true;
                Collection list = this.a;
                this.a = null;
                aqz.a(list);
            }
        }
    }

    private static void a(Collection<aps> subscriptions) {
        if (subscriptions != null) {
            List<Throwable> es = null;
            for (aps s : subscriptions) {
                try {
                    s.unsubscribe();
                } catch (Throwable e) {
                    if (es == null) {
                        es = new ArrayList();
                    }
                    es.add(e);
                }
            }
            apx.a((List) es);
        }
    }
}
