package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import java.util.HashMap;

/* compiled from: FontFactory */
public class ih {
    private static volatile ih a;
    private Context b;
    private HashMap<String, Typeface> c = new HashMap();

    private ih(Context context) {
        this.b = context;
    }

    public static ih a(Context context) {
        if (a == null) {
            synchronized (ih.class) {
                if (a == null) {
                    a = new ih(context);
                }
            }
        }
        return a;
    }

    public Typeface a(String font) {
        Typeface typeface = (Typeface) this.c.get(font);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(this.b.getAssets(), "fonts/" + font);
                this.c.put(font, typeface);
            } catch (Exception e) {
                Log.e("FontFactory", "Could not get typeface: " + e.getMessage() + " with name: " + font);
                return null;
            }
        }
        return typeface;
    }
}
