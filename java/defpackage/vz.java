package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.login.DefaultAudience;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: NativeProtocol */
public final class vz {
    private static final String a = vz.class.getName();
    private static List<vz$c> b = vz.e();
    private static Map<String, List<vz$c>> c = vz.f();
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static final List<Integer> e = Arrays.asList(new Integer[]{Integer.valueOf(20160327), Integer.valueOf(20141218), Integer.valueOf(20141107), Integer.valueOf(20141028), Integer.valueOf(20141001), Integer.valueOf(20140701), Integer.valueOf(20140324), Integer.valueOf(20140204), Integer.valueOf(20131107), Integer.valueOf(20130618), Integer.valueOf(20130502), Integer.valueOf(20121101)});

    private static List<vz$c> e() {
        List<vz$c> list = new ArrayList();
        list.add(new vz$a(null));
        list.add(new vz$d(null));
        return list;
    }

    private static Map<String, List<vz$c>> f() {
        Map<String, List<vz$c>> map = new HashMap();
        ArrayList<vz$c> messengerAppInfoList = new ArrayList();
        messengerAppInfoList.add(new vz$b(null));
        map.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", b);
        map.put("com.facebook.platform.action.request.FEED_DIALOG", b);
        map.put("com.facebook.platform.action.request.LIKE_DIALOG", b);
        map.put("com.facebook.platform.action.request.APPINVITES_DIALOG", b);
        map.put("com.facebook.platform.action.request.MESSAGE_DIALOG", messengerAppInfoList);
        map.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", messengerAppInfoList);
        return map;
    }

    static Intent a(Context context, Intent intent, vz$c appInfo) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveInfo = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveInfo == null) {
            return null;
        }
        if (appInfo.a(context, resolveInfo.activityInfo.packageName)) {
            return intent;
        }
        return null;
    }

    static Intent b(Context context, Intent intent, vz$c appInfo) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveInfo = context.getPackageManager().resolveService(intent, 0);
        if (resolveInfo == null) {
            return null;
        }
        if (appInfo.a(context, resolveInfo.serviceInfo.packageName)) {
            return intent;
        }
        return null;
    }

    public static Intent a(Context context, String applicationId, Collection<String> permissions, String e2e, boolean isRerequest, boolean isForPublish, DefaultAudience defaultAudience, String clientState) {
        for (vz$c appInfo : b) {
            Intent intent = new Intent().setClassName(appInfo.a(), "com.facebook.katana.ProxyAuth").putExtra("client_id", applicationId);
            if (!we.a((Collection) permissions)) {
                intent.putExtra("scope", TextUtils.join(",", permissions));
            }
            if (!we.a(e2e)) {
                intent.putExtra("e2e", e2e);
            }
            intent.putExtra("state", clientState);
            intent.putExtra("response_type", "token,signed_request");
            intent.putExtra("return_scopes", "true");
            if (isForPublish) {
                intent.putExtra("default_audience", defaultAudience.a());
            }
            intent.putExtra("legacy_override", "v2.6");
            if (isRerequest) {
                intent.putExtra("auth_type", "rerequest");
            }
            intent = vz.a(context, intent, appInfo);
            if (intent != null) {
                return intent;
            }
        }
        return null;
    }

    public static final int a() {
        return ((Integer) e.get(0)).intValue();
    }

    private static Intent a(Context context, String activityAction, String internalAction) {
        List<vz$c> list = (List) c.get(internalAction);
        if (list == null) {
            return null;
        }
        Intent intent = null;
        for (vz$c appInfo : list) {
            intent = vz.a(context, new Intent().setAction(activityAction).setPackage(appInfo.a()).addCategory("android.intent.category.DEFAULT"), appInfo);
            if (intent != null) {
                return intent;
            }
        }
        return intent;
    }

    public static boolean a(int version) {
        return e.contains(Integer.valueOf(version)) && version >= 20140701;
    }

    public static Intent a(Context context, String callId, String action, int version, Bundle extras) {
        Intent intent = vz.a(context, "com.facebook.platform.PLATFORM_ACTIVITY", action);
        if (intent == null) {
            return null;
        }
        vz.a(intent, callId, action, version, extras);
        return intent;
    }

    public static void a(Intent intent, String callId, String action, int version, Bundle params) {
        String applicationId = ul.i();
        String applicationName = ul.j();
        intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", version).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", action).putExtra("com.facebook.platform.extra.APPLICATION_ID", applicationId);
        if (vz.a(version)) {
            Bundle methodArguments;
            Bundle bridgeArguments = new Bundle();
            bridgeArguments.putString("action_id", callId);
            we.a(bridgeArguments, "app_name", applicationName);
            intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bridgeArguments);
            if (params == null) {
                methodArguments = new Bundle();
            } else {
                methodArguments = params;
            }
            intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", methodArguments);
            return;
        }
        intent.putExtra("com.facebook.platform.protocol.CALL_ID", callId);
        if (!we.a(applicationName)) {
            intent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", applicationName);
        }
        intent.putExtras(params);
    }

    public static Intent a(Intent requestIntent, Bundle results, FacebookException error) {
        UUID callId = vz.b(requestIntent);
        if (callId == null) {
            return null;
        }
        Intent resultIntent = new Intent();
        resultIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", vz.a(requestIntent));
        Bundle bridgeArguments = new Bundle();
        bridgeArguments.putString("action_id", callId.toString());
        if (error != null) {
            bridgeArguments.putBundle("error", vz.a(error));
        }
        resultIntent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bridgeArguments);
        if (results == null) {
            return resultIntent;
        }
        resultIntent.putExtra("com.facebook.platform.protocol.RESULT_ARGS", results);
        return resultIntent;
    }

    public static Intent a(Context context) {
        for (vz$c appInfo : b) {
            Intent intent = vz.b(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(appInfo.a()).addCategory("android.intent.category.DEFAULT"), appInfo);
            if (intent != null) {
                return intent;
            }
        }
        return null;
    }

    public static int a(Intent intent) {
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    }

    public static UUID b(Intent intent) {
        if (intent == null) {
            return null;
        }
        String callIdString = null;
        if (vz.a(vz.a(intent))) {
            Bundle bridgeArgs = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
            if (bridgeArgs != null) {
                callIdString = bridgeArgs.getString("action_id");
            }
        } else {
            callIdString = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        }
        UUID callId = null;
        if (callIdString == null) {
            return callId;
        }
        try {
            return UUID.fromString(callIdString);
        } catch (IllegalArgumentException e) {
            return callId;
        }
    }

    public static Bundle c(Intent intent) {
        if (vz.a(vz.a(intent))) {
            return intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
        }
        return null;
    }

    public static Bundle d(Intent intent) {
        if (vz.a(vz.a(intent))) {
            return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
        }
        return intent.getExtras();
    }

    public static Bundle e(Intent resultIntent) {
        int version = vz.a(resultIntent);
        Bundle extras = resultIntent.getExtras();
        return (!vz.a(version) || extras == null) ? extras : extras.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
    }

    public static boolean f(Intent resultIntent) {
        Bundle bridgeArgs = vz.c(resultIntent);
        if (bridgeArgs != null) {
            return bridgeArgs.containsKey("error");
        }
        return resultIntent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
    }

    public static Bundle g(Intent resultIntent) {
        if (!vz.f(resultIntent)) {
            return null;
        }
        Bundle bridgeArgs = vz.c(resultIntent);
        if (bridgeArgs != null) {
            return bridgeArgs.getBundle("error");
        }
        return resultIntent.getExtras();
    }

    public static FacebookException a(Bundle errorData) {
        if (errorData == null) {
            return null;
        }
        String type = errorData.getString("error_type");
        if (type == null) {
            type = errorData.getString("com.facebook.platform.status.ERROR_TYPE");
        }
        String description = errorData.getString("error_description");
        if (description == null) {
            description = errorData.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
        }
        if (type == null || !type.equalsIgnoreCase("UserCanceled")) {
            return new FacebookException(description);
        }
        return new FacebookOperationCanceledException(description);
    }

    public static Bundle a(FacebookException e) {
        if (e == null) {
            return null;
        }
        Bundle errorBundle = new Bundle();
        errorBundle.putString("error_description", e.toString());
        if (!(e instanceof FacebookOperationCanceledException)) {
            return errorBundle;
        }
        errorBundle.putString("error_type", "UserCanceled");
        return errorBundle;
    }

    public static int b(int minimumVersion) {
        return vz.a(b, new int[]{minimumVersion});
    }

    public static int a(String action, int[] versionSpec) {
        return vz.a((List) c.get(action), versionSpec);
    }

    private static int a(List<vz$c> appInfoList, int[] versionSpec) {
        vz.b();
        if (appInfoList == null) {
            return -1;
        }
        for (vz$c appInfo : appInfoList) {
            int protocolVersion = vz.a(appInfo.b(), vz.a(), versionSpec);
            if (protocolVersion != -1) {
                return protocolVersion;
            }
        }
        return -1;
    }

    public static void b() {
        if (d.compareAndSet(false, true)) {
            ul.d().execute(new vz$1());
        }
    }

    private static TreeSet<Integer> b(vz$c appInfo) {
        TreeSet<Integer> allAvailableVersions = new TreeSet();
        ContentResolver contentResolver = ul.f().getContentResolver();
        String[] projection = new String[]{"version"};
        Uri uri = vz.c(appInfo);
        Cursor c = null;
        if (ul.f().getPackageManager().resolveContentProvider(appInfo.a() + ".provider.PlatformProvider", 0) != null) {
            try {
                c = contentResolver.query(uri, projection, null, null, null);
            } catch (NullPointerException e) {
                try {
                    Log.e(a, "Failed to query content resolver.");
                    c = null;
                    if (c != null) {
                        while (c.moveToNext()) {
                            allAvailableVersions.add(Integer.valueOf(c.getInt(c.getColumnIndex("version"))));
                        }
                    }
                    if (c != null) {
                        c.close();
                    }
                    return allAvailableVersions;
                } catch (Throwable th) {
                    if (c != null) {
                        c.close();
                    }
                }
            } catch (SecurityException e2) {
                Log.e(a, "Failed to query content resolver.");
                c = null;
                if (c != null) {
                    while (c.moveToNext()) {
                        allAvailableVersions.add(Integer.valueOf(c.getInt(c.getColumnIndex("version"))));
                    }
                }
                if (c != null) {
                    c.close();
                }
                return allAvailableVersions;
            }
            if (c != null) {
                while (c.moveToNext()) {
                    allAvailableVersions.add(Integer.valueOf(c.getInt(c.getColumnIndex("version"))));
                }
            }
        }
        if (c != null) {
            c.close();
        }
        return allAvailableVersions;
    }

    public static int a(TreeSet<Integer> allAvailableFacebookAppVersions, int latestSdkVersion, int[] versionSpec) {
        int versionSpecIndex = versionSpec.length - 1;
        Iterator<Integer> fbAppVersionsIterator = allAvailableFacebookAppVersions.descendingIterator();
        int latestFacebookAppVersion = -1;
        while (fbAppVersionsIterator.hasNext()) {
            int fbAppVersion = ((Integer) fbAppVersionsIterator.next()).intValue();
            latestFacebookAppVersion = Math.max(latestFacebookAppVersion, fbAppVersion);
            while (versionSpecIndex >= 0 && versionSpec[versionSpecIndex] > fbAppVersion) {
                versionSpecIndex--;
            }
            if (versionSpecIndex < 0) {
                return -1;
            }
            if (versionSpec[versionSpecIndex] == fbAppVersion) {
                return versionSpecIndex % 2 == 0 ? Math.min(latestFacebookAppVersion, latestSdkVersion) : -1;
            }
        }
        return -1;
    }

    private static Uri c(vz$c appInfo) {
        return Uri.parse("content://" + appInfo.a() + ".provider.PlatformProvider/versions");
    }
}
