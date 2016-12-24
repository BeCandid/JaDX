package defpackage;

/* compiled from: CommentsAdapter */
class he$12 extends apr<in$ai> {
    final /* synthetic */ he a;

    he$12(he this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$ai) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$ai reportComment) {
        jb.a(reportComment.a, reportComment.d, reportComment.b);
    }
}
