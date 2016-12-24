package defpackage;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.becandid.candid.GossipApplication;
import java.io.InputStream;

/* compiled from: ImageLoadingUtil */
class is$1 implements qf<String, oh> {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;
    final /* synthetic */ View c;
    final /* synthetic */ View d;
    final /* synthetic */ ImageView e;

    is$1(Context context, int i, View view, View view2, ImageView imageView) {
        this.a = context;
        this.b = i;
        this.c = view;
        this.d = view2;
        this.e = imageView;
    }

    public /* synthetic */ boolean onException(Exception exception, Object obj, qy qyVar, boolean z) {
        return a(exception, (String) obj, qyVar, z);
    }

    public /* synthetic */ boolean onResourceReady(Object obj, Object obj2, qy qyVar, boolean z, boolean z2) {
        return a((oh) obj, (String) obj2, qyVar, z, z2);
    }

    public boolean a(Exception e, String model, qy<oh> qyVar, boolean isFirstResource) {
        jx.a(GossipApplication.a().getApplicationContext()).a(mj.class, InputStream.class, new kl$a());
        new Handler(this.a.getMainLooper()).post(new is$1$1(this));
        return false;
    }

    public boolean a(oh resource, String model, qy<oh> qyVar, boolean isFromMemoryCache, boolean isFirstResource) {
        jx.a(GossipApplication.a().getApplicationContext()).a(mj.class, InputStream.class, new kl$a());
        new Handler(this.a.getMainLooper()).post(new is$1$2(this));
        return false;
    }
}
