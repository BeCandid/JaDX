package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
abstract class to$j {
    private final int a;
    private final to$j[] b;

    public to$j(int tag, to$j... children) {
        this.a = tag;
        if (children == null) {
            children = to.b;
        }
        this.b = children;
    }

    public int b() {
        int size = c();
        return (size + CodedOutputStream.l(size)) + CodedOutputStream.j(this.a);
    }

    public int c() {
        int size = a();
        for (to$j child : this.b) {
            size += child.b();
        }
        return size;
    }

    public void b(CodedOutputStream cos) throws IOException {
        cos.g(this.a, 2);
        cos.k(c());
        a(cos);
        for (to$j child : this.b) {
            child.b(cos);
        }
    }

    public int a() {
        return 0;
    }

    public void a(CodedOutputStream cos) throws IOException {
    }
}
