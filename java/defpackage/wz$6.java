package defpackage;

import android.os.Bundle;
import com.facebook.share.model.ShareMedia;
import java.util.List;
import java.util.UUID;

/* compiled from: ShareInternalUtility */
class wz$6 implements we$d<ShareMedia, Bundle> {
    final /* synthetic */ UUID a;
    final /* synthetic */ List b;

    wz$6(UUID uuid, List list) {
        this.a = uuid;
        this.b = list;
    }

    public Bundle a(ShareMedia item) {
        vy$a attachment = wz.b(this.a, item);
        this.b.add(attachment);
        Bundle mediaInfo = new Bundle();
        mediaInfo.putString("type", item.b().name());
        mediaInfo.putString("uri", attachment.a());
        return mediaInfo;
    }
}
