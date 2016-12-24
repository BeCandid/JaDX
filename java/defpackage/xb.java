package defpackage;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.internal.MessageDialogFeature;
import com.facebook.share.internal.OpenGraphMessageDialogFeature;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageDialog */
public final class xb extends vl<ShareContent, wq$a> implements wq {
    private static final int b = RequestCodeOffset.Message.a();
    private boolean c;

    public static boolean a(Class<? extends ShareContent> contentType) {
        vj feature = xb.c(contentType);
        return feature != null && vk.a(feature);
    }

    public xb(Activity activity, int requestCode) {
        super(activity, requestCode);
        this.c = false;
        wz.a(requestCode);
    }

    public xb(Fragment fragment, int requestCode) {
        this(new vq(fragment), requestCode);
    }

    public xb(android.app.Fragment fragment, int requestCode) {
        this(new vq(fragment), requestCode);
    }

    private xb(vq fragmentWrapper, int requestCode) {
        super(fragmentWrapper, requestCode);
        this.c = false;
        wz.a(requestCode);
    }

    protected void a(CallbackManagerImpl callbackManager, uk<wq$a> callback) {
        wz.a(a(), (uj) callbackManager, (uk) callback);
    }

    public boolean e() {
        return this.c;
    }

    protected vf d() {
        return new vf(a());
    }

    protected List<vl$a> c() {
        ArrayList<vl$a> handlers = new ArrayList();
        handlers.add(new xb$a(this, null));
        return handlers;
    }

    private static vj c(Class<? extends ShareContent> contentType) {
        if (ShareLinkContent.class.isAssignableFrom(contentType)) {
            return MessageDialogFeature.MESSAGE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(contentType)) {
            return MessageDialogFeature.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(contentType)) {
            return MessageDialogFeature.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(contentType)) {
            return OpenGraphMessageDialogFeature.OG_MESSAGE_DIALOG;
        }
        return null;
    }
}
