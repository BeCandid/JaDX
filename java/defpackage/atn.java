package defpackage;

import android.annotation.TargetApi;
import android.content.Context;

@TargetApi(14)
/* compiled from: IcsScroller */
public class atn extends atm {
    public atn(Context context) {
        super(context);
    }

    public boolean a() {
        return this.a.computeScrollOffset();
    }
}
