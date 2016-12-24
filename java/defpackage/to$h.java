package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class to$h extends to$j {
    sw a;

    public to$h(sw logBytes) {
        super(6, new to$j[0]);
        this.a = logBytes;
    }

    public int a() {
        return CodedOutputStream.b(1, this.a);
    }

    public void a(CodedOutputStream cos) throws IOException {
        cos.a(1, this.a);
    }
}
