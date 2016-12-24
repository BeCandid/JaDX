package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import defpackage.uu$d;

public class BasePostViewHolder$$ViewBinder<T extends BasePostViewHolder> implements ViewBinder<T> {

    /* compiled from: BasePostViewHolder$$ViewBinder */
    public static class a<T extends BasePostViewHolder> implements Unbinder {
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
            target.mLikeRumorPostContainer = null;
            target.mLikeRumorPostIcon = null;
            target.mLikeRumorPostText = null;
            target.mLikeRumorPostBadge = null;
            target.mRumorTrueText = null;
            target.mUnlikeRumorPostContainer = null;
            target.mUnlikeRumorPostIcon = null;
            target.mUnlikeRumorPostText = null;
            target.mUnlikeRumorPostBadge = null;
            target.mRumorFalseText = null;
            target.mCommentPostContainer = null;
            target.mCommentPostBadge = null;
            target.mCommentPostText = null;
            target.mShareButton = null;
            target.mShareIcon = null;
            target.mMessagePostContainer = null;
            target.mPostAuthor = null;
            target.mPostIcon = null;
            target.mPostModIcon = null;
            target.mPostGroup = null;
            target.mPostGroupContainer = null;
            target.mPostGroupMenu = null;
            target.mPostGroupMenuContainer = null;
            target.mPostTimestamp = null;
            target.mFooter = null;
            target.mHeader = null;
            target.mPostPopupAction = null;
            target.mPostHeaderBadge = null;
            target.mPostHeaderBadgeText = null;
            target.mPostHeaderBadgeScore = null;
            target.mPostHeaderBadgeDot = null;
            target.reportFlag = null;
            target.mFooterCommentIcon = null;
            target.mFooterCommentModIcon = null;
            target.mFooterCommentImage = null;
            target.mFooterCommentTimestamp = null;
            target.mFooterCommentText = null;
            target.mFooterCommentSnippet = null;
            target.mFooterCommentValue = null;
            target.mPostContainer = null;
            target.mPostRelated = null;
            target.mPostRelatedBottom = null;
            target.mPostRelatedBar = null;
            target.mPostTrending = null;
            target.mPostRumorAlert = null;
            target.mPostTrendingDrawable = null;
            target.mPostTrendingText = null;
            target.mPostRumorAlertDrawable = null;
            target.mPostRumorAlertText = null;
            target.mPostCaption = null;
            target.mProgressBar = null;
            target.mPostShareOgImage = null;
            target.mPostGroupOgImage = null;
            target.mPostCaptionOgImage = null;
            target.mLikePostBtnOgImage = null;
            target.mUnlikePostBtnOgImage = null;
            target.mTrueRumorTextOgImage = null;
            target.mFalseRumorTextOgImage = null;
            target.mTrueRumorIconOgImage = null;
            target.mFalseRumorIconOgImage = null;
            target.mCommentPostBtnOgImage = null;
            target.mTrueRumorContainerOgImage = null;
            target.mFalseRumorContainerOgImage = null;
            target.mPostImageFooter = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (BasePostViewHolder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.mLikeRumorPostContainer = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624737, "field 'mLikeRumorPostContainer'"), 2131624737, "field 'mLikeRumorPostContainer'");
        target.mLikeRumorPostIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624739, "field 'mLikeRumorPostIcon'"), 2131624739, "field 'mLikeRumorPostIcon'");
        target.mLikeRumorPostText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624742, "field 'mLikeRumorPostText'"), 2131624742, "field 'mLikeRumorPostText'");
        target.mLikeRumorPostBadge = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624741, "field 'mLikeRumorPostBadge'"), 2131624741, "field 'mLikeRumorPostBadge'");
        target.mRumorTrueText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624740, "field 'mRumorTrueText'"), 2131624740, "field 'mRumorTrueText'");
        target.mUnlikeRumorPostContainer = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624743, "field 'mUnlikeRumorPostContainer'"), 2131624743, "field 'mUnlikeRumorPostContainer'");
        target.mUnlikeRumorPostIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624745, "field 'mUnlikeRumorPostIcon'"), 2131624745, "field 'mUnlikeRumorPostIcon'");
        target.mUnlikeRumorPostText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624748, "field 'mUnlikeRumorPostText'"), 2131624748, "field 'mUnlikeRumorPostText'");
        target.mUnlikeRumorPostBadge = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624747, "field 'mUnlikeRumorPostBadge'"), 2131624747, "field 'mUnlikeRumorPostBadge'");
        target.mRumorFalseText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624746, "field 'mRumorFalseText'"), 2131624746, "field 'mRumorFalseText'");
        target.mCommentPostContainer = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624749, "field 'mCommentPostContainer'"), 2131624749, "field 'mCommentPostContainer'");
        target.mCommentPostBadge = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624751, "field 'mCommentPostBadge'"), 2131624751, "field 'mCommentPostBadge'");
        target.mCommentPostText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624752, "field 'mCommentPostText'"), 2131624752, "field 'mCommentPostText'");
        target.mShareButton = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624753, "field 'mShareButton'"), 2131624753, "field 'mShareButton'");
        target.mShareIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624754, "field 'mShareIcon'"), 2131624754, "field 'mShareIcon'");
        target.mMessagePostContainer = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624755, "field 'mMessagePostContainer'"), 2131624755, "field 'mMessagePostContainer'");
        target.mPostAuthor = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624769, "field 'mPostAuthor'"), 2131624769, "field 'mPostAuthor'");
        target.mPostIcon = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624766, "field 'mPostIcon'"), 2131624766, "field 'mPostIcon'");
        target.mPostModIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624767, "field 'mPostModIcon'"), 2131624767, "field 'mPostModIcon'");
        target.mPostGroup = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624779, "field 'mPostGroup'"), 2131624779, "field 'mPostGroup'");
        target.mPostGroupContainer = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624776, "field 'mPostGroupContainer'"), 2131624776, "field 'mPostGroupContainer'");
        target.mPostGroupMenu = (View) finder.findRequiredView(source, 2131624778, "field 'mPostGroupMenu'");
        target.mPostGroupMenuContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624777, "field 'mPostGroupMenuContainer'"), 2131624777, "field 'mPostGroupMenuContainer'");
        target.mPostTimestamp = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624774, "field 'mPostTimestamp'"), 2131624774, "field 'mPostTimestamp'");
        target.mFooter = (View) finder.findRequiredView(source, 2131624267, "field 'mFooter'");
        target.mHeader = (View) finder.findRequiredView(source, 2131624264, "field 'mHeader'");
        target.mPostPopupAction = (View) finder.findRequiredView(source, 2131624768, "field 'mPostPopupAction'");
        target.mPostHeaderBadge = (View) finder.findRequiredView(source, 2131624770, "field 'mPostHeaderBadge'");
        target.mPostHeaderBadgeText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624771, "field 'mPostHeaderBadgeText'"), 2131624771, "field 'mPostHeaderBadgeText'");
        target.mPostHeaderBadgeScore = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624773, "field 'mPostHeaderBadgeScore'"), 2131624773, "field 'mPostHeaderBadgeScore'");
        target.mPostHeaderBadgeDot = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624772, "field 'mPostHeaderBadgeDot'"), 2131624772, "field 'mPostHeaderBadgeDot'");
        target.reportFlag = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624775, "field 'reportFlag'"), 2131624775, "field 'reportFlag'");
        target.mFooterCommentIcon = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624760, "field 'mFooterCommentIcon'"), 2131624760, "field 'mFooterCommentIcon'");
        target.mFooterCommentModIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624761, "field 'mFooterCommentModIcon'"), 2131624761, "field 'mFooterCommentModIcon'");
        target.mFooterCommentImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624763, "field 'mFooterCommentImage'"), 2131624763, "field 'mFooterCommentImage'");
        target.mFooterCommentTimestamp = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624762, "field 'mFooterCommentTimestamp'"), 2131624762, "field 'mFooterCommentTimestamp'");
        target.mFooterCommentText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624764, "field 'mFooterCommentText'"), 2131624764, "field 'mFooterCommentText'");
        target.mFooterCommentSnippet = (View) finder.findRequiredView(source, 2131624757, "field 'mFooterCommentSnippet'");
        target.mFooterCommentValue = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624758, "field 'mFooterCommentValue'"), 2131624758, "field 'mFooterCommentValue'");
        target.mPostContainer = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624401, "field 'mPostContainer'"), 2131624401, "field 'mPostContainer'");
        target.mPostRelated = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624797, "field 'mPostRelated'"), 2131624797, "field 'mPostRelated'");
        target.mPostRelatedBottom = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624800, "field 'mPostRelatedBottom'"), 2131624800, "field 'mPostRelatedBottom'");
        target.mPostRelatedBar = (View) finder.findRequiredView(source, 2131624400, "field 'mPostRelatedBar'");
        target.mPostTrending = (View) finder.findRequiredView(source, 2131624804, "field 'mPostTrending'");
        target.mPostRumorAlert = (View) finder.findRequiredView(source, 2131624801, "field 'mPostRumorAlert'");
        target.mPostTrendingDrawable = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624805, "field 'mPostTrendingDrawable'"), 2131624805, "field 'mPostTrendingDrawable'");
        target.mPostTrendingText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624806, "field 'mPostTrendingText'"), 2131624806, "field 'mPostTrendingText'");
        target.mPostRumorAlertDrawable = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624802, "field 'mPostRumorAlertDrawable'"), 2131624802, "field 'mPostRumorAlertDrawable'");
        target.mPostRumorAlertText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624803, "field 'mPostRumorAlertText'"), 2131624803, "field 'mPostRumorAlertText'");
        target.mPostCaption = (TextView) finder.castView((View) finder.findOptionalView(source, 2131624115, null), 2131624115, "field 'mPostCaption'");
        target.mProgressBar = (ProgressBar) finder.castView((View) finder.findRequiredView(source, uu$d.progress_bar, "field 'mProgressBar'"), uu$d.progress_bar, "field 'mProgressBar'");
        target.mPostShareOgImage = (View) finder.findRequiredView(source, 2131624408, "field 'mPostShareOgImage'");
        target.mPostGroupOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624795, "field 'mPostGroupOgImage'"), 2131624795, "field 'mPostGroupOgImage'");
        target.mPostCaptionOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624411, "field 'mPostCaptionOgImage'"), 2131624411, "field 'mPostCaptionOgImage'");
        target.mLikePostBtnOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624783, "field 'mLikePostBtnOgImage'"), 2131624783, "field 'mLikePostBtnOgImage'");
        target.mUnlikePostBtnOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624788, "field 'mUnlikePostBtnOgImage'"), 2131624788, "field 'mUnlikePostBtnOgImage'");
        target.mTrueRumorTextOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624786, "field 'mTrueRumorTextOgImage'"), 2131624786, "field 'mTrueRumorTextOgImage'");
        target.mFalseRumorTextOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624791, "field 'mFalseRumorTextOgImage'"), 2131624791, "field 'mFalseRumorTextOgImage'");
        target.mTrueRumorIconOgImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624785, "field 'mTrueRumorIconOgImage'"), 2131624785, "field 'mTrueRumorIconOgImage'");
        target.mFalseRumorIconOgImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624790, "field 'mFalseRumorIconOgImage'"), 2131624790, "field 'mFalseRumorIconOgImage'");
        target.mCommentPostBtnOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624793, "field 'mCommentPostBtnOgImage'"), 2131624793, "field 'mCommentPostBtnOgImage'");
        target.mTrueRumorContainerOgImage = (View) finder.findRequiredView(source, 2131624784, "field 'mTrueRumorContainerOgImage'");
        target.mFalseRumorContainerOgImage = (View) finder.findRequiredView(source, 2131624789, "field 'mFalseRumorContainerOgImage'");
        target.mPostImageFooter = (View) finder.findRequiredView(source, 2131624413, "field 'mPostImageFooter'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
