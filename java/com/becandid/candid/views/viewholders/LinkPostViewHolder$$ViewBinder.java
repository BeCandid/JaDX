package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class LinkPostViewHolder$$ViewBinder<T extends LinkPostViewHolder> extends BasePostViewHolder$$ViewBinder<T> {

    /* compiled from: LinkPostViewHolder$$ViewBinder */
    public static class a<T extends LinkPostViewHolder> extends com.becandid.candid.views.viewholders.BasePostViewHolder$.ViewBinder.a<T> {
        protected a(T target) {
            super(target);
        }

        protected void a(T target) {
            super.a(target);
            target.mPostLinkTitle = null;
            target.mPostLinkImage = null;
            target.mPostLinkDesc = null;
            target.mPostLinkDomain = null;
            target.mPostImageRow = null;
            target.mPostCaption = null;
            target.mPostLinkPlacehoder = null;
            target.mPostLinkRow = null;
            target.mPostImageImage = null;
            target.mPostLinkTitleImage = null;
            target.mPostLinkDescImage = null;
            target.mPostLinkDomainImage = null;
            target.mPostInfoImage = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (LinkPostViewHolder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = (a) super.a(finder, target, source);
        target.mPostLinkTitle = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624396, "field 'mPostLinkTitle'"), 2131624396, "field 'mPostLinkTitle'");
        target.mPostLinkImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624395, "field 'mPostLinkImage'"), 2131624395, "field 'mPostLinkImage'");
        target.mPostLinkDesc = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624397, "field 'mPostLinkDesc'"), 2131624397, "field 'mPostLinkDesc'");
        target.mPostLinkDomain = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624398, "field 'mPostLinkDomain'"), 2131624398, "field 'mPostLinkDomain'");
        target.mPostImageRow = (View) finder.findRequiredView(source, 2131624402, "field 'mPostImageRow'");
        target.mPostCaption = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624115, "field 'mPostCaption'"), 2131624115, "field 'mPostCaption'");
        target.mPostLinkPlacehoder = (View) finder.findRequiredView(source, 2131624394, "field 'mPostLinkPlacehoder'");
        target.mPostLinkRow = (View) finder.findRequiredView(source, 2131624414, "field 'mPostLinkRow'");
        target.mPostImageImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624412, "field 'mPostImageImage'"), 2131624412, "field 'mPostImageImage'");
        target.mPostLinkTitleImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624416, "field 'mPostLinkTitleImage'"), 2131624416, "field 'mPostLinkTitleImage'");
        target.mPostLinkDescImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624417, "field 'mPostLinkDescImage'"), 2131624417, "field 'mPostLinkDescImage'");
        target.mPostLinkDomainImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624418, "field 'mPostLinkDomainImage'"), 2131624418, "field 'mPostLinkDomainImage'");
        target.mPostInfoImage = (View) finder.findRequiredView(source, 2131624415, "field 'mPostInfoImage'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
