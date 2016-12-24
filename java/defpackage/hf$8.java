package defpackage;

/* compiled from: FeedAdapter */
class hf$8 extends apr<in$ag> {
    final /* synthetic */ hf a;

    hf$8(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$ag) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
    }

    public void a(in$ag refreshProgressUpdate) {
        this.a.notifyDataSetChanged();
    }
}
