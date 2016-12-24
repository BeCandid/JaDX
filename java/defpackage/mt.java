package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.util.Log;

/* compiled from: ResourceLoader */
public class mt<T> implements mr<Integer, T> {
    private final mr<Uri, T> a;
    private final Resources b;

    public mt(Context context, mr<Uri, T> uriLoader) {
        this(context.getResources(), (mr) uriLoader);
    }

    public mt(Resources resources, mr<Uri, T> uriLoader) {
        this.b = resources;
        this.a = uriLoader;
    }

    public ku<T> a(Integer model, int width, int height) {
        Uri uri = null;
        try {
            uri = Uri.parse("android.resource://" + this.b.getResourcePackageName(model.intValue()) + '/' + this.b.getResourceTypeName(model.intValue()) + '/' + this.b.getResourceEntryName(model.intValue()));
        } catch (NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + model, e);
            }
        }
        if (uri != null) {
            return this.a.a(uri, width, height);
        }
        return null;
    }
}
