package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: StrictLineReader */
class kb$1 extends ByteArrayOutputStream {
    final /* synthetic */ kb a;

    kb$1(kb kbVar, int x0) {
        this.a = kbVar;
        super(x0);
    }

    public String toString() {
        int length = (this.count <= 0 || this.buf[this.count - 1] != (byte) 13) ? this.count : this.count - 1;
        try {
            return new String(this.buf, 0, length, this.a.b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
