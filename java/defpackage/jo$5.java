package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jo$5 implements jo$c {
    jo$5() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        int gravity = jo.c(value);
        if (view instanceof TextView) {
            ((TextView) view).setGravity(gravity);
        } else if (view instanceof LinearLayout) {
            ((LinearLayout) view).setGravity(gravity);
        } else if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).setGravity(gravity);
        }
    }
}
