package defpackage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: ReportUploader */
class ts {
    static final Map<String, String> a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    private static final FilenameFilter b = new ts$1();
    private static final short[] c = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    private final Object d = new Object();
    private final tg e;
    private Thread f;

    public ts(tg createReportCall) {
        if (createReportCall == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.e = createReportCall;
    }

    public synchronized void a(float delay) {
        if (this.f == null) {
            this.f = new Thread(new ts$a(this, delay), "Crashlytics Report Uploader");
            this.f.start();
        }
    }

    boolean a(tr report) {
        boolean removed = false;
        synchronized (this.d) {
            try {
                boolean sent = this.e.a(new tf(new alr().a(sz.e().E()), report));
                akx.h().c("CrashlyticsCore", "Crashlytics report upload " + (sent ? "complete: " : "FAILED: ") + report.b());
                if (sent) {
                    report.a();
                    removed = true;
                }
            } catch (Exception e) {
                akx.h().e("CrashlyticsCore", "Error occurred sending report " + report, e);
            }
        }
        return removed;
    }

    List<tr> a() {
        akx.h().a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.d) {
            File[] clsFiles = sz.e().w().listFiles(b);
        }
        List<tr> reports = new LinkedList();
        for (File file : clsFiles) {
            akx.h().a("CrashlyticsCore", "Found crash report " + file.getPath());
            reports.add(new tu(file));
        }
        if (reports.isEmpty()) {
            akx.h().a("CrashlyticsCore", "No reports found.");
        }
        return reports;
    }
}
