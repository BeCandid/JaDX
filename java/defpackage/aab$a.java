package defpackage;

import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class aab$a extends yv$a {
    private int a;

    protected aab$a(byte[] bArr) {
        xz.b(bArr.length == 25, "cert hash data has incorrect length. length=" + bArr.length);
        this.a = Arrays.hashCode(bArr);
    }

    protected static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public aag a() {
        return aah.a(c());
    }

    public int b() {
        return hashCode();
    }

    abstract byte[] c();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof yv)) {
            return false;
        }
        try {
            yv yvVar = (yv) obj;
            if (yvVar.b() != hashCode()) {
                return false;
            }
            aag a = yvVar.a();
            if (a == null) {
                return false;
            }
            return Arrays.equals(c(), (byte[]) aah.a(a));
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "iCertData failed to retrive data from remote");
            return false;
        }
    }

    public int hashCode() {
        return this.a;
    }
}
