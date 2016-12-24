package com.becandid.candid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.GroupStackView;
import com.becandid.candid.views.GroupStackView.c;
import defpackage.apr;
import defpackage.apv;
import defpackage.ik;
import defpackage.rj;
import java.util.ArrayList;
import rx.schedulers.Schedulers;

public class OnboardingGroupsActivity extends BaseActivity implements c {
    private int b;
    private int c;
    @BindView(2131624260)
    Button ogButton;
    @BindView(2131624262)
    TextView ogEmpty;
    @BindView(2131624258)
    TextView ogHeader;
    @BindView(2131624261)
    LinearLayout ogSpinny;
    @BindView(2131624259)
    GroupStackView ogStack;

    protected void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(2130968626);
        ButterKnife.bind(this);
        c();
        this.ogStack.setListener(this);
        AppState.groups = new ArrayList();
        this.b = 0;
        this.c = AppState.config.getInt("onboarding_num_groups", 10);
        a();
    }

    private void a() {
        this.ogButton.setEnabled(false);
        this.ogSpinny.setVisibility(0);
        ik.a().f().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
            final /* synthetic */ OnboardingGroupsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
                Toast.makeText(this.a, "Unable to get get your recommended groups. Please try again", 0).show();
                rj.a(e);
                Log.d("OnboardingGroups", e.toString());
                this.a.ogSpinny.setVisibility(8);
                this.a.b();
            }

            public void onNext(NetworkData networkData) {
                this.a.ogStack.setGroups(networkData.groups);
                new Handler().postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = this$1;
                    }

                    public void run() {
                        this.a.a.ogSpinny.setVisibility(8);
                        this.a.a.ogStack.setVisibility(0);
                    }
                }, 500);
            }
        });
    }

    private void b() {
        this.ogButton.setText("Retry");
        this.ogButton.setEnabled(true);
        this.ogButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingGroupsActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.c();
                this.a.ogButton.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 a;

                    {
                        this.a = this$1;
                    }

                    public void onClick(View v) {
                        this.a.a.launchMainActivity(this.a.a.ogButton);
                    }
                });
                this.a.a();
            }
        });
    }

    private void c() {
        this.ogHeader.setText(AppState.config.getString("onboarding_groups_header", getString(2131230863)));
        this.ogButton.setText(AppState.config.getString("onboarding_groups_done", getString(2131230854)));
    }

    public void onBackPressed() {
    }

    public void launchMainActivity(View view) {
        Intent intent;
        if (AppState.referralPostId != 0) {
            intent = new Intent(this, PostDetailsActivity.class);
            intent.putExtra("post_id", AppState.referralPostId);
        } else {
            intent = new Intent(this, MainTabsActivity.class);
        }
        startActivity(intent);
        finish();
    }

    public void onJoinGroup(Group group) {
        this.b++;
        if (this.b >= this.c || this.ogStack.a() <= 1) {
            this.ogButton.setEnabled(true);
        }
    }

    public void onSkipGroup(Group group) {
        if (this.ogStack.a() <= 1) {
            this.ogButton.setEnabled(true);
        }
    }

    public void onTouchEvent(Group group) {
    }

    public void onEmptyGroups() {
        this.ogStack.setVisibility(8);
        this.ogEmpty.setVisibility(0);
    }
}
