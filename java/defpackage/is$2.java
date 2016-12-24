package defpackage;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.becandid.candid.GossipApplication;
import java.io.InputStream;

/* compiled from: ImageLoadingUtil */
class is$2 implements qf<String, oh> {
    final /* synthetic */ Context a;
    final /* synthetic */ View b;
    final /* synthetic */ int c;
    final /* synthetic */ View d;
    final /* synthetic */ View e;
    final /* synthetic */ int f;
    final /* synthetic */ int g;
    final /* synthetic */ boolean h;
    final /* synthetic */ String i;
    final /* synthetic */ ImageView j;

    is$2(Context context, View view, int i, View view2, View view3, int i2, int i3, boolean z, String str, ImageView imageView) {
        this.a = context;
        this.b = view;
        this.c = i;
        this.d = view2;
        this.e = view3;
        this.f = i2;
        this.g = i3;
        this.h = z;
        this.i = str;
        this.j = imageView;
    }

    public /* synthetic */ boolean onException(Exception exception, Object obj, qy qyVar, boolean z) {
        return a(exception, (String) obj, qyVar, z);
    }

    public /* synthetic */ boolean onResourceReady(Object obj, Object obj2, qy qyVar, boolean z, boolean z2) {
        return a((oh) obj, (String) obj2, qyVar, z, z2);
    }

    public boolean a(Exception e, String model, qy<oh> qyVar, boolean isFirstResource) {
        new Handler(this.a.getMainLooper()).post(new is$2$1(this));
        return false;
    }

    public boolean a(oh resource, String model, qy<oh> qyVar, boolean isFromMemoryCache, boolean isFirstResource) {
        jx.a(GossipApplication.a().getApplicationContext()).a(mj.class, InputStream.class, new kl$a());
        new Handler(this.a.getMainLooper()).post(new is$2$2(this));
        return false;
    }
}
