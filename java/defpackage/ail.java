package defpackage;

import java.io.IOException;
import java.io.StringWriter;

/* compiled from: JsonElement */
public abstract class ail {
    public boolean i() {
        return this instanceof aij;
    }

    public boolean j() {
        return this instanceof ain;
    }

    public boolean k() {
        return this instanceof aip;
    }

    public boolean l() {
        return this instanceof aim;
    }

    public ain m() {
        if (j()) {
            return (ain) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public aij n() {
        if (i()) {
            return (aij) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public aip o() {
        if (k()) {
            return (aip) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean p() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            ajw jsonWriter = new ajw(stringWriter);
            jsonWriter.b(true);
            aje.a(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
