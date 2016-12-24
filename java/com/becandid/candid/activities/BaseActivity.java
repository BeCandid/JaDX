package com.becandid.candid.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.InviteContactsActivity.InviteFlowTypes;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.JoinedFacebookData;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.services.ConnectivityReceiver;
import com.becandid.candid.services.ConnectivityReceiver.a;
import com.facebook.AccessToken;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import defpackage.ain;
import defpackage.apl;
import defpackage.apr;
import defpackage.aps;
import defpackage.apv;
import defpackage.aqd;
import defpackage.ik;
import defpackage.in$ac;
import defpackage.in$ao;
import defpackage.in$ap;
import defpackage.in$au;
import defpackage.in$m;
import defpackage.in$v;
import defpackage.it;
import defpackage.ix;
import defpackage.iy;
import defpackage.rj;
import defpackage.uj;
import defpackage.uj$a;
import defpackage.uk;
import defpackage.wm;
import defpackage.wn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import rx.schedulers.Schedulers;

public class BaseActivity extends AppCompatActivity implements a {
    public static final int PERMISSION_WRITE_EXTERNAL_STORAGE = 1104;
    public static final int UPSELL_FEED = 1104;
    public static final int UPSELL_GROUP = 929;
    View a;
    public uj callbackManager;
    protected ArrayList<aps> eventSubscriptions = new ArrayList();
    public boolean isStopped;
    public boolean keyboardOpen;
    protected aps mSubscription;
    protected it photoHelper;

    public void enableKeyboardEvents(final View root) {
        this.a = root;
        Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);
        root.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ BaseActivity c;

            public void onGlobalLayout() {
                int height = root.getHeight();
                if (height < size.y - 100 && !this.c.keyboardOpen) {
                    this.c.keyboardOpen = true;
                    this.c.keyboardOpened();
                } else if (height >= size.y - 100 && this.c.keyboardOpen) {
                    this.c.keyboardOpen = false;
                    this.c.keyboardClosed();
                }
            }
        });
    }

    protected void keyboardOpened() {
    }

    protected void keyboardClosed() {
    }

    public void closeKeyboard() {
        closeKeyboard(this.a);
    }

    public void closeKeyboard(View view) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void openKeyboard() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(1, 1);
    }

    public void backNavClick(View backNav) {
        onBackPressed();
    }

    protected void busSubscribe(aps subscription) {
        this.eventSubscriptions.add(subscription);
    }

    protected <T> void busSubscribe(Class<T> eventClass, apr<T> subscriber) {
        this.eventSubscriptions.add(ix.a().a((Class) eventClass, (apr) subscriber));
    }

    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        this.isStopped = false;
        a();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GossipApplication application = (GossipApplication) getApplication();
        Bundle args = getIntent().getExtras();
        if (args != null && args.containsKey("click_notification")) {
            ik.a().j(args.getString("click_notification")).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        }
        busSubscribe(in$ao.class, new apr<in$ao>(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void onNext(in$ao twitterReady) {
                iy.a().b();
            }
        });
        busSubscribe(in$ac.class, new apr<in$ac>(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$ac e) {
                Toast.makeText(GossipApplication.a().getApplicationContext(), 2131230887, 0).show();
            }
        });
        busSubscribe(in$ap.class, new apr<in$ap>(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void onNext(in$ap e) {
                Toast.makeText(GossipApplication.a().getApplicationContext(), 2131230941, 0).show();
            }
        });
        a();
    }

    private void a() {
        showSnack(ConnectivityReceiver.a());
    }

    protected void showSnack(boolean isConnected) {
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle args = intent.getExtras();
        if (args != null && args.containsKey("click_notification")) {
            ik.a().j(args.getString("click_notification")).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        }
    }

    protected void onResume() {
        super.onResume();
        GossipApplication.a().a((a) this);
    }

    protected void onStart() {
        super.onStart();
        this.isStopped = false;
    }

    protected void onStop() {
        super.onStop();
        this.isStopped = true;
    }

    protected void onDestroy() {
        super.onDestroy();
        Iterator it = this.eventSubscriptions.iterator();
        while (it.hasNext()) {
            ((aps) it.next()).unsubscribe();
        }
    }

    public void addToSubscriptionList(aps subscription) {
        this.eventSubscriptions.add(subscription);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.photoHelper != null) {
            this.photoHelper.a(requestCode, resultCode, data);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (this.photoHelper != null) {
            this.photoHelper.a(requestCode, permissions, grantResults);
        }
        if (requestCode == 1989 && grantResults.length > 0 && grantResults[0] == 0) {
            ix.a().a(new in$ao());
        }
    }

    public it getPhotoHelper() {
        if (this.photoHelper == null) {
            this.photoHelper = new it(this);
        }
        return this.photoHelper;
    }

    public void setPhotoHelper(it photoHelper) {
        this.photoHelper = photoHelper;
    }

    public void onPhotoChosen(String url, int width, int height) {
    }

    protected void getRxSubscription() {
        this.mSubscription = null;
    }

    public void skipUpsell(int upsellId, int groupId) {
        ik.a().g(Integer.toString(upsellId) + "," + Integer.toString(groupId)).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        upsellChange(upsellId);
    }

    public void skipUpsell(int upsellId) {
        ik.a().g(Integer.toString(upsellId)).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        upsellChange(upsellId);
    }

    public void inviteFriends(final int upsellId, final int groupId) {
        new Builder(this).setTitle("Invite Candid Friends").setMessage("Do you want to anonymously recommend this group to your friends on Candid?").setCancelable(true).setNegativeButton(getResources().getString(2131230890), new OnClickListener(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = this$0;
            }

            public void onClick(DialogInterface dialog, int which) {
            }
        }).setPositiveButton(getResources().getString(2131230953), new OnClickListener(this) {
            final /* synthetic */ BaseActivity c;

            public void onClick(DialogInterface dialog, int which) {
                ik.a().e(groupId).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                this.c.upsellChange(upsellId);
                Toast.makeText(this.c.getBaseContext(), "Your friends have been notified. Thanks!", 1).show();
            }
        }).create().show();
    }

    public void showContactsDialog(int upsellId, int groupId) {
        Intent intent = new Intent(this, InviteContactsActivity.class);
        intent.putExtra("invite_type", InviteFlowTypes.GROUP.toString());
        intent.putExtra("groupId", groupId);
        intent.putExtra("upsellId", upsellId);
        startActivityForResult(intent, UPSELL_GROUP);
    }

    public void upsellChange(int upsellId) {
    }

    public void showConnectAccount(int upsellId) {
        Intent intent = new Intent(this, OnboardingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_facebook_last_fragment", true);
        bundle.putString("first_fragment", "phone");
        bundle.putString("second_fragment", "fb");
        intent.putExtras(bundle);
        startActivityForResult(intent, UPSELL_FEED);
    }

    public void showPhoneConnect(int upsellId) {
        Intent intent = new Intent(this, OnboardingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("first_fragment", "phone");
        bundle.putString("second_fragment", "phone");
        intent.putExtras(bundle);
        startActivityForResult(intent, UPSELL_FEED);
    }

    public void showContactsDialog(int upsellId) {
        Intent intent = new Intent(this, InviteContactsActivity.class);
        intent.putExtra("invite_type", InviteFlowTypes.DOWNLOAD.toString());
        intent.putExtra("upsellId", upsellId);
        startActivityForResult(intent, UPSELL_GROUP);
    }

    public void connectFacebook(int upsellId) {
        if (this.callbackManager == null) {
            this.callbackManager = uj$a.a();
            wm.c().a(this.callbackManager, new uk<wn>(this) {
                final /* synthetic */ BaseActivity a;

                {
                    this.a = this$0;
                }

                public void onSuccess(wn loginResult) {
                    Log.d("FBConnect", "success");
                    AppState.setFBInfo(loginResult.a());
                    aps sub = ix.a().a(in$v.class, new apr<in$v>(this) {
                        final /* synthetic */ AnonymousClass7 a;

                        {
                            this.a = this$1;
                        }

                        public void onCompleted() {
                        }

                        public void onError(Throwable e) {
                            rj.a(e);
                        }

                        public void onNext(in$v fbInfoReceived) {
                            this.a.a.sendFbDataToServer();
                        }
                    });
                }

                public void onCancel() {
                    Log.d("FBConnect", "cancel");
                }

                public void onError(FacebookException error) {
                    Log.e("FBConnect", error.toString());
                    if (!(error instanceof FacebookAuthorizationException) || AccessToken.a() == null) {
                        Toast.makeText(GossipApplication.a(), "Unable to connect to Facebook", 1).show();
                        return;
                    }
                    wm.c().d();
                    wm.c().a(this.a.getParent(), Arrays.asList("public_profile,user_friends,user_work_history,user_education_history".split(",")));
                }
            });
        }
        wm.c().a((Activity) this, Arrays.asList("public_profile,user_friends,user_work_history,user_education_history".split(",")));
    }

    public void showWebView(String url) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("url", GossipApplication.d + url);
        startActivity(intent);
    }

    public void sendFbDataToServer() {
        Map hashParams = new HashMap();
        hashParams.put("fb_token", AppState.fbInfo.fbToken.b());
        hashParams.put("fb_uid", AppState.fbInfo.fbToken.i());
        Map<String, String> syncParams = new HashMap();
        syncParams.put("type", "fb");
        syncParams.put("fb_uid", AppState.fbInfo.fbToken.i());
        syncParams.put("id_list", DataUtil.join(AppState.fbInfo.friendIds));
        apl.a(ik.a().b(hashParams).b(Schedulers.io()).a(apv.a()), ik.a().a(AppState.fbInfo).b(Schedulers.io()).a(apv.a()), new aqd<ain, NetworkData, JoinedFacebookData>(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = this$0;
            }

            public JoinedFacebookData call(ain hash, NetworkData autoJoin) {
                return new JoinedFacebookData(hash, autoJoin);
            }
        }).b(new apr<JoinedFacebookData>(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
                ix.a().a(new in$au());
            }

            public void onError(Throwable e) {
            }

            public void onNext(JoinedFacebookData joinedFacebookData) {
                NetworkData autoJoin = joinedFacebookData.autoJoin;
                if (!(autoJoin == null || autoJoin.groups == null)) {
                    for (Group group : autoJoin.groups) {
                        ix.a().a(new in$m(group));
                    }
                }
                if (autoJoin != null && autoJoin.my_info != null) {
                    AppState.account.num_groups = autoJoin.my_info.num_groups;
                }
            }
        });
    }

    protected void clearPhoto() {
        if (this.photoHelper != null) {
            this.photoHelper.clearPhoto();
        }
    }

    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
    }
}
