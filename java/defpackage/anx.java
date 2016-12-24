package defpackage;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import io.fabric.sdk.android.services.common.CommonUtils;

/* compiled from: IconRequest */
public class anx {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    public anx(String hash, int iconResourceId, int width, int height) {
        this.a = hash;
        this.b = iconResourceId;
        this.c = width;
        this.d = height;
    }

    public static anx a(Context context, String iconHash) {
        if (iconHash == null) {
            return null;
        }
        try {
            int iconId = CommonUtils.l(context);
            akx.h().a("Fabric", "App icon resource ID is " + iconId);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), iconId, options);
            return new anx(iconHash, iconId, options.outWidth, options.outHeight);
        } catch (Exception e) {
            akx.h().e("Fabric", "Failed to load icon", e);
            return null;
        }
    }
}
