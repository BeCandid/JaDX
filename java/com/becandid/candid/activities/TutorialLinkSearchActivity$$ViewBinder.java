package com.becandid.candid.activities;

import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class TutorialLinkSearchActivity$$ViewBinder<T extends TutorialLinkSearchActivity> implements ViewBinder<T> {

    /* compiled from: TutorialLinkSearchActivity$$ViewBinder */
    public static class InnerUnbinder<T extends TutorialLinkSearchActivity> implements Unbinder {
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
            target.mContinue = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.mContinue = (Button) finder.castView((View) finder.findRequiredView(source, 2131624301, "field 'mContinue'"), 2131624301, "field 'mContinue'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
