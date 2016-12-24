package defpackage;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl.a;

/* compiled from: LikeActionController */
class ws$6 implements a {
    ws$6() {
    }

    public boolean a(int resultCode, Intent data) {
        return ws.a(RequestCodeOffset.Like.a(), resultCode, data);
    }
}
