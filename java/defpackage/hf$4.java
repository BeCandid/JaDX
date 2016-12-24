package defpackage;

/* compiled from: FeedAdapter */
class hf$4 extends apr<in$ad> {
    final /* synthetic */ hf a;

    hf$4(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$ad) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$ad newComment) {
        this.a.a(newComment);
    }
}
