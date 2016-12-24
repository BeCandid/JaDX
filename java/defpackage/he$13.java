package defpackage;

/* compiled from: CommentsAdapter */
class he$13 extends apr<in$h> {
    final /* synthetic */ he a;

    he$13(he this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$h) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$h deleteCommentEvent) {
        jb.b(deleteCommentEvent.a, deleteCommentEvent.b, deleteCommentEvent.c);
    }
}
