package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: GifBitmapWrapperStreamResourceDecoder */
public class pa implements kp<InputStream, ow> {
    private final kp<mm, ow> a;

    public pa(kp<mm, ow> gifBitmapDecoder) {
        this.a = gifBitmapDecoder;
    }

    public lj<ow> a(InputStream source, int width, int height) throws IOException {
        return this.a.a(new mm(source, null), width, height);
    }

    public String a() {
        return this.a.a();
    }
}
