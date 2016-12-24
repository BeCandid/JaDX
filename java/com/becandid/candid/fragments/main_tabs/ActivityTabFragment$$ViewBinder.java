package com.becandid.candid.fragments.main_tabs;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class ActivityTabFragment$$ViewBinder<T extends ActivityTabFragment> implements ViewBinder<T> {

    /* compiled from: ActivityTabFragment$$ViewBinder */
    public static class a<T extends ActivityTabFragment> implements Unbinder {
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
            target.mSwipeRefresh = null;
            target.mRecyclerView = null;
            target.mEmptyView = null;
            target.mSettingView = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (ActivityTabFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.mSwipeRefresh = (SwipeRefreshLayout) finder.castView((View) finder.findRequiredView(source, 2131624296, "field 'mSwipeRefresh'"), 2131624296, "field 'mSwipeRefresh'");
        target.mRecyclerView = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624297, "field 'mRecyclerView'"), 2131624297, "field 'mRecyclerView'");
        target.mEmptyView = (View) finder.findRequiredView(source, 2131624298, "field 'mEmptyView'");
        target.mSettingView = (View) finder.findRequiredView(source, 2131624295, "field 'mSettingView'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
