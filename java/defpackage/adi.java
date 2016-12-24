package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface adi extends IInterface {
    aag a() throws RemoteException;

    aag a(float f) throws RemoteException;

    aag a(float f, float f2) throws RemoteException;

    aag a(float f, int i, int i2) throws RemoteException;

    aag a(CameraPosition cameraPosition) throws RemoteException;

    aag a(LatLng latLng) throws RemoteException;

    aag a(LatLng latLng, float f) throws RemoteException;

    aag a(LatLngBounds latLngBounds, int i) throws RemoteException;

    aag a(LatLngBounds latLngBounds, int i, int i2, int i3) throws RemoteException;

    aag b() throws RemoteException;

    aag b(float f) throws RemoteException;
}
