package defpackage;

import com.facebook.AccessToken;
import com.facebook.AccessToken.a;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AccessTokenManager */
class uh$4 implements un$a {
    final /* synthetic */ AccessToken a;
    final /* synthetic */ a b;
    final /* synthetic */ AtomicBoolean c;
    final /* synthetic */ uh$a d;
    final /* synthetic */ Set e;
    final /* synthetic */ Set f;
    final /* synthetic */ uh g;

    uh$4(uh this$0, AccessToken accessToken, a aVar, AtomicBoolean atomicBoolean, uh$a uh_a, Set set, Set set2) {
        this.g = this$0;
        this.a = accessToken;
        this.b = aVar;
        this.c = atomicBoolean;
        this.d = uh_a;
        this.e = set;
        this.f = set2;
    }

    public void a(un batch) {
        AccessToken newAccessToken;
        Throwable th;
        try {
            if (uh.a().b() == null || uh.a().b().i() != this.a.i()) {
                if (this.b != null) {
                    this.b.a(new FacebookException("No current access token to refresh"));
                }
                this.g.e.set(false);
                if (!(this.b == null || null == null)) {
                    this.b.a(null);
                }
                newAccessToken = null;
            } else if (!this.c.get() && this.d.a == null && this.d.b == 0) {
                if (this.b != null) {
                    this.b.a(new FacebookException("Failed to refresh access token"));
                }
                this.g.e.set(false);
                if (!(this.b == null || null == null)) {
                    this.b.a(null);
                }
                newAccessToken = null;
            } else {
                String str;
                Collection collection;
                Collection collection2;
                Date date;
                if (this.d.a != null) {
                    str = this.d.a;
                } else {
                    str = this.a.b();
                }
                String h = this.a.h();
                String i = this.a.i();
                if (this.c.get()) {
                    collection = this.e;
                } else {
                    collection = this.a.d();
                }
                if (this.c.get()) {
                    collection2 = this.f;
                } else {
                    collection2 = this.a.e();
                }
                AccessTokenSource f = this.a.f();
                if (this.d.b != 0) {
                    date = new Date(((long) this.d.b) * 1000);
                } else {
                    date = this.a.c();
                }
                newAccessToken = new AccessToken(str, h, i, collection, collection2, f, date, new Date());
                try {
                    uh.a().a(newAccessToken);
                    this.g.e.set(false);
                    if (this.b != null && newAccessToken != null) {
                        this.b.a(newAccessToken);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.g.e.set(false);
                    if (!(this.b == null || newAccessToken == null)) {
                        this.b.a(newAccessToken);
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            newAccessToken = null;
            this.g.e.set(false);
            this.b.a(newAccessToken);
            throw th;
        }
    }
}
