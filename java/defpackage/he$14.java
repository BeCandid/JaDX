package defpackage;

/* compiled from: CommentsAdapter */
class he$14 extends apr<in$i> {
    final /* synthetic */ he a;

    he$14(he this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$i) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$i deleteModeratorCommentEvent) {
        jb.a(deleteModeratorCommentEvent.a, deleteModeratorCommentEvent.d, deleteModeratorCommentEvent.b, deleteModeratorCommentEvent.c);
    }
}
