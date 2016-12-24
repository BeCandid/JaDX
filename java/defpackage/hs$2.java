package defpackage;

/* compiled from: FeedFragment */
class hs$2 extends apr<in$k> {
    final /* synthetic */ hs a;

    hs$2(hs this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$k) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$k didCreatePost) {
        if (this.a.c.equals("home")) {
            this.a.a(didCreatePost);
        }
    }
}
