package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class LinkSearchViewholder$$ViewBinder<T extends LinkSearchViewholder> implements ViewBinder<T> {

    /* compiled from: LinkSearchViewholder$$ViewBinder */
    public static class a<T extends LinkSearchViewholder> implements Unbinder {
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
            target.linkImage = null;
            target.linkDesc = null;
            target.linkTitle = null;
            target.linkHost = null;
            target.linkSearchResultIcon = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (LinkSearchViewholder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.linkImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624515, "field 'linkImage'"), 2131624515, "field 'linkImage'");
        target.linkDesc = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624518, "field 'linkDesc'"), 2131624518, "field 'linkDesc'");
        target.linkTitle = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624517, "field 'linkTitle'"), 2131624517, "field 'linkTitle'");
        target.linkHost = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624519, "field 'linkHost'"), 2131624519, "field 'linkHost'");
        target.linkSearchResultIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624516, "field 'linkSearchResultIcon'"), 2131624516, "field 'linkSearchResultIcon'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
