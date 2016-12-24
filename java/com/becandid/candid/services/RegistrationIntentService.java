package com.becandid.candid.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.becandid.candid.data.EmptyClass;
import defpackage.aal;
import defpackage.apr;
import defpackage.apv;
import defpackage.ik;
import java.io.IOException;
import rx.schedulers.Schedulers;

public class RegistrationIntentService extends IntentService {
    public RegistrationIntentService() {
        super("RegIntentService");
    }

    protected void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        try {
            String token = aal.c(this).a(getResources().getString(2131230847), "GCM");
            Log.d("RegIntentService", "GCM Registration Token: " + token);
            a(token);
            sharedPreferences.edit().putString("gcmToken", token).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void a(String token) {
        ik.a().c(token).a(apv.a()).b(Schedulers.io()).b(new apr<EmptyClass>(this) {
            final /* synthetic */ RegistrationIntentService a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((EmptyClass) obj);
            }

            public void onCompleted() {
                PreferenceManager.getDefaultSharedPreferences(this.a.getApplicationContext()).edit().putBoolean("sentTokenToServer", true).apply();
            }

            public void onError(Throwable e) {
            }

            public void a(EmptyClass emptyClass) {
            }
        });
    }
}
