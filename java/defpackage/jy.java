package defpackage;

import android.content.Context;
import android.os.Build.VERSION;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor;
import java.util.concurrent.ExecutorService;

/* compiled from: GlideBuilder */
public class jy {
    private final Context a;
    private lc b;
    private ln c;
    private mb d;
    private ExecutorService e;
    private ExecutorService f;
    private DecodeFormat g;
    private lu$a h;

    public jy(Context context) {
        this.a = context.getApplicationContext();
    }

    jx a() {
        if (this.e == null) {
            this.e = new FifoPriorityThreadPoolExecutor(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f == null) {
            this.f = new FifoPriorityThreadPoolExecutor(1);
        }
        mc calculator = new mc(this.a);
        if (this.c == null) {
            if (VERSION.SDK_INT >= 11) {
                this.c = new lq(calculator.b());
            } else {
                this.c = new lo();
            }
        }
        if (this.d == null) {
            this.d = new ma(calculator.a());
        }
        if (this.h == null) {
            this.h = new lz(this.a);
        }
        if (this.b == null) {
            this.b = new lc(this.d, this.h, this.f, this.e);
        }
        if (this.g == null) {
            this.g = DecodeFormat.d;
        }
        return new jx(this.b, this.d, this.c, this.a, this.g);
    }
}
