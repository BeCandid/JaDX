package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jo$10 implements jo$c {
    jo$10() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        view.setClickable(value.equals("true"));
    }
}
