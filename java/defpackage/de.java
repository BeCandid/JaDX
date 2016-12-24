package defpackage;

/* compiled from: TextDirectionHeuristicsCompat */
public final class de {
    public static final dd a = new de$e(null, false, null);
    public static final dd b = new de$e(null, true, null);
    public static final dd c = new de$e(de$b.a, false, null);
    public static final dd d = new de$e(de$b.a, true, null);
    public static final dd e = new de$e(de$a.a, false, null);
    public static final dd f = de$f.a;

    private static int c(int directionality) {
        switch (directionality) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                return 1;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return 0;
            default:
                return 2;
        }
    }

    private static int d(int directionality) {
        switch (directionality) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
            case ha$a.Toolbar_titleMarginEnd /*14*/:
            case ha$a.Toolbar_titleMarginTop /*15*/:
                return 1;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
            case ha$a.Toolbar_titleMarginBottom /*16*/:
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                return 0;
            default:
                return 2;
        }
    }
}
