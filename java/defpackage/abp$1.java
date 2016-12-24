package defpackage;

class abp$1 implements Runnable {
    final /* synthetic */ xk a;
    final /* synthetic */ abp b;

    abp$1(abp abp, xk xkVar) {
        this.b = abp;
        this.a = xkVar;
    }

    public void run() {
        xh xhVar;
        try {
            abe.a.set(Boolean.valueOf(true));
            this.b.h.sendMessage(this.b.h.obtainMessage(0, this.b.a.a(this.a)));
            abe.a.set(Boolean.valueOf(false));
            this.b.b(this.a);
            xhVar = (xh) this.b.g.get();
            if (xhVar != null) {
                xhVar.b(this.b);
            }
        } catch (RuntimeException e) {
            this.b.h.sendMessage(this.b.h.obtainMessage(1, e));
            abe.a.set(Boolean.valueOf(false));
            this.b.b(this.a);
            xhVar = (xh) this.b.g.get();
            if (xhVar != null) {
                xhVar.b(this.b);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            abe.a.set(Boolean.valueOf(false));
            this.b.b(this.a);
            xhVar = (xh) this.b.g.get();
            if (xhVar != null) {
                xhVar.b(this.b);
            }
        }
    }
}
