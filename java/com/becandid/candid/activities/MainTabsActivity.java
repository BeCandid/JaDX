package com.becandid.candid.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.a;
import android.support.design.widget.TabLayout.d;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog.Builder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.Group;
import com.becandid.candid.fragments.main_tabs.ActivityTabFragment;
import com.becandid.candid.fragments.main_tabs.FeedTabFragment;
import com.becandid.candid.fragments.main_tabs.MeTabFragment;
import com.becandid.candid.fragments.main_tabs.MessageTabFragment;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.services.RegistrationIntentService;
import com.becandid.candid.views.MainTabViewPager;
import com.becandid.thirdparty.BlurTask;
import com.becandid.thirdparty.BlurTask.BadgeType;
import defpackage.apr;
import defpackage.apv;
import defpackage.hj;
import defpackage.ht;
import defpackage.ik;
import defpackage.in$as;
import defpackage.in$au;
import defpackage.in$e;
import defpackage.in$f;
import defpackage.in$u;
import defpackage.ix;
import defpackage.rj;
import defpackage.uu$h;
import defpackage.xd;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class MainTabsActivity extends PopupWithBlurBackgroundActivity implements a {
    public static final int CREATE_GROUP = 1001;
    public static final int CREATE_POST_REQUEST = 888;
    public static final int PERMISSION_READ_CONTACTS = 1;
    final BroadcastReceiver b = new BroadcastReceiver(this) {
        final /* synthetic */ MainTabsActivity a;

        {
            this.a = this$0;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getExtras().getString("activity_id") != null) {
                this.a.busSubscribe(in$as.class, new apr<in$as>(this) {
                    final /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = this$1;
                    }

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rj.a(e);
                    }

                    public void onNext(in$as updateUnreadCount) {
                        this.a.a.a(updateUnreadCount);
                    }
                });
            }
            abortBroadcast();
        }
    };
    private final int c = 999;
    private Handler d;
    private final int e = 60000;
    private List<String> f;
    private MeTabFragment g;
    private FeedTabFragment h;
    private MessageTabFragment i;
    private hj j;
    private Runnable k = new Runnable(this) {
        final /* synthetic */ MainTabsActivity a;

        {
            this.a = this$0;
        }

        public void run() {
            this.a.d.postDelayed(this.a.k, 60000);
        }
    };
    @BindView(2131624194)
    TabLayout mBottomTabs;
    @BindView(2131624211)
    View mCreatePostBtn;
    @BindView(2131624209)
    MainTabViewPager mViewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AppState.config.experimentConfig.containsKey("messaging_turned_on") && AppState.config.getBoolean("messaging_turned_on")) {
            setContentView(2130968619);
            this.f = Arrays.asList(new String[]{"feed", "groups", "post", "messages", "me"});
        } else {
            setContentView(2130968618);
            this.f = Arrays.asList(new String[]{"feed", "groups", "post", "me", "activity"});
        }
        ButterKnife.bind(this);
        AppState.mainTabsActivity = this;
        this.d = new Handler(getMainLooper());
        this.a = (RelativeLayout) findViewById(2131624193);
        this.j = new hj(getSupportFragmentManager());
        this.j.a(this.f);
        this.mViewPager.setSwipeEnabled(false);
        this.mViewPager.setAdapter(this.j);
        this.mViewPager.setOffscreenPageLimit(4);
        this.mBottomTabs.setupWithViewPager(this.mViewPager);
        this.mBottomTabs.setOnTabSelectedListener(this);
        this.mBottomTabs.setSelectedTabIndicatorHeight(0);
        for (int i = 0; i < this.mBottomTabs.getTabCount(); i += PERMISSION_READ_CONTACTS) {
            this.mBottomTabs.a(i).a(this.j.a(i));
        }
        if (f()) {
            startService(new Intent(this, RegistrationIntentService.class));
        }
        if (AppState.config != null && AppState.config.getBoolean("android_force_upgrade_version_number")) {
            Builder builder = new Builder(this);
            builder.setTitle("A new version is available. Pleage update your app!").setCancelable(false).setPositiveButton("Update", new OnClickListener(this) {
                final /* synthetic */ MainTabsActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("market://details?id=com.becandid.candid"));
                    this.a.startActivity(intent);
                    this.a.finish();
                }
            }).setNegativeButton("Quit app", new OnClickListener(this) {
                final /* synthetic */ MainTabsActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });
            builder.show();
        }
        if (AppState.needAge == PERMISSION_READ_CONTACTS && AppState.age == null) {
            if (AppState.fbInfo == null || AppState.fbInfo.fbToken == null || AppState.fbInfo.fbToken.b() == null) {
                this.a.setAlpha(0.2f);
                startActivityForResult(new Intent(this, VerifyAgeActivity.class), 999);
            } else {
                Map params = new HashMap();
                params.put("fb_token", AppState.fbInfo.fbToken.b());
                ik.a().a(params);
            }
        }
        busSubscribe(ix.a().a(in$e.class, new apr<in$e>(this) {
            final /* synthetic */ MainTabsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$e changeTab) {
                if (changeTab.a >= 0 && changeTab.a < 5 && changeTab.a != 2) {
                    this.a.mViewPager.setCurrentItem(changeTab.a);
                }
            }
        }));
        busSubscribe(ix.a().a(in$as.class, new apr<in$as>(this) {
            final /* synthetic */ MainTabsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$as updateUnreadCount) {
                if (updateUnreadCount.c) {
                    this.a.a(updateUnreadCount);
                    return;
                }
                this.a.g = this.a.b();
                this.a.g.a();
                this.a.g.a(updateUnreadCount);
            }
        }));
        busSubscribe(ix.a().a(in$au.class, new apr<in$au>(this) {
            final /* synthetic */ MainTabsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$au upsellRefresh) {
                this.a.h = this.a.a();
                this.a.h.a();
                this.a.g = this.a.b();
                this.a.g.a();
            }
        }));
        busSubscribe(ix.a().a(in$f.class, new apr<in$f>(this) {
            final /* synthetic */ MainTabsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$f closeMessagingPopup) {
                this.a.setShowMessagingPopup(false);
            }
        }));
    }

    private FeedTabFragment a() {
        return (FeedTabFragment) this.j.b(0);
    }

    private MeTabFragment b() {
        if (AppState.config.experimentConfig.containsKey("messaging_turned_on") && AppState.config.getBoolean("messaging_turned_on")) {
            return (MeTabFragment) this.j.b(4);
        }
        return (MeTabFragment) this.j.b(3);
    }

    private MessageTabFragment c() {
        if (AppState.config.experimentConfig.containsKey("messaging_turned_on") && AppState.config.getBoolean("messaging_turned_on")) {
            return (MessageTabFragment) this.j.b(3);
        }
        return null;
    }

    public void onTabSelected(d tab) {
        this.mViewPager.setCurrentItem(tab.c(), true);
        int pos = tab.c();
        View view = tab.a();
        ImageView button = (ImageView) view.findViewById(2131624522);
        ((TextView) view.findViewById(2131624523)).setTextColor(getResources().getColor(2131558476));
        button.setImageResource(getResources().getIdentifier(((String) this.f.get(pos)) + "_tab_orange", "drawable", getPackageName()));
        view.findViewById(2131624521).setAlpha(1.0f);
        view.findViewById(2131624524).setVisibility(8);
        switch (pos) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                AppState.account.unread_feed_count = 0;
                return;
            case PERMISSION_READ_CONTACTS /*1*/:
                AppState.account.unread_groups_count = 0;
                return;
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                if (AppState.config.getBoolean("messaging_turned_on", true)) {
                    if (!AppState.hasMessagingShown) {
                        this.i = c();
                        this.i.d();
                    }
                    ix.a().a(new in$u());
                    return;
                }
                return;
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                AppState.account.unread_activity_count = 0;
                if (AppState.config.getBoolean("messaging_turned_on", true)) {
                    this.g = b();
                    if (this.g != null) {
                        this.g.e();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onTabUnselected(d tab) {
        int pos = tab.c();
        View view = tab.a();
        ImageView button = (ImageView) view.findViewById(2131624522);
        ((TextView) view.findViewById(2131624523)).setTextColor(getResources().getColor(17170444));
        button.setImageResource(getResources().getIdentifier(((String) this.f.get(pos)) + "_tab", "drawable", getPackageName()));
        view.findViewById(2131624521).setAlpha(0.5f);
        view.findViewById(2131624524).setVisibility(8);
        if (pos == 4) {
            ik.a().b(Boolean.toString(true), null).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        }
    }

    public void onTabReselected(d tab) {
        Fragment currFragment = this.j.b(tab.c());
        if (currFragment != null && (currFragment instanceof ht)) {
            if (currFragment instanceof MeTabFragment) {
                ((MeTabFragment) currFragment).e();
            } else {
                ((ht) currFragment).a();
            }
        }
        tab.a().findViewById(2131624524).setVisibility(8);
    }

    public void hideCurrentScreen() {
        Fragment fragment = this.j.b(this.mViewPager.getCurrentItem());
        if (fragment != null && (fragment instanceof ht)) {
            ((ht) fragment).c();
        }
    }

    public void showCurrentScreen() {
        Fragment fragment = this.j.b(this.mViewPager.getCurrentItem());
        if (fragment != null && (fragment instanceof ht)) {
            ((ht) fragment).b();
        }
    }

    private void a(in$as updateUnreadCount) {
        int tabIndex = updateUnreadCount.a;
        int tabCount = updateUnreadCount.b;
        int index = this.mViewPager.getCurrentItem();
        if (tabIndex == 3 && index != 4) {
            AppState.account.unread_activity_count = tabCount;
            a(tabCount, tabIndex, 4);
        } else if (tabIndex == 0 && index != 0) {
            AppState.account.unread_feed_count = tabCount;
            a(tabCount, tabIndex, 0);
        } else if (tabIndex == PERMISSION_READ_CONTACTS && index != PERMISSION_READ_CONTACTS) {
            AppState.account.unread_groups_count = tabCount;
            a(tabCount, tabIndex, PERMISSION_READ_CONTACTS);
        } else if (tabIndex == 2 && index != 3) {
            AppState.account.unread_message_count = tabCount;
            a(tabCount, tabIndex, 3);
        }
    }

    private void a(int tabCount, int tabIndex, int index) {
        if (this.mViewPager.getCurrentItem() != index) {
            String count = "";
            if (tabCount > 99) {
                count = "99+";
            } else {
                count = Integer.toString(tabCount);
            }
            View view = this.mBottomTabs.a(index).a();
            if (view != null) {
                View tabNotificationBadge = view.findViewById(2131624524);
                TextView tabNotificationUnread = (TextView) view.findViewById(2131624525);
                if (tabCount < PERMISSION_READ_CONTACTS) {
                    tabNotificationBadge.setVisibility(8);
                    return;
                }
                tabNotificationBadge.setVisibility(0);
                tabNotificationUnread.setText(count);
                if (tabIndex == 2 && !AppState.hasMessagingShown) {
                    setShowMessagingPopup(true);
                    new BlurTask((Activity) this, findViewById(16908290), BadgeType.MESSAGE_ENABLED_NEW).execute(new Void[0]);
                    AppState.hasMessagingShown = true;
                    AppState.saveState(GossipApplication.a());
                }
            }
        }
    }

    private void d() {
        if (AppState.account != null) {
            ik.a().b(Boolean.toString(false), null).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                final /* synthetic */ MainTabsActivity a;

                {
                    this.a = this$0;
                }

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    rj.a(e);
                    this.a.e();
                }

                public void onNext(NetworkData networkData) {
                    if (networkData.unread_count > 0) {
                        AppState.account.unread_activity_count = networkData.unread_count;
                    }
                    if (networkData.unread_groups_count > 0) {
                        AppState.account.unread_groups_count = networkData.unread_groups_count;
                    }
                    if (AppState.account.unread_activity_count > 0 && networkData.unread_count == 0) {
                        AppState.account.unread_activity_count = 0;
                    }
                    this.a.e();
                }
            });
        }
    }

    private void e() {
        a(AppState.account.unread_feed_count, -1, 0);
        a(AppState.account.unread_groups_count, -1, PERMISSION_READ_CONTACTS);
        a(AppState.account.unread_activity_count, -1, 4);
        if (AppState.config.getBoolean("messaging_turned_on", true)) {
            a(AppState.account.unread_message_count, -1, 3);
        }
    }

    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter("com.becandid.candid.GOT_PUSH");
        filter.setPriority(2);
        registerReceiver(this.b, filter);
        Uri data = getIntent().getData();
        if (!(data == null || data.getPathSegments() == null || data.getPathSegments().isEmpty())) {
            int index = this.f.indexOf((String) data.getPathSegments().get(0));
            if (!(index == -1 || index == 2)) {
                this.mViewPager.setCurrentItem(index);
            }
        }
        Fragment fragment = this.j.b(this.mViewPager.getCurrentItem());
        if (fragment != null && (fragment instanceof ht)) {
            ((ht) fragment).onResume();
        }
        d();
        ik.a().h().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
            final /* synthetic */ MainTabsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void onNext(NetworkData networkData) {
                if (networkData != null) {
                    try {
                        AppState.account.unread_message_count = networkData.new_threads + networkData.new_requests;
                        this.a.d();
                    } catch (Throwable e) {
                        rj.a(e);
                    }
                }
            }
        });
        this.d.postDelayed(this.k, 60000);
    }

    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(this.b);
        } catch (Throwable e) {
            rj.a(e);
        }
        Fragment fragment = this.j.b(this.mViewPager.getCurrentItem());
        if (fragment != null && ((fragment instanceof MeTabFragment) || (fragment instanceof ActivityTabFragment))) {
            ik.a().b(Boolean.toString(true), null).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        } else if (fragment != null && (fragment instanceof ht)) {
            ((ht) fragment).onPause();
        }
        this.d.removeCallbacks(this.k);
    }

    protected void onDestroy() {
        super.onDestroy();
        AppState.mainTabsActivity = null;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int currentTab = this.mViewPager.getCurrentItem();
        if (currentTab >= 0 && currentTab < this.f.size()) {
            Fragment fragment = this.j.b(currentTab);
            if (fragment != null && (fragment instanceof ht)) {
                ((ht) fragment).onActivityResult(requestCode, resultCode, data);
            }
        }
        if (requestCode == CREATE_POST_REQUEST && resultCode == -1 && currentTab != 0) {
            this.mViewPager.setCurrentItem(0, true);
        }
        if (requestCode == CREATE_GROUP && resultCode == -1 && data != null) {
            Group group = (Group) data.getSerializableExtra("group");
            if (group == null) {
                rj.a(new Throwable("Group is NULL after creating a Group"));
                return;
            }
            Intent intent = new Intent(this, GroupDetailsActivity.class);
            intent.putExtra("group_id", group.group_id);
            intent.putExtra("group_json", DataUtil.toJson(group));
            startActivity(intent);
        }
        if (requestCode == BaseActivity.UPSELL_FEED && resultCode == -1) {
            ix.a().a(new in$au());
        }
        if (requestCode == 999 && resultCode == -1) {
            this.a.setAlpha(1.0f);
        }
    }

    private boolean f() {
        xd apiAvailability = xd.a();
        int resultCode = apiAvailability.a((Context) this);
        if (resultCode == 0) {
            return true;
        }
        if (apiAvailability.a(resultCode)) {
            apiAvailability.a((Activity) this, resultCode, 9000).show();
        } else {
            finish();
        }
        return false;
    }

    public static void disownAccount(final Context context) {
        ik.a().a(true).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>() {
            public void onCompleted() {
            }

            public void onError(Throwable e) {
                Toast.makeText(context, "Unable to disown account, please try again.", MainTabsActivity.PERMISSION_READ_CONTACTS).show();
            }

            public void onNext(NetworkData networkData) {
                if (networkData.success) {
                    AppState.disownAccount();
                    Intent i = GossipApplication.a().getBaseContext().getPackageManager().getLaunchIntentForPackage(GossipApplication.a().getPackageName());
                    i.addFlags(32768);
                    i.addFlags(268435456);
                    context.startActivity(i);
                }
            }
        });
    }

    public void createPost(View v) {
        if (!this.mIsShowingMessagingPopup) {
            startActivityForResult(new Intent(this, CreatePostActivity.class), CREATE_POST_REQUEST);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_READ_CONTACTS /*1*/:
                this.g = b();
                if (grantResults.length <= 0 || grantResults[0] != 0) {
                    this.g.h();
                    return;
                } else {
                    this.g.g();
                    return;
                }
            default:
                return;
        }
    }

    public void upsellChange(int upsellId) {
        super.upsellChange(upsellId);
        this.h = a();
        this.h.a(upsellId);
    }

    public void setShowMessagingPopup(boolean value) {
        this.mIsShowingMessagingPopup = value;
    }

    protected void showSnack(boolean isConnected) {
        super.showSnack(isConnected);
        View parentView = findViewById(2131624194);
        if (!isConnected && parentView != null) {
            Snackbar.a(parentView, "No Internet connection!", 0).a();
        }
    }
}
