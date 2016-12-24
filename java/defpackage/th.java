package defpackage;

import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map.Entry;

/* compiled from: DefaultCreateReportSpiCall */
class th extends all implements tg {
    public th(alc kit, String protocolAndHostOverride, String url, anb requestFactory) {
        super(kit, protocolAndHostOverride, url, requestFactory, HttpMethod.b);
    }

    public boolean a(tf requestData) {
        HttpRequest httpRequest = b(a(b(), requestData), requestData);
        akx.h().a("CrashlyticsCore", "Sending report to: " + a());
        int statusCode = httpRequest.b();
        akx.h().a("CrashlyticsCore", "Create report request ID: " + httpRequest.b("X-REQUEST-ID"));
        akx.h().a("CrashlyticsCore", "Result was: " + statusCode);
        return alz.a(statusCode) == 0;
    }

    private HttpRequest a(HttpRequest request, tf requestData) {
        request = request.a("X-CRASHLYTICS-API-KEY", requestData.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", sz.e().a());
        for (Entry<String, String> entry : requestData.b.e().entrySet()) {
            request = request.a(entry);
        }
        return request;
    }

    private HttpRequest b(HttpRequest request, tf requestData) {
        tr report = requestData.b;
        return request.a("report[file]", report.b(), "application/octet-stream", report.d()).e("report[identifier]", report.c());
    }
}
