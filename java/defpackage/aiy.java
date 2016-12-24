package defpackage;

/* compiled from: $Gson$Preconditions */
public final class aiy {
    public static <T> T a(T obj) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException();
    }

    public static void a(boolean condition) {
        if (!condition) {
            throw new IllegalArgumentException();
        }
    }
}
