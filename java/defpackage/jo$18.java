package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jo$18 implements jo$c {
    jo$18() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(jo.b(view, value));
        }
    }
}
