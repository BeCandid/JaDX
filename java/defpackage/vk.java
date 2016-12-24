package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;

/* compiled from: DialogPresenter */
public class vk {
    public static void a(vf appCall) {
        vk.a(appCall, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    public static void a(vf appCall, FacebookException validationError) {
        vk.b(appCall, validationError);
    }

    public static void a(vf appCall, Activity activity) {
        activity.startActivityForResult(appCall.b(), appCall.d());
        appCall.e();
    }

    public static void a(vf appCall, vq fragmentWrapper) {
        fragmentWrapper.a(appCall.b(), appCall.d());
        appCall.e();
    }

    public static boolean a(vj feature) {
        return vk.c(feature) != -1;
    }

    public static boolean b(vj feature) {
        return vk.d(feature) != null;
    }

    public static void b(vf appCall, FacebookException exception) {
        if (exception != null) {
            wf.b(ul.f());
            Intent errorResultIntent = new Intent();
            errorResultIntent.setClass(ul.f(), FacebookActivity.class);
            errorResultIntent.setAction(FacebookActivity.a);
            vz.a(errorResultIntent, appCall.c().toString(), null, vz.a(), vz.a(exception));
            appCall.a(errorResultIntent);
        }
    }

    public static void a(vf appCall, String actionName, Bundle parameters) {
        wf.b(ul.f());
        wf.a(ul.f());
        Bundle intentParameters = new Bundle();
        intentParameters.putString("action", actionName);
        intentParameters.putBundle("params", parameters);
        Intent webDialogIntent = new Intent();
        vz.a(webDialogIntent, appCall.c().toString(), actionName, vz.a(), intentParameters);
        webDialogIntent.setClass(ul.f(), FacebookActivity.class);
        webDialogIntent.setAction("FacebookDialogFragment");
        appCall.a(webDialogIntent);
    }

    public static void a(vf appCall, Bundle parameters, vj feature) {
        wf.b(ul.f());
        wf.a(ul.f());
        String featureName = feature.name();
        Uri fallbackUrl = vk.d(feature);
        if (fallbackUrl == null) {
            throw new FacebookException("Unable to fetch the Url for the DialogFeature : '" + featureName + "'");
        }
        Bundle webParams = wc.a(appCall.c().toString(), vz.a(), parameters);
        if (webParams == null) {
            throw new FacebookException("Unable to fetch the app's key-hash");
        }
        if (fallbackUrl.isRelative()) {
            fallbackUrl = we.a(wc.a(), fallbackUrl.toString(), webParams);
        } else {
            fallbackUrl = we.a(fallbackUrl.getAuthority(), fallbackUrl.getPath(), webParams);
        }
        Bundle intentParameters = new Bundle();
        intentParameters.putString("url", fallbackUrl.toString());
        intentParameters.putBoolean("is_fallback", true);
        Intent webDialogIntent = new Intent();
        vz.a(webDialogIntent, appCall.c().toString(), feature.a(), vz.a(), intentParameters);
        webDialogIntent.setClass(ul.f(), FacebookActivity.class);
        webDialogIntent.setAction("FacebookDialogFragment");
        appCall.a(webDialogIntent);
    }

    public static void a(vf appCall, vk$a parameterProvider, vj feature) {
        Context context = ul.f();
        String action = feature.a();
        int protocolVersion = vk.c(feature);
        if (protocolVersion == -1) {
            throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
        }
        Bundle params;
        if (vz.a(protocolVersion)) {
            params = parameterProvider.a();
        } else {
            params = parameterProvider.b();
        }
        if (params == null) {
            params = new Bundle();
        }
        Intent intent = vz.a(context, appCall.c().toString(), action, protocolVersion, params);
        if (intent == null) {
            throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        appCall.a(intent);
    }

    private static Uri d(vj feature) {
        String featureName = feature.name();
        we$a config = we.a(ul.i(), feature.a(), featureName);
        if (config != null) {
            return config.c();
        }
        return null;
    }

    public static int c(vj feature) {
        String applicationId = ul.i();
        String action = feature.a();
        return vz.a(action, vk.a(applicationId, action, feature));
    }

    private static int[] a(String applicationId, String actionName, vj feature) {
        we$a config = we.a(applicationId, actionName, feature.name());
        if (config != null) {
            return config.d();
        }
        return new int[]{feature.b()};
    }
}
