package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.model.ShareContent;
import defpackage.uu$g;
import defpackage.vl;
import defpackage.wq$a;
import defpackage.xb;

public final class SendButton extends ShareButtonBase {
    public SendButton(Context context) {
        super(context, null, 0, "fb_send_button_create", "fb_send_button_did_tap");
    }

    public SendButton(Context context, AttributeSet attrs) {
        super(context, attrs, 0, "fb_send_button_create", "fb_send_button_did_tap");
    }

    public SendButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, "fb_send_button_create", "fb_send_button_did_tap");
    }

    protected int getDefaultStyleResource() {
        return uu$g.com_facebook_button_send;
    }

    protected int getDefaultRequestCode() {
        return RequestCodeOffset.Message.a();
    }

    protected vl<ShareContent, wq$a> getDialog() {
        if (getFragment() != null) {
            return new xb(getFragment(), getRequestCode());
        }
        if (getNativeFragment() != null) {
            return new xb(getNativeFragment(), getRequestCode());
        }
        return new xb(getActivity(), getRequestCode());
    }
}
