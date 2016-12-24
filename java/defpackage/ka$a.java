package defpackage;

import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCache */
public final class ka$a {
    final /* synthetic */ ka a;
    private final ka$b b;
    private final boolean[] c;
    private boolean d;

    private ka$a(ka kaVar, ka$b entry) {
        this.a = kaVar;
        this.b = entry;
        this.c = entry.f ? null : new boolean[kaVar.h];
    }

    public File a(int index) throws IOException {
        File dirtyFile;
        synchronized (this.a) {
            if (this.b.g != this) {
                throw new IllegalStateException();
            }
            if (!this.b.f) {
                this.c[index] = true;
            }
            dirtyFile = this.b.b(index);
            if (!this.a.b.exists()) {
                this.a.b.mkdirs();
            }
        }
        return dirtyFile;
    }

    public void a() throws IOException {
        this.a.a(this, true);
        this.d = true;
    }

    public void b() throws IOException {
        this.a.a(this, false);
    }

    public void c() {
        if (!this.d) {
            try {
                b();
            } catch (IOException e) {
            }
        }
    }
}
