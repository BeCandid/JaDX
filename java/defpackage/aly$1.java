package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: QueueFile */
class aly$1 implements aly$c {
    boolean a = true;
    final /* synthetic */ StringBuilder b;
    final /* synthetic */ aly c;

    aly$1(aly aly, StringBuilder stringBuilder) {
        this.c = aly;
        this.b = stringBuilder;
    }

    public void a(InputStream in, int length) throws IOException {
        if (this.a) {
            this.a = false;
        } else {
            this.b.append(", ");
        }
        this.b.append(length);
    }
}
