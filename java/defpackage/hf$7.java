package defpackage;

/* compiled from: FeedAdapter */
class hf$7 extends apr<in$al> {
    final /* synthetic */ hf a;

    hf$7(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$al) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$al seeMorePost) {
        this.a.notifyItemChanged(this.a.d(seeMorePost.a));
    }
}
