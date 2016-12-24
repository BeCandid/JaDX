package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/* compiled from: Glide */
public class jx {
    private static volatile jx a;
    private final mi b;
    private final lc c;
    private final ln d;
    private final mb e;
    private final DecodeFormat f;
    private final qu g = new qu();
    private final pg h = new pg();
    private final pz i;
    private final nt j;
    private final pb k;
    private final nx l;
    private final pb m;
    private final Handler n;
    private final mf o;

    public static jx a(Context context) {
        if (a == null) {
            synchronized (jx.class) {
                if (a == null) {
                    Context applicationContext = context.getApplicationContext();
                    List<pv> modules = new pw(applicationContext).a();
                    jy builder = new jy(applicationContext);
                    for (pv module : modules) {
                        module.a(applicationContext, builder);
                    }
                    a = builder.a();
                    for (pv module2 : modules) {
                        module2.a(applicationContext, a);
                    }
                }
            }
        }
        return a;
    }

    jx(lc engine, mb memoryCache, ln bitmapPool, Context context, DecodeFormat decodeFormat) {
        this.c = engine;
        this.d = bitmapPool;
        this.e = memoryCache;
        this.f = decodeFormat;
        this.b = new mi(context);
        this.n = new Handler(Looper.getMainLooper());
        this.o = new mf(memoryCache, bitmapPool, decodeFormat);
        this.i = new pz();
        oc streamBitmapLoadProvider = new oc(bitmapPool, decodeFormat);
        this.i.a(InputStream.class, Bitmap.class, streamBitmapLoadProvider);
        nv fileDescriptorLoadProvider = new nv(bitmapPool, decodeFormat);
        this.i.a(ParcelFileDescriptor.class, Bitmap.class, fileDescriptorLoadProvider);
        ob imageVideoDataLoadProvider = new ob(streamBitmapLoadProvider, fileDescriptorLoadProvider);
        this.i.a(mm.class, Bitmap.class, imageVideoDataLoadProvider);
        oo gifDrawableLoadProvider = new oo(context, bitmapPool);
        this.i.a(InputStream.class, on.class, gifDrawableLoadProvider);
        this.i.a(mm.class, ow.class, new pc(imageVideoDataLoadProvider, gifDrawableLoadProvider, bitmapPool));
        this.i.a(InputStream.class, File.class, new ol());
        a(File.class, ParcelFileDescriptor.class, new my$a());
        a(File.class, InputStream.class, new nf$a());
        a(Integer.TYPE, ParcelFileDescriptor.class, new na$a());
        a(Integer.TYPE, InputStream.class, new nh$a());
        a(Integer.class, ParcelFileDescriptor.class, new na$a());
        a(Integer.class, InputStream.class, new nh$a());
        a(String.class, ParcelFileDescriptor.class, new nb$a());
        a(String.class, InputStream.class, new ni$a());
        a(Uri.class, ParcelFileDescriptor.class, new nc$a());
        a(Uri.class, InputStream.class, new nj$a());
        a(URL.class, InputStream.class, new nk$a());
        a(mj.class, InputStream.class, new nd$a());
        a(byte[].class, InputStream.class, new ne$a());
        this.h.a(Bitmap.class, ny.class, new pe(context.getResources(), bitmapPool));
        this.h.a(ow.class, oh.class, new pd(new pe(context.getResources(), bitmapPool)));
        this.j = new nt(bitmapPool);
        this.k = new pb(bitmapPool, this.j);
        this.l = new nx(bitmapPool);
        this.m = new pb(bitmapPool, this.l);
    }

    public ln a() {
        return this.d;
    }

    <Z, R> pf<Z, R> a(Class<Z> decodedClass, Class<R> transcodedClass) {
        return this.h.a(decodedClass, transcodedClass);
    }

    <T, Z> py<T, Z> b(Class<T> dataClass, Class<Z> decodedClass) {
        return this.i.a(dataClass, decodedClass);
    }

    <R> qy<R> a(ImageView imageView, Class<R> transcodedClass) {
        return this.g.a(imageView, transcodedClass);
    }

    lc b() {
        return this.c;
    }

    nt c() {
        return this.j;
    }

    nx d() {
        return this.l;
    }

    pb e() {
        return this.k;
    }

    pb f() {
        return this.m;
    }

    DecodeFormat g() {
        return this.f;
    }

    private mi i() {
        return this.b;
    }

    public void h() {
        ri.a();
        this.e.a();
        this.d.a();
    }

    public void a(int level) {
        ri.a();
        this.e.a(level);
        this.d.a(level);
    }

    public static void a(qy<?> target) {
        ri.a();
        qd request = target.getRequest();
        if (request != null) {
            request.d();
            target.setRequest(null);
        }
    }

    public <T, Y> void a(Class<T> modelClass, Class<Y> resourceClass, ms<T, Y> factory) {
        ms<T, Y> removed = this.b.a((Class) modelClass, (Class) resourceClass, (ms) factory);
        if (removed != null) {
            removed.a();
        }
    }

    public static <T, Y> mr<T, Y> a(Class<T> modelClass, Class<Y> resourceClass, Context context) {
        if (modelClass != null) {
            return jx.a(context).i().a(modelClass, resourceClass);
        }
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Unable to load null model, setting placeholder only");
        }
        return null;
    }

    public static <T> mr<T, InputStream> a(Class<T> modelClass, Context context) {
        return jx.a((Class) modelClass, InputStream.class, context);
    }

    public static <T> mr<T, ParcelFileDescriptor> b(Class<T> modelClass, Context context) {
        return jx.a((Class) modelClass, ParcelFileDescriptor.class, context);
    }

    public static jz b(Context context) {
        return pr.a().a(context);
    }

    public static jz a(FragmentActivity activity) {
        return pr.a().a(activity);
    }
}
