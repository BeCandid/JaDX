package defpackage;

/* compiled from: TextDirectionHeuristicsCompat */
abstract class de$d implements dd {
    private final de$c a;

    protected abstract boolean a();

    public de$d(de$c algorithm) {
        this.a = algorithm;
    }

    public boolean a(CharSequence cs, int start, int count) {
        if (cs == null || start < 0 || count < 0 || cs.length() - count < start) {
            throw new IllegalArgumentException();
        } else if (this.a == null) {
            return a();
        } else {
            return b(cs, start, count);
        }
    }

    private boolean b(CharSequence cs, int start, int count) {
        switch (this.a.a(cs, start, count)) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                return true;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return false;
            default:
                return a();
        }
    }
}
