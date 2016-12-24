package defpackage;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.a;

/* compiled from: ShareInternalUtility */
class wz$3 implements a {
    final /* synthetic */ int a;
    final /* synthetic */ uk b;

    wz$3(int i, uk ukVar) {
        this.a = i;
        this.b = ukVar;
    }

    public boolean a(int resultCode, Intent data) {
        return wz.a(this.a, resultCode, data, wz.a(this.b));
    }
}
