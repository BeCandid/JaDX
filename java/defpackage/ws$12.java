package defpackage;

/* compiled from: LikeActionController */
class ws$12 implements ws$m {
    final /* synthetic */ ws a;

    ws$12(ws this$0) {
        this.a = this$0;
    }

    public void a() {
        ws$i likeRequestWrapper;
        switch (ws$4.a[this.a.l.ordinal()]) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                likeRequestWrapper = new ws$h(this.a, this.a.s);
                break;
            default:
                likeRequestWrapper = new ws$f(this.a, this.a.s, this.a.l);
                break;
        }
        ws$d engagementRequest = new ws$d(this.a, this.a.s, this.a.l);
        un requestBatch = new un();
        likeRequestWrapper.a(requestBatch);
        engagementRequest.a(requestBatch);
        requestBatch.a(new ws$12$1(this, likeRequestWrapper, engagementRequest));
        requestBatch.h();
    }
}
