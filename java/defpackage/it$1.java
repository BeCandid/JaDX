package defpackage;

import com.becandid.candid.models.NetworkData.UploadResponse;

/* compiled from: PhotoHelper */
class it$1 extends apr<UploadResponse> {
    final /* synthetic */ it a;

    it$1(it this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((UploadResponse) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        ix.a().a(new in$ak(null, false, e.toString()));
    }

    public void a(UploadResponse uploadResponse) {
    }
}
