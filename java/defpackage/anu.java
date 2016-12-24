package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefaultSettingsJsonTransform */
class anu implements aoe {
    anu() {
    }

    public aoc a(alu currentTimeProvider, JSONObject json) throws JSONException {
        int settingsVersion = json.optInt("settings_version", 0);
        int cacheDuration = json.optInt("cache_duration", 3600);
        return new aoc(a(currentTimeProvider, (long) cacheDuration, json), a(json.getJSONObject("app")), e(json.getJSONObject("session")), f(json.getJSONObject("prompt")), c(json.getJSONObject("features")), d(json.getJSONObject("analytics")), g(json.getJSONObject("beta")), settingsVersion, cacheDuration);
    }

    private ano a(JSONObject json) throws JSONException {
        String identifier = json.getString("identifier");
        String status = json.getString("status");
        String url = json.getString("url");
        String reportsUrl = json.getString("reports_url");
        boolean updateRequired = json.optBoolean("update_required", false);
        anm icon = null;
        if (json.has("icon") && json.getJSONObject("icon").has("hash")) {
            icon = b(json.getJSONObject("icon"));
        }
        return new ano(identifier, status, url, reportsUrl, updateRequired, icon);
    }

    private anm b(JSONObject iconJson) throws JSONException {
        return new anm(iconJson.getString("hash"), iconJson.getInt("width"), iconJson.getInt("height"));
    }

    private anw c(JSONObject json) {
        return new anw(json.optBoolean("prompt_enabled", false), json.optBoolean("collect_logged_exceptions", true), json.optBoolean("collect_reports", true), json.optBoolean("collect_analytics", false));
    }

    private anl d(JSONObject json) {
        return new anl(json.optString("url", "https://e.crashlytics.com/spi/v2/events"), json.optInt("flush_interval_secs", 600), json.optInt("max_byte_size_per_file", 8000), json.optInt("max_file_count_per_send", 1), json.optInt("max_pending_send_file_count", 100), json.optBoolean("track_custom_events", true), json.optBoolean("track_predefined_events", true), json.optInt("sampling_rate", 1), json.optBoolean("flush_on_background", true));
    }

    private anz e(JSONObject json) throws JSONException {
        return new anz(json.optInt("log_buffer_size", 64000), json.optInt("max_chained_exception_depth", 8), json.optInt("max_custom_exception_events", 64), json.optInt("max_custom_key_value_pairs", 64), json.optInt("identifier_mask", 255), json.optBoolean("send_session_without_crash", false));
    }

    private any f(JSONObject json) throws JSONException {
        return new any(json.optString("title", "Send Crash Report?"), json.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), json.optString("send_button_title", "Send"), json.optBoolean("show_cancel_button", true), json.optString("cancel_button_title", "Don't Send"), json.optBoolean("show_always_send_button", true), json.optString("always_send_button_title", "Always Send"));
    }

    private anp g(JSONObject json) throws JSONException {
        return new anp(json.optString("update_endpoint", aod.a), json.optInt("update_suspend_duration", 3600));
    }

    private long a(alu currentTimeProvider, long cacheDurationSeconds, JSONObject json) throws JSONException {
        if (json.has("expires_at")) {
            return json.getLong("expires_at");
        }
        return currentTimeProvider.a() + (1000 * cacheDurationSeconds);
    }
}
