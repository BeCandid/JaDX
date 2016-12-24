package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.b;
import com.facebook.HttpMethod;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: Utility */
public final class we {
    private static final String[] a = new String[]{"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "gdpv4_chrome_custom_tabs_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout"};
    private static Map<String, we$b> b = new ConcurrentHashMap();
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static int d = 0;
    private static long e = -1;
    private static long f = -1;
    private static long g = -1;
    private static String h = "";
    private static String i = "";
    private static String j = "NoCarrier";

    public static <T> boolean a(Collection<T> c) {
        return c == null || c.size() == 0;
    }

    public static boolean a(String s) {
        return s == null || s.length() == 0;
    }

    public static String a(String s, String valueIfNullOrEmpty) {
        return we.a(s) ? valueIfNullOrEmpty : s;
    }

    public static <T> Collection<T> a(T... ts) {
        return Collections.unmodifiableCollection(Arrays.asList(ts));
    }

    public static String b(String key) {
        return we.c("MD5", key);
    }

    public static String a(byte[] bytes) {
        return we.a("SHA-1", bytes);
    }

    private static String c(String algorithm, String key) {
        return we.a(algorithm, key.getBytes());
    }

    private static String a(String algorithm, byte[] bytes) {
        try {
            return we.a(MessageDigest.getInstance(algorithm), bytes);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String a(MessageDigest hash, byte[] bytes) {
        hash.update(bytes);
        byte[] digest = hash.digest();
        StringBuilder builder = new StringBuilder();
        for (int b : digest) {
            builder.append(Integer.toHexString((b >> 4) & 15));
            builder.append(Integer.toHexString((b >> 0) & 15));
        }
        return builder.toString();
    }

    public static Uri a(String authority, String path, Bundle parameters) {
        Builder builder = new Builder();
        builder.scheme("https");
        builder.authority(authority);
        builder.path(path);
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                Object parameter = parameters.get(key);
                if (parameter instanceof String) {
                    builder.appendQueryParameter(key, (String) parameter);
                }
            }
        }
        return builder.build();
    }

    public static Bundle c(String queryString) {
        Bundle params = new Bundle();
        if (!we.a(queryString)) {
            for (String parameter : queryString.split("&")) {
                String[] keyValuePair = parameter.split("=");
                try {
                    if (keyValuePair.length == 2) {
                        params.putString(URLDecoder.decode(keyValuePair[0], "UTF-8"), URLDecoder.decode(keyValuePair[1], "UTF-8"));
                    } else if (keyValuePair.length == 1) {
                        params.putString(URLDecoder.decode(keyValuePair[0], "UTF-8"), "");
                    }
                } catch (Exception e) {
                    we.a("FacebookSDK", e);
                }
            }
        }
        return params;
    }

    public static void a(Bundle b, String key, String value) {
        if (!we.a(value)) {
            b.putString(key, value);
        }
    }

    public static void a(Bundle b, String key, Uri uri) {
        if (uri != null) {
            we.a(b, key, uri.toString());
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void a(URLConnection connection) {
        if (connection != null && (connection instanceof HttpURLConnection)) {
            ((HttpURLConnection) connection).disconnect();
        }
    }

    public static String a(Context context) {
        wf.a((Object) context, "context");
        ul.a(context);
        return ul.i();
    }

    public static Object a(JSONObject jsonObject, String key, String nonJSONPropertyKey) throws JSONException {
        JSONObject value = jsonObject.opt(key);
        if (value != null && (value instanceof String)) {
            value = new JSONTokener((String) value).nextValue();
        }
        if (value == null || (value instanceof JSONObject) || (value instanceof JSONArray)) {
            return value;
        }
        if (nonJSONPropertyKey != null) {
            jsonObject = new JSONObject();
            jsonObject.putOpt(nonJSONPropertyKey, value);
            return jsonObject;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    public static String a(InputStream inputStream) throws IOException {
        Throwable th;
        Closeable bufferedInputStream = null;
        Closeable reader = null;
        try {
            Closeable bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                Closeable reader2 = new InputStreamReader(bufferedInputStream2);
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    char[] buffer = new char[2048];
                    while (true) {
                        int n = reader2.read(buffer);
                        if (n != -1) {
                            stringBuilder.append(buffer, 0, n);
                        } else {
                            String stringBuilder2 = stringBuilder.toString();
                            we.a(bufferedInputStream2);
                            we.a(reader2);
                            return stringBuilder2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    reader = reader2;
                    bufferedInputStream = bufferedInputStream2;
                    we.a(bufferedInputStream);
                    we.a(reader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                we.a(bufferedInputStream);
                we.a(reader);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            we.a(bufferedInputStream);
            we.a(reader);
            throw th;
        }
    }

    public static int a(InputStream inputStream, OutputStream outputStream) throws IOException {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        int totalBytes = 0;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                byte[] buffer = new byte[8192];
                while (true) {
                    int bytesRead = bufferedInputStream2.read(buffer);
                    if (bytesRead == -1) {
                        break;
                    }
                    outputStream.write(buffer, 0, bytesRead);
                    totalBytes += bytesRead;
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return totalBytes;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    private static void b(Context context, String domain) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookies = cookieManager.getCookie(domain);
        if (cookies != null) {
            for (String cookie : cookies.split(";")) {
                String[] cookieParts = cookie.split("=");
                if (cookieParts.length > 0) {
                    cookieManager.setCookie(domain, cookieParts[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                }
            }
            cookieManager.removeExpiredCookie();
        }
    }

    public static void b(Context context) {
        we.b(context, "facebook.com");
        we.b(context, ".facebook.com");
        we.b(context, "https://facebook.com");
        we.b(context, "https://.facebook.com");
    }

    public static void a(String tag, Exception e) {
        if (ul.b() && tag != null && e != null) {
            Log.d(tag, e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    public static void b(String tag, String msg) {
        if (ul.b() && tag != null && msg != null) {
            Log.d(tag, msg);
        }
    }

    public static void a(String tag, String msg, Throwable t) {
        if (ul.b() && !we.a(tag)) {
            Log.d(tag, msg, t);
        }
    }

    public static <T> boolean a(T a, T b) {
        if (a == null) {
            return b == null;
        } else {
            return a.equals(b);
        }
    }

    public static void a(Context context, String applicationId) {
        boolean canStartLoading = c.compareAndSet(false, true);
        if (!we.a(applicationId) && !b.containsKey(applicationId) && canStartLoading) {
            ul.d().execute(new we$1(context, String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[]{applicationId}), applicationId));
        }
    }

    public static we$b d(String applicationId) {
        return applicationId != null ? (we$b) b.get(applicationId) : null;
    }

    public static we$b a(String applicationId, boolean forceRequery) {
        if (!forceRequery && b.containsKey(applicationId)) {
            return (we$b) b.get(applicationId);
        }
        JSONObject response = we.g(applicationId);
        if (response == null) {
            return null;
        }
        return we.b(applicationId, response);
    }

    private static we$b b(String applicationId, JSONObject settingsJSON) {
        vn errorClassification;
        JSONArray errorClassificationJSON = settingsJSON.optJSONArray("android_sdk_error_categories");
        if (errorClassificationJSON == null) {
            errorClassification = vn.a();
        } else {
            errorClassification = vn.a(errorClassificationJSON);
        }
        we$b result = new we$b(settingsJSON.optBoolean("supports_implicit_sdk_logging", false), settingsJSON.optString("gdpv4_nux_content", ""), settingsJSON.optBoolean("gdpv4_nux_enabled", false), settingsJSON.optBoolean("gdpv4_chrome_custom_tabs_enabled", false), settingsJSON.optInt("app_events_session_timeout", vd.a()), we.b(settingsJSON.optJSONObject("android_dialog_configs")), errorClassification, null);
        b.put(applicationId, result);
        return result;
    }

    private static JSONObject g(String applicationId) {
        Bundle appSettingsParams = new Bundle();
        appSettingsParams.putString("fields", TextUtils.join(",", a));
        GraphRequest request = GraphRequest.a(null, applicationId, null);
        request.a(true);
        request.a(appSettingsParams);
        return request.i().b();
    }

    public static we$a a(String applicationId, String actionName, String featureName) {
        if (we.a(actionName) || we.a(featureName)) {
            return null;
        }
        we$b settings = (we$b) b.get(applicationId);
        if (settings == null) {
            return null;
        }
        Map<String, we$a> featureMap = (Map) settings.e().get(actionName);
        if (featureMap != null) {
            return (we$a) featureMap.get(featureName);
        }
        return null;
    }

    private static Map<String, Map<String, we$a>> b(JSONObject dialogConfigResponse) {
        HashMap<String, Map<String, we$a>> dialogConfigMap = new HashMap();
        if (dialogConfigResponse != null) {
            JSONArray dialogConfigData = dialogConfigResponse.optJSONArray("data");
            if (dialogConfigData != null) {
                for (int i = 0; i < dialogConfigData.length(); i++) {
                    we$a dialogConfig = we$a.b(dialogConfigData.optJSONObject(i));
                    if (dialogConfig != null) {
                        String dialogName = dialogConfig.a();
                        Map<String, we$a> featureMap = (Map) dialogConfigMap.get(dialogName);
                        if (featureMap == null) {
                            featureMap = new HashMap();
                            dialogConfigMap.put(dialogName, featureMap);
                        }
                        featureMap.put(dialogConfig.b(), dialogConfig);
                    }
                }
            }
        }
        return dialogConfigMap;
    }

    public static String a(JSONObject response, String propertyName) {
        return response != null ? response.optString(propertyName, "") : "";
    }

    public static JSONObject b(JSONObject response, String propertyKey) {
        return response != null ? response.optJSONObject(propertyKey) : null;
    }

    public static JSONArray c(JSONObject response, String propertyKey) {
        return response != null ? response.optJSONArray(propertyKey) : null;
    }

    public static void a(File directoryOrFile) {
        if (directoryOrFile.exists()) {
            if (directoryOrFile.isDirectory()) {
                File[] children = directoryOrFile.listFiles();
                if (children != null) {
                    for (File child : children) {
                        we.a(child);
                    }
                }
            }
            directoryOrFile.delete();
        }
    }

    public static <T> List<T> b(T... array) {
        ArrayList<T> result = new ArrayList();
        for (T t : array) {
            if (t != null) {
                result.add(t);
            }
        }
        return result;
    }

    public static List<String> a(JSONArray jsonArray) throws JSONException {
        ArrayList<String> result = new ArrayList();
        for (int i = 0; i < jsonArray.length(); i++) {
            result.add(jsonArray.getString(i));
        }
        return result;
    }

    public static Set<String> b(JSONArray jsonArray) throws JSONException {
        Set<String> result = new HashSet();
        for (int i = 0; i < jsonArray.length(); i++) {
            result.add(jsonArray.getString(i));
        }
        return result;
    }

    public static void a(JSONObject params, vg attributionIdentifiers, String anonymousAppDeviceGUID, boolean limitEventUsage) throws JSONException {
        boolean z = true;
        if (!(attributionIdentifiers == null || attributionIdentifiers.a() == null)) {
            params.put("attribution", attributionIdentifiers.a());
        }
        if (!(attributionIdentifiers == null || attributionIdentifiers.b() == null)) {
            params.put("advertiser_id", attributionIdentifiers.b());
            params.put("advertiser_tracking_enabled", !attributionIdentifiers.d());
        }
        if (!(attributionIdentifiers == null || attributionIdentifiers.c() == null)) {
            params.put("installer_package", attributionIdentifiers.c());
        }
        params.put("anon_id", anonymousAppDeviceGUID);
        String str = "application_tracking_enabled";
        if (limitEventUsage) {
            z = false;
        }
        params.put(str, z);
    }

    public static void a(JSONObject params, Context appContext) throws JSONException {
        Locale locale;
        JSONArray extraInfoArray = new JSONArray();
        extraInfoArray.put("a2");
        we.d(appContext);
        String pkgName = appContext.getPackageName();
        int versionCode = -1;
        String versionName = "";
        try {
            PackageInfo pi = appContext.getPackageManager().getPackageInfo(pkgName, 0);
            versionCode = pi.versionCode;
            versionName = pi.versionName;
        } catch (NameNotFoundException e) {
        }
        extraInfoArray.put(pkgName);
        extraInfoArray.put(versionCode);
        extraInfoArray.put(versionName);
        extraInfoArray.put(VERSION.RELEASE);
        extraInfoArray.put(Build.MODEL);
        try {
            locale = appContext.getResources().getConfiguration().locale;
        } catch (Exception e2) {
            locale = Locale.getDefault();
        }
        extraInfoArray.put(locale.getLanguage() + "_" + locale.getCountry());
        extraInfoArray.put(h);
        extraInfoArray.put(j);
        int width = 0;
        int height = 0;
        double density = 0.0d;
        try {
            WindowManager wm = (WindowManager) appContext.getSystemService("window");
            if (wm != null) {
                Display display = wm.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getMetrics(displayMetrics);
                width = displayMetrics.widthPixels;
                height = displayMetrics.heightPixels;
                density = (double) displayMetrics.density;
            }
        } catch (Exception e3) {
        }
        extraInfoArray.put(width);
        extraInfoArray.put(height);
        extraInfoArray.put(String.format("%.2f", new Object[]{Double.valueOf(density)}));
        extraInfoArray.put(we.b());
        extraInfoArray.put(f);
        extraInfoArray.put(g);
        extraInfoArray.put(i);
        params.put("extinfo", extraInfoArray.toString());
    }

    public static Method a(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        try {
            return clazz.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method a(String className, String methodName, Class<?>... parameterTypes) {
        try {
            return we.a(Class.forName(className), methodName, (Class[]) parameterTypes);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static Object a(Object receiver, Method method, Object... args) {
        Object obj = null;
        try {
            obj = method.invoke(receiver, args);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return obj;
    }

    public static String c(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        return context.getClass().getSimpleName();
    }

    public static <T, K> List<K> a(List<T> target, we$d<T, K> mapper) {
        if (target == null) {
            return null;
        }
        List<K> list = new ArrayList();
        for (T item : target) {
            K mappedItem = mapper.a(item);
            if (mappedItem != null) {
                list.add(mappedItem);
            }
        }
        if (list.size() == 0) {
            list = null;
        }
        return list;
    }

    public static String a(Uri uri) {
        return uri == null ? null : uri.toString();
    }

    public static boolean b(Uri uri) {
        return uri != null && ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()));
    }

    public static boolean c(Uri uri) {
        return uri != null && "content".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean d(Uri uri) {
        return uri != null && "file".equalsIgnoreCase(uri.getScheme());
    }

    public static long e(Uri contentUri) {
        Cursor cursor = null;
        try {
            cursor = ul.f().getContentResolver().query(contentUri, null, null, null, null);
            int sizeIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            long j = cursor.getLong(sizeIndex);
            return j;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static Date a(Bundle bundle, String key, Date dateBase) {
        if (bundle == null) {
            return null;
        }
        long secondsFromBase;
        Object secondsObject = bundle.get(key);
        if (secondsObject instanceof Long) {
            secondsFromBase = ((Long) secondsObject).longValue();
        } else if (!(secondsObject instanceof String)) {
            return null;
        } else {
            try {
                secondsFromBase = Long.parseLong((String) secondsObject);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        if (secondsFromBase == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(dateBase.getTime() + (1000 * secondsFromBase));
    }

    public static void a(Parcel parcel, Map<String, String> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry<String, String> entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
    }

    public static Map<String, String> a(Parcel parcel) {
        int size = parcel.readInt();
        if (size < 0) {
            return null;
        }
        Map<String, String> map = new HashMap();
        for (int i = 0; i < size; i++) {
            map.put(parcel.readString(), parcel.readString());
        }
        return map;
    }

    public static boolean a(AccessToken token) {
        return token != null ? token.equals(AccessToken.a()) : false;
    }

    public static void a(String accessToken, we$c callback) {
        JSONObject cachedValue = wb.a(accessToken);
        if (cachedValue != null) {
            callback.a(cachedValue);
            return;
        }
        b graphCallback = new we$2(callback, accessToken);
        GraphRequest graphRequest = we.h(accessToken);
        graphRequest.a(graphCallback);
        graphRequest.j();
    }

    public static JSONObject e(String accessToken) {
        JSONObject cachedValue = wb.a(accessToken);
        if (cachedValue != null) {
            return cachedValue;
        }
        uo response = we.h(accessToken).i();
        if (response.a() != null) {
            return null;
        }
        return response.b();
    }

    private static GraphRequest h(String accessToken) {
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,first_name,middle_name,last_name,link");
        parameters.putString("access_token", accessToken);
        return new GraphRequest(null, "me", parameters, HttpMethod.GET, null);
    }

    private static int b() {
        if (d > 0) {
            return d;
        }
        try {
            File[] cpuFiles = new File("/sys/devices/system/cpu/").listFiles(new we$3());
            if (cpuFiles != null) {
                d = cpuFiles.length;
            }
        } catch (Exception e) {
        }
        if (d <= 0) {
            d = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return d;
    }

    private static void d(Context appContext) {
        if (e == -1 || System.currentTimeMillis() - e >= 1800000) {
            e = System.currentTimeMillis();
            we.c();
            we.e(appContext);
            we.f();
            we.e();
        }
    }

    private static void c() {
        try {
            TimeZone tz = TimeZone.getDefault();
            h = tz.getDisplayName(tz.inDaylightTime(new Date()), 0);
            i = tz.getID();
        } catch (Exception e) {
        }
    }

    private static void e(Context appContext) {
        if (j.equals("NoCarrier")) {
            try {
                j = ((TelephonyManager) appContext.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception e) {
            }
        }
    }

    private static boolean d() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static void e() {
        try {
            if (we.d()) {
                StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
                g = ((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize());
            }
            g = we.a((double) g);
        } catch (Exception e) {
        }
    }

    private static void f() {
        try {
            if (we.d()) {
                StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f = ((long) stat.getBlockCount()) * ((long) stat.getBlockSize());
            }
            f = we.a((double) f);
        } catch (Exception e) {
        }
    }

    private static long a(double bytes) {
        return Math.round(bytes / 1.073741824E9d);
    }

    public static we$e a(JSONObject result) throws JSONException {
        JSONArray data = result.getJSONObject("permissions").getJSONArray("data");
        List<String> grantedPermissions = new ArrayList(data.length());
        List<String> declinedPermissions = new ArrayList(data.length());
        for (int i = 0; i < data.length(); i++) {
            JSONObject object = data.optJSONObject(i);
            String permission = object.optString("permission");
            if (!(permission == null || permission.equals("installed"))) {
                String status = object.optString("status");
                if (status != null) {
                    if (status.equals("granted")) {
                        grantedPermissions.add(permission);
                    } else if (status.equals("declined")) {
                        declinedPermissions.add(permission);
                    }
                }
            }
        }
        return new we$e(grantedPermissions, declinedPermissions);
    }

    public static String a(int length) {
        return new BigInteger(length * 5, new Random()).toString(32);
    }
}
