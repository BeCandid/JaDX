package com.becandid.candid.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.StickerKeyboard;

public class PostDetailsActivity$$ViewBinder<T extends PostDetailsActivity> implements ViewBinder<T> {

    /* compiled from: PostDetailsActivity$$ViewBinder */
    public static class InnerUnbinder<T extends PostDetailsActivity> implements Unbinder {
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
            target.commentRecyclerView = null;
            target.mSwipeContainer = null;
            target.postHeaderText = null;
            target.commentInput = null;
            target.commentButton = null;
            target.postPhoto = null;
            target.stickerKeyboard = null;
            target.root = null;
            target.postSpinnyContainer = null;
            target.commentInputContainer = null;
            target.commentTextPlaceholder = null;
            target.stickerButton = null;
            target.commentPhotoClear = null;
            target.commentSpinnyContainer = null;
            target.mutePostIcon = null;
            target.relatedPostsButton = null;
            target.mReplyToBox = null;
            target.mReplyToTextHint = null;
            target.mReplyToClose = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.commentRecyclerView = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624268, "field 'commentRecyclerView'"), 2131624268, "field 'commentRecyclerView'");
        target.mSwipeContainer = (SwipeRefreshLayout) finder.castView((View) finder.findRequiredView(source, 2131624169, "field 'mSwipeContainer'"), 2131624169, "field 'mSwipeContainer'");
        target.postHeaderText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624265, "field 'postHeaderText'"), 2131624265, "field 'postHeaderText'");
        target.commentInput = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624276, "field 'commentInput'"), 2131624276, "field 'commentInput'");
        target.commentButton = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624130, "field 'commentButton'"), 2131624130, "field 'commentButton'");
        target.postPhoto = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624274, "field 'postPhoto'"), 2131624274, "field 'postPhoto'");
        target.stickerKeyboard = (StickerKeyboard) finder.castView((View) finder.findRequiredView(source, 2131624232, "field 'stickerKeyboard'"), 2131624232, "field 'stickerKeyboard'");
        target.root = (View) finder.findRequiredView(source, 2131624263, "field 'root'");
        target.postSpinnyContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624282, "field 'postSpinnyContainer'"), 2131624282, "field 'postSpinnyContainer'");
        target.commentInputContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624272, "field 'commentInputContainer'"), 2131624272, "field 'commentInputContainer'");
        target.commentTextPlaceholder = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624279, "field 'commentTextPlaceholder'"), 2131624279, "field 'commentTextPlaceholder'");
        target.stickerButton = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624278, "field 'stickerButton'"), 2131624278, "field 'stickerButton'");
        target.commentPhotoClear = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624275, "field 'commentPhotoClear'"), 2131624275, "field 'commentPhotoClear'");
        target.commentSpinnyContainer = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624281, "field 'commentSpinnyContainer'"), 2131624281, "field 'commentSpinnyContainer'");
        target.mutePostIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624266, "field 'mutePostIcon'"), 2131624266, "field 'mutePostIcon'");
        target.relatedPostsButton = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624280, "field 'relatedPostsButton'"), 2131624280, "field 'relatedPostsButton'");
        target.mReplyToBox = (View) finder.findRequiredView(source, 2131624269, "field 'mReplyToBox'");
        target.mReplyToTextHint = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624270, "field 'mReplyToTextHint'"), 2131624270, "field 'mReplyToTextHint'");
        target.mReplyToClose = (View) finder.findRequiredView(source, 2131624271, "field 'mReplyToClose'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
