package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public abstract class yn implements OnClickListener {
    public static yn a(abj abj, Intent intent, int i) {
        return new yn$3(abj, intent, i);
    }

    public static yn a(Activity activity, Intent intent, int i) {
        return new yn$1(activity, intent, i);
    }

    public static yn a(Fragment fragment, Intent intent, int i) {
        return new yn$2(fragment, intent, i);
    }

    public abstract void a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            a();
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
