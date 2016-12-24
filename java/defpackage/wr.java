package defpackage;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LegacyNativeDialogParameters */
public class wr {
    public static Bundle a(UUID callId, ShareContent shareContent, boolean shouldFailOnDataError) {
        wf.a((Object) shareContent, "shareContent");
        wf.a((Object) callId, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return wr.a((ShareLinkContent) shareContent, shouldFailOnDataError);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent photoContent = (SharePhotoContent) shareContent;
            return wr.a(photoContent, wz.a(photoContent, callId), shouldFailOnDataError);
        } else if (shareContent instanceof ShareVideoContent) {
            return wr.a((ShareVideoContent) shareContent, shouldFailOnDataError);
        } else {
            if (!(shareContent instanceof ShareOpenGraphContent)) {
                return null;
            }
            ShareOpenGraphContent openGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return wr.a(openGraphContent, wz.a(callId, openGraphContent), shouldFailOnDataError);
            } catch (JSONException e) {
                throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e.getMessage());
            }
        }
    }

    private static Bundle a(ShareLinkContent linkContent, boolean dataErrorsFatal) {
        Bundle params = wr.a((ShareContent) linkContent, dataErrorsFatal);
        we.a(params, "com.facebook.platform.extra.TITLE", linkContent.b());
        we.a(params, "com.facebook.platform.extra.DESCRIPTION", linkContent.a());
        we.a(params, "com.facebook.platform.extra.IMAGE", linkContent.c());
        return params;
    }

    private static Bundle a(SharePhotoContent photoContent, List<String> imageUrls, boolean dataErrorsFatal) {
        Bundle params = wr.a((ShareContent) photoContent, dataErrorsFatal);
        params.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList(imageUrls));
        return params;
    }

    private static Bundle a(ShareVideoContent videoContent, boolean dataErrorsFatal) {
        return null;
    }

    private static Bundle a(ShareOpenGraphContent openGraphContent, JSONObject openGraphActionJSON, boolean dataErrorsFatal) {
        Bundle params = wr.a((ShareContent) openGraphContent, dataErrorsFatal);
        we.a(params, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", openGraphContent.b());
        we.a(params, "com.facebook.platform.extra.ACTION_TYPE", openGraphContent.a().a());
        we.a(params, "com.facebook.platform.extra.ACTION", openGraphActionJSON.toString());
        return params;
    }

    private static Bundle a(ShareContent content, boolean dataErrorsFatal) {
        Bundle params = new Bundle();
        we.a(params, "com.facebook.platform.extra.LINK", content.h());
        we.a(params, "com.facebook.platform.extra.PLACE", content.j());
        we.a(params, "com.facebook.platform.extra.REF", content.k());
        params.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", dataErrorsFatal);
        Collection peopleIds = content.i();
        if (!we.a(peopleIds)) {
            params.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(peopleIds));
        }
        return params;
    }
}
