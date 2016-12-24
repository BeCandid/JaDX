package com.becandid.candid.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import defpackage.ev;
import defpackage.hr;
import defpackage.uu$h;

public class TutorialPostActivity extends FragmentActivity {
    private ev a;
    @BindView(2131624308)
    ImageView ind1;
    @BindView(2131624309)
    ImageView ind2;
    @BindView(2131624310)
    ImageView ind3;
    @BindView(2131624311)
    ImageView ind4;
    @BindView(2131624307)
    ViewPager viewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968634);
        ButterKnife.bind(this);
        this.a = new hr(getSupportFragmentManager());
        this.viewPager.setAdapter(this.a);
        this.viewPager.a(new e(this) {
            final /* synthetic */ TutorialPostActivity a;

            {
                this.a = this$0;
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                Drawable active = this.a.getResources().getDrawable(2130838092);
                Drawable inactive = this.a.getResources().getDrawable(2130838088);
                this.a.ind1.setImageDrawable(inactive);
                this.a.ind2.setImageDrawable(inactive);
                this.a.ind3.setImageDrawable(inactive);
                this.a.ind4.setImageDrawable(inactive);
                switch (position) {
                    case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                        this.a.ind1.setImageDrawable(active);
                        return;
                    case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                        this.a.ind2.setImageDrawable(active);
                        return;
                    case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                        this.a.ind3.setImageDrawable(active);
                        return;
                    case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                        this.a.ind4.setImageDrawable(active);
                        return;
                    default:
                        return;
                }
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void onBackPressed() {
    }
}
