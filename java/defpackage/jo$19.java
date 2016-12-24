package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jo$19 implements jo$c {
    jo$19() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (view instanceof TextView) {
            int typeFace = 0;
            if (value.contains("bold")) {
                typeFace = 0 | 1;
            } else if (value.contains("italic")) {
                typeFace = 0 | 2;
            }
            ((TextView) view).setTypeface(null, typeFace);
        }
    }
}
