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
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.views.TabViewPager;
import defpackage.apr;
import defpackage.hq;
import defpackage.hs;
import defpackage.ht;
import defpackage.in$ah;
import defpackage.ix;
import defpackage.rj;
import defpackage.uu$h;
import java.util.ArrayList;
import java.util.List;

public class FeedTabFragment extends ht implements a {
    BaseActivity d;
    private hq e;
    private List<String> f;
    @BindView(2131624421)
    View mFeedTab;
    @BindView(2131624422)
    TabLayout mFeedTabs;
    @BindView(2131624424)
    View mNewPostsText;
    @BindView(2131624423)
    TabViewPager viewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(2130968668, container, false);
        this.b = ButterKnife.bind(this, root);
        this.d = (BaseActivity) getActivity();
        this.a = getContext();
        this.mFeedTabs.setSelectedTabIndicatorColor(getResources().getColor(2131558476));
        this.mFeedTabs.setTabTextColors(Color.parseColor("#888888"), getResources().getColor(2131558476));
        this.f = AppState.tabsOrder;
        if (this.f == null || this.f.isEmpty()) {
            this.f = new ArrayList();
            this.f.add("home");
            this.f.add("trending");
            this.f.add("friends");
        }
        this.e = new hq(this.d.getSupportFragmentManager());
        for (String tab : this.f) {
            hs feedFragment = new hs();
            Bundle args = new Bundle();
            args.putString("feed_type", tab);
            feedFragment.setArguments(args);
            this.e.a(feedFragment, a(tab));
        }
        this.viewPager.setAdapter(this.e);
        this.viewPager.setOffscreenPageLimit(2);
        this.viewPager.setCurrTab("feed");
        this.mFeedTabs.setupWithViewPager(this.viewPager);
        this.mFeedTabs.setOnTabSelectedListener(this);
        ((BaseActivity) this.a).addToSubscriptionList(ix.a().a(in$ah.class, new apr<in$ah>(this) {
            final /* synthetic */ FeedTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((in$ah) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void a(in$ah relatedPosts) {
                if (AppState.relatedPosts != null && !AppState.relatedPosts.isEmpty() && this.a.viewPager != null && !relatedPosts.b) {
                    this.a.viewPager.setCurrentItem(0);
                }
            }
        }));
        return root;
    }

    private String a(String tab) {
        Object obj = -1;
        switch (tab.hashCode()) {
            case 3208415:
                if (tab.equals("home")) {
                    obj = null;
                    break;
                }
                break;
            case 1394955557:
                if (tab.equals("trending")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                return "New";
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return "Hot";
            default:
                return "Friends";
        }
    }

    public void onTabSelected(d tab) {
        this.viewPager.setCurrentItem(tab.c(), true);
    }

    public void onTabUnselected(d tab) {
    }

    public void onTabReselected(d tab) {
        ((hs) this.e.getItem(tab.c())).a(0);
    }

    public void a() {
        super.a();
        if (this.viewPager != null) {
            for (int i = 0; i < this.viewPager.getChildCount(); i++) {
                ((hs) this.e.getItem(i)).a(0);
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.d != null && this.d.callbackManager != null) {
            this.d.callbackManager.a(requestCode, resultCode, data);
        }
    }

    public void a(int upsellId) {
        ((hs) this.e.getItem(this.viewPager.getCurrentItem())).b(upsellId);
    }

    public void onResume() {
        super.onResume();
    }

    public void b() {
        if (this.mFeedTab != null) {
            this.mFeedTab.setVisibility(0);
        }
    }

    public void c() {
        if (this.mFeedTab != null) {
            this.mFeedTab.setVisibility(8);
        }
    }
}
