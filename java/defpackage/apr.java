package defpackage;

/* compiled from: Subscriber */
public abstract class apr<T> implements apm<T>, aps {
    private static final Long NOT_SET = Long.valueOf(Long.MIN_VALUE);
    private apn producer;
    private long requested;
    private final apr<?> subscriber;
    private final aqz subscriptions;

    public apr() {
        this(null, false);
    }

    protected apr(apr<?> subscriber) {
        this(subscriber, true);
    }

    protected apr(apr<?> subscriber, boolean shareSubscriptions) {
        this.requested = NOT_SET.longValue();
        this.subscriber = subscriber;
        aqz aqz = (!shareSubscriptions || subscriber == null) ? new aqz() : subscriber.subscriptions;
        this.subscriptions = aqz;
    }

    public final void add(aps s) {
        this.subscriptions.a(s);
    }

    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    public final void request(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + n);
        }
        synchronized (this) {
            if (this.producer != null) {
                apn producerToRequestFrom = this.producer;
                producerToRequestFrom.a(n);
                return;
            }
            addToRequested(n);
        }
    }

    private void addToRequested(long n) {
        if (this.requested == NOT_SET.longValue()) {
            this.requested = n;
            return;
        }
        long total = this.requested + n;
        if (total < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = total;
        }
    }

    public void setProducer(apn p) {
        boolean passToSubscriber = false;
        synchronized (this) {
            long toRequest = this.requested;
            this.producer = p;
            if (this.subscriber != null && toRequest == NOT_SET.longValue()) {
                passToSubscriber = true;
            }
        }
        if (passToSubscriber) {
            this.subscriber.setProducer(this.producer);
        } else if (toRequest == NOT_SET.longValue()) {
            this.producer.a(Long.MAX_VALUE);
        } else {
            this.producer.a(toRequest);
        }
    }
}
