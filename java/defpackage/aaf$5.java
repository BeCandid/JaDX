package defpackage;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.common.GooglePlayServicesUtil;

class aaf$5 implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;

    aaf$5(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    public void onClick(View view) {
        this.a.startActivity(GooglePlayServicesUtil.zzbC(this.b));
    }
}
