package defpackage;

import java.util.List;

/* compiled from: ReportUploader */
class ts$a extends als {
    final /* synthetic */ ts a;
    private final float b;

    ts$a(ts tsVar, float delay) {
        this.a = tsVar;
        this.b = delay;
    }

    public void a() {
        try {
            b();
        } catch (Exception e) {
            akx.h().e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
        }
        this.a.f = null;
    }

    private void b() {
        akx.h().a("CrashlyticsCore", "Starting report processing in " + this.b + " second(s)...");
        if (this.b > 0.0f) {
            try {
                Thread.sleep((long) (this.b * 1000.0f));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        sz crashlyticsCore = sz.e();
        te handler = crashlyticsCore.o();
        List<tr> reports = this.a.a();
        if (!handler.a()) {
            if (reports.isEmpty() || crashlyticsCore.z()) {
                int retryCount = 0;
                while (!reports.isEmpty() && !sz.e().o().a()) {
                    akx.h().a("CrashlyticsCore", "Attempting to send " + reports.size() + " report(s)");
                    for (tr report : reports) {
                        this.a.a(report);
                    }
                    reports = this.a.a();
                    if (!reports.isEmpty()) {
                        int retryCount2 = retryCount + 1;
                        long interval = (long) ts.c[Math.min(retryCount, ts.c.length - 1)];
                        akx.h().a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + interval + " seconds");
                        try {
                            Thread.sleep(1000 * interval);
                            retryCount = retryCount2;
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
                return;
            }
            akx.h().a("CrashlyticsCore", "User declined to send. Removing " + reports.size() + " Report(s).");
            for (tr report2 : reports) {
                report2.a();
            }
        }
    }
}
