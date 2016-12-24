package com.becandid.candid.fragments.onboarding;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class OnboardingLocationFragment$$ViewBinder<T extends OnboardingLocationFragment> implements ViewBinder<T> {

    /* compiled from: OnboardingLocationFragment$$ViewBinder */
    public static class a<T extends OnboardingLocationFragment> implements Unbinder {
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
            target.privacy = null;
            target.skip = null;
            target.locationButton = null;
            target.spinny = null;
            target.locationSubheader = null;
            target.locationInfo = null;
            target.locationHeader = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (OnboardingLocationFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.privacy = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624676, "field 'privacy'"), 2131624676, "field 'privacy'");
        target.skip = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624670, "field 'skip'"), 2131624670, "field 'skip'");
        target.locationButton = (Button) finder.castView((View) finder.findRequiredView(source, 2131624674, "field 'locationButton'"), 2131624674, "field 'locationButton'");
        target.spinny = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624677, "field 'spinny'"), 2131624677, "field 'spinny'");
        target.locationSubheader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624672, "field 'locationSubheader'"), 2131624672, "field 'locationSubheader'");
        target.locationInfo = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624675, "field 'locationInfo'"), 2131624675, "field 'locationInfo'");
        target.locationHeader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624671, "field 'locationHeader'"), 2131624671, "field 'locationHeader'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
