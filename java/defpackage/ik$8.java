package defpackage;

import com.becandid.candid.models.NetworkData.UploadResponse;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.schedulers.Schedulers;

/* compiled from: ApiService */
class ik$8 implements aqc<UploadResponse, apl<UploadResponse>> {
    final /* synthetic */ File a;
    final /* synthetic */ ik b;

    ik$8(ik this$0, File file) {
        this.b = this$0;
        this.a = file;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((UploadResponse) obj);
    }

    public apl<UploadResponse> a(UploadResponse uploadResponse) {
        if (uploadResponse != null && uploadResponse.success) {
            this.b.a((String) uploadResponse.s3_data.get("bucket"), uploadResponse.s3_data, RequestBody.create(MediaType.parse("image/jpg"), this.a)).b(Schedulers.io()).a(apv.a()).b(new ik$8$1(this, uploadResponse));
        }
        return null;
    }
}
