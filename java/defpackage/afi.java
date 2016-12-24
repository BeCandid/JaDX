package defpackage;

import android.os.IInterface;
import android.os.RemoteException;

public interface afi extends IInterface {
    void a() throws RemoteException;

    void a(float f) throws RemoteException;

    void a(boolean z) throws RemoteException;

    boolean a(afi afi) throws RemoteException;

    void b() throws RemoteException;

    void b(boolean z) throws RemoteException;

    String c() throws RemoteException;

    float d() throws RemoteException;

    boolean e() throws RemoteException;

    int f() throws RemoteException;

    boolean g() throws RemoteException;
}
