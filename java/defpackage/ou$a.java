package defpackage;

import java.util.Queue;

/* compiled from: GifResourceDecoder */
class ou$a {
    private final Queue<kd> a = ri.a(0);

    ou$a() {
    }

    public synchronized kd a(kd$a bitmapProvider) {
        kd result;
        result = (kd) this.a.poll();
        if (result == null) {
            result = new kd(bitmapProvider);
        }
        return result;
    }

    public synchronized void a(kd decoder) {
        decoder.g();
        this.a.offer(decoder);
    }
}
