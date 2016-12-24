package defpackage;

import java.io.IOException;
import java.lang.reflect.Field;

/* compiled from: ReflectiveTypeAdapterFactory */
class ajo$1 extends ajo$b {
    final air<?> a = this.f.a(this.b, this.c, this.d);
    final /* synthetic */ aih b;
    final /* synthetic */ Field c;
    final /* synthetic */ aju d;
    final /* synthetic */ boolean e;
    final /* synthetic */ ajo f;

    ajo$1(ajo this$0, String name, boolean serialized, boolean deserialized, aih aih, Field field, aju aju, boolean z) {
        this.f = this$0;
        this.b = aih;
        this.c = field;
        this.d = aju;
        this.e = z;
        super(name, serialized, deserialized);
    }

    void a(ajw writer, Object value) throws IOException, IllegalAccessException {
        new ajr(this.b, this.a, this.d.getType()).a(writer, this.c.get(value));
    }

    void a(ajv reader, Object value) throws IOException, IllegalAccessException {
        Object fieldValue = this.a.b(reader);
        if (fieldValue != null || !this.e) {
            this.c.set(value, fieldValue);
        }
    }

    public boolean a(Object value) throws IOException, IllegalAccessException {
        if (this.h && this.c.get(value) != value) {
            return true;
        }
        return false;
    }
}
