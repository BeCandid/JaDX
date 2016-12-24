package defpackage;

import android.net.Uri;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: UrlRedirectCache */
class wd {
    static final String a = wd.class.getSimpleName();
    private static final String b = (a + "_Redirect");
    private static volatile vp c;

    wd() {
    }

    static synchronized vp a() throws IOException {
        vp vpVar;
        synchronized (wd.class) {
            if (c == null) {
                c = new vp(a, new vp$d());
            }
            vpVar = c;
        }
        return vpVar;
    }

    static Uri a(Uri uri) {
        Closeable closeable;
        Throwable th;
        Uri uri2 = null;
        if (uri != null) {
            String uriString = uri.toString();
            closeable = null;
            try {
                vp cache = wd.a();
                boolean redirectExists = false;
                Closeable reader = null;
                while (true) {
                    try {
                        InputStream stream = cache.a(uriString, b);
                        if (stream == null) {
                            break;
                        }
                        redirectExists = true;
                        closeable = new InputStreamReader(stream);
                        char[] buffer = new char[128];
                        StringBuilder urlBuilder = new StringBuilder();
                        while (true) {
                            int bufferLength = closeable.read(buffer, 0, buffer.length);
                            if (bufferLength <= 0) {
                                break;
                            }
                            urlBuilder.append(buffer, 0, bufferLength);
                        }
                        we.a(closeable);
                        uriString = urlBuilder.toString();
                        reader = closeable;
                    } catch (IOException e) {
                        closeable = reader;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = reader;
                    }
                }
                if (redirectExists) {
                    uri2 = Uri.parse(uriString);
                    we.a(reader);
                } else {
                    we.a(reader);
                    closeable = reader;
                }
            } catch (IOException e2) {
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return uri2;
        we.a(closeable);
        return uri2;
        we.a(closeable);
        throw th;
    }

    static void a(Uri fromUri, Uri toUri) {
        if (fromUri != null && toUri != null) {
            Closeable redirectStream = null;
            try {
                redirectStream = wd.a().b(fromUri.toString(), b);
                redirectStream.write(toUri.toString().getBytes());
            } catch (IOException e) {
            } finally {
                we.a(redirectStream);
            }
        }
    }
}
