package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;

/* compiled from: GlideBitmapDrawableTranscoder */
public class pe implements pf<Bitmap, ny> {
    private final Resources a;
    private final ln b;

    public pe(Resources resources, ln bitmapPool) {
        this.a = resources;
        this.b = bitmapPool;
    }

    public lj<ny> a(lj<Bitmap> toTranscode) {
        return new nz(new ny(this.a, (Bitmap) toTranscode.b()), this.b);
    }

    public String a() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
