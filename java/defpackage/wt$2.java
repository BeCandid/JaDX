package defpackage;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.a;

/* compiled from: LikeDialog */
class wt$2 implements a {
    final /* synthetic */ wx a;
    final /* synthetic */ wt b;

    wt$2(wt this$0, wx wxVar) {
        this.b = this$0;
        this.a = wxVar;
    }

    public boolean a(int resultCode, Intent data) {
        return wz.a(this.b.a(), resultCode, data, this.a);
    }
}
