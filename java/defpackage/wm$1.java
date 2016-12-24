package defpackage;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.a;

/* compiled from: LoginManager */
class wm$1 implements a {
    final /* synthetic */ uk a;
    final /* synthetic */ wm b;

    wm$1(wm this$0, uk ukVar) {
        this.b = this$0;
        this.a = ukVar;
    }

    public boolean a(int resultCode, Intent data) {
        return this.b.a(resultCode, data, this.a);
    }
}
