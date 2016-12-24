package defpackage;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

/* compiled from: MenuItemCompatIcs */
class el$a implements OnActionExpandListener {
    private el$b a;

    public el$a(el$b wrapped) {
        this.a = wrapped;
    }

    public boolean onMenuItemActionExpand(MenuItem item) {
        return this.a.a(item);
    }

    public boolean onMenuItemActionCollapse(MenuItem item) {
        return this.a.b(item);
    }
}
