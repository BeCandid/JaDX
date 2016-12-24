package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jo$12 implements jo$c {
    jo$12() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (view instanceof ImageView) {
            ScaleType scaleType = ((ImageView) view).getScaleType();
            String toLowerCase = value.toLowerCase();
            Object obj = -1;
            switch (toLowerCase.hashCode()) {
                case -2021672893:
                    if (toLowerCase.equals("fit_center")) {
                        obj = 3;
                        break;
                    }
                    break;
                case -1364013995:
                    if (toLowerCase.equals("center")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1274273297:
                    if (toLowerCase.equals("fit_xy")) {
                        obj = 6;
                        break;
                    }
                    break;
                case -1081239615:
                    if (toLowerCase.equals("matrix")) {
                        obj = 7;
                        break;
                    }
                    break;
                case -847785043:
                    if (toLowerCase.equals("fit_end")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 225732390:
                    if (toLowerCase.equals("center_inside")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1335468724:
                    if (toLowerCase.equals("fit_start")) {
                        obj = 5;
                        break;
                    }
                    break;
                case 1671566394:
                    if (toLowerCase.equals("center_crop")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    scaleType = ScaleType.CENTER;
                    break;
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    scaleType = ScaleType.CENTER_CROP;
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    scaleType = ScaleType.CENTER_INSIDE;
                    break;
                case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    scaleType = ScaleType.FIT_CENTER;
                    break;
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    scaleType = ScaleType.FIT_END;
                    break;
                case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    scaleType = ScaleType.FIT_START;
                    break;
                case uu$h.CardView_cardUseCompatPadding /*6*/:
                    scaleType = ScaleType.FIT_XY;
                    break;
                case uu$h.CardView_cardPreventCornerOverlap /*7*/:
                    scaleType = ScaleType.MATRIX;
                    break;
            }
            ((ImageView) view).setScaleType(scaleType);
        }
    }
}
