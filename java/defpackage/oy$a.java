package defpackage;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;

/* compiled from: GifBitmapWrapperResourceDecoder */
class oy$a {
    oy$a() {
    }

    public InputStream a(InputStream is, byte[] buffer) {
        return new RecyclableBufferedInputStream(is, buffer);
    }
}
