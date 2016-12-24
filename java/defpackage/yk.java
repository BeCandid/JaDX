package defpackage;

import java.util.Arrays;

public abstract class yk {
    public static final yk a = yk.a((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000\u00a0\u180e\u202f").a(yk.a('\u2000', '\u200a'));
    public static final yk b = yk.a((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").a(yk.a('\u2000', '\u2006')).a(yk.a('\u2008', '\u200a'));
    public static final yk c = yk.a('\u0000', '\u007f');
    public static final yk d;
    public static final yk e = yk.a('\t', '\r').a(yk.a('\u001c', ' ')).a(yk.a('\u1680')).a(yk.a('\u180e')).a(yk.a('\u2000', '\u2006')).a(yk.a('\u2008', '\u200b')).a(yk.a('\u2028', '\u2029')).a(yk.a('\u205f')).a(yk.a('\u3000'));
    public static final yk f = new yk$1();
    public static final yk g = new yk$7();
    public static final yk h = new yk$8();
    public static final yk i = new yk$9();
    public static final yk j = new yk$10();
    public static final yk k = yk.a('\u0000', '\u001f').a(yk.a('\u007f', '\u009f'));
    public static final yk l = yk.a('\u0000', ' ').a(yk.a('\u007f', '\u00a0')).a(yk.a('\u00ad')).a(yk.a('\u0600', '\u0603')).a(yk.a((CharSequence) "\u06dd\u070f\u1680\u17b4\u17b5\u180e")).a(yk.a('\u2000', '\u200f')).a(yk.a('\u2028', '\u202f')).a(yk.a('\u205f', '\u2064')).a(yk.a('\u206a', '\u206f')).a(yk.a('\u3000')).a(yk.a('\ud800', '\uf8ff')).a(yk.a((CharSequence) "\ufeff\ufff9\ufffa\ufffb"));
    public static final yk m = yk.a('\u0000', '\u04f9').a(yk.a('\u05be')).a(yk.a('\u05d0', '\u05ea')).a(yk.a('\u05f3')).a(yk.a('\u05f4')).a(yk.a('\u0600', '\u06ff')).a(yk.a('\u0750', '\u077f')).a(yk.a('\u0e00', '\u0e7f')).a(yk.a('\u1e00', '\u20af')).a(yk.a('\u2100', '\u213a')).a(yk.a('\ufb50', '\ufdff')).a(yk.a('\ufe70', '\ufeff')).a(yk.a('\uff61', '\uffdc'));
    public static final yk n = new yk$11();
    public static final yk o = new yk$2();

    static {
        yk a = yk.a('0', '9');
        yk ykVar = a;
        for (char c : "\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".toCharArray()) {
            ykVar = ykVar.a(yk.a(c, (char) (c + 9)));
        }
        d = ykVar;
    }

    public static yk a(char c) {
        return new yk$3(c);
    }

    public static yk a(char c, char c2) {
        xz.b(c2 >= c);
        return new yk$6(c, c2);
    }

    public static yk a(CharSequence charSequence) {
        switch (charSequence.length()) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                return o;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return yk.a(charSequence.charAt(0));
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return new yk$4(charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new yk$5(toCharArray);
        }
    }

    public yk a(yk ykVar) {
        return new yk$a(Arrays.asList(new yk[]{this, (yk) xz.a((Object) ykVar)}));
    }

    public abstract boolean b(char c);

    public boolean b(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!b(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
