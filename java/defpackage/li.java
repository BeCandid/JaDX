package defpackage;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* compiled from: OriginalKey */
class li implements kn {
    private final String a;
    private final kn b;

    public li(String id, kn signature) {
        this.a = id;
        this.b = signature;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        li that = (li) o;
        if (!this.a.equals(that.a)) {
            return false;
        }
        if (this.b.equals(that.b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.a.getBytes("UTF-8"));
        this.b.a(messageDigest);
    }
}
