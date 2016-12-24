package defpackage;

import java.util.List;
import java.util.Map;

class ahe$b implements Runnable {
    private final ahe$a a;
    private final int b;
    private final Throwable c;
    private final byte[] d;
    private final String e;
    private final Map<String, List<String>> f;

    private ahe$b(String str, ahe$a ahe_a, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        xz.a((Object) ahe_a);
        this.a = ahe_a;
        this.b = i;
        this.c = th;
        this.d = bArr;
        this.e = str;
        this.f = map;
    }

    public void run() {
        this.a.a(this.e, this.b, this.c, this.d, this.f);
    }
}
