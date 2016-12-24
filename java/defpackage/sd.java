package defpackage;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import java.io.IOException;
import java.util.UUID;

/* compiled from: SessionAnalyticsFilesManager */
class sd extends amr<SessionEvent> {
    private anl g;

    sd(Context context, si transform, alu currentTimeProvider, ams eventStorage) throws IOException {
        super(context, transform, currentTimeProvider, eventStorage, 100);
    }

    protected String a() {
        return "sa" + "_" + UUID.randomUUID().toString() + "_" + this.c.a() + ".tap";
    }

    protected int b() {
        return this.g == null ? super.b() : this.g.e;
    }

    protected int c() {
        return this.g == null ? super.c() : this.g.c;
    }

    void a(anl analyticsSettingsData) {
        this.g = analyticsSettingsData;
    }
}
