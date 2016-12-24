package defpackage;

import rx.schedulers.Schedulers;

/* compiled from: RxBus */
public class ix {
    private static final ix a = new ix();
    private final ast<Object, Object> b = new ass(asr.b());

    public static ix a() {
        return a;
    }

    public <T> aps a(Class<T> eventClass, apr<T> subscriber) {
        return this.b.a(10000).a(new ix$3(this, eventClass)).b(Schedulers.newThread()).a(apv.a()).c(new ix$2(this)).a(new ix$1(this)).b((apr) subscriber);
    }

    public void a(Object event, boolean toReact) {
        this.b.onNext(event);
        this.b.a(new ix$4(this));
    }

    public void a(Object event) {
        a(event, true);
    }
}
