package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson */
class aih$7 extends air<AtomicLongArray> {
    final /* synthetic */ air a;

    aih$7(air air) {
        this.a = air;
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public void a(ajw out, AtomicLongArray value) throws IOException {
        out.b();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            this.a.a(out, Long.valueOf(value.get(i)));
        }
        out.c();
    }

    public AtomicLongArray a(ajv in) throws IOException {
        List<Long> list = new ArrayList();
        in.a();
        while (in.e()) {
            list.add(Long.valueOf(((Number) this.a.b(in)).longValue()));
        }
        in.b();
        int length = list.size();
        AtomicLongArray array = new AtomicLongArray(length);
        for (int i = 0; i < length; i++) {
            array.set(i, ((Long) list.get(i)).longValue());
        }
        return array;
    }
}
