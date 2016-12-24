package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: GifDrawable */
class on$a extends ConstantState {
    kf a;
    byte[] b;
    Context c;
    kr<Bitmap> d;
    int e;
    int f;
    kd$a g;
    ln h;
    Bitmap i;

    public on$a(kf header, byte[] data, Context context, kr<Bitmap> frameTransformation, int targetWidth, int targetHeight, kd$a provider, ln bitmapPool, Bitmap firstFrame) {
        if (firstFrame == null) {
            throw new NullPointerException("The first frame of the GIF must not be null");
        }
        this.a = header;
        this.b = data;
        this.h = bitmapPool;
        this.i = firstFrame;
        this.c = context.getApplicationContext();
        this.d = frameTransformation;
        this.e = targetWidth;
        this.f = targetHeight;
        this.g = provider;
    }

    public Drawable newDrawable(Resources res) {
        return newDrawable();
    }

    public Drawable newDrawable() {
        return new on(this);
    }

    public int getChangingConfigurations() {
        return 0;
    }
}
