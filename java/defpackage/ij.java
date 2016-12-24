package defpackage;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* compiled from: ProgressResponseBody */
public class ij extends ResponseBody {
    private final ResponseBody a;
    private final ij$a b;
    private BufferedSource c;

    public ij(ResponseBody responseBody, ij$a progressListener) {
        this.a = responseBody;
        this.b = progressListener;
    }

    public MediaType contentType() {
        return this.a.contentType();
    }

    public long contentLength() {
        return this.a.contentLength();
    }

    public BufferedSource source() {
        if (this.c == null) {
            this.c = Okio.buffer(a(this.a.source()));
        }
        return this.c;
    }

    private Source a(Source source) {
        return new ij$1(this, source);
    }
}
