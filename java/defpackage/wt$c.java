package defpackage;

import com.facebook.share.internal.LikeContent;

/* compiled from: LikeDialog */
class wt$c extends vl$a {
    final /* synthetic */ wt b;

    private wt$c(wt wtVar) {
        this.b = wtVar;
        super(wtVar);
    }

    public boolean a(LikeContent content, boolean isBestEffort) {
        return content != null && wt.f();
    }

    public vf a(LikeContent content) {
        vf appCall = this.b.d();
        vk.a(appCall, wt.b(content), wt.h());
        return appCall;
    }
}
