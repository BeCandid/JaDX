package defpackage;

/* compiled from: OperatorOnErrorResumeNextViaFunction */
class aqo$2 extends apr<T> {
    long a;
    final /* synthetic */ apr b;
    final /* synthetic */ aqq c;
    final /* synthetic */ asx d;
    final /* synthetic */ aqo e;
    private boolean f;

    aqo$2(aqo aqo, apr apr, aqq aqq, asx asx) {
        this.e = aqo;
        this.b = apr;
        this.c = aqq;
        this.d = asx;
    }

    public void onCompleted() {
        if (!this.f) {
            this.f = true;
            this.b.onCompleted();
        }
    }

    public void onError(Throwable e) {
        if (this.f) {
            apx.a(e);
            ask.a().b().a(e);
            return;
        }
        this.f = true;
        try {
            unsubscribe();
            apr next = new aqo$2$1(this);
            this.d.a(next);
            long p = this.a;
            if (p != 0) {
                this.c.b(p);
            }
            ((apl) this.e.a.call(e)).a(next);
        } catch (Throwable e2) {
            apx.a(e2, this.b);
        }
    }

    public void onNext(T t) {
        if (!this.f) {
            this.a++;
            this.b.onNext(t);
        }
    }

    public void setProducer(apn producer) {
        this.c.a(producer);
    }
}
