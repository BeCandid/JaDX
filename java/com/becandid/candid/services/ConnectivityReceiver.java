package com.becandid.candid.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.becandid.candid.GossipApplication;

public class ConnectivityReceiver extends BroadcastReceiver {
    public static a a;

    public interface a {
        void onNetworkConnectionChanged(boolean z);
    }

    public void onReceive(Context context, Intent arg1) {
        NetworkInfo activeNetwork = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if (a != null) {
            a.onNetworkConnectionChanged(isConnected);
        }
    }

    public static boolean a() {
        NetworkInfo activeNetwork = ((ConnectivityManager) GossipApplication.a().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
