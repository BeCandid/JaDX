package defpackage;

/* compiled from: MessagesAdapter */
class hm$1 extends apr<in$aj> {
    final /* synthetic */ hm a;

    hm$1(hm this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$aj) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$aj reportMessage) {
        int pos = this.a.a.indexOf(reportMessage.a);
        this.a.a.remove(reportMessage.a);
        this.a.notifyItemRemoved(pos);
    }
}
