package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class to$m extends to$j {
    private final String a;
    private final int b;

    public to$m(uf threadData, to$k frames) {
        super(1, new to$j[]{frames});
        this.a = threadData.a;
        this.b = threadData.b;
    }

    public int a() {
        return CodedOutputStream.d(2, this.b) + (d() ? CodedOutputStream.b(1, sw.a(this.a)) : 0);
    }

    public void a(CodedOutputStream cos) throws IOException {
        if (d()) {
            cos.a(1, sw.a(this.a));
        }
        cos.a(2, this.b);
    }

    private boolean d() {
        return this.a != null && this.a.length() > 0;
    }
}
