package defpackage;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

public class xy extends yt$a {
    int a;

    public static Account a(yt ytVar) {
        Account account = null;
        if (ytVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = ytVar.a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public Account a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.a) {
            if (aac.zze(null, callingUid)) {
                this.a = callingUid;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        Account account = null;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xy)) {
            return false;
        }
        xy xyVar = (xy) obj;
        return account.equals(account);
    }
}
