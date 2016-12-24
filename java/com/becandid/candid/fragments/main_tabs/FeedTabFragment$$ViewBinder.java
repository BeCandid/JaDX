package com.becandid.candid.fragments.main_tabs;

import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.TabViewPager;

public class FeedTabFragment$$ViewBinder<T extends FeedTabFragment> implements ViewBinder<T> {

    /* compiled from: FeedTabFragment$$ViewBinder */
    public static class a<T extends FeedTabFragment> implements Unbinder {
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
            target.mFeedTabs = null;
            target.mNewPostsText = null;
            target.viewPager = null;
            target.mFeedTab = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (FeedTabFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.mFeedTabs = (TabLayout) finder.castView((View) finder.findRequiredView(source, 2131624422, "field 'mFeedTabs'"), 2131624422, "field 'mFeedTabs'");
        target.mNewPostsText = (View) finder.findRequiredView(source, 2131624424, "field 'mNewPostsText'");
        target.viewPager = (TabViewPager) finder.castView((View) finder.findRequiredView(source, 2131624423, "field 'viewPager'"), 2131624423, "field 'viewPager'");
        target.mFeedTab = (View) finder.findRequiredView(source, 2131624421, "field 'mFeedTab'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
