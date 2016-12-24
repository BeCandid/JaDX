package defpackage;

/* compiled from: WorkQueue */
class wh$b implements wh$a {
    static final /* synthetic */ boolean a = (!wh.class.desiredAssertionStatus());
    final /* synthetic */ wh b;
    private final Runnable c;
    private wh$b d;
    private wh$b e;
    private boolean f;

    wh$b(wh whVar, Runnable callback) {
        this.b = whVar;
        this.c = callback;
    }

    public boolean a() {
        synchronized (this.b.b) {
            if (c()) {
                return false;
            }
            this.b.c = a(this.b.c);
            return true;
        }
    }

    public void b() {
        synchronized (this.b.b) {
            if (!c()) {
                this.b.c = a(this.b.c);
                this.b.c = a(this.b.c, true);
            }
        }
    }

    public boolean c() {
        return this.f;
    }

    Runnable d() {
        return this.c;
    }

    void a(boolean isRunning) {
        this.f = isRunning;
    }

    wh$b a(wh$b list, boolean addToFront) {
        if (!a && this.d != null) {
            throw new AssertionError();
        } else if (a || this.e == null) {
            if (list == null) {
                this.e = this;
                this.d = this;
                list = this;
            } else {
                this.d = list;
                this.e = list.e;
                wh$b wh_b = this.d;
                this.e.d = this;
                wh_b.e = this;
            }
            if (addToFront) {
                return this;
            }
            return list;
        } else {
            throw new AssertionError();
        }
    }

    wh$b a(wh$b list) {
        if (!a && this.d == null) {
            throw new AssertionError();
        } else if (a || this.e != null) {
            if (list == this) {
                if (this.d == this) {
                    list = null;
                } else {
                    list = this.d;
                }
            }
            this.d.e = this.e;
            this.e.d = this.d;
            this.e = null;
            this.d = null;
            return list;
        } else {
            throw new AssertionError();
        }
    }
}
