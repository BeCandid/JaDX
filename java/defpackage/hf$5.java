package defpackage;

/* compiled from: FeedAdapter */
class hf$5 extends apr<in$l> {
    final /* synthetic */ hf a;

    hf$5(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$l) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$l didDeleteComment) {
        this.a.a(didDeleteComment);
    }
}
