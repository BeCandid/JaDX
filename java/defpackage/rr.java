package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;

/* compiled from: AnswersPreferenceManager */
class rr {
    private final ani a;

    public static rr a(Context context) {
        return new rr(new anj(context, "settings"));
    }

    rr(ani prefStore) {
        this.a = prefStore;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void a() {
        this.a.a(this.a.b().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean b() {
        return this.a.a().getBoolean("analytics_launched", false);
    }
}
