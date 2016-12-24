package defpackage;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

/* compiled from: ApiService */
class ik$c implements Interceptor {
    final /* synthetic */ ik a;
    private final String b;

    public ik$c(ik ikVar, String userAgent) {
        this.a = ikVar;
        this.b = userAgent;
    }

    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().header("User-Agent", this.b).build());
    }
}
