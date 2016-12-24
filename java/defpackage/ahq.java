package defpackage;

import android.accounts.Account;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import com.google.android.gms.signin.internal.RecordConsentRequest;
import com.google.android.gms.signin.internal.SignInRequest;

public interface ahq extends IInterface {
    void a(int i) throws RemoteException;

    void a(int i, Account account, ahp ahp) throws RemoteException;

    void a(ahp ahp) throws RemoteException;

    void a(AuthAccountRequest authAccountRequest, ahp ahp) throws RemoteException;

    void a(ResolveAccountRequest resolveAccountRequest, yy yyVar) throws RemoteException;

    void a(CheckServerAuthResult checkServerAuthResult) throws RemoteException;

    void a(RecordConsentRequest recordConsentRequest, ahp ahp) throws RemoteException;

    void a(SignInRequest signInRequest, ahp ahp) throws RemoteException;

    void a(yt ytVar, int i, boolean z) throws RemoteException;

    void a(boolean z) throws RemoteException;
}
