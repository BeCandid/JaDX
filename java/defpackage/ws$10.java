package defpackage;

import android.os.Bundle;

/* compiled from: LikeActionController */
class ws$10 implements ws$m {
    final /* synthetic */ Bundle a;
    final /* synthetic */ ws b;

    ws$10(ws this$0, Bundle bundle) {
        this.b = this$0;
        this.a = bundle;
    }

    public void a() {
        if (we.a(this.b.s)) {
            Bundle errorBundle = new Bundle();
            errorBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
            ws.c(this.b, "com.facebook.sdk.LikeActionController.DID_ERROR", errorBundle);
            return;
        }
        un requestBatch = new un();
        ws$k likeRequest = new ws$k(this.b, this.b.s, this.b.l);
        likeRequest.a(requestBatch);
        requestBatch.a(new ws$10$1(this, likeRequest));
        requestBatch.h();
    }
}
