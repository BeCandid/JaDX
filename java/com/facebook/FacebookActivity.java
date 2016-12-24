package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;
import defpackage.ul;
import defpackage.uu$d;
import defpackage.uu$e;
import defpackage.vm;
import defpackage.vz;
import defpackage.we;
import defpackage.wk;
import defpackage.wm;

public class FacebookActivity extends FragmentActivity {
    public static String a = "PassThrough";
    private static String b = "SingleFragment";
    private static final String c = FacebookActivity.class.getName();
    private Fragment d;

    private static final String b() {
        return "fb" + ul.i() + "://authorize";
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!ul.a()) {
            Log.d(c, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            ul.a(getApplicationContext());
        }
        setContentView(uu$e.com_facebook_activity_layout);
        Intent intent = getIntent();
        if (a.equals(intent.getAction())) {
            c();
            return;
        }
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(b);
        if (fragment == null) {
            if ("FacebookDialogFragment".equals(intent.getAction())) {
                vm dialogFragment = new vm();
                dialogFragment.setRetainInstance(true);
                dialogFragment.show(manager, b);
                fragment = dialogFragment;
            } else if ("DeviceShareDialogFragment".equals(intent.getAction())) {
                DeviceShareDialogFragment dialogFragment2 = new DeviceShareDialogFragment();
                dialogFragment2.setRetainInstance(true);
                dialogFragment2.a((ShareContent) intent.getParcelableExtra("content"));
                dialogFragment2.show(manager, b);
                fragment = dialogFragment2;
            } else {
                fragment = new wk();
                fragment.setRetainInstance(true);
                manager.beginTransaction().add(uu$d.com_facebook_fragment_container, fragment, b).commit();
            }
        }
        this.d = fragment;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.d != null) {
            this.d.onConfigurationChanged(newConfig);
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent.getStringExtra("url"));
    }

    public Fragment a() {
        return this.d;
    }

    private void c() {
        a(null, vz.a(vz.d(getIntent())));
    }

    private void a(String url) {
        if (url != null && url.startsWith(b())) {
            Uri uri = Uri.parse(url);
            Bundle values = we.c(uri.getQuery());
            values.putAll(we.c(uri.getFragment()));
            if (!((this.d instanceof wk) && ((wk) this.d).a(values))) {
                a(null, new FacebookException("Invalid state parameter"));
            }
            String error = values.getString("error");
            if (error == null) {
                error = values.getString("error_type");
            }
            String errorMessage = values.getString("error_msg");
            if (errorMessage == null) {
                errorMessage = values.getString("error_message");
            }
            if (errorMessage == null) {
                errorMessage = values.getString("error_description");
            }
            String errorCodeString = values.getString("error_code");
            int errorCode = -1;
            if (!we.a(errorCodeString)) {
                try {
                    errorCode = Integer.parseInt(errorCodeString);
                } catch (NumberFormatException e) {
                    errorCode = -1;
                }
            }
            if (we.a(error) && we.a(errorMessage) && errorCode == -1) {
                a(values, null);
            } else if (error != null && (error.equals("access_denied") || error.equals("OAuthAccessDeniedException"))) {
                a(null, new FacebookOperationCanceledException());
            } else if (errorCode == 4201) {
                a(null, new FacebookOperationCanceledException());
            } else {
                a(null, new FacebookServiceException(new FacebookRequestError(errorCode, error, errorMessage), errorMessage));
            }
        }
    }

    public void a(Bundle results, FacebookException error) {
        int resultCode;
        Intent resultIntent = getIntent();
        if (error == null) {
            resultCode = -1;
            wm.a(resultIntent, results);
        } else {
            resultCode = 0;
            resultIntent = vz.a(resultIntent, results, error);
        }
        setResult(resultCode, resultIntent);
        finish();
    }
}
