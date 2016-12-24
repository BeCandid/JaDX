package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.internal.LikeContent.a;
import com.facebook.share.widget.LikeView.ObjectType;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LikeActionController */
public class ws {
    private static final String a = ws.class.getSimpleName();
    private static vp b;
    private static final ConcurrentHashMap<String, ws> c = new ConcurrentHashMap();
    private static wh d = new wh(1);
    private static wh e = new wh(1);
    private static Handler f;
    private static String g;
    private static boolean h;
    private static volatile int i;
    private static ui j;
    private String k;
    private ObjectType l;
    private boolean m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private boolean u;
    private boolean v;
    private Bundle w;
    private AppEventsLogger x;

    private static void b(java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextEntry(HashMap.java:789)
	at java.util.HashMap$KeyIterator.next(HashMap.java:814)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:173)
*/
        /*
        r1 = 0;
        r2 = b;	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r1 = r2.b(r4);	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r2 = r5.getBytes();	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r1.write(r2);	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        if (r1 == 0) goto L_0x0013;
    L_0x0010:
        defpackage.we.a(r1);
    L_0x0013:
        return;
    L_0x0014:
        r0 = move-exception;
        r2 = a;	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r3 = "Unable to serialize controller to disk";	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        if (r1 == 0) goto L_0x0013;
    L_0x001e:
        defpackage.we.a(r1);
        goto L_0x0013;
    L_0x0022:
        r2 = move-exception;
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        defpackage.we.a(r1);
    L_0x0028:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: ws.b(java.lang.String, java.lang.String):void");
    }

    public static boolean a(int requestCode, int resultCode, Intent data) {
        if (we.a(g)) {
            g = ul.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
        }
        if (we.a(g)) {
            return false;
        }
        ws.a(g, ObjectType.UNKNOWN, new ws$1(requestCode, resultCode, data));
        return true;
    }

    public static void a(String objectId, ObjectType objectType, ws$c callback) {
        if (!h) {
            ws.j();
        }
        ws controllerForObject = ws.a(objectId);
        if (controllerForObject != null) {
            ws.a(controllerForObject, objectType, callback);
        } else {
            e.a(new ws$b(objectId, objectType, callback));
        }
    }

    private static void a(ws likeActionController, ObjectType objectType, ws$c callback) {
        ObjectType bestObjectType = wz.a(objectType, likeActionController.l);
        FacebookException error = null;
        if (bestObjectType == null) {
            error = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", likeActionController.k, likeActionController.l.toString(), objectType.toString());
            likeActionController = null;
        } else {
            likeActionController.l = bestObjectType;
        }
        ws.a(callback, likeActionController, error);
    }

    private static void c(String objectId, ObjectType objectType, ws$c callback) {
        ws controllerForObject = ws.a(objectId);
        if (controllerForObject != null) {
            ws.a(controllerForObject, objectType, callback);
            return;
        }
        controllerForObject = ws.b(objectId);
        if (controllerForObject == null) {
            controllerForObject = new ws(objectId, objectType);
            ws.l(controllerForObject);
        }
        ws.a(objectId, controllerForObject);
        ws controllerToRefresh = controllerForObject;
        f.post(new ws$5(controllerToRefresh));
        ws.a(callback, controllerToRefresh, null);
    }

    private static synchronized void j() {
        synchronized (ws.class) {
            if (!h) {
                f = new Handler(Looper.getMainLooper());
                i = ul.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getInt("OBJECT_SUFFIX", 1);
                b = new vp(a, new vp$d());
                ws.k();
                CallbackManagerImpl.a(RequestCodeOffset.Like.a(), new ws$6());
                h = true;
            }
        }
    }

    private static void a(ws$c callback, ws controller, FacebookException error) {
        if (callback != null) {
            f.post(new ws$7(callback, controller, error));
        }
    }

    private static void k() {
        j = new ws$8();
    }

    private static void a(String objectId, ws controllerForObject) {
        String cacheKey = ws.d(objectId);
        d.a(new ws$j(cacheKey, true));
        c.put(cacheKey, controllerForObject);
    }

    private static ws a(String objectId) {
        String cacheKey = ws.d(objectId);
        ws controller = (ws) c.get(cacheKey);
        if (controller != null) {
            d.a(new ws$j(cacheKey, false));
        }
        return controller;
    }

    private static void l(ws controller) {
        String controllerJson = ws.m(controller);
        String cacheKey = ws.d(controller.k);
        if (!we.a(controllerJson) && !we.a(cacheKey)) {
            e.a(new ws$o(cacheKey, controllerJson));
        }
    }

    private static ws b(String objectId) {
        ws controller = null;
        try {
            Closeable inputStream = b.a(ws.d(objectId));
            if (inputStream != null) {
                String controllerJsonString = we.a((InputStream) inputStream);
                if (!we.a(controllerJsonString)) {
                    controller = ws.c(controllerJsonString);
                }
            }
            if (inputStream != null) {
                we.a(inputStream);
            }
        } catch (IOException e) {
            Log.e(a, "Unable to deserialize controller from disk", e);
            controller = null;
            if (null != null) {
                we.a(null);
            }
        } catch (Throwable th) {
            if (null != null) {
                we.a(null);
            }
        }
        return controller;
    }

    private static ws c(String controllerJsonString) {
        try {
            JSONObject controllerJson = new JSONObject(controllerJsonString);
            if (controllerJson.optInt("com.facebook.share.internal.LikeActionController.version", -1) != 3) {
                return null;
            }
            ws controller = new ws(controllerJson.getString("object_id"), ObjectType.a(controllerJson.optInt("object_type", ObjectType.UNKNOWN.a())));
            controller.n = controllerJson.optString("like_count_string_with_like", null);
            controller.o = controllerJson.optString("like_count_string_without_like", null);
            controller.p = controllerJson.optString("social_sentence_with_like", null);
            controller.q = controllerJson.optString("social_sentence_without_like", null);
            controller.m = controllerJson.optBoolean("is_object_liked");
            controller.r = controllerJson.optString("unlike_token", null);
            JSONObject analyticsJSON = controllerJson.optJSONObject("facebook_dialog_analytics_bundle");
            if (analyticsJSON == null) {
                return controller;
            }
            controller.w = vh.a(analyticsJSON);
            return controller;
        } catch (JSONException e) {
            Log.e(a, "Unable to deserialize controller from JSON", e);
            return null;
        }
    }

    private static String m(ws controller) {
        JSONObject controllerJson = new JSONObject();
        try {
            controllerJson.put("com.facebook.share.internal.LikeActionController.version", 3);
            controllerJson.put("object_id", controller.k);
            controllerJson.put("object_type", controller.l.a());
            controllerJson.put("like_count_string_with_like", controller.n);
            controllerJson.put("like_count_string_without_like", controller.o);
            controllerJson.put("social_sentence_with_like", controller.p);
            controllerJson.put("social_sentence_without_like", controller.q);
            controllerJson.put("is_object_liked", controller.m);
            controllerJson.put("unlike_token", controller.r);
            if (controller.w != null) {
                JSONObject analyticsJSON = vh.a(controller.w);
                if (analyticsJSON != null) {
                    controllerJson.put("facebook_dialog_analytics_bundle", analyticsJSON);
                }
            }
            return controllerJson.toString();
        } catch (JSONException e) {
            Log.e(a, "Unable to serialize controller to JSON", e);
            return null;
        }
    }

    private static String d(String objectId) {
        String accessTokenPortion = null;
        AccessToken accessToken = AccessToken.a();
        if (accessToken != null) {
            accessTokenPortion = accessToken.b();
        }
        if (accessTokenPortion != null) {
            accessTokenPortion = we.b(accessTokenPortion);
        }
        return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", new Object[]{objectId, we.a(accessTokenPortion, ""), Integer.valueOf(i)});
    }

    private static void d(ws controller, String action) {
        ws.c(controller, action, null);
    }

    private static void c(ws controller, String action, Bundle data) {
        Intent broadcastIntent = new Intent(action);
        if (controller != null) {
            if (data == null) {
                data = new Bundle();
            }
            data.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", controller.a());
        }
        if (data != null) {
            broadcastIntent.putExtras(data);
        }
        bn.a(ul.f()).a(broadcastIntent);
    }

    private ws(String objectId, ObjectType objectType) {
        this.k = objectId;
        this.l = objectType;
    }

    public String a() {
        return this.k;
    }

    public String b() {
        return this.m ? this.n : this.o;
    }

    public String c() {
        return this.m ? this.p : this.q;
    }

    public boolean d() {
        return this.m;
    }

    public boolean e() {
        if (wt.e() || wt.f()) {
            return true;
        }
        if (this.t || this.l == ObjectType.PAGE) {
            return false;
        }
        AccessToken token = AccessToken.a();
        if (token == null || token.d() == null || !token.d().contains("publish_actions")) {
            return false;
        }
        return true;
    }

    public void a(Activity activity, vq fragment, Bundle analyticsParameters) {
        boolean shouldLikeObject;
        boolean z = true;
        if (this.m) {
            shouldLikeObject = false;
        } else {
            shouldLikeObject = true;
        }
        if (n()) {
            b(shouldLikeObject);
            if (this.v) {
                l().a("fb_like_control_did_undo_quickly", null, analyticsParameters);
                return;
            } else if (!a(shouldLikeObject, analyticsParameters)) {
                if (shouldLikeObject) {
                    z = false;
                }
                b(z);
                b(activity, fragment, analyticsParameters);
                return;
            } else {
                return;
            }
        }
        b(activity, fragment, analyticsParameters);
    }

    private AppEventsLogger l() {
        if (this.x == null) {
            this.x = AppEventsLogger.a(ul.f());
        }
        return this.x;
    }

    private boolean a(boolean shouldLikeObject, Bundle analyticsParameters) {
        if (!n()) {
            return false;
        }
        if (shouldLikeObject) {
            c(analyticsParameters);
            return true;
        } else if (we.a(this.r)) {
            return false;
        } else {
            d(analyticsParameters);
            return true;
        }
    }

    private void a(boolean oldLikeState) {
        b(oldLikeState);
        Bundle errorBundle = new Bundle();
        errorBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
        ws.c(this, "com.facebook.sdk.LikeActionController.DID_ERROR", errorBundle);
    }

    private void b(boolean isObjectLiked) {
        a(isObjectLiked, this.n, this.o, this.p, this.q, this.r);
    }

    private void a(boolean isObjectLiked, String likeCountStringWithLike, String likeCountStringWithoutLike, String socialSentenceWithLike, String socialSentenceWithoutLike, String unlikeToken) {
        Object likeCountStringWithLike2 = we.a(likeCountStringWithLike, null);
        Object likeCountStringWithoutLike2 = we.a(likeCountStringWithoutLike, null);
        Object socialSentenceWithLike2 = we.a(socialSentenceWithLike, null);
        Object socialSentenceWithoutLike2 = we.a(socialSentenceWithoutLike, null);
        Object unlikeToken2 = we.a(unlikeToken, null);
        boolean stateChanged = (isObjectLiked == this.m && we.a(likeCountStringWithLike2, this.n) && we.a(likeCountStringWithoutLike2, this.o) && we.a(socialSentenceWithLike2, this.p) && we.a(socialSentenceWithoutLike2, this.q) && we.a(unlikeToken2, this.r)) ? false : true;
        if (stateChanged) {
            this.m = isObjectLiked;
            this.n = likeCountStringWithLike2;
            this.o = likeCountStringWithoutLike2;
            this.p = socialSentenceWithLike2;
            this.q = socialSentenceWithoutLike2;
            this.r = unlikeToken2;
            ws.l(this);
            ws.d(this, "com.facebook.sdk.LikeActionController.UPDATED");
        }
    }

    private void b(Activity activity, vq fragmentWrapper, Bundle analyticsParameters) {
        String analyticsEvent = null;
        if (wt.e()) {
            analyticsEvent = "fb_like_control_did_present_dialog";
        } else if (wt.f()) {
            analyticsEvent = "fb_like_control_did_present_fallback_dialog";
        } else {
            a("present_dialog", analyticsParameters);
            we.b(a, "Cannot show the Like Dialog on this device.");
            ws.d(null, "com.facebook.sdk.LikeActionController.UPDATED");
        }
        if (analyticsEvent != null) {
            String objectTypeString;
            if (this.l != null) {
                objectTypeString = this.l.toString();
            } else {
                objectTypeString = ObjectType.UNKNOWN.toString();
            }
            LikeContent likeContent = new a().a(this.k).b(objectTypeString).a();
            if (fragmentWrapper != null) {
                new wt(fragmentWrapper).b(likeContent);
            } else {
                new wt(activity).b(likeContent);
            }
            b(analyticsParameters);
            l().a("fb_like_control_did_present_dialog", null, analyticsParameters);
        }
    }

    private void b(int requestCode, int resultCode, Intent data) {
        wz.a(requestCode, resultCode, data, a(this.w));
        m();
    }

    private wx a(Bundle analyticsParameters) {
        return new ws$9(this, null, analyticsParameters);
    }

    private void b(Bundle analyticsParameters) {
        ws.e(this.k);
        this.w = analyticsParameters;
        ws.l(this);
    }

    private void m() {
        this.w = null;
        ws.e(null);
    }

    private static void e(String objectId) {
        g = objectId;
        ul.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", g).apply();
    }

    private boolean n() {
        AccessToken accessToken = AccessToken.a();
        return (this.t || this.s == null || accessToken == null || accessToken.d() == null || !accessToken.d().contains("publish_actions")) ? false : true;
    }

    private void c(Bundle analyticsParameters) {
        this.v = true;
        a(new ws$10(this, analyticsParameters));
    }

    private void d(Bundle analyticsParameters) {
        this.v = true;
        un requestBatch = new un();
        ws$l unlikeRequest = new ws$l(this, this.r);
        unlikeRequest.a(requestBatch);
        requestBatch.a(new ws$11(this, unlikeRequest, analyticsParameters));
        requestBatch.h();
    }

    private void o() {
        if (AccessToken.a() == null) {
            p();
        } else {
            a(new ws$12(this));
        }
    }

    private void p() {
        wu likeStatusClient = new wu(ul.f(), ul.i(), this.k);
        if (likeStatusClient.a()) {
            likeStatusClient.a(new ws$2(this));
        }
    }

    private void e(Bundle analyticsParameters) {
        if (this.m != this.u && !a(this.m, analyticsParameters)) {
            a(!this.m);
        }
    }

    private void a(ws$m completionHandler) {
        if (we.a(this.s)) {
            ws$e objectIdRequest = new ws$e(this, this.k, this.l);
            ws$g pageIdRequest = new ws$g(this, this.k, this.l);
            un requestBatch = new un();
            objectIdRequest.a(requestBatch);
            pageIdRequest.a(requestBatch);
            requestBatch.a(new ws$3(this, objectIdRequest, pageIdRequest, completionHandler));
            requestBatch.h();
        } else if (completionHandler != null) {
            completionHandler.a();
        }
    }

    private void a(String action, Bundle parameters) {
        Bundle logParams = new Bundle(parameters);
        logParams.putString("object_id", this.k);
        logParams.putString("object_type", this.l.toString());
        logParams.putString("current_action", action);
        l().a("fb_like_control_error", null, logParams);
    }

    private void a(String action, FacebookRequestError error) {
        Bundle logParams = new Bundle();
        if (error != null) {
            JSONObject requestResult = error.f();
            if (requestResult != null) {
                logParams.putString("error", requestResult.toString());
            }
        }
        a(action, logParams);
    }
}
