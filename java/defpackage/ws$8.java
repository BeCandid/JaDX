package defpackage;

import android.content.Context;
import com.facebook.AccessToken;

/* compiled from: LikeActionController */
class ws$8 extends ui {
    ws$8() {
    }

    protected void a(AccessToken oldAccessToken, AccessToken currentAccessToken) {
        Context appContext = ul.f();
        if (currentAccessToken == null) {
            ws.i = (ws.i + 1) % 1000;
            appContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", ws.i).apply();
            ws.c.clear();
            ws.b.a();
        }
        ws.d(null, "com.facebook.sdk.LikeActionController.DID_RESET");
    }
}
