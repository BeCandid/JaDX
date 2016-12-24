package defpackage;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;

/* compiled from: VideoBitmapDecoder */
public class of implements np<ParcelFileDescriptor> {
    private static final of$a a = new of$a();
    private of$a b;
    private int c;

    public of() {
        this(a, -1);
    }

    of(of$a factory, int frame) {
        this.b = factory;
        this.c = frame;
    }

    public Bitmap a(ParcelFileDescriptor resource, ln bitmapPool, int outWidth, int outHeight, DecodeFormat decodeFormat) throws IOException {
        Bitmap result;
        MediaMetadataRetriever mediaMetadataRetriever = this.b.a();
        mediaMetadataRetriever.setDataSource(resource.getFileDescriptor());
        if (this.c >= 0) {
            result = mediaMetadataRetriever.getFrameAtTime((long) this.c);
        } else {
            result = mediaMetadataRetriever.getFrameAtTime();
        }
        mediaMetadataRetriever.release();
        resource.close();
        return result;
    }

    public String a() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
