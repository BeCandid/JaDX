package com.becandid.candid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.fragments.onboarding.OnboardingAgeFragment;
import com.becandid.candid.fragments.onboarding.OnboardingContactsFragment;
import com.becandid.candid.fragments.onboarding.OnboardingFacebookFragment;
import com.becandid.candid.fragments.onboarding.OnboardingLocationFragment;
import com.becandid.candid.fragments.onboarding.OnboardingPhoneFragment;
import com.becandid.candid.fragments.onboarding.OnboardingTagsFragment;
import com.becandid.candid.fragments.onboarding.OnboardingVerifyFragment;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import defpackage.apr;
import defpackage.apv;
import defpackage.ik;
import defpackage.in$an;
import defpackage.ix;
import defpackage.jb;
import defpackage.rj;
import defpackage.uu$h;
import rx.schedulers.Schedulers;

public class OnboardingActivity extends BaseActivity {
    private boolean b = false;
    private boolean c = false;
    private Bundle d;
    private FragmentManager e;
    private OnboardingFacebookFragment f;
    private OnboardingPhoneFragment g;
    private OnboardingLocationFragment h;
    private OnboardingTagsFragment i;
    private Handler j;
    private int k;
    private int l;
    public String otpCode;

    protected void onCreate(Bundle savedInstanceState) {
        if (AppState.contactsInfo == null) {
            AppState.contactsInfo = new ContactsInfo();
        }
        super.onCreate(savedInstanceState);
        if (AppState.config.has("skip_age_onboarding")) {
            this.l = AppState.config.getInt("skip_age_onboarding", 0);
        }
        if (AppState.config.has("skip_tags_onboarding")) {
            this.k = AppState.config.getInt("skip_tags_onboarding", 0);
        }
        this.j = new Handler(getMainLooper());
        setContentView(2130968625);
        this.e = getSupportFragmentManager();
        this.d = getIntent().getExtras();
        if (this.d != null && this.d.containsKey("second_fragment")) {
            this.g = new OnboardingPhoneFragment();
            this.g.setArguments(this.d);
            this.e.beginTransaction().add(2131624257, this.g, "phone").commit();
        } else if (this.d != null && this.d.containsKey(MeSettingsActivity.TAG_SETTINGS_KEY)) {
            this.i = new OnboardingTagsFragment();
            this.i.setArguments(this.d);
            this.e.beginTransaction().add(2131624257, this.i, "tags").commit();
        } else if (this.d != null && this.d.containsKey("need_onboarding")) {
            this.h = new OnboardingLocationFragment();
            this.e.beginTransaction().add(2131624257, this.h, "location").commit();
        } else if (savedInstanceState != null) {
            this.f = (OnboardingFacebookFragment) this.e.findFragmentByTag("fb");
        } else {
            this.f = new OnboardingFacebookFragment();
            this.e.beginTransaction().add(2131624257, this.f, "fb").commit();
        }
        addToSubscriptionList(ix.a().a(in$an.class, new apr<in$an>(this) {
            final /* synthetic */ OnboardingActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$an switchFrag) {
                Fragment fragment = this.a.e.findFragmentByTag(switchFrag.a);
                if (switchFrag.c != null) {
                    if (fragment != null && fragment.isVisible()) {
                        this.a.switchFragment(switchFrag.a, switchFrag.b, switchFrag.c);
                    }
                } else if (fragment != null && fragment.isVisible()) {
                    this.a.switchFragment(switchFrag.a, switchFrag.b);
                }
            }
        }));
    }

    public void onBackPressed() {
    }

    public void switchFragment(String fromFragment, String toFragment) {
        switchFragment(fromFragment, toFragment, null);
    }

    public void switchFragment(String fromFragment, String toFragment, Bundle bundle) {
        Fragment fragment = this.e.findFragmentByTag(fromFragment);
        jb.a(fragment.getContext(), fragment.getView());
        if (toFragment.equals("age") && (this.l == 1 || !(AppState.fbInfo == null || AppState.fbInfo.age == null))) {
            toFragment = "tags";
        }
        if (toFragment.equals("tags") && this.k == 1) {
            finishGetGroups();
            return;
        }
        fragment = this.e.findFragmentByTag(toFragment);
        if (fragment == null) {
            Object obj = -1;
            switch (toFragment.hashCode()) {
                case -819951495:
                    if (toFragment.equals("verify")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -567451565:
                    if (toFragment.equals("contacts")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 3260:
                    if (toFragment.equals("fb")) {
                        obj = null;
                        break;
                    }
                    break;
                case 96511:
                    if (toFragment.equals("age")) {
                        obj = 5;
                        break;
                    }
                    break;
                case 3552281:
                    if (toFragment.equals("tags")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 106642798:
                    if (toFragment.equals("phone")) {
                        int i = 1;
                        break;
                    }
                    break;
                case 1901043637:
                    if (toFragment.equals("location")) {
                        obj = 4;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    fragment = new OnboardingFacebookFragment();
                    break;
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    fragment = new OnboardingPhoneFragment();
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    fragment = new OnboardingVerifyFragment();
                    break;
                case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    fragment = new OnboardingContactsFragment();
                    break;
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    fragment = new OnboardingLocationFragment();
                    break;
                case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    fragment = new OnboardingAgeFragment();
                    break;
                case uu$h.CardView_cardUseCompatPadding /*6*/:
                    fragment = new OnboardingTagsFragment();
                    break;
            }
            if (bundle != null) {
                fragment.setArguments(bundle);
            }
        }
        FragmentTransaction fragmentTransaction = this.e.beginTransaction();
        fragmentTransaction.replace(2131624257, fragment, toFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void finish() {
        super.finish();
        setResult(-1);
    }

    public void finishGetGroups() {
        if (!AppState.config.has("skip_groups_onboarding")) {
            startActivity(new Intent(this, OnboardingGroupsActivity.class));
            finish();
        } else if (AppState.config.getInt("skip_groups_onboarding", 0) == 1) {
            ik.a().f().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                final /* synthetic */ OnboardingActivity a;

                {
                    this.a = this$0;
                }

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    rj.a(e);
                    Toast.makeText(this.a, "Unable to get get your recommended groups. Please try again", 0).show();
                }

                public void onNext(NetworkData networkData) {
                    this.a.finishSyncAccount();
                }
            });
        }
    }

    public void finishSyncAccount() {
        Intent intent;
        ik.a().b().b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        if (AppState.referralPostId != 0) {
            intent = new Intent(this, PostDetailsActivity.class);
            intent.putExtra("post_id", AppState.referralPostId);
        } else {
            intent = new Intent(this, MainTabsActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
