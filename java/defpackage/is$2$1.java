package defpackage;

import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import java.io.InputStream;

/* compiled from: ImageLoadingUtil */
class is$2$1 implements Runnable {
    final /* synthetic */ is$2 a;

    is$2$1(is$2 this$0) {
        this.a = this$0;
    }

    public void run() {
        if (this.a.b != null && this.a.c == 1 && AppState.config.getInt("android_ wait_for_play") == 1) {
            this.a.b.setVisibility(0);
            this.a.b.setOnClickListener(new is$2$1$1(this));
            return;
        }
        this.a.d.setVisibility(0);
        jx.a(GossipApplication.a().getApplicationContext()).a(mj.class, InputStream.class, new kl$a(is.b(this.a.e, this.a.d, this.a.a, this.a.f, this.a.g)));
        if (this.a.h) {
            is.d(this.a.i, this.a.e, this.a.d, this.a.a, this.a.f, this.a.j);
        } else {
            is.c(this.a.i, this.a.e, this.a.d, this.a.a, this.a.f, this.a.j);
        }
    }
}
