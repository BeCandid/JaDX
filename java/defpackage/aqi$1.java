package defpackage;

/* compiled from: OnSubscribeTimerOnce */
class aqi$1 implements apy {
    final /* synthetic */ apr a;
    final /* synthetic */ aqi b;

    aqi$1(aqi aqi, apr apr) {
        this.b = aqi;
        this.a = apr;
    }

    public void call() {
        try {
            this.a.onNext(Long.valueOf(0));
            this.a.onCompleted();
        } catch (Throwable t) {
            apx.a(t, this.a);
        }
    }
}
