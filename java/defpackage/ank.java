package defpackage;

import android.content.res.Resources.NotFoundException;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.InputStream;
import java.util.Locale;

/* compiled from: AbstractAppSpiCall */
abstract class ank extends all {
    public ank(alc kit, String protocolAndHostOverride, String url, anb requestFactory, HttpMethod method) {
        super(kit, protocolAndHostOverride, url, requestFactory, method);
    }

    public boolean a(ann requestData) {
        HttpRequest httpRequest = b(a(b(), requestData), requestData);
        akx.h().a("Fabric", "Sending app info to " + a());
        if (requestData.j != null) {
            akx.h().a("Fabric", "App icon hash is " + requestData.j.a);
            akx.h().a("Fabric", "App icon size is " + requestData.j.c + "x" + requestData.j.d);
        }
        int statusCode = httpRequest.b();
        akx.h().a("Fabric", ("POST".equals(httpRequest.p()) ? "Create" : "Update") + " app request ID: " + httpRequest.b("X-REQUEST-ID"));
        akx.h().a("Fabric", "Result was " + statusCode);
        if (alz.a(statusCode) == 0) {
            return true;
        }
        return false;
    }

    private HttpRequest a(HttpRequest request, ann requestData) {
        return request.a("X-CRASHLYTICS-API-KEY", requestData.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
    }

    private HttpRequest b(HttpRequest request, ann requestData) {
        request = request.e("app[identifier]", requestData.b).e("app[name]", requestData.f).e("app[display_version]", requestData.c).e("app[build_version]", requestData.d).a("app[source]", Integer.valueOf(requestData.g)).e("app[minimum_sdk_version]", requestData.h).e("app[built_sdk_version]", requestData.i);
        if (!CommonUtils.c(requestData.e)) {
            request.e("app[instance_identifier]", requestData.e);
        }
        if (requestData.j != null) {
            InputStream inputStream = null;
            try {
                inputStream = this.a.E().getResources().openRawResource(requestData.j.b);
                request.e("app[icon][hash]", requestData.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", inputStream).a("app[icon][width]", Integer.valueOf(requestData.j.c)).a("app[icon][height]", Integer.valueOf(requestData.j.d));
            } catch (NotFoundException e) {
                akx.h().e("Fabric", "Failed to find app icon with resource ID: " + requestData.j.b, e);
            } finally {
                CommonUtils.a(inputStream, "Failed to close app icon InputStream.");
            }
        }
        if (requestData.k != null) {
            for (ale kit : requestData.k) {
                request.e(a(kit), kit.b());
                request.e(b(kit), kit.c());
            }
        }
        return request;
    }

    String a(ale kit) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{kit.a()});
    }

    String b(ale kit) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{kit.a()});
    }
}
