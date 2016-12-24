package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: ImageViewTargetFactory */
public class qu {
    public <Z> qy<Z> a(ImageView view, Class<Z> clazz) {
        if (oh.class.isAssignableFrom(clazz)) {
            return new qs(view);
        }
        if (Bitmap.class.equals(clazz)) {
            return new qq(view);
        }
        if (Drawable.class.isAssignableFrom(clazz)) {
            return new qr(view);
        }
        throw new IllegalArgumentException("Unhandled class: " + clazz + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
