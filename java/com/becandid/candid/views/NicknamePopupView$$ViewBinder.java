package com.becandid.candid.views;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class NicknamePopupView$$ViewBinder<T extends NicknamePopupView> extends BlurLayout$$ViewBinder<T> {

    /* compiled from: NicknamePopupView$$ViewBinder */
    public static class a<T extends NicknamePopupView> extends com.becandid.candid.views.BlurLayout$.ViewBinder.a<T> {
        protected a(T target) {
            super(target);
        }

        protected void a(T target) {
            super.a(target);
            target.mMessageContainerAddNickname = null;
            target.mMessageContainerSecondNickname = null;
            target.mBadgeIcon = null;
            target.mFinishBtn = null;
            target.mNicknameCloseButton = null;
            target.secondNicknameDesc = null;
            target.addNicknameDesc = null;
            target.mNoButton = null;
            target.mYesButton = null;
            target.mOkButton = null;
            target.mCancelButton = null;
            target.editNickname = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (NicknamePopupView) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = (a) super.a(finder, target, source);
        target.mMessageContainerAddNickname = (View) finder.findRequiredView(source, 2131624590, "field 'mMessageContainerAddNickname'");
        target.mMessageContainerSecondNickname = (View) finder.findRequiredView(source, 2131624584, "field 'mMessageContainerSecondNickname'");
        target.mBadgeIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624079, "field 'mBadgeIcon'"), 2131624079, "field 'mBadgeIcon'");
        target.mFinishBtn = (Button) finder.castView((View) finder.findRequiredView(source, 2131624579, "field 'mFinishBtn'"), 2131624579, "field 'mFinishBtn'");
        target.mNicknameCloseButton = (View) finder.findRequiredView(source, 2131624595, "field 'mNicknameCloseButton'");
        target.secondNicknameDesc = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624586, "field 'secondNicknameDesc'"), 2131624586, "field 'secondNicknameDesc'");
        target.addNicknameDesc = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624592, "field 'addNicknameDesc'"), 2131624592, "field 'addNicknameDesc'");
        target.mNoButton = (Button) finder.castView((View) finder.findRequiredView(source, 2131624587, "field 'mNoButton'"), 2131624587, "field 'mNoButton'");
        target.mYesButton = (Button) finder.castView((View) finder.findRequiredView(source, 2131624588, "field 'mYesButton'"), 2131624588, "field 'mYesButton'");
        target.mOkButton = (Button) finder.castView((View) finder.findRequiredView(source, 2131624589, "field 'mOkButton'"), 2131624589, "field 'mOkButton'");
        target.mCancelButton = (Button) finder.castView((View) finder.findRequiredView(source, 2131624594, "field 'mCancelButton'"), 2131624594, "field 'mCancelButton'");
        target.editNickname = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624593, "field 'editNickname'"), 2131624593, "field 'editNickname'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
