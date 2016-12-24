package defpackage;

import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: ImageResponseCache */
class vu {
    static final String a = vu.class.getSimpleName();
    private static volatile vp b;

    vu() {
    }

    static synchronized vp a(Context context) throws IOException {
        vp vpVar;
        synchronized (vu.class) {
            if (b == null) {
                b = new vp(a, new vp$d());
            }
            vpVar = b;
        }
        return vpVar;
    }

    static InputStream a(Uri uri, Context context) {
        InputStream imageStream = null;
        if (uri != null && vu.a(uri)) {
            try {
                imageStream = vu.a(context).a(uri.toString());
            } catch (IOException e) {
                vx.a(LoggingBehavior.CACHE, 5, a, e.toString());
            }
        }
        return imageStream;
    }

    static InputStream a(Context context, HttpURLConnection connection) throws IOException {
        InputStream stream = null;
        if (connection.getResponseCode() == 200) {
            Uri uri = Uri.parse(connection.getURL().toString());
            stream = connection.getInputStream();
            try {
                if (vu.a(uri)) {
                    stream = vu.a(context).a(uri.toString(), new vu$a(stream, connection));
                }
            } catch (IOException e) {
            }
        }
        return stream;
    }

    private static boolean a(Uri uri) {
        if (uri != null) {
            String uriHost = uri.getHost();
            if (uriHost.endsWith("fbcdn.net")) {
                return true;
            }
            if (uriHost.startsWith("fbcdn") && uriHost.endsWith("akamaihd.net")) {
                return true;
            }
        }
        return false;
    }
}
