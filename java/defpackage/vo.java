package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONObject;

/* compiled from: FacebookWebFallbackDialog */
public class vo extends wg {
    private static final String a = vo.class.getName();
    private boolean b;

    public vo(Context context, String url, String expectedRedirectUrl) {
        super(context, url);
        b(expectedRedirectUrl);
    }

    protected Bundle a(String url) {
        Bundle queryParams = we.c(Uri.parse(url).getQuery());
        String bridgeArgsJSONString = queryParams.getString("bridge_args");
        queryParams.remove("bridge_args");
        if (!we.a(bridgeArgsJSONString)) {
            try {
                queryParams.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", vh.a(new JSONObject(bridgeArgsJSONString)));
            } catch (Throwable je) {
                we.a(a, "Unable to parse bridge_args JSON", je);
            }
        }
        String methodResultsJSONString = queryParams.getString("method_results");
        queryParams.remove("method_results");
        if (!we.a(methodResultsJSONString)) {
            if (we.a(methodResultsJSONString)) {
                methodResultsJSONString = "{}";
            }
            try {
                queryParams.putBundle("com.facebook.platform.protocol.RESULT_ARGS", vh.a(new JSONObject(methodResultsJSONString)));
            } catch (Throwable je2) {
                we.a(a, "Unable to parse bridge_args JSON", je2);
            }
        }
        queryParams.remove("version");
        queryParams.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", vz.a());
        return queryParams;
    }

    public void cancel() {
        WebView webView = c();
        if (!b() || a() || webView == null || !webView.isShown()) {
            super.cancel();
        } else if (!this.b) {
            this.b = true;
            webView.loadUrl("javascript:" + "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
            new Handler(Looper.getMainLooper()).postDelayed(new vo$1(this), 1500);
        }
    }
}
