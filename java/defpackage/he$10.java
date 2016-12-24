package defpackage;

/* compiled from: CommentsAdapter */
class he$10 extends apr<in$s> {
    final /* synthetic */ he a;

    he$10(he this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$s) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$s didReportComment) {
        this.a.c(didReportComment.a);
    }
}
