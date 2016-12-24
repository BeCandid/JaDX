package defpackage;

import com.facebook.FacebookException;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;

/* compiled from: ShareContentValidation */
class wy$b extends wy$a {
    private wy$b() {
        super(null);
    }

    public void a(SharePhotoContent photoContent) {
        throw new FacebookException("Cannot share SharePhotoContent via web sharing dialogs");
    }

    public void a(ShareVideoContent videoContent) {
        throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
    }

    public void a(ShareMediaContent mediaContent) {
        throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
    }

    public void a(SharePhoto photo) {
        wy.e(photo, this);
    }
}
