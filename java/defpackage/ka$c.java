package defpackage;

import java.io.File;

/* compiled from: DiskLruCache */
public final class ka$c {
    final /* synthetic */ ka a;
    private final String b;
    private final long c;
    private final long[] d;
    private final File[] e;

    private ka$c(ka kaVar, String key, long sequenceNumber, File[] files, long[] lengths) {
        this.a = kaVar;
        this.b = key;
        this.c = sequenceNumber;
        this.e = files;
        this.d = lengths;
    }

    public File a(int index) {
        return this.e[index];
    }
}
