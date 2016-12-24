package defpackage;

import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;

/* compiled from: RxRingBuffer */
public class aqy implements aps {
    static int b;
    public static final int c = b;
    public static aqv<Queue<Object>> d = new aqy$1();
    public static aqv<Queue<Object>> e = new aqy$2();
    private static final NotificationLite<Object> f = NotificationLite.a();
    public volatile Object a;
    private Queue<Object> g;
    private final int h;
    private final aqv<Queue<Object>> i;

    public static aqy a() {
        if (asd.a()) {
            return new aqy(d, c);
        }
        return new aqy();
    }

    public static aqy b() {
        if (asd.a()) {
            return new aqy(e, c);
        }
        return new aqy();
    }

    static {
        b = 128;
        if (aqw.a()) {
            b = 16;
        }
        String sizeFromProperty = System.getProperty("rx.ring-buffer.size");
        if (sizeFromProperty != null) {
            try {
                b = Integer.parseInt(sizeFromProperty);
            } catch (Exception e) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + sizeFromProperty + " => " + e.getMessage());
            }
        }
    }

    private aqy(Queue<Object> queue, int size) {
        this.g = queue;
        this.i = null;
        this.h = size;
    }

    private aqy(aqv<Queue<Object>> pool, int size) {
        this.i = pool;
        this.g = (Queue) pool.a();
        this.h = size;
    }

    public synchronized void c() {
        Object q = this.g;
        aqv<Queue<Object>> p = this.i;
        if (!(p == null || q == null)) {
            q.clear();
            this.g = null;
            p.a(q);
        }
    }

    public void unsubscribe() {
        c();
    }

    aqy() {
        this(new ara(c), c);
    }

    public void a(Object o) throws MissingBackpressureException {
        boolean iae = false;
        boolean mbe = false;
        synchronized (this) {
            Queue<Object> q = this.g;
            if (q != null) {
                mbe = !q.offer(f.a(o));
            } else {
                iae = true;
            }
        }
        if (iae) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        } else if (mbe) {
            throw new MissingBackpressureException();
        }
    }

    public void d() {
        if (this.a == null) {
            this.a = f.b();
        }
    }

    public boolean e() {
        Queue<Object> q = this.g;
        if (q == null) {
            return true;
        }
        return q.isEmpty();
    }

    public Object f() {
        Object obj = null;
        synchronized (this) {
            Queue<Object> q = this.g;
            if (q == null) {
            } else {
                obj = q.poll();
                Object ts = this.a;
                if (obj == null && ts != null && q.peek() == null) {
                    obj = ts;
                    this.a = null;
                }
            }
        }
        return obj;
    }

    public Object g() {
        Object obj;
        synchronized (this) {
            Queue<Object> q = this.g;
            if (q == null) {
                obj = null;
            } else {
                obj = q.peek();
                Object ts = this.a;
                if (obj == null && ts != null && q.peek() == null) {
                    obj = ts;
                }
            }
        }
        return obj;
    }

    public boolean b(Object o) {
        return f.b(o);
    }

    public Object c(Object o) {
        return f.c(o);
    }

    public boolean isUnsubscribed() {
        return this.g == null;
    }
}
