package defpackage;

import android.view.View;
import com.facebook.login.LoginClient.a;

/* compiled from: LoginFragment */
class wk$2 implements a {
    final /* synthetic */ View a;
    final /* synthetic */ wk b;

    wk$2(wk this$0, View view) {
        this.b = this$0;
        this.a = view;
    }

    public void a() {
        this.a.findViewById(uu$d.com_facebook_login_activity_progress_bar).setVisibility(0);
    }

    public void b() {
        this.a.findViewById(uu$d.com_facebook_login_activity_progress_bar).setVisibility(8);
    }
}
