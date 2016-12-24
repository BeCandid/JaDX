package defpackage;

import android.content.Context;
import android.os.Bundle;

/* compiled from: LikeStatusClient */
final class wu extends wa {
    private String a;

    wu(Context context, String applicationId, String objectId) {
        super(context, 65542, 65543, 20141001, applicationId);
        this.a = objectId;
    }

    protected void a(Bundle data) {
        data.putString("com.facebook.platform.extra.OBJECT_ID", this.a);
    }
}
