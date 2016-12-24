package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class to$g extends to$j {
    private final long a;
    private final String b;
    private final String c;
    private final long d;
    private final int e;

    public to$g(uf$a frameData) {
        super(3, new to$j[0]);
        this.a = frameData.a;
        this.b = frameData.b;
        this.c = frameData.c;
        this.d = frameData.d;
        this.e = frameData.e;
    }

    public int a() {
        return (((CodedOutputStream.b(1, this.a) + CodedOutputStream.b(2, sw.a(this.b))) + CodedOutputStream.b(3, sw.a(this.c))) + CodedOutputStream.b(4, this.d)) + CodedOutputStream.d(5, this.e);
    }

    public void a(CodedOutputStream cos) throws IOException {
        cos.a(1, this.a);
        cos.a(2, sw.a(this.b));
        cos.a(3, sw.a(this.c));
        cos.a(4, this.d);
        cos.a(5, this.e);
    }
}
