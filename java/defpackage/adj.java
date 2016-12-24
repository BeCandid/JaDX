package defpackage;

import android.location.Location;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

public interface adj extends IInterface {
    afb a(PolylineOptions polylineOptions) throws RemoteException;

    afd a(CircleOptions circleOptions) throws RemoteException;

    afe a(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    afg a(MarkerOptions markerOptions) throws RemoteException;

    afh a(PolygonOptions polygonOptions) throws RemoteException;

    afi a(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    CameraPosition a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2, int i3, int i4) throws RemoteException;

    void a(aag aag) throws RemoteException;

    void a(aag aag, int i, adz adz) throws RemoteException;

    void a(aag aag, adz adz) throws RemoteException;

    void a(adk adk) throws RemoteException;

    void a(adw adw, aag aag) throws RemoteException;

    void a(aeb aeb) throws RemoteException;

    void a(aec aec) throws RemoteException;

    void a(aed aed) throws RemoteException;

    void a(aee aee) throws RemoteException;

    void a(aef aef) throws RemoteException;

    void a(aeg aeg) throws RemoteException;

    void a(aeh aeh) throws RemoteException;

    void a(aej aej) throws RemoteException;

    void a(aek aek) throws RemoteException;

    void a(ael ael) throws RemoteException;

    void a(aem aem) throws RemoteException;

    void a(aen aen) throws RemoteException;

    void a(aeo aeo) throws RemoteException;

    void a(aep aep) throws RemoteException;

    void a(aeq aeq) throws RemoteException;

    void a(aer aer) throws RemoteException;

    void a(aes aes) throws RemoteException;

    void a(aet aet) throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(boolean z) throws RemoteException;

    float b() throws RemoteException;

    void b(aag aag) throws RemoteException;

    void b(Bundle bundle) throws RemoteException;

    boolean b(boolean z) throws RemoteException;

    float c() throws RemoteException;

    void c(Bundle bundle) throws RemoteException;

    void c(boolean z) throws RemoteException;

    void d() throws RemoteException;

    void d(boolean z) throws RemoteException;

    void e() throws RemoteException;

    int f() throws RemoteException;

    boolean g() throws RemoteException;

    boolean h() throws RemoteException;

    boolean i() throws RemoteException;

    Location j() throws RemoteException;

    adr k() throws RemoteException;

    adn l() throws RemoteException;

    boolean m() throws RemoteException;

    aff n() throws RemoteException;

    void o() throws RemoteException;

    void p() throws RemoteException;

    void q() throws RemoteException;

    void r() throws RemoteException;

    boolean s() throws RemoteException;

    void t() throws RemoteException;
}
