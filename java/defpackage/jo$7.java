package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jo$7 implements jo$c {
    jo$7() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        int visibility = 0;
        String visValue = value.toLowerCase();
        if (visValue.equals("gone")) {
            visibility = 8;
        } else if (visValue.equals("invisible")) {
            visibility = 4;
        }
        view.setVisibility(visibility);
    }
}
