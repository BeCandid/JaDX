package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import defpackage.uj;
import defpackage.uk;
import defpackage.uu$h;
import defpackage.vf;
import defpackage.vj;
import defpackage.vk;
import defpackage.vk$a;
import defpackage.vl;
import defpackage.vl$a;
import defpackage.vq;
import defpackage.we;
import defpackage.wq;
import defpackage.wq$a;
import defpackage.wr;
import defpackage.wv;
import defpackage.wy;
import defpackage.wz;
import defpackage.xa;
import java.util.ArrayList;
import java.util.List;

public final class ShareDialog extends vl<ShareContent, wq$a> implements wq {
    private static final int b = RequestCodeOffset.Share.a();
    private boolean c;
    private boolean d;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Mode.values().length];

        static {
            try {
                a[Mode.AUTOMATIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Mode.WEB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Mode.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    class a extends vl$a {
        final /* synthetic */ ShareDialog b;

        private a(ShareDialog shareDialog) {
            this.b = shareDialog;
            super(shareDialog);
        }

        public Object a() {
            return Mode.FEED;
        }

        public boolean a(ShareContent content, boolean isBestEffort) {
            return (content instanceof ShareLinkContent) || (content instanceof ShareFeedContent);
        }

        public vf a(ShareContent content) {
            Bundle params;
            this.b.a(this.b.b(), content, Mode.FEED);
            vf appCall = this.b.d();
            if (content instanceof ShareLinkContent) {
                ShareLinkContent linkContent = (ShareLinkContent) content;
                wy.c(linkContent);
                params = xa.b(linkContent);
            } else {
                params = xa.a((ShareFeedContent) content);
            }
            vk.a(appCall, "feed", params);
            return appCall;
        }
    }

    class b extends vl$a {
        final /* synthetic */ ShareDialog b;

        private b(ShareDialog shareDialog) {
            this.b = shareDialog;
            super(shareDialog);
        }

        public Object a() {
            return Mode.NATIVE;
        }

        public boolean a(ShareContent content, boolean isBestEffort) {
            if (content == null) {
                return false;
            }
            boolean canShowResult = true;
            if (!isBestEffort) {
                if (content.l() != null) {
                    canShowResult = vk.a(ShareDialogFeature.HASHTAG);
                }
                if ((content instanceof ShareLinkContent) && !we.a(((ShareLinkContent) content).d())) {
                    canShowResult &= vk.a(ShareDialogFeature.LINK_SHARE_QUOTES);
                }
            }
            boolean z = canShowResult && ShareDialog.e(content.getClass());
            return z;
        }

        public vf a(final ShareContent content) {
            this.b.a(this.b.b(), content, Mode.NATIVE);
            wy.b(content);
            final vf appCall = this.b.d();
            final boolean shouldFailOnDataError = this.b.e();
            vk.a(appCall, new vk$a(this) {
                final /* synthetic */ b d;

                public Bundle a() {
                    return wv.a(appCall.c(), content, shouldFailOnDataError);
                }

                public Bundle b() {
                    return wr.a(appCall.c(), content, shouldFailOnDataError);
                }
            }, ShareDialog.g(content.getClass()));
            return appCall;
        }
    }

    class c extends vl$a {
        final /* synthetic */ ShareDialog b;

        private c(ShareDialog shareDialog) {
            this.b = shareDialog;
            super(shareDialog);
        }

        public Object a() {
            return Mode.WEB;
        }

        public boolean a(ShareContent content, boolean isBestEffort) {
            return content != null && ShareDialog.f(content.getClass());
        }

        public vf a(ShareContent content) {
            Bundle params;
            this.b.a(this.b.b(), content, Mode.WEB);
            vf appCall = this.b.d();
            wy.c(content);
            if (content instanceof ShareLinkContent) {
                params = xa.a((ShareLinkContent) content);
            } else {
                params = xa.a((ShareOpenGraphContent) content);
            }
            vk.a(appCall, b(content), params);
            return appCall;
        }

        private String b(ShareContent shareContent) {
            if (shareContent instanceof ShareLinkContent) {
                return "share";
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                return "share_open_graph";
            }
            return null;
        }
    }

    public static boolean a(Class<? extends ShareContent> contentType) {
        return f(contentType) || e(contentType);
    }

    private static boolean e(Class<? extends ShareContent> contentType) {
        vj feature = g(contentType);
        return feature != null && vk.a(feature);
    }

    private static boolean f(Class<? extends ShareContent> contentType) {
        return ShareLinkContent.class.isAssignableFrom(contentType) || ShareOpenGraphContent.class.isAssignableFrom(contentType);
    }

    public ShareDialog(Activity activity) {
        super(activity, b);
        this.c = false;
        this.d = true;
        wz.a(b);
    }

    ShareDialog(Activity activity, int requestCode) {
        super(activity, requestCode);
        this.c = false;
        this.d = true;
        wz.a(requestCode);
    }

    ShareDialog(Fragment fragment, int requestCode) {
        this(new vq(fragment), requestCode);
    }

    ShareDialog(android.app.Fragment fragment, int requestCode) {
        this(new vq(fragment), requestCode);
    }

    private ShareDialog(vq fragmentWrapper, int requestCode) {
        super(fragmentWrapper, requestCode);
        this.c = false;
        this.d = true;
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
        handlers.add(new b());
        handlers.add(new a());
        handlers.add(new c());
        return handlers;
    }

    private static vj g(Class<? extends ShareContent> contentType) {
        if (ShareLinkContent.class.isAssignableFrom(contentType)) {
            return ShareDialogFeature.SHARE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(contentType)) {
            return ShareDialogFeature.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(contentType)) {
            return ShareDialogFeature.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(contentType)) {
            return OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
        }
        if (ShareMediaContent.class.isAssignableFrom(contentType)) {
            return ShareDialogFeature.MULTIMEDIA;
        }
        return null;
    }

    private void a(Context context, ShareContent content, Mode mode) {
        String displayType;
        String contentType;
        if (this.d) {
            mode = Mode.AUTOMATIC;
        }
        switch (AnonymousClass1.a[mode.ordinal()]) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                displayType = "automatic";
                break;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                displayType = "web";
                break;
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                displayType = "native";
                break;
            default:
                displayType = "unknown";
                break;
        }
        vj dialogFeature = g(content.getClass());
        if (dialogFeature == ShareDialogFeature.SHARE_DIALOG) {
            contentType = "status";
        } else if (dialogFeature == ShareDialogFeature.PHOTOS) {
            contentType = "photo";
        } else if (dialogFeature == ShareDialogFeature.VIDEO) {
            contentType = "video";
        } else if (dialogFeature == OpenGraphActionDialogFeature.OG_ACTION_DIALOG) {
            contentType = "open_graph";
        } else {
            contentType = "unknown";
        }
        AppEventsLogger logger = AppEventsLogger.a(context);
        Bundle parameters = new Bundle();
        parameters.putString("fb_share_dialog_show", displayType);
        parameters.putString("fb_share_dialog_content_type", contentType);
        logger.a("fb_share_dialog_show", null, parameters);
    }
}
