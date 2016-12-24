package com.becandid.candid.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class RelatedPostsFeedActivity$$ViewBinder<T extends RelatedPostsFeedActivity> implements ViewBinder<T> {

    /* compiled from: RelatedPostsFeedActivity$$ViewBinder */
    public static class InnerUnbinder<T extends RelatedPostsFeedActivity> implements Unbinder {
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
            target.feedRecycler = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.feedRecycler = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624284, "field 'feedRecycler'"), 2131624284, "field 'feedRecycler'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
