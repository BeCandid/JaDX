package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

public interface aev extends IInterface {
    void a(StreetViewPanoramaLocation streetViewPanoramaLocation) throws RemoteException;
}
