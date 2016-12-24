package defpackage;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

/* compiled from: ProgressResponseBody */
class ij$1 extends ForwardingSource {
    long a = 0;
    final /* synthetic */ ij b;

    ij$1(ij this$0, Source x0) {
        this.b = this$0;
        super(x0);
    }

    public long read(Buffer sink, long byteCount) throws IOException {
        long bytesRead = super.read(sink, byteCount);
        this.a = (bytesRead != -1 ? bytesRead : 0) + this.a;
        this.b.b.a(this.a, this.b.a.contentLength(), bytesRead == -1);
        return bytesRead;
    }
}
