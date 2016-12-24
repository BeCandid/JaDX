package defpackage;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: ImageViewTarget */
public abstract class qt<Z> extends qz<ImageView, Z> implements qk$a {
    protected abstract void setResource(Z z);

    public qt(ImageView view) {
        super(view);
    }

    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void onLoadStarted(Drawable placeholder) {
        ((ImageView) this.view).setImageDrawable(placeholder);
    }

    public void onLoadFailed(Exception e, Drawable errorDrawable) {
        ((ImageView) this.view).setImageDrawable(errorDrawable);
    }

    public void onLoadCleared(Drawable placeholder) {
        ((ImageView) this.view).setImageDrawable(placeholder);
    }

    public void onResourceReady(Z resource, qk<? super Z> glideAnimation) {
        if (glideAnimation == null || !glideAnimation.a(resource, this)) {
            setResource(resource);
        }
    }
}
