package defpackage;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.List;

/* compiled from: DeviceShareDialog */
public class wp extends vl<ShareContent, wp$a> {
    private static final int b = RequestCodeOffset.DeviceShare.a();

    public wp(Activity activity) {
        super(activity, b);
    }

    public wp(Fragment fragment) {
        super(new vq(fragment), b);
    }

    public wp(android.support.v4.app.Fragment fragment) {
        super(new vq(fragment), b);
    }

    protected boolean a(ShareContent content, Object mode) {
        return (content instanceof ShareLinkContent) || (content instanceof ShareOpenGraphContent);
    }

    protected void b(ShareContent content, Object mode) {
        if (content == null) {
            throw new FacebookException("Must provide non-null content to share");
        } else if ((content instanceof ShareLinkContent) || (content instanceof ShareOpenGraphContent)) {
            Intent intent = new Intent();
            intent.setClass(ul.f(), FacebookActivity.class);
            intent.setAction("DeviceShareDialogFragment");
            intent.putExtra("content", content);
            a(intent, a());
        } else {
            throw new FacebookException(getClass().getSimpleName() + " only supports ShareLinkContent or ShareOpenGraphContent");
        }
    }

    protected List<vl$a> c() {
        return null;
    }

    protected vf d() {
        return null;
    }

    protected void a(CallbackManagerImpl callbackManager, uk<wp$a> callback) {
        callbackManager.b(a(), new wp$1(this, callback));
    }
}
