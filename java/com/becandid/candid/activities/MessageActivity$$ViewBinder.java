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

public class MessageActivity$$ViewBinder<T extends MessageActivity> implements ViewBinder<T> {

    /* compiled from: MessageActivity$$ViewBinder */
    public static class InnerUnbinder<T extends MessageActivity> implements Unbinder {
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
            target.root = null;
            target.contentRootView = null;
            target.messageSpinnyContainer = null;
            target.blockedFrameLayout = null;
            target.headerName = null;
            target.headerOnline = null;
            target.messageHeaderUserIcon = null;
            target.messageHeaderUserIconContainer = null;
            target.messageHeaderPostText = null;
            target.messageHeaderRightArrow = null;
            target.messageHeaderPostContainer = null;
            target.mNickname = null;
            target.messageSwipeContainer = null;
            target.messageRecycler = null;
            target.messageTextPlaceholder = null;
            target.messageInputContainer = null;
            target.postButton = null;
            target.messageInput = null;
            target.messagePhoto = null;
            target.messagePhotoButton = null;
            target.messagePhotoClear = null;
            target.requestButtons = null;
            target.requestIgnore = null;
            target.requestAccept = null;
            target.stickerKeyboard = null;
            target.stickerButton = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.root = (View) finder.findRequiredView(source, 2131624215, "field 'root'");
        target.contentRootView = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624216, "field 'contentRootView'"), 2131624216, "field 'contentRootView'");
        target.messageSpinnyContainer = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624233, "field 'messageSpinnyContainer'"), 2131624233, "field 'messageSpinnyContainer'");
        target.blockedFrameLayout = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624234, "field 'blockedFrameLayout'"), 2131624234, "field 'blockedFrameLayout'");
        target.headerName = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624237, "field 'headerName'"), 2131624237, "field 'headerName'");
        target.headerOnline = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624239, "field 'headerOnline'"), 2131624239, "field 'headerOnline'");
        target.messageHeaderUserIcon = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624238, "field 'messageHeaderUserIcon'"), 2131624238, "field 'messageHeaderUserIcon'");
        target.messageHeaderUserIconContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624236, "field 'messageHeaderUserIconContainer'"), 2131624236, "field 'messageHeaderUserIconContainer'");
        target.messageHeaderPostText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624241, "field 'messageHeaderPostText'"), 2131624241, "field 'messageHeaderPostText'");
        target.messageHeaderRightArrow = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624242, "field 'messageHeaderRightArrow'"), 2131624242, "field 'messageHeaderRightArrow'");
        target.messageHeaderPostContainer = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624240, "field 'messageHeaderPostContainer'"), 2131624240, "field 'messageHeaderPostContainer'");
        target.mNickname = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624243, "field 'mNickname'"), 2131624243, "field 'mNickname'");
        target.messageSwipeContainer = (SwipeRefreshLayout) finder.castView((View) finder.findRequiredView(source, 2131624217, "field 'messageSwipeContainer'"), 2131624217, "field 'messageSwipeContainer'");
        target.messageRecycler = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624220, "field 'messageRecycler'"), 2131624220, "field 'messageRecycler'");
        target.messageTextPlaceholder = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624228, "field 'messageTextPlaceholder'"), 2131624228, "field 'messageTextPlaceholder'");
        target.messageInputContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624221, "field 'messageInputContainer'"), 2131624221, "field 'messageInputContainer'");
        target.postButton = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624130, "field 'postButton'"), 2131624130, "field 'postButton'");
        target.messageInput = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624225, "field 'messageInput'"), 2131624225, "field 'messageInput'");
        target.messagePhoto = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624223, "field 'messagePhoto'"), 2131624223, "field 'messagePhoto'");
        target.messagePhotoButton = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624226, "field 'messagePhotoButton'"), 2131624226, "field 'messagePhotoButton'");
        target.messagePhotoClear = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624224, "field 'messagePhotoClear'"), 2131624224, "field 'messagePhotoClear'");
        target.requestButtons = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624229, "field 'requestButtons'"), 2131624229, "field 'requestButtons'");
        target.requestIgnore = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624230, "field 'requestIgnore'"), 2131624230, "field 'requestIgnore'");
        target.requestAccept = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624231, "field 'requestAccept'"), 2131624231, "field 'requestAccept'");
        target.stickerKeyboard = (StickerKeyboard) finder.castView((View) finder.findRequiredView(source, 2131624232, "field 'stickerKeyboard'"), 2131624232, "field 'stickerKeyboard'");
        target.stickerButton = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624227, "field 'stickerButton'"), 2131624227, "field 'stickerButton'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
