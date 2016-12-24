package defpackage;

import java.io.File;

/* compiled from: FileLruCache */
final class vp$e implements Comparable<vp$e> {
    private final File a;
    private final long b;

    public /* synthetic */ int compareTo(Object obj) {
        return a((vp$e) obj);
    }

    vp$e(File file) {
        this.a = file;
        this.b = file.lastModified();
    }

    File a() {
        return this.a;
    }

    long b() {
        return this.b;
    }

    public int a(vp$e another) {
        if (b() < another.b()) {
            return -1;
        }
        if (b() > another.b()) {
            return 1;
        }
        return a().compareTo(another.a());
    }

    public boolean equals(Object another) {
        return (another instanceof vp$e) && a((vp$e) another) == 0;
    }

    public int hashCode() {
        return ((this.a.hashCode() + 1073) * 37) + ((int) (this.b % 2147483647L));
    }
}
