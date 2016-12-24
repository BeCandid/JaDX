package com.becandid.candid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.models.NetworkData;
import defpackage.ain;
import defpackage.apr;
import defpackage.apv;
import defpackage.ik;
import defpackage.rj;
import defpackage.rk;
import defpackage.sk;
import java.util.List;
import java.util.Map;
import rx.exceptions.CompositeException;
import rx.schedulers.Schedulers;

public class SplashActivity extends BaseActivity {
    public static final int CHANGE_ENDPOINT_CODE = 1001;
    private View b;
    private View c;
    private boolean d = false;
    private boolean e = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AppState.loggedin()) {
            ik.a().b().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                final /* synthetic */ SplashActivity a;

                {
                    this.a = this$0;
                }

                public void onCompleted() {
                    if (AppState.needOnboarding == 1) {
                        Intent intent = new Intent(this.a, OnboardingActivity.class);
                        intent.putExtra("need_onboarding", 1);
                        this.a.startActivity(intent);
                        this.a.finish();
                        return;
                    }
                    this.a.startActivity(new Intent(this.a, MainTabsActivity.class));
                    this.a.finish();
                }

                public void onError(Throwable e) {
                    this.a.startActivity(new Intent(this.a, MainTabsActivity.class));
                    this.a.finish();
                }

                public void onNext(NetworkData data) {
                }
            });
            return;
        }
        renderSplashPage();
        TextView termsAndGuidelines = (TextView) findViewById(2131624291);
        Spanned spanned1 = Html.fromHtml("By selecting \"Get Started Anonymously\" you agree to the ");
        Spanned spanned2 = Html.fromHtml("<a href=\"" + GossipApplication.d + "content/terms\">Terms of Service</a>");
        Spanned spanned3 = Html.fromHtml("<a href=\"" + GossipApplication.d + "content/community\">Community Guidelines</a>");
        termsAndGuidelines.setText(TextUtils.concat(new CharSequence[]{spanned1, spanned2, " and ", spanned3}));
        termsAndGuidelines.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void renderSplashPage() {
        setContentView(2130968630);
        this.b = findViewById(2131624293);
        this.c = findViewById(2131624292);
        a(findViewById(2131624290));
    }

    public void startOnboarding(View v) {
        if (!this.d) {
            a(v);
        }
        this.e = true;
        this.b.setVisibility(0);
        v.setEnabled(false);
    }

    private void a(final View v) {
        this.d = true;
        ik.a().c().b(Schedulers.io()).a(apv.a()).b(new apr<ain>(this) {
            final /* synthetic */ SplashActivity b;

            public void onCompleted() {
                this.b.d = false;
            }

            public void onError(Throwable e) {
                Log.d("Splash", e.toString());
                if (e instanceof CompositeException) {
                    for (Throwable throwable : ((CompositeException) e).a()) {
                        Log.d("Splash", throwable.toString());
                    }
                }
                this.b.b.setVisibility(8);
                v.setEnabled(true);
                rk.c().a(new sk().a("splash_page").a(false));
                this.b.d = false;
            }

            public void onNext(ain result) {
                this.b.b.setVisibility(8);
                v.setEnabled(true);
                Map<String, Object> config = DataUtil.toMap(result.d("config"));
                Map<String, Object> onboarding = DataUtil.toMap(result.d("onboarding_data"));
                try {
                    AppState.internal = result.b("debug").h();
                    if (AppState.internal) {
                        this.b.c.setVisibility(0);
                    }
                    AppState.referralId = result.b("referral_id").c();
                } catch (Throwable e) {
                    rj.a(e);
                }
                try {
                    List<String> teenTags = DataUtil.toList(result.c("under_18_tags"), String.class);
                    List<String> adultTags = DataUtil.toList(result.c("18_plus_tags"), String.class);
                    AppState.setOnboardingTeenTags(teenTags);
                    AppState.setOnboardingAdultTags(adultTags);
                } catch (Throwable e2) {
                    rj.a(e2);
                }
                AppState.setConfig(config);
                AppState.setOnboardingTags(onboarding);
                if (this.b.e) {
                    this.b.startActivity(new Intent(v.getContext(), OnboardingActivity.class));
                    rk.c().a(new sk().a("splash_page").a(true));
                    this.b.finish();
                }
            }
        });
    }

    public void changeEndpoint(View v) {
        startActivity(new Intent(this, ChangeEndpointActivity.class));
    }

    protected void showSnack(boolean isConnected) {
        super.showSnack(isConnected);
        View parentView = findViewById(2131624291);
        if (!isConnected && parentView != null) {
            Snackbar.a(parentView, "No Internet connection!", 0).a();
        }
    }
}
