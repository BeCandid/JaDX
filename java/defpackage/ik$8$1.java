package defpackage;

import android.util.Log;
import com.becandid.candid.models.NetworkData.UploadResponse;
import rx.exceptions.CompositeException;

/* compiled from: ApiService */
class ik$8$1 extends apr<String> {
    final /* synthetic */ UploadResponse a;
    final /* synthetic */ ik$8 b;

    ik$8$1(ik$8 this$1, UploadResponse uploadResponse) {
        this.b = this$1;
        this.a = uploadResponse;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((String) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
        if (e instanceof CompositeException) {
            for (Throwable err : ((CompositeException) e).a()) {
                Log.d("ERRS", err.toString());
            }
        }
        ix.a().a(new in$ak(this.a, false, null));
    }

    public void a(String string) {
        ix.a().a(new in$ak(this.a, true, null));
    }
}
