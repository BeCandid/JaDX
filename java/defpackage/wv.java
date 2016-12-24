package defpackage;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NativeDialogParameters */
public class wv {
    public static Bundle a(UUID callId, ShareContent shareContent, boolean shouldFailOnDataError) {
        wf.a((Object) shareContent, "shareContent");
        wf.a((Object) callId, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return wv.a((ShareLinkContent) shareContent, shouldFailOnDataError);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent photoContent = (SharePhotoContent) shareContent;
            return wv.a(photoContent, wz.a(photoContent, callId), shouldFailOnDataError);
        } else if (shareContent instanceof ShareVideoContent) {
            ShareVideoContent videoContent = (ShareVideoContent) shareContent;
            return wv.a(videoContent, wz.a(videoContent, callId), shouldFailOnDataError);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent openGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return wv.a(openGraphContent, wz.a(wz.a(callId, openGraphContent), false), shouldFailOnDataError);
            } catch (JSONException e) {
                throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e.getMessage());
            }
        } else if (!(shareContent instanceof ShareMediaContent)) {
            return null;
        } else {
            ShareMediaContent mediaContent = (ShareMediaContent) shareContent;
            return wv.a(mediaContent, wz.a(mediaContent, callId), shouldFailOnDataError);
        }
    }

    private static Bundle a(ShareLinkContent linkContent, boolean dataErrorsFatal) {
        Bundle params = wv.a((ShareContent) linkContent, dataErrorsFatal);
        we.a(params, "TITLE", linkContent.b());
        we.a(params, "DESCRIPTION", linkContent.a());
        we.a(params, "IMAGE", linkContent.c());
        we.a(params, "QUOTE", linkContent.d());
        return params;
    }

    private static Bundle a(SharePhotoContent photoContent, List<String> imageUrls, boolean dataErrorsFatal) {
        Bundle params = wv.a((ShareContent) photoContent, dataErrorsFatal);
        params.putStringArrayList("PHOTOS", new ArrayList(imageUrls));
        return params;
    }

    private static Bundle a(ShareVideoContent videoContent, String videoUrl, boolean dataErrorsFatal) {
        Bundle params = wv.a((ShareContent) videoContent, dataErrorsFatal);
        we.a(params, "TITLE", videoContent.b());
        we.a(params, "DESCRIPTION", videoContent.a());
        we.a(params, "VIDEO", videoUrl);
        return params;
    }

    private static Bundle a(ShareMediaContent mediaContent, List<Bundle> mediaInfos, boolean dataErrorsFatal) {
        Bundle params = wv.a((ShareContent) mediaContent, dataErrorsFatal);
        params.putParcelableArrayList("MEDIA", new ArrayList(mediaInfos));
        return params;
    }

    private static Bundle a(ShareOpenGraphContent openGraphContent, JSONObject openGraphActionJSON, boolean dataErrorsFatal) {
        Bundle params = wv.a((ShareContent) openGraphContent, dataErrorsFatal);
        we.a(params, "PREVIEW_PROPERTY_NAME", wz.a(openGraphContent.b()).second);
        we.a(params, "ACTION_TYPE", openGraphContent.a().a());
        we.a(params, "ACTION", openGraphActionJSON.toString());
        return params;
    }

    private static Bundle a(ShareContent content, boolean dataErrorsFatal) {
        Bundle params = new Bundle();
        we.a(params, "LINK", content.h());
        we.a(params, "PLACE", content.j());
        we.a(params, "REF", content.k());
        params.putBoolean("DATA_FAILURES_FATAL", dataErrorsFatal);
        Collection peopleIds = content.i();
        if (!we.a(peopleIds)) {
            params.putStringArrayList("FRIENDS", new ArrayList(peopleIds));
        }
        ShareHashtag shareHashtag = content.l();
        if (shareHashtag != null) {
            we.a(params, "HASHTAG", shareHashtag.a());
        }
        return params;
    }
}
