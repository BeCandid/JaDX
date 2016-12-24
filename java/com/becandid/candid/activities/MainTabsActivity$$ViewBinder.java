package com.becandid.candid.activities;

import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.MainTabViewPager;

public class MainTabsActivity$$ViewBinder<T extends MainTabsActivity> implements ViewBinder<T> {

    /* compiled from: MainTabsActivity$$ViewBinder */
    public static class InnerUnbinder<T extends MainTabsActivity> implements Unbinder {
        private T a;

        protected InnerUnbinder(T target) {
            this.a = target;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            unbind(this.a);
            this.a = null;
        }

        protected void unbind(T target) {
            target.mViewPager = null;
            target.mBottomTabs = null;
            target.mCreatePostBtn = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.mViewPager = (MainTabViewPager) finder.castView((View) finder.findRequiredView(source, 2131624209, "field 'mViewPager'"), 2131624209, "field 'mViewPager'");
        target.mBottomTabs = (TabLayout) finder.castView((View) finder.findRequiredView(source, 2131624194, "field 'mBottomTabs'"), 2131624194, "field 'mBottomTabs'");
        target.mCreatePostBtn = (View) finder.findRequiredView(source, 2131624211, "field 'mCreatePostBtn'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
