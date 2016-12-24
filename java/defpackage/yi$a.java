package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class yi$a extends yi$e<Boolean> {
    public final int a;
    public final Bundle b;
    final /* synthetic */ yi c;

    protected yi$a(yi yiVar, int i, Bundle bundle) {
        this.c = yiVar;
        super(yiVar, Boolean.valueOf(true));
        this.a = i;
        this.b = bundle;
    }

    protected abstract void a(ConnectionResult connectionResult);

    protected void a(Boolean bool) {
        PendingIntent pendingIntent = null;
        if (bool == null) {
            this.c.b(1, null);
            return;
        }
        switch (this.a) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                if (!a()) {
                    this.c.b(1, null);
                    a(new ConnectionResult(8, null));
                    return;
                }
                return;
            case uu$h.CardView_contentPaddingRight /*10*/:
                this.c.b(1, null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                this.c.b(1, null);
                if (this.b != null) {
                    pendingIntent = (PendingIntent) this.b.getParcelable("pendingIntent");
                }
                a(new ConnectionResult(this.a, pendingIntent));
                return;
        }
    }

    protected /* synthetic */ void a(Object obj) {
        a((Boolean) obj);
    }

    protected abstract boolean a();

    protected void b() {
    }
}
