package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray */
public final class aij extends ail implements Iterable<ail> {
    private final List<ail> a = new ArrayList();

    public void a(ail element) {
        if (element == null) {
            element = aim.a;
        }
        this.a.add(element);
    }

    public int a() {
        return this.a.size();
    }

    public Iterator<ail> iterator() {
        return this.a.iterator();
    }

    public ail a(int i) {
        return (ail) this.a.get(i);
    }

    public Number b() {
        if (this.a.size() == 1) {
            return ((ail) this.a.get(0)).b();
        }
        throw new IllegalStateException();
    }

    public String c() {
        if (this.a.size() == 1) {
            return ((ail) this.a.get(0)).c();
        }
        throw new IllegalStateException();
    }

    public double d() {
        if (this.a.size() == 1) {
            return ((ail) this.a.get(0)).d();
        }
        throw new IllegalStateException();
    }

    public float e() {
        if (this.a.size() == 1) {
            return ((ail) this.a.get(0)).e();
        }
        throw new IllegalStateException();
    }

    public long f() {
        if (this.a.size() == 1) {
            return ((ail) this.a.get(0)).f();
        }
        throw new IllegalStateException();
    }

    public int g() {
        if (this.a.size() == 1) {
            return ((ail) this.a.get(0)).g();
        }
        throw new IllegalStateException();
    }

    public boolean h() {
        if (this.a.size() == 1) {
            return ((ail) this.a.get(0)).h();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof aij) && ((aij) o).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
