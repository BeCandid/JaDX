package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: RequestManager */
public class jz implements pp {
    private final Context a;
    private final po b;
    private final ps c;
    private final pt d;
    private final jx e;
    private final jz$d f;
    private jz$a g;

    public jz(Context context, po lifecycle, ps treeNode) {
        this(context, lifecycle, treeNode, new pt(), new pl());
    }

    jz(Context context, po lifecycle, ps treeNode, pt requestTracker, pl factory) {
        this.a = context.getApplicationContext();
        this.b = lifecycle;
        this.c = treeNode;
        this.d = requestTracker;
        this.e = jx.a(context);
        this.f = new jz$d(this);
        pk connectivityMonitor = factory.a(context, new jz$e(requestTracker));
        if (ri.c()) {
            new Handler(Looper.getMainLooper()).post(new jz$1(this, lifecycle));
        } else {
            lifecycle.a(this);
        }
        lifecycle.a(connectivityMonitor);
    }

    public void a(int level) {
        this.e.a(level);
    }

    public void a() {
        this.e.h();
    }

    public void b() {
        ri.a();
        this.d.a();
    }

    public void c() {
        ri.a();
        this.d.b();
    }

    public void onStart() {
        c();
    }

    public void onStop() {
        b();
    }

    public void onDestroy() {
        this.d.c();
    }

    public <A, T> jz$b<A, T> a(mr<A, T> modelLoader, Class<T> dataClass) {
        return new jz$b(this, modelLoader, dataClass);
    }

    public <T> jz$c<T> a(ng<T> modelLoader) {
        return new jz$c(this, modelLoader);
    }

    public ju<String> a(String string) {
        return (ju) d().a((Object) string);
    }

    public ju<String> d() {
        return a(String.class);
    }

    public <T> ju<T> a(T model) {
        return (ju) a(jz.c((Object) model)).a((Object) model);
    }

    private <T> ju<T> a(Class<T> modelClass) {
        mr<T, InputStream> streamModelLoader = jx.a((Class) modelClass, this.a);
        mr<T, ParcelFileDescriptor> fileDescriptorModelLoader = jx.b((Class) modelClass, this.a);
        if (modelClass != null && streamModelLoader == null && fileDescriptorModelLoader == null) {
            throw new IllegalArgumentException("Unknown type " + modelClass + ". You must provide a Model of a type for" + " which there is a registered ModelLoader, if you are using a custom model, you must first call" + " Glide#register with a ModelLoaderFactory for your custom model class");
        }
        return (ju) this.f.a(new ju(modelClass, streamModelLoader, fileDescriptorModelLoader, this.a, this.e, this.d, this.b, this.f));
    }

    private static <T> Class<T> c(T model) {
        return model != null ? model.getClass() : null;
    }
}
