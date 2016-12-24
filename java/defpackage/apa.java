package defpackage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: DigestUtils */
public class apa {
    public static MessageDigest a(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static MessageDigest a() {
        return apa.a("MD5");
    }

    public static byte[] a(byte[] data) {
        return apa.a().digest(data);
    }

    public static byte[] b(String data) {
        return apa.a(aoz.a(data));
    }
}
