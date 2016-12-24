package defpackage;

/* compiled from: Completable */
public class apk {
    static final apk a = apk.a(new apk$1());
    static final apk b = apk.a(new apk$2());
    static final ash c = ask.a().b();
    private final apk$a d;

    public static apk a(apk$a onSubscribe) {
        apk.a((Object) onSubscribe);
        try {
            return new apk(onSubscribe);
        } catch (NullPointerException ex) {
            throw ex;
        } catch (Throwable ex2) {
            c.a(ex2);
            NullPointerException a = apk.a(ex2);
        }
    }

    static <T> T a(T o) {
        if (o != null) {
            return o;
        }
        throw new NullPointerException();
    }

    static NullPointerException a(Throwable ex) {
        NullPointerException npe = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        npe.initCause(ex);
        return npe;
    }

    protected apk(apk$a onSubscribe) {
        this.d = onSubscribe;
    }

    public final void a(apk$b s) {
        apk.a((Object) s);
        try {
            this.d.call(s);
        } catch (NullPointerException ex) {
            throw ex;
        } catch (Throwable ex2) {
            c.a(ex2);
            NullPointerException a = apk.a(ex2);
        }
    }

    public final apk a(apo scheduler) {
        apk.a((Object) scheduler);
        return apk.a(new apk$3(this, scheduler));
    }
}
