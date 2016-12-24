package defpackage;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* compiled from: ActivityLifecycleManager */
class akv$a$1 implements ActivityLifecycleCallbacks {
    final /* synthetic */ akv$b a;
    final /* synthetic */ akv$a b;

    akv$a$1(akv$a akv_a, akv$b akv_b) {
        this.b = akv_a;
        this.a = akv_b;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.a.a(activity, bundle);
    }

    public void onActivityStarted(Activity activity) {
        this.a.a(activity);
    }

    public void onActivityResumed(Activity activity) {
        this.a.b(activity);
    }

    public void onActivityPaused(Activity activity) {
        this.a.c(activity);
    }

    public void onActivityStopped(Activity activity) {
        this.a.d(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.a.b(activity, bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        this.a.e(activity);
    }
}
