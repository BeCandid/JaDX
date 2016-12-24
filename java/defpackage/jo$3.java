package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jo$3 implements jo$c {
    jo$3() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (view instanceof EditText) {
            ((EditText) view).setHint(value);
        }
    }
}
