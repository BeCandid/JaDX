package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: QueueFileLogStore */
class tq$1 implements aly$c {
    final /* synthetic */ byte[] a;
    final /* synthetic */ int[] b;
    final /* synthetic */ tq c;

    tq$1(tq tqVar, byte[] bArr, int[] iArr) {
        this.c = tqVar;
        this.a = bArr;
        this.b = iArr;
    }

    public void a(InputStream in, int length) throws IOException {
        try {
            in.read(this.a, this.b[0], length);
            int[] iArr = this.b;
            iArr[0] = iArr[0] + length;
        } finally {
            in.close();
        }
    }
}
