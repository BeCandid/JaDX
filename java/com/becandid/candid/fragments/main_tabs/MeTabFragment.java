package com.becandid.candid.fragments.main_tabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.a;
import android.support.design.widget.TabLayout.d;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MeSettingsActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.activities.SeeAllBadgesActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.FacebookInfo.LoadCallback;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.User;
import com.becandid.candid.models.JoinedFacebookData;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.BadgeInfoView;
import com.becandid.candid.views.TabViewPager;
import com.becandid.thirdparty.BlurTask;
import com.becandid.thirdparty.BlurTask.BadgeType;
import com.facebook.AccessToken;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import defpackage.ain;
import defpackage.apl;
import defpackage.apr;
import defpackage.apv;
import defpackage.aqd;
import defpackage.bb;
import defpackage.hq;
import defpackage.ht;
import defpackage.hu;
import defpackage.hv;
import defpackage.hw;
import defpackage.hx;
import defpackage.ig;
import defpackage.ig$a;
import defpackage.ik;
import defpackage.in$as;
import defpackage.in$au;
import defpackage.in$d;
import defpackage.in$k;
import defpackage.in$m;
import defpackage.in$o;
import defpackage.in$r;
import defpackage.ix;
import defpackage.rj;
import defpackage.uj;
import defpackage.uj$a;
import defpackage.uk;
import defpackage.wm;
import defpackage.wn;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

public class MeTabFragment extends ht implements a, BadgeInfoView.a {
    @BindView(2131624819)
    LinearLayout buttonPanel;
    @BindView(2131624820)
    View connectContact;
    @BindView(2131624821)
    View connectFb;
    private final String d = "ACTIVITY";
    private final String e = "GROUPS";
    private final String f = "POSTS";
    private final String g = "HISTORY";
    private uj h;
    private boolean i;
    private long j = 0;
    private TabLayout k;
    private Context l;
    private BaseActivity m;
    @BindView(2131624079)
    ImageView mBadgeIcon;
    @BindView(2131624287)
    FrameLayout mBadgeInfoContainer;
    @BindView(2131624076)
    TextView mBadgeTitle;
    @BindView(2131624818)
    TextView mGroupsCount;
    @BindView(2131624816)
    TextView mNumContacts;
    @BindView(2131624815)
    TextView mNumFriends;
    @BindView(2131624817)
    TextView mPostsCount;
    @BindView(2131624809)
    View mProfileContainer;
    @BindView(2131624824)
    View mProfileSpinny;
    @BindView(2131624813)
    TextView mQualityScore;
    private BadgeInfoView n;
    private View o;
    private hq p;
    @BindView(2131624823)
    TabViewPager viewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(2130968743, container, false);
        this.b = ButterKnife.bind(this, root);
        this.l = getContext();
        this.m = (BaseActivity) getActivity();
        this.k = (TabLayout) root.findViewById(2131624822);
        this.k.setSelectedTabIndicatorColor(getResources().getColor(2131558476));
        this.k.setTabTextColors(Color.parseColor("#888888"), getResources().getColor(2131558476));
        this.p = new hq(this.m.getSupportFragmentManager());
        hv groupFragment = new hv();
        hx postsFragment = new hx();
        hw historyFragment = new hw();
        if (AppState.config.getBoolean("messaging_turned_on", true)) {
            this.p.a(new hu(), "ACTIVITY");
        }
        this.p.a(groupFragment, "GROUPS");
        this.p.a(postsFragment, "POSTS");
        this.p.a(historyFragment, "HISTORY");
        this.viewPager.setAdapter(this.p);
        this.viewPager.setOffscreenPageLimit(3);
        this.viewPager.setCurrTab("me");
        this.k.setupWithViewPager(this.viewPager);
        this.k.setOnTabSelectedListener(this);
        for (int i = 0; i < this.k.getTabCount(); i++) {
            TextView tab = (TextView) LayoutInflater.from(this.l).inflate(2130968649, null);
            tab.setText(this.k.a(i).d());
            tab.setCompoundDrawablePadding(0);
            this.k.a(i).a(tab);
        }
        root.findViewById(2131624814).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MeTabFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View view) {
                this.a.getContext().startActivity(new Intent(this.a.getContext(), MeSettingsActivity.class));
            }
        });
        this.m.addToSubscriptionList(ix.a().a(in$k.class, new apr<in$k>(this) {
            final /* synthetic */ MeTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((in$k) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void a(in$k didCreatePost) {
                ((hx) this.a.p.a("POSTS")).a(didCreatePost.a);
                User user = AppState.account;
                user.num_posts++;
                this.a.d();
            }
        }));
        this.m.addToSubscriptionList(ix.a().a(in$r.class, new apr<in$r>(this) {
            final /* synthetic */ MeTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((in$r) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void a(in$r didRemovePost) {
                ((hx) this.a.p.a("POSTS")).a(didRemovePost.a);
                User user = AppState.account;
                user.num_posts--;
                this.a.d();
            }
        }));
        this.m.addToSubscriptionList(ix.a().a(in$m.class, new apr<in$m>(this) {
            final /* synthetic */ MeTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((in$m) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void a(in$m didJoinGroup) {
                ((hv) this.a.p.a("GROUPS")).a(didJoinGroup.a);
                if (!(AppState.groups == null || AppState.account == null)) {
                    AppState.account.num_groups = AppState.groups.size();
                }
                this.a.d();
            }
        }));
        this.m.addToSubscriptionList(ix.a().a(in$o.class, new apr<in$o>(this) {
            final /* synthetic */ MeTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((in$o) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void a(in$o didLeaveGroup) {
                ((hv) this.a.p.a("GROUPS")).a(didLeaveGroup.a);
                AppState.account.num_groups = AppState.groups.size();
                this.a.a();
                this.a.d();
            }
        }));
        this.m.addToSubscriptionList(ix.a().a(in$d.class, new apr<in$d>(this) {
            final /* synthetic */ MeTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((in$d) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void a(in$d blurTaskFinished) {
                this.a.n = new BadgeInfoView(this.a.m, AppState.account.badge_status, true, blurTaskFinished.a);
                this.a.a(this.a.n);
                this.a.mBadgeInfoContainer.setVisibility(0);
                this.a.mProfileContainer.setVisibility(8);
                this.a.mBadgeInfoContainer.addView(this.a.n);
                Animation slideUpAnimation = AnimationUtils.loadAnimation(this.a.m, 2131034137);
                slideUpAnimation.setDuration(500);
                this.a.o = this.a.mBadgeInfoContainer.findViewById(2131624074);
                this.a.o.startAnimation(slideUpAnimation);
                this.a.mBadgeInfoContainer.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass12 a;

                    {
                        this.a = this$1;
                    }

                    public void onClick(View v) {
                        this.a.a.a(v);
                    }
                });
                AppState.blurTaskCalledOnFlight = false;
            }
        }));
        d();
        this.mBadgeIcon.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MeTabFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                if (AppState.account != null && AppState.account.badge_status != null && !AppState.blurTaskCalledOnFlight) {
                    AppState.blurTaskCalledOnFlight = true;
                    new BlurTask(this.a.m, 2131624809).execute(new Void[0]);
                }
            }
        });
        return root;
    }

    public void d() {
        if (AppState.account != null) {
            this.mPostsCount.setText(Integer.toString(AppState.account.num_posts));
            this.mGroupsCount.setText(Integer.toString(AppState.account.num_groups));
            this.mNumFriends.setText(Integer.toString(AppState.account.num_fb_friends));
            this.mNumContacts.setText(Integer.toString(Integer.valueOf(AppState.account.num_phone_friends).intValue()));
            final String score = new DecimalFormat("#").format((double) AppState.account.quality_score);
            if (score == null || score.equals("0")) {
                this.mQualityScore.setVisibility(8);
            } else {
                this.mQualityScore.setVisibility(0);
                this.mQualityScore.setText(score);
                this.mQualityScore.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ MeTabFragment b;

                    public void onClick(View v) {
                        if (!AppState.blurTaskCalledOnFlight) {
                            AppState.blurTaskCalledOnFlight = true;
                            new BlurTask((Activity) this.b.l, ((Activity) this.b.l).findViewById(16908290), score, BadgeType.ME_QUALITY_SCORE, null, null).execute(new Void[0]);
                        }
                    }
                });
            }
            ig$a badge = ig.a().a(AppState.account.badge_status);
            if (badge != null) {
                this.mBadgeIcon.setImageResource(badge.c);
                this.mBadgeTitle.setText(badge.b);
            }
            if (AppState.account.have_fb && AppState.account.have_phone_number) {
                this.buttonPanel.setVisibility(8);
                return;
            }
            this.buttonPanel.setVisibility(0);
            if (AppState.fbInfo != null) {
                this.connectFb.setVisibility(8);
            } else {
                this.connectFb.setVisibility(0);
            }
            if (AppState.account.have_phone_number) {
                this.connectContact.setVisibility(8);
            } else {
                this.connectContact.setVisibility(0);
            }
        }
    }

    public void a(final boolean forceRefresh, final boolean markActivityRead) {
        if (AppState.account == null || AppState.account.user_id <= 0) {
            Toast.makeText(getContext(), "Unable to find your profile.", 1).show();
            return;
        }
        this.i = true;
        if (forceRefresh) {
            this.viewPager.setVisibility(8);
            this.mProfileSpinny.setVisibility(0);
        }
        ik.a().d(AppState.account.user_id).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
            final /* synthetic */ MeTabFragment c;

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                this.c.c = false;
                this.c.i = false;
                if (this.c.viewPager != null && this.c.mProfileSpinny != null) {
                    this.c.viewPager.setVisibility(0);
                    this.c.mProfileSpinny.setVisibility(8);
                    rj.a(e);
                }
            }

            public void a(NetworkData networkData) {
                if (AppState.account != null) {
                    this.c.c = false;
                    this.c.i = false;
                    this.c.mProfileSpinny.setVisibility(8);
                    this.c.viewPager.setVisibility(0);
                    if (this.c.f()) {
                        if (this.c.p.a("ACTIVITY") != null) {
                            ((hu) this.c.p.a("ACTIVITY")).a(markActivityRead);
                        }
                        this.c.l();
                    } else {
                        if (this.c.p.a("ACTIVITY") != null) {
                            ((hu) this.c.p.a("ACTIVITY")).a(markActivityRead);
                        }
                        if (forceRefresh) {
                            this.c.l();
                        }
                    }
                    if (networkData.profile != null) {
                        AppState.account.num_posts = networkData.profile.num_posts;
                        AppState.account.num_groups = networkData.profile.num_groups;
                        AppState.account.num_fb_friends = networkData.profile.num_fb_friends;
                        AppState.account.num_phone_friends = networkData.profile.num_phone_friends;
                        AppState.account.quality_score = networkData.profile.quality_score;
                    }
                    this.c.j = System.currentTimeMillis() / 1000;
                    this.c.d();
                }
            }
        });
    }

    public void e() {
        if (this.viewPager != null) {
            this.viewPager.setCurrentItem(0, true);
            a(true, true);
            if (getView() != null) {
                ((AppBarLayout) getView().findViewById(2131624810)).setExpanded(true, true);
            }
        }
    }

    private void l() {
        ((hv) this.p.a("GROUPS")).b();
        ((hx) this.p.a("POSTS")).b();
        ((hw) this.p.a("HISTORY")).b();
    }

    public boolean f() {
        return (System.currentTimeMillis() / 1000) - this.j > ((long) AppState.config.getInt("profile_update_time", 300));
    }

    private void a(BadgeInfoView badgeInfoView) {
        badgeInfoView.setSeeAllBadgesListener(this);
    }

    public void onTabSelected(d tab) {
        this.viewPager.setCurrentItem(tab.c(), true);
        if (tab.c() == 0 && AppState.config.getBoolean("messaging_turned_on", true)) {
            TextView tabView = (TextView) tab.a();
            tabView.setTextColor(getResources().getColor(2131558476));
            tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public void onTabUnselected(d tab) {
        if (tab.c() == 0 && AppState.config.getBoolean("messaging_turned_on", true)) {
            TextView tabView = (TextView) tab.a();
            tabView.setTextColor(Color.parseColor("#888888"));
            tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public void onTabReselected(d tab) {
        a();
    }

    public void a() {
        super.a();
        a(false, false);
    }

    @OnClick({2131624821})
    public void connectFB(final View view) {
        view.setVisibility(8);
        if (this.h == null) {
            this.h = uj$a.a();
            wm.c().a(this.h, new uk<wn>(this) {
                final /* synthetic */ MeTabFragment b;

                public /* synthetic */ void onSuccess(Object obj) {
                    a((wn) obj);
                }

                public void a(wn loginResult) {
                    Log.d("FBConnect", "success");
                    AppState.setFBInfo(loginResult.a(), new LoadCallback(this) {
                        final /* synthetic */ AnonymousClass2 a;

                        {
                            this.a = this$1;
                        }

                        public void onNext(int numFriends) {
                            if (AppState.account != null) {
                                AppState.account.num_fb_friends = numFriends;
                            }
                            this.a.b.d();
                            this.a.b.i();
                        }
                    });
                }

                public void onCancel() {
                    Log.d("FBConnect", "cancel");
                    view.setVisibility(0);
                }

                public void onError(FacebookException error) {
                    Log.e("FBConnect", error.toString());
                    if (!(error instanceof FacebookAuthorizationException) || AccessToken.a() == null) {
                        Toast.makeText(GossipApplication.a(), "Unable to connect to Facebook", 1).show();
                        view.setVisibility(0);
                        return;
                    }
                    wm.c().d();
                    wm.c().a(this.b.m, Arrays.asList("public_profile,user_friends,user_work_history,user_education_history".split(",")));
                }
            });
        }
        wm.c().a(this.m, Arrays.asList("public_profile,user_friends,user_work_history,user_education_history".split(",")));
    }

    @OnClick({2131624820})
    public void connectContacts(View view) {
        if (AppState.contactsInfo == null) {
            AppState.contactsInfo = new ContactsInfo();
        }
        if (!AppState.account.have_phone_number || bb.checkSelfPermission(view.getContext(), "android.permission.READ_CONTACTS") == 0) {
            Intent intent = new Intent(view.getContext(), OnboardingActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("first_fragment", "phone");
            bundle.putString("second_fragment", "phone");
            intent.putExtras(bundle);
            view.getContext().startActivity(intent);
            return;
        }
        ActivityCompat.requestPermissions((Activity) view.getContext(), new String[]{"android.permission.READ_CONTACTS"}, 1);
    }

    public void g() {
        GossipApplication.a().d();
        j();
        this.connectContact.setVisibility(8);
    }

    public void h() {
        this.connectContact.setEnabled(true);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.h != null) {
            this.h.a(requestCode, resultCode, data);
        }
    }

    public void i() {
        Map hashParams = new HashMap();
        hashParams.put("fb_token", AppState.fbInfo.fbToken.b());
        hashParams.put("fb_uid", AppState.fbInfo.fbToken.i());
        Map<String, String> syncParams = new HashMap();
        syncParams.put("type", "fb");
        syncParams.put("fb_uid", AppState.fbInfo.fbToken.i());
        syncParams.put("id_list", DataUtil.join(AppState.fbInfo.friendIds));
        apl.a(ik.a().b(hashParams).b(Schedulers.io()).a(apv.a()), ik.a().a(AppState.fbInfo).b(Schedulers.io()).a(apv.a()), new aqd<ain, NetworkData, JoinedFacebookData>(this) {
            final /* synthetic */ MeTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ Object call(Object obj, Object obj2) {
                return a((ain) obj, (NetworkData) obj2);
            }

            public JoinedFacebookData a(ain hash, NetworkData autoJoin) {
                return new JoinedFacebookData(hash, autoJoin);
            }
        }).b(new apr<JoinedFacebookData>(this) {
            final /* synthetic */ MeTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((JoinedFacebookData) obj);
            }

            public void onCompleted() {
                ix.a().a(new in$au());
            }

            public void onError(Throwable e) {
            }

            public void a(JoinedFacebookData joinedFacebookData) {
                NetworkData autoJoin = joinedFacebookData.autoJoin;
                if (!(autoJoin == null || autoJoin.groups == null)) {
                    for (Group group : autoJoin.groups) {
                        ix.a().a(new in$m(group));
                    }
                }
                if (!(autoJoin == null || autoJoin.my_info == null)) {
                    AppState.account.num_groups = autoJoin.my_info.num_groups;
                }
                this.a.d();
            }
        });
    }

    public void j() {
        Map params = new HashMap();
        params.put("type", "phone_number");
        params.put("id_list", DataUtil.join(AppState.contactsInfo.contacts));
        ik.a().c(params).b(Schedulers.io()).a(apv.a()).b(new apr<ain>(this) {
            final /* synthetic */ MeTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((ain) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void a(ain result) {
                AppState.account.num_phone_friends = result.b("num_phone_friends").g();
                AppState.saveState(GossipApplication.a());
                this.a.d();
                ix.a().a(new in$au());
            }
        });
    }

    public void k() {
        a(this.mBadgeInfoContainer);
        final Context context = getContext();
        this.mProfileContainer.postDelayed(new Runnable(this) {
            final /* synthetic */ MeTabFragment b;

            public void run() {
                context.startActivity(new Intent(context, SeeAllBadgesActivity.class));
            }
        }, 600);
    }

    private void a(View v) {
        Animation slideDownAnimation = AnimationUtils.loadAnimation(getContext(), 2131034132);
        slideDownAnimation.setDuration(500);
        this.o.startAnimation(slideDownAnimation);
        v.postDelayed(new Runnable(this) {
            final /* synthetic */ MeTabFragment a;

            {
                this.a = this$0;
            }

            public void run() {
                this.a.mProfileContainer.setVisibility(0);
                this.a.mBadgeInfoContainer.removeView(this.a.n);
                this.a.mBadgeInfoContainer.setVisibility(8);
            }
        }, 500);
    }

    public void b() {
        this.mProfileContainer.setVisibility(0);
    }

    public void c() {
        this.mProfileContainer.setVisibility(8);
    }

    public void a(in$as updateUnreadCount) {
        int position = this.viewPager.getCurrentItem();
        if (updateUnreadCount != null && position != 0 && updateUnreadCount.a == 3 && AppState.config.getBoolean("messaging_turned_on", true)) {
            int unreadDot;
            if (updateUnreadCount.b > 0) {
                unreadDot = 2130838257;
            } else {
                unreadDot = 0;
            }
            ((TextView) this.k.a(0).a()).setCompoundDrawablesWithIntrinsicBounds(0, 0, unreadDot, 0);
            ((TextView) this.k.a(0).a()).setMaxLines(1);
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.i && f()) {
            a(false, false);
        }
    }
}
