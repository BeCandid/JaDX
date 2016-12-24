package defpackage;

import android.view.MenuItem;

/* compiled from: MenuItemCompat */
class ej$c extends ej$b {
    ej$c() {
    }

    public boolean b(MenuItem item) {
        return el.a(item);
    }

    public boolean c(MenuItem item) {
        return el.b(item);
    }

    public MenuItem a(MenuItem item, ej$e listener) {
        if (listener == null) {
            return el.a(item, null);
        }
        return el.a(item, new ej$c$1(this, listener));
    }
}
