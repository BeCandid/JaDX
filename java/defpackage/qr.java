package defpackage;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: DrawableImageViewTarget */
public class qr extends qt<Drawable> {
    protected /* synthetic */ void setResource(Object x0) {
        a((Drawable) x0);
    }

    public qr(ImageView view) {
        super(view);
    }

    protected void a(Drawable resource) {
        ((ImageView) this.view).setImageDrawable(resource);
    }
}
