package defpackage;

/* compiled from: FeedAdapter */
class hf$2 extends apr<in$ar> {
    final /* synthetic */ hf a;

    hf$2(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$ar) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$ar update) {
        this.a.a(update.a.post_id, update);
    }
}
