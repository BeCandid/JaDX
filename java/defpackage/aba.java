package defpackage;

public final class aba<O extends xf$a> {
    private final xf<O> a;
    private final O b;

    public xf$d<?> a() {
        return this.a.c();
    }

    public String b() {
        return this.a.e();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aba)) {
            return false;
        }
        aba aba = (aba) obj;
        return zc.a(this.a, aba.a) && zc.a(this.b, aba.b);
    }

    public int hashCode() {
        return zc.a(this.a, this.b);
    }
}
