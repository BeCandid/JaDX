package defpackage;

import android.view.MenuItem;

/* compiled from: MenuItemCompatIcs */
class el {
    public static boolean a(MenuItem item) {
        return item.expandActionView();
    }

    public static boolean b(MenuItem item) {
        return item.isActionViewExpanded();
    }

    public static MenuItem a(MenuItem item, el$b listener) {
        return item.setOnActionExpandListener(new el$a(listener));
    }
}
