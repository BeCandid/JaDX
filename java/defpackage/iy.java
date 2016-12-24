package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.becandid.candid.data.AppState;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareLinkContent.a;
import com.facebook.share.widget.ShareDialog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: ShareUtils */
public class iy {
    public static int a = 1;
    private static volatile iy b;
    private Context c;
    private String d;
    private Bitmap e;

    public void a(Context mContext) {
        this.c = mContext;
    }

    public void a(String mShareUrl) {
        this.d = mShareUrl;
    }

    public void a(Bitmap mBitmap) {
        this.e = mBitmap;
    }

    public static iy a() {
        if (b == null) {
            synchronized (iy.class) {
                if (b == null) {
                    b = new iy();
                }
            }
        }
        return b;
    }

    public static void a(Context context, String url, String title) {
        try {
            context.startActivity(iy.a(title, iy.b(url)));
        } catch (ActivityNotFoundException ex) {
            Log.d("ShareUtils", "Exception loading activity");
            ex.printStackTrace();
        }
    }

    private static Intent b(String url) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", url);
        return intent;
    }

    private static Intent a(String title, Intent intent) {
        Intent chooser = Intent.createChooser(intent, title);
        chooser.setFlags(268435456);
        return chooser;
    }

    public static void a(Context context, String shareUrl, String remoteUrl, ShareDialog shareDialog) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (remoteUrl != null && networkInfo.isConnected()) {
            new iy$a(context, shareUrl, shareDialog).execute(new String[]{remoteUrl});
        }
    }

    public void b() {
        Intent tweetIntent = new Intent("android.intent.action.SEND");
        tweetIntent.putExtra("android.intent.extra.TEXT", this.d);
        tweetIntent.setType("text/plain");
        boolean resolved = false;
        for (ResolveInfo resolveInfo : this.c.getPackageManager().queryIntentActivities(tweetIntent, 65536)) {
            if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                tweetIntent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                resolved = true;
                break;
            }
        }
        if (resolved) {
            new View(this.c).draw(new Canvas(this.e));
            Uri shareUri = Uri.parse(Media.insertImage(this.c.getContentResolver(), this.e, "Nur", null));
            if (shareUri != null) {
                tweetIntent.putExtra("android.intent.extra.STREAM", shareUri);
                tweetIntent.setType("image/*");
                tweetIntent.putExtra("android.intent.extra.TEXT", "");
                this.c.startActivity(tweetIntent);
                return;
            }
            return;
        }
        Intent i = new Intent();
        i.putExtra("android.intent.extra.TEXT", this.d);
        i.setAction("android.intent.action.VIEW");
        i.setData(Uri.parse("https://twitter.com/intent/tweet?text=" + iy.c(this.d)));
        this.c.startActivity(i);
        Toast.makeText(this.c, "Twitter app isn't found", 1).show();
    }

    private static String c(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static void b(Context context, String shareUrl, String imageUrl) {
        uj callbackManager = uj$a.a();
        ShareDialog shareDialog = new ShareDialog((Activity) context);
        shareDialog.a(callbackManager, new iy$1());
        if (AppState.config.getInt("android_share_post_as_link", 0) != 1) {
            iy.a(context, shareUrl, imageUrl, shareDialog);
        } else if (ShareDialog.a(ShareLinkContent.class)) {
            shareDialog.b(((a) new a().a(Uri.parse(shareUrl))).a());
        }
    }
}
