package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/* compiled from: GifFrameLoader */
class or {
    private final or$b a;
    private final kd b;
    private final Handler c;
    private boolean d;
    private boolean e;
    private jv<kd, kd, Bitmap, Bitmap> f;
    private or$a g;
    private boolean h;

    public or(Context context, or$b callback, kd gifDecoder, int width, int height) {
        this(callback, gifDecoder, null, or.a(context, gifDecoder, width, height, jx.a(context).a()));
    }

    or(or$b callback, kd gifDecoder, Handler handler, jv<kd, kd, Bitmap, Bitmap> requestBuilder) {
        this.d = false;
        this.e = false;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), new or$c(this, null));
        }
        this.a = callback;
        this.b = gifDecoder;
        this.c = handler;
        this.f = requestBuilder;
    }

    public void a(kr<Bitmap> transformation) {
        if (transformation == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f = this.f.b(transformation);
    }

    public void a() {
        if (!this.d) {
            this.d = true;
            this.h = false;
            e();
        }
    }

    public void b() {
        this.d = false;
    }

    public void c() {
        b();
        if (this.g != null) {
            jx.a(this.g);
            this.g = null;
        }
        this.h = true;
    }

    public Bitmap d() {
        return this.g != null ? this.g.a() : null;
    }

    private void e() {
        if (this.d && !this.e) {
            this.e = true;
            this.b.a();
            this.f.b(new or$d()).a(new or$a(this.c, this.b.d(), SystemClock.uptimeMillis() + ((long) this.b.b())));
        }
    }

    void a(or$a delayTarget) {
        if (this.h) {
            this.c.obtainMessage(2, delayTarget).sendToTarget();
            return;
        }
        or$a previous = this.g;
        this.g = delayTarget;
        this.a.b(delayTarget.b);
        if (previous != null) {
            this.c.obtainMessage(2, previous).sendToTarget();
        }
        this.e = false;
        e();
    }

    private static jv<kd, kd, Bitmap, Bitmap> a(Context context, kd gifDecoder, int width, int height, ln bitmapPool) {
        kp frameResourceDecoder = new ot(bitmapPool);
        os frameLoader = new os();
        return jx.b(context).a(frameLoader, kd.class).a((Object) gifDecoder).a(Bitmap.class).b((km) nl.b()).b(frameResourceDecoder).b(true).b(DiskCacheStrategy.b).b(width, height);
    }
}
