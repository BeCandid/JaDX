package defpackage;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import org.json.JSONObject;

/* compiled from: WebDialogParameters */
public class xa {
    public static Bundle a(ShareLinkContent shareLinkContent) {
        Bundle params = xa.a((ShareContent) shareLinkContent);
        we.a(params, "href", shareLinkContent.h());
        we.a(params, "quote", shareLinkContent.d());
        return params;
    }

    public static Bundle a(ShareOpenGraphContent shareOpenGraphContent) {
        Bundle params = xa.a((ShareContent) shareOpenGraphContent);
        we.a(params, "action_type", shareOpenGraphContent.a().a());
        try {
            JSONObject ogJSON = wz.a(wz.a(shareOpenGraphContent), false);
            if (ogJSON != null) {
                we.a(params, "action_properties", ogJSON.toString());
            }
            return params;
        } catch (Throwable e) {
            throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", e);
        }
    }

    public static Bundle a(ShareContent shareContent) {
        Bundle params = new Bundle();
        ShareHashtag shareHashtag = shareContent.l();
        if (shareHashtag != null) {
            we.a(params, "hashtag", shareHashtag.a());
        }
        return params;
    }

    public static Bundle b(ShareLinkContent shareLinkContent) {
        Bundle webParams = new Bundle();
        we.a(webParams, "name", shareLinkContent.b());
        we.a(webParams, "description", shareLinkContent.a());
        we.a(webParams, "link", we.a(shareLinkContent.h()));
        we.a(webParams, "picture", we.a(shareLinkContent.c()));
        we.a(webParams, "quote", shareLinkContent.d());
        if (shareLinkContent.l() != null) {
            we.a(webParams, "hashtag", shareLinkContent.l().a());
        }
        return webParams;
    }

    public static Bundle a(ShareFeedContent shareFeedContent) {
        Bundle webParams = new Bundle();
        we.a(webParams, "to", shareFeedContent.a());
        we.a(webParams, "link", shareFeedContent.b());
        we.a(webParams, "picture", shareFeedContent.f());
        we.a(webParams, "source", shareFeedContent.g());
        we.a(webParams, "name", shareFeedContent.c());
        we.a(webParams, "caption", shareFeedContent.d());
        we.a(webParams, "description", shareFeedContent.e());
        return webParams;
    }
}
