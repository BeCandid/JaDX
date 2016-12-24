package defpackage;

import android.view.MenuItem;

/* compiled from: MenuItemCompat */
class ej$c$1 implements el$b {
    final /* synthetic */ ej$e a;
    final /* synthetic */ ej$c b;

    ej$c$1(ej$c ej_c, ej$e ej_e) {
        this.b = ej_c;
        this.a = ej_e;
    }

    public boolean a(MenuItem item) {
        return this.a.onMenuItemActionExpand(item);
    }

    public boolean b(MenuItem item) {
        return this.a.onMenuItemActionCollapse(item);
    }
}
