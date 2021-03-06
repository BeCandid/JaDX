package defpackage;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;

/* compiled from: OperatorObserveOn */
final class aqm$a<T> extends apr<T> implements apy {
    final apr<? super T> a;
    final apo$a b;
    final NotificationLite<T> c;
    final boolean d;
    final Queue<Object> e;
    volatile boolean f;
    final AtomicLong g = new AtomicLong();
    final AtomicLong h = new AtomicLong();
    Throwable i;

    public aqm$a(apo scheduler, apr<? super T> child, boolean delayError) {
        this.a = child;
        this.b = scheduler.createWorker();
        this.d = delayError;
        this.c = NotificationLite.a();
        if (asd.a()) {
            this.e = new arw(aqy.c);
        } else {
            this.e = new ard(aqy.c);
        }
    }

    void a() {
        apr<? super T> localChild = this.a;
        localChild.setProducer(new aqm$a$1(this));
        localChild.add(this.b);
        localChild.add(this);
    }

    public void onStart() {
        request((long) aqy.c);
    }

    public void onNext(T t) {
        if (!isUnsubscribed() && !this.f) {
            if (this.e.offer(this.c.a(t))) {
                b();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    public void onCompleted() {
        if (!isUnsubscribed() && !this.f) {
            this.f = true;
            b();
        }
    }

    public void onError(Throwable e) {
        if (isUnsubscribed() || this.f) {
            ask.a().b().a(e);
            return;
        }
        this.i = e;
        this.f = true;
        b();
    }

    protected void b() {
        if (this.h.getAndIncrement() == 0) {
            this.b.a(this);
        }
    }

    public void call() {
        long emitted = 0;
        long missed = 1;
        Queue<Object> q = this.e;
        apr<? super T> localChild = this.a;
        NotificationLite<T> localOn = this.c;
        do {
            if (!a(this.f, q.isEmpty(), localChild, q)) {
                long requestAmount = this.g.get();
                boolean unbounded = requestAmount == Long.MAX_VALUE;
                long currentEmission = 0;
                while (requestAmount != 0) {
                    boolean done = this.f;
                    Object v = q.poll();
                    boolean empty = v == null;
                    if (!a(done, empty, localChild, q)) {
                        if (empty) {
                            break;
                        }
                        localChild.onNext(localOn.c(v));
                        requestAmount--;
                        currentEmission--;
                        emitted++;
                    } else {
                        return;
                    }
                }
                if (!(currentEmission == 0 || unbounded)) {
                    this.g.addAndGet(currentEmission);
                }
                missed = this.h.addAndGet(-missed);
            } else {
                return;
            }
        } while (missed != 0);
        if (emitted != 0) {
            request(emitted);
        }
    }

    boolean a(boolean done, boolean isEmpty, apr<? super T> a, Queue<Object> q) {
        if (a.isUnsubscribed()) {
            q.clear();
            return true;
        }
        if (done) {
            Throwable e;
            if (!this.d) {
                e = this.i;
                if (e != null) {
                    q.clear();
                    try {
                        a.onError(e);
                        return true;
                    } finally {
                        this.b.unsubscribe();
                    }
                } else if (isEmpty) {
                    try {
                        a.onCompleted();
                        return true;
                    } finally {
                        this.b.unsubscribe();
                    }
                }
            } else if (isEmpty) {
                e = this.i;
                if (e != null) {
                    try {
                        a.onError(e);
                    } catch (Throwable th) {
                        this.b.unsubscribe();
                    }
                } else {
                    a.onCompleted();
                }
                this.b.unsubscribe();
            }
        }
        return false;
    }
}
