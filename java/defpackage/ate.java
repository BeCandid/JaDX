package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;

@TargetApi(5)
/* compiled from: EclairGestureDetector */
public class ate extends atd {
    private int f = -1;
    private int g = 0;

    public ate(Context context) {
        super(context);
    }

    float a(MotionEvent ev) {
        try {
            return ev.getX(this.g);
        } catch (Exception e) {
            return ev.getX();
        }
    }

    float b(MotionEvent ev) {
        try {
            return ev.getY(this.g);
        } catch (Exception e) {
            return ev.getY();
        }
    }

    public boolean c(MotionEvent ev) {
        boolean z = true;
        int i = 0;
        switch (ev.getAction() & 255) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                this.f = ev.getPointerId(0);
                break;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                this.f = -1;
                break;
            case uu$h.CardView_cardUseCompatPadding /*6*/:
                int pointerIndex = asz.a(ev.getAction());
                if (ev.getPointerId(pointerIndex) == this.f) {
                    int newPointerIndex;
                    if (pointerIndex == 0) {
                        newPointerIndex = z;
                    } else {
                        newPointerIndex = 0;
                    }
                    this.f = ev.getPointerId(newPointerIndex);
                    this.b = ev.getX(newPointerIndex);
                    this.c = ev.getY(newPointerIndex);
                    break;
                }
                break;
        }
        if (this.f != -1) {
            i = this.f;
        }
        this.g = ev.findPointerIndex(i);
        try {
            z = super.c(ev);
        } catch (IllegalArgumentException e) {
        }
        return z;
    }
}
