package defpackage;

import android.os.Handler;
import com.facebook.GraphRequest;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProgressNoopOutputStream */
public class us extends OutputStream implements uv {
    private final Map<GraphRequest, uw> a = new HashMap();
    private final Handler b;
    private GraphRequest c;
    private uw d;
    private int e;

    public us(Handler callbackHandler) {
        this.b = callbackHandler;
    }

    public void a(GraphRequest currentRequest) {
        this.c = currentRequest;
        this.d = currentRequest != null ? (uw) this.a.get(currentRequest) : null;
    }

    public int a() {
        return this.e;
    }

    public Map<GraphRequest, uw> b() {
        return this.a;
    }

    public void a(long size) {
        if (this.d == null) {
            this.d = new uw(this.b, this.c);
            this.a.put(this.c, this.d);
        }
        this.d.b(size);
        this.e = (int) (((long) this.e) + size);
    }

    public void write(byte[] buffer) {
        a((long) buffer.length);
    }

    public void write(byte[] buffer, int offset, int length) {
        a((long) length);
    }

    public void write(int oneByte) {
        a(1);
    }
}
