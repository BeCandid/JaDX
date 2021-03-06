package defpackage;

import android.os.Handler;
import com.facebook.GraphRequest;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/* compiled from: ProgressOutputStream */
public class ut extends FilterOutputStream implements uv {
    private final Map<GraphRequest, uw> a;
    private final un b;
    private final long c = ul.h();
    private long d;
    private long e;
    private long f;
    private uw g;

    public ut(OutputStream out, un requests, Map<GraphRequest, uw> progressMap, long maxProgress) {
        super(out);
        this.b = requests;
        this.a = progressMap;
        this.f = maxProgress;
    }

    private void a(long size) {
        if (this.g != null) {
            this.g.a(size);
        }
        this.d += size;
        if (this.d >= this.e + this.c || this.d >= this.f) {
            a();
        }
    }

    private void a() {
        if (this.d > this.e) {
            for (un$a callback : this.b.e()) {
                if (callback instanceof un$b) {
                    Handler callbackHandler = this.b.c();
                    un$b progressCallback = (un$b) callback;
                    if (callbackHandler == null) {
                        progressCallback.a(this.b, this.d, this.f);
                    } else {
                        callbackHandler.post(new ut$1(this, progressCallback));
                    }
                }
            }
            this.e = this.d;
        }
    }

    public void a(GraphRequest request) {
        this.g = request != null ? (uw) this.a.get(request) : null;
    }

    public void write(byte[] buffer) throws IOException {
        this.out.write(buffer);
        a((long) buffer.length);
    }

    public void write(byte[] buffer, int offset, int length) throws IOException {
        this.out.write(buffer, offset, length);
        a((long) length);
    }

    public void write(int oneByte) throws IOException {
        this.out.write(oneByte);
        a(1);
    }

    public void close() throws IOException {
        super.close();
        for (uw p : this.a.values()) {
            p.a();
        }
        a();
    }
}
