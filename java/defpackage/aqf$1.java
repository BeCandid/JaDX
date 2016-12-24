package defpackage;

/* compiled from: Functions */
class aqf$1 implements aqe<R> {
    final /* synthetic */ aqd a;

    aqf$1(aqd aqd) {
        this.a = aqd;
    }

    public R a(Object... args) {
        if (args.length == 2) {
            return this.a.call(args[0], args[1]);
        }
        throw new RuntimeException("Func2 expecting 2 arguments.");
    }
}
