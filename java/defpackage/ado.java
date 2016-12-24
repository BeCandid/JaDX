package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public interface ado extends IInterface {
    aag a(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;

    StreetViewPanoramaOrientation a(aag aag) throws RemoteException;

    void a(aeu aeu) throws RemoteException;

    void a(aev aev) throws RemoteException;

    void a(aew aew) throws RemoteException;

    void a(aex aex) throws RemoteException;

    void a(LatLng latLng) throws RemoteException;

    void a(LatLng latLng, int i) throws RemoteException;

    void a(StreetViewPanoramaCamera streetViewPanoramaCamera, long j) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(boolean z) throws RemoteException;

    boolean a() throws RemoteException;

    void b(boolean z) throws RemoteException;

    boolean b() throws RemoteException;

    void c(boolean z) throws RemoteException;

    boolean c() throws RemoteException;

    void d(boolean z) throws RemoteException;

    boolean d() throws RemoteException;

    StreetViewPanoramaCamera e() throws RemoteException;

    StreetViewPanoramaLocation f() throws RemoteException;
}
