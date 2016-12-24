package defpackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: HttpUrlFetcher */
class kx$a implements kx$b {
    private kx$a() {
    }

    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
}
