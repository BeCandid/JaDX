package defpackage;

/* compiled from: FeedAdapter */
class hf$6 extends apr<in$af> {
    final /* synthetic */ hf a;

    hf$6(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$af) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$af postEdit) {
        this.a.a(postEdit.a, postEdit.b, postEdit.c);
    }
}
