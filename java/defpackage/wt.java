package defpackage;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.internal.LikeDialogFeature;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LikeDialog */
public class wt extends vl<LikeContent, wt$b> {
    private static final int b = RequestCodeOffset.Like.a();

    public static boolean e() {
        return vk.a(wt.h());
    }

    public static boolean f() {
        return vk.b(wt.h());
    }

    public wt(Activity activity) {
        super(activity, b);
    }

    public wt(vq fragmentWrapper) {
        super(fragmentWrapper, b);
    }

    protected vf d() {
        return new vf(a());
    }

    protected List<vl$a> c() {
        ArrayList<vl$a> handlers = new ArrayList();
        handlers.add(new wt$a(this, null));
        handlers.add(new wt$c(this, null));
        return handlers;
    }

    protected void a(CallbackManagerImpl callbackManager, uk<wt$b> callback) {
        callbackManager.b(a(), new wt$2(this, callback == null ? null : new wt$1(this, callback, callback)));
    }

    private static vj h() {
        return LikeDialogFeature.LIKE_DIALOG;
    }

    private static Bundle b(LikeContent likeContent) {
        Bundle params = new Bundle();
        params.putString("object_id", likeContent.a());
        params.putString("object_type", likeContent.b());
        return params;
    }
}
