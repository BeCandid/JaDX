package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jo$6 implements jo$c {
    jo$6() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> attrs) {
        if (view instanceof ImageView) {
            String imageName = value;
            if (imageName.startsWith("//")) {
                imageName = "http:" + imageName;
            }
            if (imageName.startsWith("http")) {
                if (jo.e == null) {
                    return;
                }
                if (attrs.containsKey("cornerRadius")) {
                    jo.e.a((ImageView) view, imageName, jn.a((String) attrs.get("cornerRadius"), view.getResources().getDisplayMetrics()));
                    return;
                }
                jo.e.a((ImageView) view, imageName);
            } else if (imageName.startsWith("@drawable/")) {
                ((ImageView) view).setImageDrawable(jo.c(view, imageName.substring("@drawable/".length())));
            } else if (imageName.startsWith("@mipmap/")) {
                ((ImageView) view).setImageDrawable(jo.d(view, imageName.substring("@mipmap/".length())));
            }
        }
    }
}
