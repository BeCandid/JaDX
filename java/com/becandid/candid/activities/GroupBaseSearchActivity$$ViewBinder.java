package com.becandid.candid.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class GroupBaseSearchActivity$$ViewBinder<T extends GroupBaseSearchActivity> implements ViewBinder<T> {

    /* compiled from: GroupBaseSearchActivity$$ViewBinder */
    public static class InnerUnbinder<T extends GroupBaseSearchActivity> implements Unbinder {
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
            target.mSearchResultRecyclerView = null;
            target.mSearchEmpty = null;
            target.mSearchProgressBar = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.mSearchResultRecyclerView = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624164, "field 'mSearchResultRecyclerView'"), 2131624164, "field 'mSearchResultRecyclerView'");
        target.mSearchEmpty = (View) finder.findRequiredView(source, 2131624165, "field 'mSearchEmpty'");
        target.mSearchProgressBar = (View) finder.findRequiredView(source, 2131624167, "field 'mSearchProgressBar'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
