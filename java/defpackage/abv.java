package defpackage;

import android.content.Context;

public class abv {
    private static abv b = new abv();
    private abu a = null;

    public static abu b(Context context) {
        return b.a(context);
    }

    public synchronized abu a(Context context) {
        if (this.a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.a = new abu(context);
        }
        return this.a;
    }
}
