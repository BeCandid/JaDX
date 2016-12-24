package defpackage;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonTreeWriter */
public final class ajl extends ajw {
    private static final Writer a = new ajl$1();
    private static final aip b = new aip("closed");
    private final List<ail> c = new ArrayList();
    private String d;
    private ail e = aim.a;

    public ajl() {
        super(a);
    }

    public ail a() {
        if (this.c.isEmpty()) {
            return this.e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.c);
    }

    private ail j() {
        return (ail) this.c.get(this.c.size() - 1);
    }

    private void a(ail value) {
        if (this.d != null) {
            if (!value.l() || i()) {
                ((ain) j()).a(this.d, value);
            }
            this.d = null;
        } else if (this.c.isEmpty()) {
            this.e = value;
        } else {
            ail element = j();
            if (element instanceof aij) {
                ((aij) element).a(value);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public ajw b() throws IOException {
        ail array = new aij();
        a(array);
        this.c.add(array);
        return this;
    }

    public ajw c() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof aij) {
            this.c.remove(this.c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public ajw d() throws IOException {
        ail object = new ain();
        a(object);
        this.c.add(object);
        return this;
    }

    public ajw e() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof ain) {
            this.c.remove(this.c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public ajw a(String name) throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof ain) {
            this.d = name;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public ajw b(String value) throws IOException {
        if (value == null) {
            return f();
        }
        a(new aip(value));
        return this;
    }

    public ajw f() throws IOException {
        a(aim.a);
        return this;
    }

    public ajw a(boolean value) throws IOException {
        a(new aip(Boolean.valueOf(value)));
        return this;
    }

    public ajw a(long value) throws IOException {
        a(new aip(Long.valueOf(value)));
        return this;
    }

    public ajw a(Number value) throws IOException {
        if (value == null) {
            return f();
        }
        if (!g()) {
            double d = value.doubleValue();
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + value);
            }
        }
        a(new aip(value));
        return this;
    }

    public void flush() throws IOException {
    }

    public void close() throws IOException {
        if (this.c.isEmpty()) {
            this.c.add(b);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
