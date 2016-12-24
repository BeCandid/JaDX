package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jo$13 implements jo$c {
    jo$13() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        view.setOnClickListener(jo.b(parent, value));
    }
}
