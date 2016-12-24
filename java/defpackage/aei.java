package defpackage;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;

public interface aei extends IInterface {
    void a(aag aag) throws RemoteException;

    void a(Location location) throws RemoteException;
}
