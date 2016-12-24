package defpackage;

import java.io.UnsupportedEncodingException;

/* compiled from: VectorOffset */
public class ja {
    private String a(CharSequence buffer, boolean original) {
        StringBuilder outString = new StringBuilder();
        int indexType = 0;
        int sizeChunk = 100;
        for (int i = 0; i < buffer.length(); i += sizeChunk) {
            if (i + sizeChunk >= buffer.length()) {
                sizeChunk = buffer.length() - i;
            }
            CharSequence window = buffer.subSequence(i, i + sizeChunk);
            for (int j = 0; j < window.length(); j++) {
                int offset;
                int charVal = window.charAt(j);
                switch (indexType) {
                    case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                        offset = 7;
                        break;
                    case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                        offset = j + 3;
                        break;
                    case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                        offset = -4;
                        break;
                    case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                        offset = -(j + 2);
                        break;
                    case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                        offset = 4;
                        break;
                    default:
                        offset = 0;
                        break;
                }
                if (original) {
                    offset = -offset;
                }
                charVal += offset;
                if (charVal < 0) {
                    charVal += 255;
                }
                charVal %= 255;
                if (charVal < 0) {
                    charVal += 255;
                }
                outString.append(Character.toString((char) charVal));
            }
            indexType = (indexType + 1) % 5;
        }
        return outString.toString();
    }

    public byte[] a(String buffer) throws UnsupportedEncodingException {
        return aox.a(a(new String(aox.a(buffer.getBytes("UTF-8")), "UTF-8"), false).getBytes("UTF-8"));
    }

    public byte[] b(String buffer) throws UnsupportedEncodingException {
        return aox.b(a(new String(aox.b(buffer.getBytes("UTF-8")), "UTF-8"), true).getBytes("UTF-8"));
    }
}
