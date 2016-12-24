package defpackage;

import java.io.InputStream;

/* compiled from: StreamByteArrayLoader */
public class ne implements ng<byte[]> {
    private final String a;

    public ne() {
        this("");
    }

    @Deprecated
    public ne(String id) {
        this.a = id;
    }

    public ku<InputStream> a(byte[] model, int width, int height) {
        return new kt(model, this.a);
    }
}
