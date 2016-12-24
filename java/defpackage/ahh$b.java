package defpackage;

import android.content.SharedPreferences.Editor;

public final class ahh$b {
    final /* synthetic */ ahh a;
    private final String b;
    private final long c;
    private boolean d;
    private long e;

    public ahh$b(ahh ahh, String str, long j) {
        this.a = ahh;
        xz.a(str);
        this.b = str;
        this.c = j;
    }

    private void b() {
        if (!this.d) {
            this.d = true;
            this.e = this.a.o.getLong(this.b, this.c);
        }
    }

    public long a() {
        b();
        return this.e;
    }

    public void a(long j) {
        Editor edit = this.a.o.edit();
        edit.putLong(this.b, j);
        edit.apply();
        this.e = j;
    }
}
