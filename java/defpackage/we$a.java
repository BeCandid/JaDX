package defpackage;

import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Utility */
public class we$a {
    private String a;
    private String b;
    private Uri c;
    private int[] d;

    private static we$a b(JSONObject dialogConfigJSON) {
        String dialogNameWithFeature = dialogConfigJSON.optString("name");
        if (we.a(dialogNameWithFeature)) {
            return null;
        }
        String[] components = dialogNameWithFeature.split("\\|");
        if (components.length != 2) {
            return null;
        }
        String dialogName = components[0];
        String featureName = components[1];
        if (we.a(dialogName) || we.a(featureName)) {
            return null;
        }
        String urlString = dialogConfigJSON.optString("url");
        Uri fallbackUri = null;
        if (!we.a(urlString)) {
            fallbackUri = Uri.parse(urlString);
        }
        return new we$a(dialogName, featureName, fallbackUri, we$a.a(dialogConfigJSON.optJSONArray("versions")));
    }

    private static int[] a(JSONArray versionsJSON) {
        int[] versionSpec = null;
        if (versionsJSON != null) {
            int numVersions = versionsJSON.length();
            versionSpec = new int[numVersions];
            for (int i = 0; i < numVersions; i++) {
                int version = versionsJSON.optInt(i, -1);
                if (version == -1) {
                    String versionString = versionsJSON.optString(i);
                    if (!we.a(versionString)) {
                        try {
                            version = Integer.parseInt(versionString);
                        } catch (Exception nfe) {
                            we.a("FacebookSDK", nfe);
                            version = -1;
                        }
                    }
                }
                versionSpec[i] = version;
            }
        }
        return versionSpec;
    }

    private we$a(String dialogName, String featureName, Uri fallbackUrl, int[] featureVersionSpec) {
        this.a = dialogName;
        this.b = featureName;
        this.c = fallbackUrl;
        this.d = featureVersionSpec;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public Uri c() {
        return this.c;
    }

    public int[] d() {
        return this.d;
    }
}
