package defpackage;

public final class adu {
    public static byte a(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }

    public static Boolean a(byte b) {
        switch (b) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                return Boolean.FALSE;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return Boolean.TRUE;
            default:
                return null;
        }
    }
}
