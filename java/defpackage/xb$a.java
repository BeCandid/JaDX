package defpackage;

import android.app.Activity;
import com.facebook.share.model.ShareContent;

/* compiled from: MessageDialog */
class xb$a extends vl$a {
    final /* synthetic */ xb b;

    private xb$a(xb xbVar) {
        this.b = xbVar;
        super(xbVar);
    }

    public boolean a(ShareContent shareContent, boolean isBestEffort) {
        return shareContent != null && xb.a(shareContent.getClass());
    }

    public vf a(ShareContent content) {
        wy.a(content);
        vf appCall = this.b.d();
        boolean shouldFailOnDataError = this.b.e();
        Activity activity = this.b.b();
        vk.a(appCall, new xb$a$1(this, appCall, content, shouldFailOnDataError), xb.c(content.getClass()));
        return appCall;
    }
}
