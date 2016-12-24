package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;

/* compiled from: GlideBitmapDrawable */
public class ny extends oh {
    private final Rect a;
    private int b;
    private int c;
    private boolean d;
    private boolean e;
    private ny$a f;

    public ny(Resources res, Bitmap bitmap) {
        this(res, new ny$a(bitmap));
    }

    ny(Resources res, ny$a state) {
        this.a = new Rect();
        if (state == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        int targetDensity;
        this.f = state;
        if (res != null) {
            int density = res.getDisplayMetrics().densityDpi;
            if (density == 0) {
                targetDensity = 160;
            } else {
                targetDensity = density;
            }
            state.b = targetDensity;
        } else {
            targetDensity = state.b;
        }
        this.b = state.a.getScaledWidth(targetDensity);
        this.c = state.a.getScaledHeight(targetDensity);
    }

    public int getIntrinsicWidth() {
        return this.b;
    }

    public int getIntrinsicHeight() {
        return this.c;
    }

    public boolean a() {
        return false;
    }

    public void a(int loopCount) {
    }

    public void start() {
    }

    public void stop() {
    }

    public boolean isRunning() {
        return false;
    }

    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.d = true;
    }

    public ConstantState getConstantState() {
        return this.f;
    }

    public void draw(Canvas canvas) {
        if (this.d) {
            Gravity.apply(119, this.b, this.c, getBounds(), this.a);
            this.d = false;
        }
        canvas.drawBitmap(this.f.a, null, this.a, this.f.c);
    }

    public void setAlpha(int alpha) {
        if (this.f.c.getAlpha() != alpha) {
            this.f.a(alpha);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f.a(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        Bitmap bm = this.f.a;
        return (bm == null || bm.hasAlpha() || this.f.c.getAlpha() < 255) ? -3 : -1;
    }

    public Drawable mutate() {
        if (!this.e && super.mutate() == this) {
            this.f = new ny$a(this.f);
            this.e = true;
        }
        return this;
    }

    public Bitmap b() {
        return this.f.a;
    }
}
