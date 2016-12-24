package defpackage;

public final class agz$a<V> {
    private final V a;
    private final abr<V> b;
    private final String c;

    private agz$a(String str, abr<V> abr_V, V v) {
        xz.a((Object) abr_V);
        this.b = abr_V;
        this.a = v;
        this.c = str;
    }

    static agz$a<Integer> a(String str, int i) {
        return agz$a.a(str, i, i);
    }

    static agz$a<Integer> a(String str, int i, int i2) {
        return new agz$a(str, abr.a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    static agz$a<Long> a(String str, long j) {
        return agz$a.a(str, j, j);
    }

    static agz$a<Long> a(String str, long j, long j2) {
        return new agz$a(str, abr.a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    static agz$a<String> a(String str, String str2) {
        return agz$a.a(str, str2, str2);
    }

    static agz$a<String> a(String str, String str2, String str3) {
        return new agz$a(str, abr.a(str, str3), str2);
    }

    static agz$a<Boolean> a(String str, boolean z) {
        return agz$a.a(str, z, z);
    }

    static agz$a<Boolean> a(String str, boolean z, boolean z2) {
        return new agz$a(str, abr.a(str, z2), Boolean.valueOf(z));
    }

    public V a(V v) {
        return v != null ? v : this.a;
    }

    public String a() {
        return this.c;
    }

    public V b() {
        return this.a;
    }
}
