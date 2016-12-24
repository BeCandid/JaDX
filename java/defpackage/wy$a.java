package defpackage;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;

/* compiled from: ShareContentValidation */
class wy$a {
    private boolean a;

    private wy$a() {
        this.a = false;
    }

    public void a(ShareLinkContent linkContent) {
        wy.b(linkContent, this);
    }

    public void a(SharePhotoContent photoContent) {
        wy.b(photoContent, this);
    }

    public void a(ShareVideoContent videoContent) {
        wy.b(videoContent, this);
    }

    public void a(ShareMediaContent mediaContent) {
        wy.b(mediaContent, this);
    }

    public void a(ShareOpenGraphContent openGraphContent) {
        this.a = true;
        wy.b(openGraphContent, this);
    }

    public void a(ShareOpenGraphAction openGraphAction) {
        wy.b(openGraphAction, this);
    }

    public void a(ShareOpenGraphObject openGraphObject) {
        wy.b(openGraphObject, this);
    }

    public void a(ShareOpenGraphValueContainer openGraphValueContainer, boolean requireNamespace) {
        wy.b(openGraphValueContainer, this, requireNamespace);
    }

    public void a(SharePhoto photo) {
        wy.d(photo, this);
    }

    public void a(ShareVideo video) {
        wy.b(video, this);
    }

    public void a(ShareMedia medium) {
        wy.a(medium, this);
    }

    public boolean a() {
        return this.a;
    }
}
