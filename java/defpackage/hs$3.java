package defpackage;

/* compiled from: FeedFragment */
class hs$3 extends apr<in$p> {
    final /* synthetic */ hs a;

    hs$3(hs this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$p) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$p didLeaveGroupFromFeed) {
        int pos = this.a.b.d(didLeaveGroupFromFeed.b);
        if (pos != -1) {
            int total = this.a.b.getItemCount();
            int i = pos;
            while (i < total) {
                if (this.a.b.f(i).group_id == didLeaveGroupFromFeed.a) {
                    this.a.b.b(this.a.b.e(i));
                    i--;
                    total--;
                }
                i++;
            }
            this.a.b.notifyDataSetChanged();
        }
    }
}
