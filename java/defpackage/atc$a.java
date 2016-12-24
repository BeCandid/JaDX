package defpackage;

import android.widget.ImageView;

/* compiled from: PhotoViewAttacher */
class atc$a implements Runnable {
    final /* synthetic */ atc a;
    private final float b;
    private final float c;
    private final long d = System.currentTimeMillis();
    private final float e;
    private final float f;

    public atc$a(atc atc, float currentZoom, float targetZoom, float focalX, float focalY) {
        this.a = atc;
        this.b = focalX;
        this.c = focalY;
        this.e = currentZoom;
        this.f = targetZoom;
    }

    public void run() {
        ImageView imageView = this.a.c();
        if (imageView != null) {
            float t = a();
            this.a.a((this.e + ((this.f - this.e) * t)) / this.a.g(), this.b, this.c);
            if (t < 1.0f) {
                asz.a(imageView, this);
            }
        }
    }

    private float a() {
        return atc.a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.d)) * 1.0f) / ((float) this.a.b)));
    }
}
