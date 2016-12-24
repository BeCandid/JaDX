package defpackage;

import android.os.Handler;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.b;
import com.facebook.GraphRequest.e;

/* compiled from: RequestProgress */
public class uw {
    private final GraphRequest a;
    private final Handler b;
    private final long c = ul.h();
    private long d;
    private long e;
    private long f;

    uw(Handler callbackHandler, GraphRequest request) {
        this.a = request;
        this.b = callbackHandler;
    }

    void a(long size) {
        this.d += size;
        if (this.d >= this.e + this.c || this.d >= this.f) {
            a();
        }
    }

    void b(long size) {
        this.f += size;
    }

    void a() {
        if (this.d > this.e) {
            b callback = this.a.g();
            if (this.f > 0 && (callback instanceof e)) {
                long currentCopy = this.d;
                long maxProgressCopy = this.f;
                e callbackCopy = (e) callback;
                if (this.b == null) {
                    callbackCopy.a(currentCopy, maxProgressCopy);
                } else {
                    this.b.post(new uw$1(this, callbackCopy, currentCopy, maxProgressCopy));
                }
                this.e = this.d;
            }
        }
    }
}
