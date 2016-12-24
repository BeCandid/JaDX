package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jo$11 implements jo$c {
    jo$11() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (view.getTag() == null) {
            view.setTag(value);
        }
    }
}
