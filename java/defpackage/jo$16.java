package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jo$16 implements jo$c {
    jo$16() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (view instanceof TextView) {
            ((TextView) view).setText(value);
        }
    }
}
