package defpackage;

/* compiled from: CommentsAdapter */
class he$11 extends apr<in$g> {
    final /* synthetic */ he a;

    he$11(he this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$g) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$g commentEdit) {
        this.a.a(commentEdit.a, commentEdit.b, commentEdit.c);
    }
}
