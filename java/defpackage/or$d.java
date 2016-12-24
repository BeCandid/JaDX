package defpackage;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

/* compiled from: GifFrameLoader */
class or$d implements kn {
    private final UUID a;

    public or$d() {
        this(UUID.randomUUID());
    }

    or$d(UUID uuid) {
        this.a = uuid;
    }

    public boolean equals(Object o) {
        if (o instanceof or$d) {
            return ((or$d) o).a.equals(this.a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        throw new UnsupportedOperationException("Not implemented");
    }
}
