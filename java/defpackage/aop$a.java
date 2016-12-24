package defpackage;

/* compiled from: GeofenceModel */
public class aop$a {
    private String a;
    private double b;
    private double c;
    private float d;
    private long e;
    private int f;
    private int g;

    public aop$a(String id) {
        this.a = id;
    }

    public aop$a a(double latitude) {
        this.b = latitude;
        return this;
    }

    public aop$a b(double longitude) {
        this.c = longitude;
        return this;
    }

    public aop$a a(float radius) {
        this.d = radius;
        return this;
    }

    public aop$a a(long expiration) {
        this.e = expiration;
        return this;
    }

    public aop$a a(int transition) {
        this.f = transition;
        return this;
    }

    public aop$a b(int loiteringDelay) {
        this.g = loiteringDelay;
        return this;
    }

    public aop a() {
        return new aop(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }
}
