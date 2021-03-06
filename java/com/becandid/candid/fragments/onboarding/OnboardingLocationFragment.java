package com.becandid.candid.fragments.onboarding;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.activities.WebViewActivity;
import com.becandid.candid.data.AppState;
import defpackage.apr;
import defpackage.bb;
import defpackage.in$an;
import defpackage.in$w;
import defpackage.ix;
import defpackage.rj;
import defpackage.uu$h;

public class OnboardingLocationFragment extends Fragment {
    final int a = 0;
    Handler b;
    Runnable c = new Runnable(this) {
        final /* synthetic */ OnboardingLocationFragment a;

        {
            this.a = this$0;
        }

        public void run() {
            if (AppState.location == null) {
                Toast.makeText(this.a.getActivity(), "Location unavailable; we'll try again later", 1).show();
                this.a.spinny.setVisibility(8);
                ix.a().a(new in$an("location", "age"));
            }
        }
    };
    private Unbinder d;
    private boolean e = false;
    private boolean f = false;
    @BindView(2131624674)
    Button locationButton;
    @BindView(2131624671)
    TextView locationHeader;
    @BindView(2131624675)
    TextView locationInfo;
    @BindView(2131624672)
    TextView locationSubheader;
    @BindView(2131624676)
    TextView privacy;
    @BindView(2131624670)
    TextView skip;
    @BindView(2131624677)
    FrameLayout spinny;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968725, container, false);
        this.d = ButterKnife.bind(this, view);
        this.b = new Handler(getContext().getMainLooper());
        c();
        this.privacy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingLocationFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                Intent intent = new Intent(this.a.getContext(), WebViewActivity.class);
                intent.putExtra("title", "Why Can I Trust Candid?");
                intent.putExtra("url", GossipApplication.d + "content/whysafe");
                this.a.getContext().startActivity(intent);
            }
        });
        this.skip.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingLocationFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.a("location", "age");
            }
        });
        this.locationButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingLocationFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.a();
            }
        });
        return view;
    }

    private void c() {
        this.locationHeader.setText(AppState.config.getString("location_header", getString(2131230869)));
        this.locationSubheader.setText(AppState.config.getString("location_subheader", getString(2131230871)));
        this.locationInfo.setText(AppState.config.getString("location_info", getString(2131230870)));
        this.privacy.setText(AppState.config.getString("more_info", getString(2131230904)));
        this.locationButton.setText(AppState.config.getString("allow_location_button", getString(2131230868)));
    }

    public void a() {
        Log.d("Onboarding", "asking for location permission");
        if (bb.checkSelfPermission(getActivity(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 0);
            return;
        }
        b();
        GossipApplication.a().c();
    }

    public void b() {
        if (((LocationManager) getActivity().getSystemService("location")).isProviderEnabled("network")) {
            this.spinny.setVisibility(0);
            this.b.postDelayed(this.c, 5000);
        } else {
            new Builder(getActivity()).setTitle("Location Is Disabled").setMessage("Do you want to enable it?").setPositiveButton(2131230953, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ OnboardingLocationFragment a;

                {
                    this.a = this$0;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.a.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    this.a.f = true;
                    this.a.spinny.setVisibility(0);
                }
            }).setNegativeButton(2131230890, null).create().show();
        }
        ((BaseActivity) getActivity()).addToSubscriptionList(ix.a().a(in$w.class, new apr<in$w>(this) {
            final /* synthetic */ OnboardingLocationFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((in$w) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void a(in$w gotLocation) {
                if (!this.a.e) {
                    this.a.e = true;
                    Fragment fragment = this.a.getActivity().getSupportFragmentManager().findFragmentByTag("location");
                    if (fragment != null && fragment.isVisible()) {
                        this.a.spinny.setVisibility(8);
                        ix.a().a(new in$an("location", "age"));
                    }
                }
            }
        }));
    }

    public void onResume() {
        super.onResume();
        Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag("location");
        if (AppState.location != null && fragment != null && fragment.isVisible() && this.e) {
            this.spinny.setVisibility(8);
            a("location", "age");
        } else if (fragment != null && fragment.isVisible() && this.f) {
            this.b.postDelayed(this.c, 5000);
        } else {
            this.spinny.setVisibility(8);
        }
    }

    public void onPause() {
        super.onPause();
        this.b.removeCallbacks(this.c);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                if (grantResults.length <= 0 || grantResults[0] != 0) {
                    Log.d("Permissions", "Unable to get location permission; skip location");
                    ix.a().a(new in$an("location", "age"));
                    return;
                }
                b();
                GossipApplication.a().c();
                return;
            default:
                return;
        }
    }

    public void a(String fromTag, String toTag) {
        Activity activity = getActivity();
        if (activity instanceof OnboardingActivity) {
            ((OnboardingActivity) activity).switchFragment(fromTag, toTag);
        }
    }
}
