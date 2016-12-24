package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/* compiled from: DrawableRequestBuilder */
public class jt<ModelType> extends jv<ModelType, mm, ow, oh> {
    public /* synthetic */ jv b(int x0) {
        return a(x0);
    }

    public /* synthetic */ jv b(int x0, int x1) {
        return a(x0, x1);
    }

    public /* synthetic */ jv b(DiskCacheStrategy x0) {
        return a(x0);
    }

    public /* synthetic */ jv b(Object x0) {
        return a(x0);
    }

    public /* synthetic */ jv b(km x0) {
        return a(x0);
    }

    public /* synthetic */ jv b(kn x0) {
        return a(x0);
    }

    public /* synthetic */ jv b(kp x0) {
        return a(x0);
    }

    public /* synthetic */ jv b(qf x0) {
        return a(x0);
    }

    public /* synthetic */ jv b(boolean x0) {
        return a(x0);
    }

    public /* synthetic */ jv b(kr[] x0) {
        return c(x0);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return i();
    }

    public /* synthetic */ jv g() {
        return i();
    }

    public /* synthetic */ jv h() {
        return d();
    }

    jt(Context context, Class<ModelType> modelClass, qc<ModelType, mm, ow, oh> loadProvider, jx glide, pt requestTracker, po lifecycle) {
        super(context, modelClass, loadProvider, oh.class, glide, requestTracker, lifecycle);
        c();
    }

    public jt<ModelType> a(kp<mm, ow> decoder) {
        super.b((kp) decoder);
        return this;
    }

    public jt<ModelType> a(ns... transformations) {
        return a((kr[]) transformations);
    }

    public jt<ModelType> a() {
        return c(this.c.e());
    }

    public jt<ModelType> b() {
        return c(this.c.f());
    }

    public jt<ModelType> a(kr<Bitmap>... bitmapTransformations) {
        pb[] transformations = new pb[bitmapTransformations.length];
        for (int i = 0; i < bitmapTransformations.length; i++) {
            transformations[i] = new pb(this.c.a(), bitmapTransformations[i]);
        }
        return c(transformations);
    }

    public jt<ModelType> c(kr<ow>... transformation) {
        super.b((kr[]) transformation);
        return this;
    }

    public final jt<ModelType> c() {
        super.a(new qi());
        return this;
    }

    public jt<ModelType> d() {
        super.h();
        return this;
    }

    public jt<ModelType> a(int resourceId) {
        super.b(resourceId);
        return this;
    }

    public jt<ModelType> a(qf<? super ModelType, oh> requestListener) {
        super.b((qf) requestListener);
        return this;
    }

    public jt<ModelType> a(DiskCacheStrategy strategy) {
        super.b(strategy);
        return this;
    }

    public jt<ModelType> a(boolean skip) {
        super.b(skip);
        return this;
    }

    public jt<ModelType> a(int width, int height) {
        super.b(width, height);
        return this;
    }

    public jt<ModelType> a(km<mm> sourceEncoder) {
        super.b((km) sourceEncoder);
        return this;
    }

    public jt<ModelType> a(kn signature) {
        super.b(signature);
        return this;
    }

    public jt<ModelType> a(ModelType model) {
        super.b((Object) model);
        return this;
    }

    public jt<ModelType> i() {
        return (jt) super.g();
    }

    public qy<oh> a(ImageView view) {
        return super.a(view);
    }

    void e() {
        b();
    }

    void f() {
        a();
    }
}
