package defpackage;

import android.content.Intent;
import com.facebook.FacebookException;

/* compiled from: LikeActionController */
class ws$1 implements ws$c {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ Intent c;

    ws$1(int i, int i2, Intent intent) {
        this.a = i;
        this.b = i2;
        this.c = intent;
    }

    public void a(ws likeActionController, FacebookException error) {
        if (error == null) {
            likeActionController.b(this.a, this.b, this.c);
        } else {
            we.a(ws.a, (Exception) error);
        }
    }
}
