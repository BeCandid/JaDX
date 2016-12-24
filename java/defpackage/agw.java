package defpackage;

class agw {
    final String a;
    final String b;
    final long c;
    final long d;
    final long e;

    agw(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        xz.a(str);
        xz.a(str2);
        xz.b(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        xz.b(z);
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = j3;
    }

    agw a() {
        return new agw(this.a, this.b, this.c + 1, this.d + 1, this.e);
    }

    agw a(long j) {
        return new agw(this.a, this.b, this.c, this.d, j);
    }
}
