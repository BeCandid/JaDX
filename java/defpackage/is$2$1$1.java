package defpackage;

import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.GossipApplication;
import java.io.InputStream;

/* compiled from: ImageLoadingUtil */
class is$2$1$1 implements OnClickListener {
    final /* synthetic */ is$2$1 a;

    is$2$1$1(is$2$1 this$1) {
        this.a = this$1;
    }

    public void onClick(View v) {
        this.a.a.b.setVisibility(8);
        this.a.a.d.setVisibility(0);
        jx.a(GossipApplication.a().getApplicationContext()).a(mj.class, InputStream.class, new kl$a(is.b(this.a.a.e, this.a.a.d, this.a.a.a, this.a.a.f, this.a.a.g)));
        if (this.a.a.h) {
            is.d(this.a.a.i, this.a.a.e, this.a.a.d, this.a.a.a, this.a.a.f, this.a.a.j);
        } else {
            is.c(this.a.a.i, this.a.a.e, this.a.a.d, this.a.a.a, this.a.a.f, this.a.a.j);
        }
    }
}
