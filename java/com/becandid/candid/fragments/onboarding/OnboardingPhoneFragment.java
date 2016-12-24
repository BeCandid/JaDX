package com.becandid.candid.fragments.onboarding;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
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
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.models.NetworkData;
import defpackage.akn;
import defpackage.ako;
import defpackage.apr;
import defpackage.apv;
import defpackage.ha$a;
import defpackage.ik;
import defpackage.in$an;
import defpackage.ix;
import defpackage.rj;
import defpackage.rk;
import defpackage.ru;
import defpackage.uu$h;
import rx.schedulers.Schedulers;

public class OnboardingPhoneFragment extends Fragment {
    String a;
    private Unbinder b;
    @BindView(2131624683)
    TextView countryCode;
    @BindView(2131624684)
    EditText phone;
    @BindView(2131624680)
    TextView phoneHeader;
    @BindView(2131624710)
    TextView phoneInfo;
    @BindView(2131624711)
    TextView phonePrivacy;
    @BindView(2131624681)
    TextView phoneSubheader;
    @BindView(2131624685)
    Button phoneSubmit;
    @BindView(2131624679)
    TextView skip;
    @BindView(2131624712)
    FrameLayout spinny;
    @BindView(2131624686)
    RelativeLayout wrapper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.a = bundle.getString("second_fragment");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(2130968726, container, false);
        this.b = ButterKnife.bind(this, view);
        ((BaseActivity) getActivity()).enableKeyboardEvents(view);
        c();
        this.phonePrivacy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingPhoneFragment a;

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
        this.phone.requestFocus();
        ((BaseActivity) getActivity()).openKeyboard();
        Rect r = new Rect();
        view.getWindowVisibleDisplayFrame(r);
        final int pre = r.bottom - r.top;
        new Handler().postDelayed(new Runnable(this) {
            final /* synthetic */ OnboardingPhoneFragment c;

            public void run() {
                Rect r = new Rect();
                view.getWindowVisibleDisplayFrame(r);
                if (Float.compare(((float) (r.bottom - r.top)) / ((float) pre), 0.52f) >= 0) {
                    Fragment fragment = this.c.getActivity().getSupportFragmentManager().findFragmentByTag("phone");
                    if (fragment != null && fragment.isVisible()) {
                        this.c.wrapper.setVisibility(0);
                        this.c.a(view);
                    }
                }
            }
        }, 800);
        final akn picker = akn.a("Select Country");
        String skipPhone = AppState.config.getString("show_phone_skip", "sim");
        final String skipPhoneTo = AppState.config.getString("phone_skip_to", "contacts");
        boolean z = true;
        switch (skipPhone.hashCode()) {
            case 96673:
                if (skipPhone.equals("all")) {
                    z = false;
                    break;
                }
                break;
            case 113879:
                if (skipPhone.equals("sim")) {
                    z = true;
                    break;
                }
                break;
            case 3387192:
                if (skipPhone.equals("none")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                this.skip.setVisibility(0);
                this.skip.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ OnboardingPhoneFragment b;

                    public void onClick(View v) {
                        this.b.a(skipPhoneTo);
                    }
                });
                if (a()) {
                    this.countryCode.setText(picker.a(getActivity()).a());
                    break;
                }
                break;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                if (!a()) {
                    this.skip.setVisibility(0);
                    this.skip.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ OnboardingPhoneFragment b;

                        public void onClick(View v) {
                            this.b.a(skipPhoneTo);
                        }
                    });
                    break;
                }
                this.countryCode.setText(picker.a(getActivity()).a());
                break;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                if (a()) {
                    this.countryCode.setText(picker.a(getActivity()).a());
                    break;
                }
                break;
        }
        this.countryCode.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingPhoneFragment b;

            public void onClick(View v) {
                this.b.countryCode.setEnabled(false);
                picker.show(this.b.getFragmentManager(), "COUNTRY_PICKER");
                picker.a(new ako(this) {
                    final /* synthetic */ AnonymousClass6 a;

                    {
                        this.a = this$1;
                    }

                    public void a(String name, String code, String dialCode, int flagDrawableResID) {
                        this.a.b.countryCode.setText(dialCode);
                        this.a.b.countryCode.setEnabled(true);
                        picker.dismiss();
                    }
                });
            }
        });
        this.phoneSubmit.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingPhoneFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.b();
            }
        });
        this.phone.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ OnboardingPhoneFragment b;

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Button submit = (Button) view.findViewById(2131624685);
                if (s.length() >= 5) {
                    submit.setEnabled(true);
                } else {
                    submit.setEnabled(false);
                }
            }

            public void afterTextChanged(Editable s) {
            }
        });
        return view;
    }

    private void a(final String skipPhoneTo) {
        AppState.contactsInfo = null;
        ((BaseActivity) getActivity()).closeKeyboard();
        if (AppState.account != null) {
            rk.c().a((ru) new ru("Skip Phone Number").a("logged_in", "true"));
        } else {
            rk.c().a((ru) new ru("Skip Phone Number").a("logged_in", "false"));
        }
        if (this.a == null) {
            this.spinny.setVisibility(0);
            ik.a().e().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                final /* synthetic */ OnboardingPhoneFragment b;

                public /* synthetic */ void onNext(Object obj) {
                    a((NetworkData) obj);
                }

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    this.b.spinny.setVisibility(8);
                    rj.a(e);
                    Toast.makeText(this.b.getActivity(), 2131230926, 0).show();
                }

                public void a(NetworkData networkData) {
                    AppState.saveState(GossipApplication.a());
                    this.b.spinny.setVisibility(8);
                    if (!networkData.success) {
                        return;
                    }
                    if (networkData.is_new_user) {
                        ix.a().a(new in$an("phone", skipPhoneTo));
                    } else {
                        ((OnboardingActivity) this.b.getActivity()).finishSyncAccount();
                    }
                }
            });
        } else if (this.a.equals("fb")) {
            Bundle bundle = new Bundle();
            bundle.putString("second_fragment", this.a);
            ((OnboardingActivity) getActivity()).switchFragment("phone", this.a, bundle);
        } else {
            getActivity().setResult(-1);
            ((OnboardingActivity) getActivity()).finish();
        }
    }

    private void c() {
        this.phoneHeader.setText(AppState.config.getString("phone_header", getString(2131230896)));
        this.phoneSubheader.setText(AppState.config.getString("phone_subheader", getString(2131230899)));
        this.phone.setHint(AppState.config.getString("phone_input", getString(2131230898)));
        this.phonePrivacy.setText(AppState.config.getString("more_info", getString(2131230904)));
        this.phoneInfo.setText(AppState.config.getString("phone_info", getString(2131230897)));
    }

    public boolean a() {
        switch (((TelephonyManager) getActivity().getSystemService("phone")).getSimState()) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                return false;
            default:
                return true;
        }
    }

    public void a(View view) {
        Animation move_left = new TranslateAnimation(1, 0.0f, 1, -0.5f, 0, 0.0f, 0, 0.0f);
        move_left.setDuration(200);
        move_left.setStartOffset(800);
        move_left.setFillAfter(true);
        move_left.setFillEnabled(true);
        Animation move_right = new TranslateAnimation(1, 0.0f, 1, 0.5f, 0, 0.0f, 0, 0.0f);
        move_right.setDuration(200);
        move_right.setStartOffset(800);
        move_right.setFillAfter(true);
        move_right.setFillEnabled(true);
        Animation spark1 = a(-45, -10, 0, 2131624691, view);
        Animation spark2 = a(-28, -20, 60, 2131624692, view);
        Animation spark3 = a(-23, -35, 30, 2131624693, view);
        Animation spark4 = a(-2, -35, 80, 2131624694, view);
        Animation spark5 = a(18, -30, 120, 2131624695, view);
        Animation spark6 = a(16, 30, 30, 2131624696, view);
        Animation spark7 = a(-2, 35, 100, 2131624697, view);
        Animation spark8 = a(-30, 23, 40, 2131624698, view);
        Animation spark9 = a(-35, 8, 130, 2131624699, view);
        Animation spark10 = a(-15, -38, 180, 2131624700, view);
        Animation spark11 = a(3, -34, 60, 2131624701, view);
        Animation spark12 = a(22, -28, 80, 2131624702, view);
        Animation spark13 = a(29, -10, 140, 2131624703, view);
        Animation spark14 = a(30, 8, 40, 2131624704, view);
        Animation spark15 = a(20, 24, 50, 2131624705, view);
        Animation spark16 = a(4, 32, ha$a.AppCompatTheme_spinnerStyle, 2131624706, view);
        Animation spark17 = a(-16, 32, 30, 2131624707, view);
        view.findViewById(2131624708).startAnimation(move_left);
        view.findViewById(2131624709).startAnimation(move_right);
        view.findViewById(2131624691).startAnimation(spark1);
        view.findViewById(2131624692).startAnimation(spark2);
        view.findViewById(2131624693).startAnimation(spark3);
        view.findViewById(2131624694).startAnimation(spark4);
        view.findViewById(2131624695).startAnimation(spark5);
        view.findViewById(2131624696).startAnimation(spark6);
        view.findViewById(2131624697).startAnimation(spark7);
        view.findViewById(2131624698).startAnimation(spark8);
        view.findViewById(2131624699).startAnimation(spark9);
        view.findViewById(2131624700).startAnimation(spark10);
        view.findViewById(2131624701).startAnimation(spark11);
        view.findViewById(2131624702).startAnimation(spark12);
        view.findViewById(2131624703).startAnimation(spark13);
        view.findViewById(2131624704).startAnimation(spark14);
        view.findViewById(2131624705).startAnimation(spark15);
        view.findViewById(2131624706).startAnimation(spark16);
        view.findViewById(2131624707).startAnimation(spark17);
    }

    public Animation a(int endX, int endY, int offset, final int identifier, final View view) {
        float density = getResources().getDisplayMetrics().density;
        Animation spark = new TranslateAnimation(0, 0.0f, 0, ((float) endX) * density, 0, 0.0f, 0, ((float) endY) * density);
        spark.setInterpolator(new AccelerateDecelerateInterpolator());
        spark.setDuration(200);
        spark.setStartOffset((long) (offset + 1000));
        spark.setFillAfter(true);
        spark.setFillEnabled(true);
        spark.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ OnboardingPhoneFragment c;

            public void onAnimationStart(Animation animation) {
                new Handler().postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass10 a;

                    {
                        this.a = this$1;
                    }

                    public void run() {
                        view.findViewById(identifier).setVisibility(0);
                    }
                }, 1000);
            }

            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        return spark;
    }

    public void b() {
        this.phoneSubmit.setEnabled(false);
        String phoneNumber = this.phone.getText().toString();
        String code = this.countryCode.getText().toString();
        if (AppState.contactsInfo == null) {
            AppState.contactsInfo = new ContactsInfo();
        }
        AppState.contactsInfo.phone_number = code + phoneNumber;
        this.spinny.setVisibility(0);
        ik.a().h(AppState.contactsInfo.phone_number).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
            final /* synthetic */ OnboardingPhoneFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                if (AppState.account != null) {
                    rk.c().a((ru) ((ru) new ru("Connect Phone Number").a("success", "false")).a("logged_in", "true"));
                } else {
                    rk.c().a((ru) ((ru) new ru("Connect Phone Number").a("success", "false")).a("logged_in", "false"));
                }
                this.a.spinny.setVisibility(8);
                this.a.phoneSubmit.setEnabled(true);
                Toast.makeText(this.a.getActivity(), e.toString(), 0).show();
            }

            public void a(NetworkData networkData) {
                if (AppState.account != null) {
                    rk.c().a((ru) ((ru) new ru("Connect Phone Number").a("success", "true")).a("logged_in", "true"));
                } else {
                    rk.c().a((ru) ((ru) new ru("Connect Phone Number").a("success", "true")).a("logged_in", "false"));
                }
                if (networkData == null || !networkData.success) {
                    this.a.spinny.setVisibility(8);
                    this.a.phoneSubmit.setEnabled(true);
                    if (networkData != null) {
                        Toast.makeText(this.a.getActivity(), networkData.error, 0).show();
                        return;
                    }
                    return;
                }
                this.a.spinny.setVisibility(8);
                Bundle bundle = new Bundle();
                if (this.a.a != null) {
                    bundle.putString("second_fragment", this.a.a);
                }
                ((OnboardingActivity) this.a.getActivity()).switchFragment("phone", "verify", bundle);
                ((BaseActivity) this.a.getActivity()).closeKeyboard();
            }
        });
    }
}
