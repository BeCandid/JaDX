package defpackage;

import android.os.Bundle;

/* compiled from: LikeDialog */
class wt$1 extends wx {
    final /* synthetic */ uk a;
    final /* synthetic */ wt b;

    wt$1(wt this$0, uk callback, uk ukVar) {
        this.b = this$0;
        this.a = ukVar;
        super(callback);
    }

    public void a(vf appCall, Bundle results) {
        this.a.onSuccess(new wt$b(results));
    }
}
