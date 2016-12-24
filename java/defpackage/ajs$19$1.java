package defpackage;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: TypeAdapters */
class ajs$19$1 extends air<Timestamp> {
    final /* synthetic */ air a;
    final /* synthetic */ ajs$19 b;

    ajs$19$1(ajs$19 this$0, air air) {
        this.b = this$0;
        this.a = air;
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public Timestamp a(ajv in) throws IOException {
        Date date = (Date) this.a.b(in);
        return date != null ? new Timestamp(date.getTime()) : null;
    }

    public void a(ajw out, Timestamp value) throws IOException {
        this.a.a(out, value);
    }
}
