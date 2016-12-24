package com.becandid.candid.fragments.main_tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.NotificationSettingsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.models.NetworkData;
import defpackage.aou;
import defpackage.apr;
import defpackage.aps;
import defpackage.apv;
import defpackage.hb;
import defpackage.hn;
import defpackage.ht;
import defpackage.ik;
import defpackage.in$as;
import defpackage.iv;
import defpackage.ix;
import defpackage.rj;
import rx.schedulers.Schedulers;

public class ActivityTabFragment extends ht implements OnClickListener {
    private hb d;
    private aps e;
    private long f;
    @BindView(2131624298)
    View mEmptyView;
    @BindView(2131624297)
    RecyclerView mRecyclerView;
    @BindView(2131624295)
    View mSettingView;
    @BindView(2131624296)
    SwipeRefreshLayout mSwipeRefresh;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(2130968631, container, false);
        this.b = ButterKnife.bind(this, root);
        this.a = getContext();
        aou.a(this.a);
        this.mSettingView.setOnClickListener(this);
        this.mSwipeRefresh.setColorSchemeColors(new int[]{2131558476});
        this.mSwipeRefresh.setOnRefreshListener(new OnRefreshListener(this) {
            final /* synthetic */ ActivityTabFragment a;

            {
                this.a = this$0;
            }

            public void onRefresh() {
                if (this.a.e != null) {
                    this.a.e.unsubscribe();
                }
                this.a.e = this.a.a(true);
                this.a.d.c();
            }
        });
        LinearLayoutManager llm = new LinearLayoutManager(this.a);
        this.mRecyclerView.setLayoutManager(llm);
        this.mRecyclerView.addOnItemTouchListener(new iv(this, this.a) {
            final /* synthetic */ ActivityTabFragment a;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onItemClick(android.view.View r10, int r11) {
                /*
                r9 = this;
                r6 = 1;
                r4 = 0;
                if (r11 < 0) goto L_0x0014;
            L_0x0004:
                r5 = r9.a;
                r5 = r5.d;
                r5 = r5.e();
                r5 = r5.size();
                if (r11 < r5) goto L_0x0022;
            L_0x0014:
                r5 = r9.a;
                r5 = r5.a;
                r6 = "Unable to find that notification";
                r4 = android.widget.Toast.makeText(r5, r6, r4);
                r4.show();
            L_0x0021:
                return;
            L_0x0022:
                r5 = r9.a;
                r5 = r5.d;
                r5 = r5.e();
                r0 = r5.get(r11);
                r0 = (com.becandid.candid.data.Notification) r0;
                r0.unread = r4;
                r5 = r9.a;
                r5 = r5.d;
                r5.notifyItemChanged(r11);
                r5 = defpackage.ik.a();
                r7 = r0.activity_id;
                r5 = r5.a(r7);
                r7 = rx.schedulers.Schedulers.io();
                r5 = r5.b(r7);
                r7 = defpackage.apv.a();
                r5 = r5.a(r7);
                r7 = new com.becandid.candid.models.EmptySubscriber;
                r7.<init>();
                r5.b(r7);
                r5 = r0.onclick;
                r7 = ":";
                r2 = r5.split(r7);
                r5 = r2[r6];
                r5 = java.lang.Integer.valueOf(r5);
                r3 = r5.intValue();
                r7 = r2[r4];
                r5 = -1;
                r8 = r7.hashCode();
                switch(r8) {
                    case -1925545598: goto L_0x00bc;
                    case -1572993592: goto L_0x00b2;
                    case -338943683: goto L_0x00a9;
                    case 2067279704: goto L_0x00c6;
                    default: goto L_0x007b;
                };
            L_0x007b:
                r4 = r5;
            L_0x007c:
                switch(r4) {
                    case 0: goto L_0x0080;
                    case 1: goto L_0x00d0;
                    case 2: goto L_0x00f5;
                    case 3: goto L_0x010e;
                    default: goto L_0x007f;
                };
            L_0x007f:
                goto L_0x0021;
            L_0x0080:
                r1 = new android.content.Intent;
                r4 = r9.a;
                r4 = r4.a;
                r5 = com.becandid.candid.activities.PostDetailsActivity.class;
                r1.<init>(r4, r5);
                r4 = "post_id";
                r1.putExtra(r4, r3);
                r4 = r0.comment_id;
                if (r4 <= 0) goto L_0x00a0;
            L_0x0094:
                r4 = "comment_id";
                r5 = r0.comment_id;
                r1.putExtra(r4, r5);
                r4 = "scrollToBottom";
                r1.putExtra(r4, r6);
            L_0x00a0:
                r4 = r9.a;
                r4 = r4.a;
                r4.startActivity(r1);
                goto L_0x0021;
            L_0x00a9:
                r8 = "showPost";
                r7 = r7.equals(r8);
                if (r7 == 0) goto L_0x007b;
            L_0x00b1:
                goto L_0x007c;
            L_0x00b2:
                r4 = "showPostBottom";
                r4 = r7.equals(r4);
                if (r4 == 0) goto L_0x007b;
            L_0x00ba:
                r4 = r6;
                goto L_0x007c;
            L_0x00bc:
                r4 = "showGroup";
                r4 = r7.equals(r4);
                if (r4 == 0) goto L_0x007b;
            L_0x00c4:
                r4 = 2;
                goto L_0x007c;
            L_0x00c6:
                r4 = "showTab";
                r4 = r7.equals(r4);
                if (r4 == 0) goto L_0x007b;
            L_0x00ce:
                r4 = 3;
                goto L_0x007c;
            L_0x00d0:
                r1 = new android.content.Intent;
                r4 = r9.a;
                r4 = r4.a;
                r5 = com.becandid.candid.activities.PostDetailsActivity.class;
                r1.<init>(r4, r5);
                r4 = "post_id";
                r1.putExtra(r4, r3);
                r4 = "comment_id";
                r5 = r0.comment_id;
                r1.putExtra(r4, r5);
                r4 = "scrollToBottom";
                r1.putExtra(r4, r6);
                r4 = r9.a;
                r4 = r4.a;
                r4.startActivity(r1);
                goto L_0x0021;
            L_0x00f5:
                r1 = new android.content.Intent;
                r4 = r9.a;
                r4 = r4.a;
                r5 = com.becandid.candid.activities.GroupDetailsActivity.class;
                r1.<init>(r4, r5);
                r4 = "group_id";
                r1.putExtra(r4, r3);
                r4 = r9.a;
                r4 = r4.a;
                r4.startActivity(r1);
                goto L_0x0021;
            L_0x010e:
                r4 = defpackage.ix.a();
                r5 = new in$e;
                r5.<init>(r3);
                r4.a(r5);
                goto L_0x0021;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.becandid.candid.fragments.main_tabs.ActivityTabFragment.2.onItemClick(android.view.View, int):void");
            }
        });
        this.d = new hb(this.a);
        this.mRecyclerView.setAdapter(this.d);
        this.mRecyclerView.addOnScrollListener(new hn(this, llm, this.d) {
            final /* synthetic */ ActivityTabFragment a;

            public void onLoadMore(String minPostId) {
                if (minPostId != null) {
                    ik.a().b(Boolean.toString(true), minPostId).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                        final /* synthetic */ AnonymousClass3 a;

                        {
                            this.a = this$1;
                        }

                        public /* synthetic */ void onNext(Object obj) {
                            a((NetworkData) obj);
                        }

                        public void onCompleted() {
                        }

                        public void onError(Throwable e) {
                        }

                        public void a(NetworkData data) {
                            if (data == null || data.activity == null || data.activity.isEmpty()) {
                                this.a.a.d.a(null);
                                return;
                            }
                            this.a.a.d.b(data.activity);
                            this.a.a.d.a(String.valueOf(data.last_activity_id));
                        }
                    });
                }
            }
        });
        this.e = a(false);
        return root;
    }

    private apr d() {
        return new apr<NetworkData>(this) {
            final /* synthetic */ ActivityTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
                this.a.mSwipeRefresh.setRefreshing(false);
                this.a.e();
            }

            public void onError(Throwable e) {
                this.a.mSwipeRefresh.setRefreshing(false);
                this.a.e();
                rj.a(e);
            }

            public void a(NetworkData data) {
                this.a.d.a(data.activity);
                this.a.d.a(String.valueOf(data.last_activity_id));
                ix.a().a(new in$as(3, data.unread_count, true));
                ix.a().a(new in$as(1, data.unread_groups_count, true));
            }
        };
    }

    private aps a(boolean markRead) {
        int readInt = 1;
        this.mSwipeRefresh.setRefreshing(true);
        this.f = System.currentTimeMillis();
        if (!markRead) {
            readInt = 0;
        }
        return ik.a().b(Integer.toString(readInt), null).b(Schedulers.io()).a(apv.a()).b(d());
    }

    private void e() {
        if (this.d.d()) {
            Log.d("Toggle", "not empty");
            this.mRecyclerView.setVisibility(0);
            this.mEmptyView.setVisibility(8);
            return;
        }
        Log.d("Toggle", "empty");
        this.mRecyclerView.setVisibility(8);
        this.mEmptyView.setVisibility(0);
    }

    public void onResume() {
        super.onResume();
        if (AppState.account != null) {
            this.e = a(true);
        }
        aou.a(this.a);
    }

    public void onClick(View v) {
        if (v.getId() == 2131624295) {
            getContext().startActivity(new Intent(getContext(), NotificationSettingsActivity.class));
        }
    }

    public void a() {
        super.a();
        this.mRecyclerView.scrollToPosition(0);
        if (this.e != null) {
            this.e.unsubscribe();
        }
        this.e = a(false);
        this.d.c();
        this.c = false;
    }

    public void b() {
    }

    public void c() {
    }
}
