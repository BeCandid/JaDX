package defpackage;

import android.graphics.Bitmap;
import android.os.IInterface;
import android.os.RemoteException;

public interface afc extends IInterface {
    aag a() throws RemoteException;

    aag a(float f) throws RemoteException;

    aag a(int i) throws RemoteException;

    aag a(Bitmap bitmap) throws RemoteException;

    aag a(String str) throws RemoteException;

    aag b(String str) throws RemoteException;

    aag c(String str) throws RemoteException;
}
