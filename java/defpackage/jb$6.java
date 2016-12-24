package defpackage;

import android.content.Context;
import android.widget.Toast;
import com.becandid.candid.models.NetworkData;

/* compiled from: ViewUtils */
class jb$6 extends apr<NetworkData> {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    jb$6(Context context, int i, int i2) {
        this.a = context;
        this.b = i;
        this.c = i2;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
        Toast.makeText(this.a, e.toString(), 1).show();
    }

    public void a(NetworkData networkData) {
        ix.a().a(new in$l(this.b, this.c));
        Toast.makeText(this.a, this.a.getResources().getString(2131230956), 0).show();
    }
}
