package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class MessagePostViewHolder$$ViewBinder<T extends MessagePostViewHolder> implements ViewBinder<T> {

    /* compiled from: MessagePostViewHolder$$ViewBinder */
    public static class a<T extends MessagePostViewHolder> implements Unbinder {
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
            target.messagePostDeleted = null;
            target.messagePostWrapper = null;
            target.mPostCaption = null;
            target.mPostImage = null;
            target.mPostRow = null;
            target.mHeader = null;
            target.mPostPopupAction = null;
            target.mPostHeaderBadge = null;
            target.mPostHeaderBadgeText = null;
            target.mPostHeaderBadgeScore = null;
            target.mPostHeaderBadgeDot = null;
            target.mPostAuthor = null;
            target.mPostIcon = null;
            target.mPostModIcon = null;
            target.mPostGroup = null;
            target.mPostGroupContainer = null;
            target.mPostGroupMenu = null;
            target.mPostGroupMenuContainer = null;
            target.mPostTimestamp = null;
            target.mPostLinkPlacehoder = null;
            target.mPostLinkTitle = null;
            target.mPostLinkImage = null;
            target.mPostLinkDesc = null;
            target.mPostLinkDomain = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (MessagePostViewHolder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.messagePostDeleted = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624399, "field 'messagePostDeleted'"), 2131624399, "field 'messagePostDeleted'");
        target.messagePostWrapper = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624390, "field 'messagePostWrapper'"), 2131624390, "field 'messagePostWrapper'");
        target.mPostCaption = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624392, "field 'mPostCaption'"), 2131624392, "field 'mPostCaption'");
        target.mPostImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624393, "field 'mPostImage'"), 2131624393, "field 'mPostImage'");
        target.mPostRow = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624391, "field 'mPostRow'"), 2131624391, "field 'mPostRow'");
        target.mHeader = (View) finder.findRequiredView(source, 2131624264, "field 'mHeader'");
        target.mPostPopupAction = (View) finder.findRequiredView(source, 2131624768, "field 'mPostPopupAction'");
        target.mPostHeaderBadge = (View) finder.findRequiredView(source, 2131624770, "field 'mPostHeaderBadge'");
        target.mPostHeaderBadgeText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624771, "field 'mPostHeaderBadgeText'"), 2131624771, "field 'mPostHeaderBadgeText'");
        target.mPostHeaderBadgeScore = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624773, "field 'mPostHeaderBadgeScore'"), 2131624773, "field 'mPostHeaderBadgeScore'");
        target.mPostHeaderBadgeDot = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624772, "field 'mPostHeaderBadgeDot'"), 2131624772, "field 'mPostHeaderBadgeDot'");
        target.mPostAuthor = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624769, "field 'mPostAuthor'"), 2131624769, "field 'mPostAuthor'");
        target.mPostIcon = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624766, "field 'mPostIcon'"), 2131624766, "field 'mPostIcon'");
        target.mPostModIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624767, "field 'mPostModIcon'"), 2131624767, "field 'mPostModIcon'");
        target.mPostGroup = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624779, "field 'mPostGroup'"), 2131624779, "field 'mPostGroup'");
        target.mPostGroupContainer = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624776, "field 'mPostGroupContainer'"), 2131624776, "field 'mPostGroupContainer'");
        target.mPostGroupMenu = (View) finder.findRequiredView(source, 2131624778, "field 'mPostGroupMenu'");
        target.mPostGroupMenuContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624777, "field 'mPostGroupMenuContainer'"), 2131624777, "field 'mPostGroupMenuContainer'");
        target.mPostTimestamp = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624774, "field 'mPostTimestamp'"), 2131624774, "field 'mPostTimestamp'");
        target.mPostLinkPlacehoder = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624394, "field 'mPostLinkPlacehoder'"), 2131624394, "field 'mPostLinkPlacehoder'");
        target.mPostLinkTitle = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624396, "field 'mPostLinkTitle'"), 2131624396, "field 'mPostLinkTitle'");
        target.mPostLinkImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624395, "field 'mPostLinkImage'"), 2131624395, "field 'mPostLinkImage'");
        target.mPostLinkDesc = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624397, "field 'mPostLinkDesc'"), 2131624397, "field 'mPostLinkDesc'");
        target.mPostLinkDomain = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624398, "field 'mPostLinkDomain'"), 2131624398, "field 'mPostLinkDomain'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
