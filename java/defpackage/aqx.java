package defpackage;

/* compiled from: RxJavaPluginUtils */
public final class aqx {
    public static void a(Throwable e) {
        try {
            ask.a().b().a(e);
        } catch (Throwable pluginException) {
            aqx.b(pluginException);
        }
    }

    private static void b(Throwable pluginException) {
        System.err.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + pluginException.getMessage());
        pluginException.printStackTrace();
    }
}
