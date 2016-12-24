package defpackage;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: BitmapImageViewTarget */
public class qq extends qt<Bitmap> {
    public qq(ImageView view) {
        super(view);
    }

    protected void setResource(Bitmap resource) {
        ((ImageView) this.view).setImageBitmap(resource);
    }
}
