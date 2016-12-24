package defpackage;

/* compiled from: FeedAdapter */
class hf$3 extends apr<in$r> {
    final /* synthetic */ hf a;

    hf$3(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$r) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$r didRemovePost) {
        this.a.b(didRemovePost.a);
    }
}
