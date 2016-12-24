package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class ady {
    private static Context a;
    private static aea b;

    public static aea a(Context context) throws GooglePlayServicesNotAvailableException {
        za.zzz(context);
        if (b != null) {
            return b;
        }
        ady.b(context);
        b = ady.c(context);
        try {
            b.a(aah.zzC(ady.d(context).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static <T> T a(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static <T> T a(ClassLoader classLoader, String str) {
        try {
            return ady.a(((ClassLoader) za.zzz(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    public static boolean a() {
        return false;
    }

    private static Class<?> b() {
        try {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static void b(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    private static aea c(Context context) {
        if (ady.a()) {
            Log.i(ady.class.getSimpleName(), "Making Creator statically");
            return (aea) ady.a(ady.b());
        }
        Log.i(ady.class.getSimpleName(), "Making Creator dynamically");
        return aea$a.a((IBinder) ady.a(ady.d(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    private static Context d(Context context) {
        if (a == null) {
            if (ady.a()) {
                a = context.getApplicationContext();
            } else {
                a = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return a;
    }
}
