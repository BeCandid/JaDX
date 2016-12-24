package defpackage;

import android.os.Bundle;
import com.facebook.FacebookException;

/* compiled from: ResultProcessor */
public abstract class wx {
    private uk a;

    public abstract void a(vf vfVar, Bundle bundle);

    public wx(uk callback) {
        this.a = callback;
    }

    public void a(vf appCall) {
        if (this.a != null) {
            this.a.onCancel();
        }
    }

    public void a(vf appCall, FacebookException error) {
        if (this.a != null) {
            this.a.onError(error);
        }
    }
}
