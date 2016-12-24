package com.becandid.candid.fragments.main_tabs;

import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.TabViewPager;

public class MessageTabFragment$$ViewBinder<T extends MessageTabFragment> implements ViewBinder<T> {

    /* compiled from: MessageTabFragment$$ViewBinder */
    public static class a<T extends MessageTabFragment> implements Unbinder {
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
            target.messagesSearch = null;
            target.messagesSettings = null;
            target.tabBar = null;
            target.viewPager = null;
            target.messagesSpinny = null;
            target.messagingDisabled = null;
            target.messagesContainer = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (MessageTabFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.messagesSearch = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624558, "field 'messagesSearch'"), 2131624558, "field 'messagesSearch'");
        target.messagesSettings = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624559, "field 'messagesSettings'"), 2131624559, "field 'messagesSettings'");
        target.tabBar = (TabLayout) finder.castView((View) finder.findRequiredView(source, 2131624560, "field 'tabBar'"), 2131624560, "field 'tabBar'");
        target.viewPager = (TabViewPager) finder.castView((View) finder.findRequiredView(source, 2131624561, "field 'viewPager'"), 2131624561, "field 'viewPager'");
        target.messagesSpinny = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624563, "field 'messagesSpinny'"), 2131624563, "field 'messagesSpinny'");
        target.messagingDisabled = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624562, "field 'messagingDisabled'"), 2131624562, "field 'messagingDisabled'");
        target.messagesContainer = (View) finder.findRequiredView(source, 2131624557, "field 'messagesContainer'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
