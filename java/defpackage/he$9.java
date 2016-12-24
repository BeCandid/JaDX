package defpackage;

/* compiled from: CommentsAdapter */
class he$9 extends apr<in$l> {
    final /* synthetic */ he a;

    he$9(he this$0) {
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
        this.a.c(didDeleteComment.a);
    }
}
