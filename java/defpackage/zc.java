package defpackage;

import java.util.Arrays;

public final class zc {
    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zc$a a(Object obj) {
        return new zc$a(obj, null);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
