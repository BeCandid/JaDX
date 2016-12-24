package defpackage;

/* compiled from: CommentsAdapter */
class he$1 extends apr<in$aq> {
    final /* synthetic */ he a;

    he$1(he this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$aq) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$aq updateComment) {
        this.a.a(updateComment.a, updateComment);
    }
}
