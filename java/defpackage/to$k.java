package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class to$k extends to$j {
    private final to$j[] a;

    public to$k(to$j... messages) {
        super(0, new to$j[0]);
        this.a = messages;
    }

    public void b(CodedOutputStream cos) throws IOException {
        for (to$j message : this.a) {
            message.b(cos);
        }
    }

    public int b() {
        int size = 0;
        for (to$j message : this.a) {
            size += message.b();
        }
        return size;
    }
}
