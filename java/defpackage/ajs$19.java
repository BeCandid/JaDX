package defpackage;

import java.sql.Timestamp;
import java.util.Date;

/* compiled from: TypeAdapters */
class ajs$19 implements ais {
    ajs$19() {
    }

    public <T> air<T> a(aih gson, aju<T> typeToken) {
        if (typeToken.getRawType() != Timestamp.class) {
            return null;
        }
        return new ajs$19$1(this, gson.a(Date.class));
    }
}
