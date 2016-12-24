package defpackage;

import java.util.Queue;

/* compiled from: GifResourceDecoder */
class ou$b {
    private final Queue<kg> a = ri.a(0);

    ou$b() {
    }

    public synchronized kg a(byte[] data) {
        kg result;
        result = (kg) this.a.poll();
        if (result == null) {
            result = new kg();
        }
        return result.a(data);
    }

    public synchronized void a(kg parser) {
        parser.a();
        this.a.offer(parser);
    }
}
