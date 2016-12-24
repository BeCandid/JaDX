package defpackage;

import java.util.concurrent.TimeUnit;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorZip;
import rx.internal.util.ScalarSynchronousObservable;
import rx.schedulers.Schedulers;

/* compiled from: Observable */
public class apl<T> {
    static final asi b = ask.a().c();
    final apl$a<T> a;

    public apl(apl$a<T> f) {
        this.a = f;
    }

    public static <T> apl<T> a(apl$a<T> f) {
        return new apl(b.a((apl$a) f));
    }

    public final <R> apl<R> a(apl$b<? extends R, ? super T> operator) {
        return new apl(new apl$2(this, operator));
    }

    public app<T> a() {
        return new app(aqh.a(this));
    }

    public static <T> apl<T> a(Throwable exception) {
        return new apl$c(exception);
    }

    public static <T> apl<T> a(T value) {
        return ScalarSynchronousObservable.b(value);
    }

    public static <T> apl<T> a(apl<? extends apl<? extends T>> source) {
        if (source.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) source).e(arb.a());
        }
        return source.a(OperatorMerge.a(false));
    }

    public static apl<Long> a(long delay, TimeUnit unit) {
        return apl.a(delay, unit, Schedulers.computation());
    }

    public static apl<Long> a(long delay, TimeUnit unit, apo scheduler) {
        return apl.a(new aqi(delay, unit, scheduler));
    }

    public static <T1, T2, R> apl<R> a(apl<? extends T1> o1, apl<? extends T2> o2, aqd<? super T1, ? super T2, ? extends R> zipFunction) {
        return apl.a(new apl[]{o1, o2}).a(new OperatorZip(zipFunction));
    }

    public final apl<T> a(apz<Throwable> onError) {
        return a(new aqj(new apl$1(this, onError)));
    }

    public final apl<T> a(aqc<? super T, Boolean> predicate) {
        return a(new aqk(predicate));
    }

    public final <R> apl<R> b(aqc<? super T, ? extends apl<? extends R>> func) {
        if (getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) this).e(func);
        }
        return apl.a(c(func));
    }

    public final <R> apl<R> c(aqc<? super T, ? extends R> func) {
        return a(new aql(func));
    }

    public final apl<T> a(apo scheduler) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).c(scheduler);
        }
        return a(new aqm(scheduler, false));
    }

    public final apl<T> a(long capacity) {
        return a(new aqn(capacity));
    }

    public final apl<T> d(aqc<Throwable, ? extends T> resumeFunction) {
        return a(aqo.a((aqc) resumeFunction));
    }

    public final aps b(apz<? super T> onNext) {
        if (onNext != null) {
            return b(new apl$3(this, onNext));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final aps a(apr<? super T> subscriber) {
        try {
            subscriber.onStart();
            b.a(this, this.a).call(subscriber);
            return b.a((aps) subscriber);
        } catch (Throwable e2) {
            apx.a(e2);
            b.a(new RuntimeException("Error occurred attempting to subscribe [" + e.getMessage() + "] and then again while trying to pass to onError.", e2));
        }
    }

    public final aps b(apr<? super T> subscriber) {
        return apl.a((apr) subscriber, this);
    }

    private static <T> aps a(apr<? super T> subscriber, apl<T> observable) {
        if (subscriber == null) {
            throw new IllegalArgumentException("observer can not be null");
        } else if (observable.a == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        } else {
            aps subscriber2;
            subscriber.onStart();
            if (!(subscriber instanceof ase)) {
                subscriber2 = new ase(subscriber);
            }
            try {
                b.a(observable, observable.a).call(subscriber2);
                return b.a(subscriber2);
            } catch (Throwable e2) {
                apx.a(e2);
                b.a(new RuntimeException("Error occurred attempting to subscribe [" + e.getMessage() + "] and then again while trying to pass to onError.", e2));
            }
        }
    }

    public final apl<T> b(apo scheduler) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).c(scheduler);
        }
        return apl.a(new aqp(this, scheduler));
    }
}
