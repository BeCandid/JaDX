package defpackage;

/* compiled from: Engine */
class lc$b implements lb$a {
    private final lu$a a;
    private volatile lu b;

    public lc$b(lu$a factory) {
        this.a = factory;
    }

    public lu a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = this.a.a();
                }
                if (this.b == null) {
                    this.b = new lv();
                }
            }
        }
        return this.b;
    }
}
