package defpackage;

/* compiled from: FeedFragment */
class hs$4 extends apr<in$n> {
    final /* synthetic */ hs a;

    hs$4(hs this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$n) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$n didJoinGroupFromFeed) {
        this.a.b.notifyDataSetChanged();
    }
}
