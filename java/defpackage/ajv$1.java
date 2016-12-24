package defpackage;

import java.io.IOException;

/* compiled from: JsonReader */
class ajv$1 extends ajb {
    ajv$1() {
    }

    public void a(ajv reader) throws IOException {
        if (reader instanceof ajk) {
            ((ajk) reader).o();
            return;
        }
        int p = reader.a;
        if (p == 0) {
            p = reader.q();
        }
        if (p == 13) {
            reader.a = 9;
        } else if (p == 12) {
            reader.a = 8;
        } else if (p == 14) {
            reader.a = 10;
        } else {
            throw new IllegalStateException("Expected a name but was " + reader.f() + " " + " at line " + reader.r() + " column " + reader.s() + " path " + reader.t());
        }
    }
}
