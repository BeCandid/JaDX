package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public interface aeu extends IInterface {
    void a(StreetViewPanoramaCamera streetViewPanoramaCamera) throws RemoteException;
}
