package defpackage;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

/* compiled from: ImageLoadingUtil */
class is$4 implements Interceptor {
    final /* synthetic */ ij$a a;

    is$4(ij$a ij_a) {
        this.a = ij_a;
    }

    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder().body(new ij(originalResponse.body(), this.a)).build();
    }
}
