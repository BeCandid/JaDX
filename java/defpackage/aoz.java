package defpackage;

import java.nio.charset.Charset;

/* compiled from: StringUtils */
public class aoz {
    private static byte[] a(String string, Charset charset) {
        if (string == null) {
            return null;
        }
        return string.getBytes(charset);
    }

    public static byte[] a(String string) {
        return aoz.a(string, aow.f);
    }

    private static String a(byte[] bytes, Charset charset) {
        return bytes == null ? null : new String(bytes, charset);
    }

    public static String a(byte[] bytes) {
        return aoz.a(bytes, aow.f);
    }
}
