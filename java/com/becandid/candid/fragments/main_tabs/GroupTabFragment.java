package com.becandid.candid.fragments.main_tabs;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.a;
import android.support.design.widget.TabLayout.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.GroupStackView;
import com.becandid.candid.views.GroupStackView.c;
import defpackage.apr;
import defpackage.apv;
import defpackage.ht;
import defpackage.ik;
import defpackage.rj;
import rx.schedulers.Schedulers;

public class GroupTabFragment extends ht implements c {
    private long d = 0;
    @BindView(2131624512)
    View discoverEmpty;
    @BindView(2131624508)
    View forYouEmpty;
    @BindView(2131624514)
    GroupStackView groupStackView;
    @BindView(2131624513)
    View loading;
    @BindView(2131624507)
    TabLayout tabBar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(2130968691, container, false);
        this.b = ButterKnife.bind(this, root);
        this.a = getContext();
        this.groupStackView.setListener(this);
        this.tabBar.setSelectedTabIndicatorColor(getResources().getColor(2131558476));
        this.tabBar.setTabTextColors(Color.parseColor("#888888"), getResources().getColor(2131558476));
        this.tabBar.a(this.tabBar.a().a("For You"));
        this.tabBar.a(this.tabBar.a().a("Discover"));
        this.tabBar.setOnTabSelectedListener(new a(this) {
            final /* synthetic */ GroupTabFragment a;

            {
                this.a = this$0;
            }

            public void onTabSelected(d tab) {
                this.a.a(true);
            }

            public void onTabUnselected(d tab) {
            }

            public void onTabReselected(d tab) {
                this.a.a();
            }
        });
        return root;
    }

    public void onResume() {
        super.onResume();
        if (this.tabBar != null && this.tabBar.getSelectedTabPosition() == 1) {
            this.tabBar.a(0).e();
        }
        a(true);
    }

    private void a(final boolean fullLoad) {
        boolean forYou = false;
        if (fullLoad && this.groupStackView != null) {
            this.groupStackView.setVisibility(8);
            this.forYouEmpty.setVisibility(8);
            this.discoverEmpty.setVisibility(8);
            this.loading.setVisibility(0);
        }
        if (this.tabBar.getSelectedTabPosition() == 0) {
            forYou = true;
        }
        ik.a().a(AppState.fbInfo, forYou).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
            final /* synthetic */ GroupTabFragment c;

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
                if (this.c.loading != null) {
                    this.c.loading.setVisibility(8);
                }
            }

            public void a(NetworkData networkData) {
                if (this.c.tabBar != null) {
                    boolean z;
                    boolean z2 = forYou;
                    if (this.c.tabBar.getSelectedTabPosition() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2 != z) {
                        return;
                    }
                }
                this.c.loading.setVisibility(8);
                if (networkData != null && networkData.groups != null) {
                    if ((!fullLoad && this.c.groupStackView.a() != 0) || networkData.groups.size() != 0) {
                        this.c.groupStackView.setVisibility(0);
                    } else if (forYou) {
                        this.c.forYouEmpty.setVisibility(0);
                    } else {
                        this.c.discoverEmpty.setVisibility(0);
                    }
                    this.c.groupStackView.setGroups(networkData.groups);
                }
            }
        });
    }

    public void onJoinGroup(Group group) {
    }

    public void onSkipGroup(Group group) {
    }

    public void onTouchEvent(Group group) {
        long thisTime = System.currentTimeMillis();
        if (thisTime - this.d < 250) {
            Intent intent = new Intent(this.a, GroupDetailsActivity.class);
            intent.putExtra("group_id", group.group_id);
            this.a.startActivity(intent);
            return;
        }
        this.d = thisTime;
    }

    public void onEmptyGroups() {
        this.groupStackView.setVisibility(8);
        if (this.tabBar.getSelectedTabPosition() == 0) {
            this.forYouEmpty.setVisibility(0);
        } else {
            this.discoverEmpty.setVisibility(0);
        }
    }

    public void b() {
    }

    public void c() {
    }

    public void a() {
        super.a();
        a(true);
        this.c = false;
    }
}
