package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class to$c extends to$j {
    private final String a;
    private final String b;

    public to$c(ub customAttributeData) {
        super(2, new to$j[0]);
        this.a = customAttributeData.a;
        this.b = customAttributeData.b;
    }

    public int a() {
        return CodedOutputStream.b(1, sw.a(this.a)) + CodedOutputStream.b(2, sw.a(this.b == null ? "" : this.b));
    }

    public void a(CodedOutputStream cos) throws IOException {
        cos.a(1, sw.a(this.a));
        cos.a(2, sw.a(this.b == null ? "" : this.b));
    }
}
