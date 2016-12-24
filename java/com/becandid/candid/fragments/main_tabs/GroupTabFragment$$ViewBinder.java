package com.becandid.candid.fragments.main_tabs;

import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.GroupStackView;

public class GroupTabFragment$$ViewBinder<T extends GroupTabFragment> implements ViewBinder<T> {

    /* compiled from: GroupTabFragment$$ViewBinder */
    public static class a<T extends GroupTabFragment> implements Unbinder {
        private T a;

        protected a(T target) {
            this.a = target;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            a(this.a);
            this.a = null;
        }

        protected void a(T target) {
            target.groupStackView = null;
            target.tabBar = null;
            target.loading = null;
            target.forYouEmpty = null;
            target.discoverEmpty = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (GroupTabFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.groupStackView = (GroupStackView) finder.castView((View) finder.findRequiredView(source, 2131624514, "field 'groupStackView'"), 2131624514, "field 'groupStackView'");
        target.tabBar = (TabLayout) finder.castView((View) finder.findRequiredView(source, 2131624507, "field 'tabBar'"), 2131624507, "field 'tabBar'");
        target.loading = (View) finder.findOptionalView(source, 2131624513, null);
        target.forYouEmpty = (View) finder.findOptionalView(source, 2131624508, null);
        target.discoverEmpty = (View) finder.findOptionalView(source, 2131624512, null);
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
