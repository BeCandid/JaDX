package defpackage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileToStreamDecoder */
public class ok<T> implements kp<File, T> {
    private static final ok$a a = new ok$a();
    private kp<InputStream, T> b;
    private final ok$a c;

    public ok(kp<InputStream, T> streamDecoder) {
        this(streamDecoder, a);
    }

    ok(kp<InputStream, T> streamDecoder, ok$a fileOpener) {
        this.b = streamDecoder;
        this.c = fileOpener;
    }

    public lj<T> a(File source, int width, int height) throws IOException {
        InputStream is = null;
        try {
            is = this.c.a(source);
            lj<T> result = this.b.a(is, width, height);
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
            return result;
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e2) {
                }
            }
        }
    }

    public String a() {
        return "";
    }
}
