package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public interface aff extends IInterface {
    int a() throws RemoteException;

    boolean a(aff aff) throws RemoteException;

    int b() throws RemoteException;

    List<IBinder> c() throws RemoteException;

    boolean d() throws RemoteException;

    int e() throws RemoteException;
}
