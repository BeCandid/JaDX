package defpackage;

public abstract class abr<T> {
    private static final Object c = new Object();
    private static abr$a d = null;
    private static int e = 0;
    private static String f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String a;
    protected final T b;
    private T g = null;

    protected abr(String str, T t) {
        this.a = str;
        this.b = t;
    }

    public static abr<Integer> a(String str, Integer num) {
        return new abr$3(str, num);
    }

    public static abr<Long> a(String str, Long l) {
        return new abr$2(str, l);
    }

    public static abr<String> a(String str, String str2) {
        return new abr$4(str, str2);
    }

    public static abr<Boolean> a(String str, boolean z) {
        return new abr$1(str, Boolean.valueOf(z));
    }

    public final T a() {
        return a(this.a);
    }

    protected abstract T a(String str);
}
