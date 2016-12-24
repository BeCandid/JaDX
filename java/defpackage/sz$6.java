package defpackage;

import android.app.Activity;

/* compiled from: CrashlyticsCore */
class sz$6 implements aoa$b<Boolean> {
    final /* synthetic */ sz a;

    sz$6(sz szVar) {
        this.a = szVar;
    }

    public /* synthetic */ Object b(aoc x0) {
        return a(x0);
    }

    public Boolean a(aoc settingsData) {
        boolean send = true;
        Activity activity = this.a.F().b();
        if (!(activity == null || activity.isFinishing() || !this.a.x())) {
            send = this.a.a(activity, settingsData.c);
        }
        return Boolean.valueOf(send);
    }
}
