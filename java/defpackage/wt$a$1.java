package defpackage;

import android.os.Bundle;
import android.util.Log;
import com.facebook.share.internal.LikeContent;

/* compiled from: LikeDialog */
class wt$a$1 implements vk$a {
    final /* synthetic */ LikeContent a;
    final /* synthetic */ wt$a b;

    wt$a$1(wt$a this$1, LikeContent likeContent) {
        this.b = this$1;
        this.a = likeContent;
    }

    public Bundle a() {
        return wt.b(this.a);
    }

    public Bundle b() {
        Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
        return new Bundle();
    }
}
