package defpackage;

import com.facebook.share.internal.LikeContent;

/* compiled from: LikeDialog */
class wt$a extends vl$a {
    final /* synthetic */ wt b;

    private wt$a(wt wtVar) {
        this.b = wtVar;
        super(wtVar);
    }

    public boolean a(LikeContent content, boolean isBestEffort) {
        return content != null && wt.e();
    }

    public vf a(LikeContent content) {
        vf appCall = this.b.d();
        vk.a(appCall, new wt$a$1(this, content), wt.h());
        return appCall;
    }
}
