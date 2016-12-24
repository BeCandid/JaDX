package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class to$l extends to$j {
    private final String a;
    private final String b;
    private final long c;

    public to$l(ue signalData) {
        super(3, new to$j[0]);
        this.a = signalData.a;
        this.b = signalData.b;
        this.c = signalData.c;
    }

    public int a() {
        return (CodedOutputStream.b(1, sw.a(this.a)) + CodedOutputStream.b(2, sw.a(this.b))) + CodedOutputStream.b(3, this.c);
    }

    public void a(CodedOutputStream cos) throws IOException {
        cos.a(1, sw.a(this.a));
        cos.a(2, sw.a(this.b));
        cos.a(3, this.c);
    }
}
