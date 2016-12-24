package defpackage;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jo$14 implements jo$c {
    jo$14() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (VERSION.SDK_INT >= 21) {
            view.setElevation((float) jn.a(value, view.getResources().getDisplayMetrics()));
        }
    }
}
