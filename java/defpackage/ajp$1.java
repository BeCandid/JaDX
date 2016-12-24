package defpackage;

import java.sql.Date;

/* compiled from: SqlDateTypeAdapter */
class ajp$1 implements ais {
    ajp$1() {
    }

    public <T> air<T> a(aih gson, aju<T> typeToken) {
        return typeToken.getRawType() == Date.class ? new ajp() : null;
    }
}
