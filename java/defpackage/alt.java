package defpackage;

/* compiled from: Crash */
public abstract class alt {
    private final String a;
    private final String b;

    public alt(String sessionId, String exceptionName) {
        this.a = sessionId;
        this.b = exceptionName;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
