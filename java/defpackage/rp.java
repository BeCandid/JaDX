package defpackage;

import android.content.Context;
import android.os.Looper;
import java.io.IOException;

/* compiled from: AnswersFilesManagerProvider */
class rp {
    final Context a;
    final ang b;

    public rp(Context context, ang fileStore) {
        this.a = context;
        this.b = fileStore;
    }

    public sd a() throws IOException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        return new sd(this.a, new si(), new ama(), new amw(this.a, this.b.a(), "session_analytics.tap", "session_analytics_to_send"));
    }
}
