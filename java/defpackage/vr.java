package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageDownloader */
public class vr {
    private static Handler a;
    private static wh b = new wh(8);
    private static wh c = new wh(2);
    private static final Map<vr$d, vr$c> d = new HashMap();

    public static void a(vs request) {
        if (request != null) {
            vr$d key = new vr$d(request.b(), request.e());
            synchronized (d) {
                vr$c downloaderContext = (vr$c) d.get(key);
                if (downloaderContext != null) {
                    downloaderContext.b = request;
                    downloaderContext.c = false;
                    downloaderContext.a.b();
                } else {
                    vr.a(request, key, request.d());
                }
            }
        }
    }

    public static boolean b(vs request) {
        boolean cancelled = false;
        vr$d key = new vr$d(request.b(), request.e());
        synchronized (d) {
            vr$c downloaderContext = (vr$c) d.get(key);
            if (downloaderContext != null) {
                cancelled = true;
                if (downloaderContext.a.a()) {
                    d.remove(key);
                } else {
                    downloaderContext.c = true;
                }
            }
        }
        return cancelled;
    }

    private static void a(vs request, vr$d key, boolean allowCachedRedirects) {
        vr.a(request, key, c, new vr$a(request.a(), key, allowCachedRedirects));
    }

    private static void a(vs request, vr$d key) {
        vr.a(request, key, b, new vr$b(request.a(), key));
    }

    private static void a(vs request, vr$d key, wh workQueue, Runnable workItem) {
        synchronized (d) {
            vr$c downloaderContext = new vr$c(null);
            downloaderContext.b = request;
            d.put(key, downloaderContext);
            downloaderContext.a = workQueue.a(workItem);
        }
    }

    private static void a(vr$d key, Exception error, Bitmap bitmap, boolean isCachedRedirect) {
        vr$c completedRequestContext = vr.a(key);
        if (completedRequestContext != null && !completedRequestContext.c) {
            vs request = completedRequestContext.b;
            vs$b callback = request.c();
            if (callback != null) {
                vr.a().post(new vr$1(request, error, isCachedRedirect, bitmap, callback));
            }
        }
    }

    private static void b(vr$d key, Context context, boolean allowCachedRedirects) {
        Closeable cachedStream = null;
        boolean isCachedRedirect = false;
        if (allowCachedRedirects) {
            Uri redirectUri = wd.a(key.a);
            if (redirectUri != null) {
                cachedStream = vu.a(redirectUri, context);
                isCachedRedirect = cachedStream != null;
            }
        }
        if (!isCachedRedirect) {
            cachedStream = vu.a(key.a, context);
        }
        if (cachedStream != null) {
            Bitmap bitmap = BitmapFactory.decodeStream(cachedStream);
            we.a(cachedStream);
            vr.a(key, null, bitmap, isCachedRedirect);
            return;
        }
        vr$c downloaderContext = vr.a(key);
        if (downloaderContext != null && !downloaderContext.c) {
            vr.a(downloaderContext.b, key);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(defpackage.vr$d r19, android.content.Context r20) {
        /*
        r5 = 0;
        r14 = 0;
        r8 = 0;
        r2 = 0;
        r10 = 1;
        r15 = new java.net.URL;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r19;
        r0 = r0.a;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r0;
        r16 = r16.toString();	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r15.<init>(r16);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r15.openConnection();	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r16;
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r5 = r0;
        r16 = 0;
        r0 = r16;
        r5.setInstanceFollowRedirects(r0);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r5.getResponseCode();	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        switch(r16) {
            case 200: goto L_0x00b5;
            case 301: goto L_0x006c;
            case 302: goto L_0x006c;
            default: goto L_0x002b;
        };	 Catch:{ IOException -> 0x0058, all -> 0x00df }
    L_0x002b:
        r14 = r5.getErrorStream();	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r9 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r9.<init>();	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        if (r14 == 0) goto L_0x00cf;
    L_0x0036:
        r11 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r11.<init>(r14);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = 128; // 0x80 float:1.8E-43 double:6.3E-322;
        r0 = r16;
        r3 = new char[r0];	 Catch:{ IOException -> 0x0058, all -> 0x00df }
    L_0x0041:
        r16 = 0;
        r0 = r3.length;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r17 = r0;
        r0 = r16;
        r1 = r17;
        r4 = r11.read(r3, r0, r1);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        if (r4 <= 0) goto L_0x00c0;
    L_0x0050:
        r16 = 0;
        r0 = r16;
        r9.append(r3, r0, r4);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        goto L_0x0041;
    L_0x0058:
        r7 = move-exception;
        r8 = r7;
        defpackage.we.a(r14);
        defpackage.we.a(r5);
    L_0x0060:
        if (r10 == 0) goto L_0x006b;
    L_0x0062:
        r16 = 0;
        r0 = r19;
        r1 = r16;
        defpackage.vr.a(r0, r8, r2, r1);
    L_0x006b:
        return;
    L_0x006c:
        r10 = 0;
        r16 = "location";
        r0 = r16;
        r12 = r5.getHeaderField(r0);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = defpackage.we.a(r12);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        if (r16 != 0) goto L_0x00ae;
    L_0x007b:
        r13 = android.net.Uri.parse(r12);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r19;
        r0 = r0.a;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r0;
        r0 = r16;
        defpackage.wd.a(r0, r13);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r6 = defpackage.vr.a(r19);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        if (r6 == 0) goto L_0x00ae;
    L_0x0090:
        r0 = r6.c;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r0;
        if (r16 != 0) goto L_0x00ae;
    L_0x0096:
        r0 = r6.b;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r0;
        r17 = new vr$d;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r19;
        r0 = r0.b;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r18 = r0;
        r0 = r17;
        r1 = r18;
        r0.<init>(r13, r1);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r18 = 0;
        defpackage.vr.a(r16, r17, r18);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
    L_0x00ae:
        defpackage.we.a(r14);
        defpackage.we.a(r5);
        goto L_0x0060;
    L_0x00b5:
        r0 = r20;
        r14 = defpackage.vu.a(r0, r5);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r2 = android.graphics.BitmapFactory.decodeStream(r14);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        goto L_0x00ae;
    L_0x00c0:
        defpackage.we.a(r11);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
    L_0x00c3:
        r8 = new com.facebook.FacebookException;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r9.toString();	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r16;
        r8.<init>(r0);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        goto L_0x00ae;
    L_0x00cf:
        r16 = defpackage.uu$f.com_facebook_image_download_unknown_error;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r20;
        r1 = r16;
        r16 = r0.getString(r1);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r16;
        r9.append(r0);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        goto L_0x00c3;
    L_0x00df:
        r16 = move-exception;
        defpackage.we.a(r14);
        defpackage.we.a(r5);
        throw r16;
        */
        throw new UnsupportedOperationException("Method not decompiled: vr.b(vr$d, android.content.Context):void");
    }

    private static synchronized Handler a() {
        Handler handler;
        synchronized (vr.class) {
            if (a == null) {
                a = new Handler(Looper.getMainLooper());
            }
            handler = a;
        }
        return handler;
    }

    private static vr$c a(vr$d key) {
        vr$c vr_c;
        synchronized (d) {
            vr_c = (vr$c) d.remove(key);
        }
        return vr_c;
    }
}
