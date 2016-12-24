package com.becandid.candid.fragments.main_tabs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.TabViewPager;

public class MeTabFragment$$ViewBinder<T extends MeTabFragment> implements ViewBinder<T> {

    /* compiled from: MeTabFragment$$ViewBinder */
    public static class a<T extends MeTabFragment> implements Unbinder {
        View a;
        View b;
        private T c;

        protected a(T target) {
            this.c = target;
        }

        public final void unbind() {
            if (this.c == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            a(this.c);
            this.c = null;
        }

        protected void a(T target) {
            target.mPostsCount = null;
            target.mGroupsCount = null;
            target.mNumContacts = null;
            target.mNumFriends = null;
            this.a.setOnClickListener(null);
            target.connectFb = null;
            this.b.setOnClickListener(null);
            target.connectContact = null;
            target.mBadgeIcon = null;
            target.mBadgeTitle = null;
            target.buttonPanel = null;
            target.mBadgeInfoContainer = null;
            target.mProfileContainer = null;
            target.viewPager = null;
            target.mQualityScore = null;
            target.mProfileSpinny = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (MeTabFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, final T target, Object source) {
        a unbinder = a(target);
        target.mPostsCount = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624817, "field 'mPostsCount'"), 2131624817, "field 'mPostsCount'");
        target.mGroupsCount = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624818, "field 'mGroupsCount'"), 2131624818, "field 'mGroupsCount'");
        target.mNumContacts = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624816, "field 'mNumContacts'"), 2131624816, "field 'mNumContacts'");
        target.mNumFriends = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624815, "field 'mNumFriends'"), 2131624815, "field 'mNumFriends'");
        View view = (View) finder.findRequiredView(source, 2131624821, "field 'connectFb' and method 'connectFB'");
        target.connectFb = view;
        unbinder.a = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ MeTabFragment$$ViewBinder b;

            public void doClick(View p0) {
                target.connectFB(p0);
            }
        });
        view = (View) finder.findRequiredView(source, 2131624820, "field 'connectContact' and method 'connectContacts'");
        target.connectContact = view;
        unbinder.b = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ MeTabFragment$$ViewBinder b;

            public void doClick(View p0) {
                target.connectContacts(p0);
            }
        });
        target.mBadgeIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624079, "field 'mBadgeIcon'"), 2131624079, "field 'mBadgeIcon'");
        target.mBadgeTitle = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624076, "field 'mBadgeTitle'"), 2131624076, "field 'mBadgeTitle'");
        target.buttonPanel = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624819, "field 'buttonPanel'"), 2131624819, "field 'buttonPanel'");
        target.mBadgeInfoContainer = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624287, "field 'mBadgeInfoContainer'"), 2131624287, "field 'mBadgeInfoContainer'");
        target.mProfileContainer = (View) finder.findRequiredView(source, 2131624809, "field 'mProfileContainer'");
        target.viewPager = (TabViewPager) finder.castView((View) finder.findRequiredView(source, 2131624823, "field 'viewPager'"), 2131624823, "field 'viewPager'");
        target.mQualityScore = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624813, "field 'mQualityScore'"), 2131624813, "field 'mQualityScore'");
        target.mProfileSpinny = (View) finder.findRequiredView(source, 2131624824, "field 'mProfileSpinny'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
