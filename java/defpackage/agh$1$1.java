package defpackage;

class agh$1$1 implements Runnable {
    final /* synthetic */ agh$1 a;

    agh$1$1(agh$1 agh_1) {
        this.a = agh_1;
    }

    public void run() {
        if (!this.a.d.c.a(this.a.b)) {
            return;
        }
        if (this.a.a.d().O()) {
            this.a.c.E().a("Device AppMeasurementService processed last upload request");
        } else {
            this.a.c.E().a("Local AppMeasurementService processed last upload request");
        }
    }
}
