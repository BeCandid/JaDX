package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public interface adn extends IInterface {
    aag a(LatLng latLng) throws RemoteException;

    LatLng a(aag aag) throws RemoteException;

    VisibleRegion a() throws RemoteException;
}
