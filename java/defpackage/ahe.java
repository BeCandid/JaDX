package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.measurement.internal.zzw;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class ahe extends agd {
    public ahe(ahk ahk) {
        super(ahk);
    }

    private byte[] a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected HttpURLConnection a(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout((int) y().I());
            httpURLConnection.setReadTimeout((int) y().J());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    protected void a(String str) {
    }

    public void a(String str, URL url, Map<String, String> map, ahe$a ahe_a) {
        j();
        c();
        xz.a((Object) url);
        xz.a((Object) ahe_a);
        v().b(new ahe$c(this, str, url, null, map, ahe_a));
    }

    public void a(String str, URL url, byte[] bArr, Map<String, String> map, ahe$a ahe_a) {
        j();
        c();
        xz.a((Object) url);
        xz.a((Object) bArr);
        xz.a((Object) ahe_a);
        v().b(new ahe$c(this, str, url, bArr, map, ahe_a));
    }

    protected void e() {
    }

    public boolean f() {
        NetworkInfo activeNetworkInfo;
        c();
        try {
            activeNetworkInfo = ((ConnectivityManager) q().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    protected void g() {
    }

    public /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public /* bridge */ /* synthetic */ agq k() {
        return super.k();
    }

    public /* bridge */ /* synthetic */ agf l() {
        return super.l();
    }

    public /* bridge */ /* synthetic */ ahb m() {
        return super.m();
    }

    public /* bridge */ /* synthetic */ agu n() {
        return super.n();
    }

    public /* bridge */ /* synthetic */ agg o() {
        return super.o();
    }

    public /* bridge */ /* synthetic */ zn p() {
        return super.p();
    }

    public /* bridge */ /* synthetic */ Context q() {
        return super.q();
    }

    public /* bridge */ /* synthetic */ ags r() {
        return super.r();
    }

    public /* bridge */ /* synthetic */ ago s() {
        return super.s();
    }

    public /* bridge */ /* synthetic */ ahj t() {
        return super.t();
    }

    public /* bridge */ /* synthetic */ agi u() {
        return super.u();
    }

    public /* bridge */ /* synthetic */ zzw v() {
        return super.v();
    }

    public /* bridge */ /* synthetic */ ahd w() {
        return super.w();
    }

    public /* bridge */ /* synthetic */ ahh x() {
        return super.x();
    }

    public /* bridge */ /* synthetic */ agr y() {
        return super.y();
    }
}
