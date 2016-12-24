package defpackage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/* compiled from: TutorialPagerAdapter */
public class hr extends FragmentPagerAdapter {
    private static int a = 4;

    public hr(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment getItem(int position) {
        switch (position) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                return new if();
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return new ie();
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return new id();
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return new ic();
            default:
                return null;
        }
    }

    public int getCount() {
        return a;
    }
}
