package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

/* compiled from: PhotoHelper */
class it$3 implements OnClickListener {
    final /* synthetic */ List a;
    final /* synthetic */ it b;

    it$3(it this$0, List list) {
        this.b = this$0;
        this.a = list;
    }

    public void onClick(DialogInterface dialog, int index) {
        String action = (String) this.a.get(index);
        Object obj = -1;
        switch (action.hashCode()) {
            case -1367724422:
                if (action.equals("cancel")) {
                    obj = 2;
                    break;
                }
                break;
            case 106642994:
                if (action.equals("photo")) {
                    obj = null;
                    break;
                }
                break;
            case 166208699:
                if (action.equals("library")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                this.b.b();
                return;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                this.b.c();
                return;
            default:
                return;
        }
    }
}
