package defpackage;

import android.os.Bundle;
import com.facebook.share.model.ShareContent;

/* compiled from: MessageDialog */
class xb$a$1 implements vk$a {
    final /* synthetic */ vf a;
    final /* synthetic */ ShareContent b;
    final /* synthetic */ boolean c;
    final /* synthetic */ xb$a d;

    xb$a$1(xb$a this$1, vf vfVar, ShareContent shareContent, boolean z) {
        this.d = this$1;
        this.a = vfVar;
        this.b = shareContent;
        this.c = z;
    }

    public Bundle a() {
        return wv.a(this.a.c(), this.b, this.c);
    }

    public Bundle b() {
        return wr.a(this.a.c(), this.b, this.c);
    }
}
