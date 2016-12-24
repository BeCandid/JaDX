package defpackage;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefaultSettingsController */
class ant implements aob {
    private final aof a;
    private final aoe b;
    private final alu c;
    private final anq d;
    private final aog e;
    private final alc f;
    private final ani g = new anj(this.f);

    public ant(alc kit, aof settingsRequest, alu currentTimeProvider, aoe settingsJsonTransform, anq cachedSettingsIo, aog settingsSpiCall) {
        this.f = kit;
        this.a = settingsRequest;
        this.c = currentTimeProvider;
        this.b = settingsJsonTransform;
        this.d = cachedSettingsIo;
        this.e = settingsSpiCall;
    }

    public aoc a() {
        return a(SettingsCacheBehavior.a);
    }

    public aoc a(SettingsCacheBehavior cacheBehavior) {
        aoc toReturn = null;
        try {
            if (!(akx.i() || d())) {
                toReturn = b(cacheBehavior);
            }
            if (toReturn == null) {
                JSONObject settingsJson = this.e.a(this.a);
                if (settingsJson != null) {
                    toReturn = this.b.a(this.c, settingsJson);
                    this.d.a(toReturn.g, settingsJson);
                    a(settingsJson, "Loaded settings: ");
                    a(b());
                }
            }
            if (toReturn == null) {
                toReturn = b(SettingsCacheBehavior.c);
            }
        } catch (Exception e) {
            akx.h().e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e);
        }
        return toReturn;
    }

    private aoc b(SettingsCacheBehavior cacheBehavior) {
        try {
            if (SettingsCacheBehavior.b.equals(cacheBehavior)) {
                return null;
            }
            JSONObject settingsJson = this.d.a();
            if (settingsJson != null) {
                aoc settingsData = this.b.a(this.c, settingsJson);
                if (settingsData != null) {
                    a(settingsJson, "Loaded cached settings: ");
                    long currentTimeMillis = this.c.a();
                    if (SettingsCacheBehavior.c.equals(cacheBehavior) || !settingsData.a(currentTimeMillis)) {
                        aoc toReturn = settingsData;
                        akx.h().a("Fabric", "Returning cached settings.");
                        return toReturn;
                    }
                    akx.h().a("Fabric", "Cached settings have expired.");
                    return null;
                }
                akx.h().e("Fabric", "Failed to transform cached settings data.", null);
                return null;
            }
            akx.h().a("Fabric", "No cached settings data found.");
            return null;
        } catch (Exception e) {
            akx.h().e("Fabric", "Failed to get cached settings", e);
            return null;
        }
    }

    private void a(JSONObject json, String message) throws JSONException {
        akx.h().a("Fabric", message + json.toString());
    }

    String b() {
        return CommonUtils.a(new String[]{CommonUtils.m(this.f.E())});
    }

    String c() {
        return this.g.a().getString("existing_instance_identifier", "");
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean a(String buildInstanceIdentifier) {
        Editor editor = this.g.b();
        editor.putString("existing_instance_identifier", buildInstanceIdentifier);
        return this.g.a(editor);
    }

    boolean d() {
        return !c().equals(b());
    }
}
