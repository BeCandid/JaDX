package defpackage;

import android.content.Context;
import android.widget.Toast;
import com.becandid.candid.models.NetworkData;

/* compiled from: ViewUtils */
class jb$4 extends apr<NetworkData> {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;

    jb$4(Context context, int i, String str) {
        this.a = context;
        this.b = i;
        this.c = str;
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
        ix.a().a(new in$s(this.b, this.c));
        Toast.makeText(this.a, this.a.getResources().getString(2131230959), 0).show();
    }
}
