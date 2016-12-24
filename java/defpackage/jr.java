package defpackage;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.InputStream;

/* compiled from: BitmapRequestBuilder */
public class jr<ModelType, TranscodeType> extends jv<ModelType, mm, Bitmap, TranscodeType> {
    private final ln g;
    private nu h = nu.a;
    private DecodeFormat i;
    private kp<InputStream, Bitmap> j;
    private kp<ParcelFileDescriptor, Bitmap> k;

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
        return a(x0);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return d();
    }

    public /* synthetic */ jv g() {
        return d();
    }

    public /* synthetic */ jv h() {
        return c();
    }

    jr(qc<ModelType, mm, Bitmap, TranscodeType> loadProvider, Class<TranscodeType> transcodeClass, jv<ModelType, ?, ?, ?> other) {
        super(loadProvider, transcodeClass, other);
        this.g = other.c.a();
        this.i = other.c.g();
        this.j = new od(this.g, this.i);
        this.k = new nw(this.g, this.i);
    }

    public jr<ModelType, TranscodeType> a(kp<mm, Bitmap> decoder) {
        super.b((kp) decoder);
        return this;
    }

    public jr<ModelType, TranscodeType> a(ns... transformations) {
        super.b((kr[]) transformations);
        return this;
    }

    public jr<ModelType, TranscodeType> a() {
        return a(this.c.c());
    }

    public jr<ModelType, TranscodeType> b() {
        return a(this.c.d());
    }

    public jr<ModelType, TranscodeType> a(kr<Bitmap>... transformations) {
        super.b((kr[]) transformations);
        return this;
    }

    public jr<ModelType, TranscodeType> c() {
        super.h();
        return this;
    }

    public jr<ModelType, TranscodeType> a(int resourceId) {
        super.b(resourceId);
        return this;
    }

    public jr<ModelType, TranscodeType> a(qf<? super ModelType, TranscodeType> requestListener) {
        super.b((qf) requestListener);
        return this;
    }

    public jr<ModelType, TranscodeType> a(boolean skip) {
        super.b(skip);
        return this;
    }

    public jr<ModelType, TranscodeType> a(DiskCacheStrategy strategy) {
        super.b(strategy);
        return this;
    }

    public jr<ModelType, TranscodeType> a(int width, int height) {
        super.b(width, height);
        return this;
    }

    public jr<ModelType, TranscodeType> a(km<mm> sourceEncoder) {
        super.b((km) sourceEncoder);
        return this;
    }

    public jr<ModelType, TranscodeType> a(kn signature) {
        super.b(signature);
        return this;
    }

    public jr<ModelType, TranscodeType> a(ModelType model) {
        super.b((Object) model);
        return this;
    }

    public jr<ModelType, TranscodeType> d() {
        return (jr) super.g();
    }

    public qy<TranscodeType> a(ImageView view) {
        return super.a(view);
    }

    void e() {
        b();
    }

    void f() {
        a();
    }
}
