package defpackage;

import java.util.ArrayList;
import java.util.List;

class ahk$a implements ags$b {
    aca$e a;
    List<Long> b;
    List<aca$b> c;
    long d;
    final /* synthetic */ ahk e;

    private ahk$a(ahk ahk) {
        this.e = ahk;
    }

    private long a(aca$b aca_b) {
        return ((aca_b.d.longValue() / 1000) / 60) / 60;
    }

    public void a(aca$e aca_e) {
        xz.a((Object) aca_e);
        this.a = aca_e;
    }

    boolean a() {
        return this.c == null || this.c.isEmpty();
    }

    public boolean a(long j, aca$b aca_b) {
        xz.a((Object) aca_b);
        if (this.c == null) {
            this.c = new ArrayList();
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (this.c.size() > 0 && a((aca$b) this.c.get(0)) != a(aca_b)) {
            return false;
        }
        long b = this.d + ((long) aca_b.b());
        if (b >= ((long) this.e.d().X())) {
            return false;
        }
        this.d = b;
        this.c.add(aca_b);
        this.b.add(Long.valueOf(j));
        return this.c.size() < this.e.d().Y();
    }
}
