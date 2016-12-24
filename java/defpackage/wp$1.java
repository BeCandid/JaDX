package defpackage;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.internal.CallbackManagerImpl.a;

/* compiled from: DeviceShareDialog */
class wp$1 implements a {
    final /* synthetic */ uk a;
    final /* synthetic */ wp b;

    wp$1(wp this$0, uk ukVar) {
        this.b = this$0;
        this.a = ukVar;
    }

    public boolean a(int resultCode, Intent data) {
        Bundle extras = data.getExtras();
        if (data.hasExtra("error")) {
            this.a.onError(((FacebookRequestError) data.getParcelableExtra("error")).g());
        } else {
            this.a.onSuccess(new wp$a());
        }
        return true;
    }
}
