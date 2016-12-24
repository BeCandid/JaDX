package defpackage;

import android.annotation.TargetApi;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
/* compiled from: ActivityLifecycleCheckForUpdatesController */
class sm extends sl {
    private final akv$b a = new sm$1(this);
    private final ExecutorService b;

    public sm(akv lifecycleManager, ExecutorService executorService) {
        this.b = executorService;
        lifecycleManager.a(this.a);
    }
}
