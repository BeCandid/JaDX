package defpackage;

/* compiled from: ActivityParams */
public class aon {
    public static final aon a = new aon$a().a(500).a();
    private long b;

    aon(long interval) {
        this.b = interval;
    }

    public long a() {
        return this.b;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof aon)) {
            return false;
        }
        if (this.b != ((aon) o).b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) (this.b ^ (this.b >>> 32));
    }
}
