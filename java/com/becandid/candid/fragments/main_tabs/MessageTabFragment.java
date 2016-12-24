package com.becandid.candid.fragments.main_tabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.a;
import android.support.design.widget.TabLayout.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.MessageSearchActivity;
import com.becandid.candid.activities.MessageSettingsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.TabViewPager;
import com.becandid.thirdparty.BlurTask;
import com.becandid.thirdparty.BlurTask.BadgeType;
import defpackage.aou;
import defpackage.apr;
import defpackage.aps;
import defpackage.apv;
import defpackage.hq;
import defpackage.ht;
import defpackage.hz;
import defpackage.ia;
import defpackage.ib;
import defpackage.ik;
import defpackage.in$aa;
import defpackage.in$ae;
import defpackage.in$as;
import defpackage.in$j;
import defpackage.in$u;
import defpackage.in$x;
import defpackage.ix;
import defpackage.rj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class MessageTabFragment extends ht {
    private Context d;
    private BaseActivity e;
    private hq f;
    private hz g;
    private ib h;
    private ia i;
    private aps j;
    @BindView(2131624557)
    View messagesContainer;
    @BindView(2131624558)
    TextView messagesSearch;
    @BindView(2131624559)
    ImageView messagesSettings;
    @BindView(2131624563)
    FrameLayout messagesSpinny;
    @BindView(2131624562)
    TextView messagingDisabled;
    @BindView(2131624560)
    TabLayout tabBar;
    @BindView(2131624561)
    TabViewPager viewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(2130968702, container, false);
        this.b = ButterKnife.bind(this, root);
        this.e = (BaseActivity) getActivity();
        this.d = (BaseActivity) getActivity();
        this.a = getContext();
        this.messagesSearch.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessageTabFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.d.startActivity(new Intent(this.a.d, MessageSearchActivity.class));
            }
        });
        this.messagesSettings.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessageTabFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.d.startActivity(new Intent(this.a.d, MessageSettingsActivity.class));
            }
        });
        this.f = new hq(this.e.getSupportFragmentManager());
        this.g = new hz();
        this.h = new ib();
        this.i = new ia();
        this.f.a(this.g, "ACTIVE");
        this.f.a(this.h, "THREADS");
        this.f.a(this.i, "REQUESTS");
        this.viewPager.setAdapter(this.f);
        this.viewPager.setOffscreenPageLimit(2);
        this.viewPager.setCurrTab("messages");
        this.tabBar.setupWithViewPager(this.viewPager);
        for (int i = 0; i < this.tabBar.getTabCount(); i++) {
            TextView tab = (TextView) LayoutInflater.from(this.d).inflate(2130968649, null);
            tab.setText(this.tabBar.a(i).d());
            tab.setCompoundDrawablePadding(0);
            this.tabBar.a(i).a(tab);
        }
        this.tabBar.setSelectedTabIndicatorColor(getResources().getColor(2131558476));
        this.tabBar.setTabTextColors(Color.parseColor("#888888"), getResources().getColor(2131558476));
        this.tabBar.setOnTabSelectedListener(new a(this) {
            final /* synthetic */ MessageTabFragment a;

            {
                this.a = this$0;
            }

            public void onTabSelected(d tab) {
                TextView tabView = (TextView) tab.a();
                tabView.setTextColor(this.a.getResources().getColor(2131558476));
                tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.a.viewPager.setCurrentItem(tab.c(), true);
                if (tab.c() == 0) {
                    tabView = (TextView) this.a.tabBar.a(1).a();
                    tabView.setTextColor(Color.parseColor("#888888"));
                    tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else if (tab.c() == 1) {
                    tabView = (TextView) this.a.tabBar.a(0).a();
                    tabView.setTextColor(Color.parseColor("#888888"));
                    tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }

            public void onTabUnselected(d tab) {
                TextView tabView = (TextView) tab.a();
                tabView.setTextColor(Color.parseColor("#888888"));
                tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                if (tab.c() == 0) {
                    tabView = (TextView) this.a.tabBar.a(1).a();
                    tabView.setTextColor(Color.parseColor("#888888"));
                    tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else if (tab.c() == 1) {
                    tabView = (TextView) this.a.tabBar.a(0).a();
                    tabView.setTextColor(Color.parseColor("#888888"));
                    tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }

            public void onTabReselected(d tab) {
                TextView tabView = (TextView) tab.a();
                tabView.setTextColor(this.a.getResources().getColor(2131558476));
                tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.a.e();
            }
        });
        this.j = e();
        if (AppState.account != null) {
            a(AppState.account.messaging_disabled);
        }
        ((BaseActivity) this.d).addToSubscriptionList(ix.a().a(in$aa.class, new apr<in$aa>(this) {
            final /* synthetic */ MessageTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((in$aa) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void a(in$aa messagingDisabled) {
                this.a.a(messagingDisabled.a);
            }
        }));
        ((BaseActivity) this.d).addToSubscriptionList(ix.a().a(in$x.class, new apr<in$x>(this) {
            final /* synthetic */ MessageTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((in$x) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void a(in$x handleMessageRequest) {
                this.a.j = this.a.e();
            }
        }));
        ((BaseActivity) this.d).addToSubscriptionList(ix.a().a(in$ae.class, new apr<in$ae>(this) {
            final /* synthetic */ MessageTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((in$ae) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void a(final in$ae newMessage) {
                int request = 1;
                boolean foundActive = this.a.g.a(newMessage);
                boolean foundThread = this.a.h.a(newMessage);
                boolean foundRequest = this.a.i.a(newMessage);
                if (((foundActive | foundThread) | foundRequest) == 0) {
                    Map<String, String> params = new HashMap();
                    params.put("post_id", Integer.toString(newMessage.b));
                    params.put("post_name", newMessage.d);
                    ik.a().n(params).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                        final /* synthetic */ AnonymousClass7 b;

                        public /* synthetic */ void onNext(Object obj) {
                            a((NetworkData) obj);
                        }

                        public void onCompleted() {
                        }

                        public void onError(Throwable e) {
                        }

                        public void a(NetworkData networkData) {
                            if (networkData.success) {
                                MessageThread thread = networkData.thread;
                                thread.unread_messages = 1;
                                ((Message) thread.messages.get(0)).subject = newMessage.c;
                                if (thread.is_request == 1) {
                                    this.b.a.i.a(thread);
                                    this.b.a.a(0, 0, 1);
                                    return;
                                }
                                this.b.a.h.a(thread);
                                if (thread.online == 1) {
                                    this.b.a.g.a(thread);
                                    this.b.a.a(1, 1, 0);
                                    return;
                                }
                                this.b.a.a(0, 1, 0);
                                return;
                            }
                            Toast.makeText(this.b.a.d, networkData.error, 0).show();
                        }
                    });
                    return;
                }
                int active;
                int thread;
                if (foundActive) {
                    active = 1;
                } else {
                    active = 0;
                }
                if (foundThread) {
                    thread = 1;
                } else {
                    thread = 0;
                }
                if (!foundRequest) {
                    request = 0;
                }
                this.a.a(active, thread, request);
            }
        }));
        ((BaseActivity) this.d).addToSubscriptionList(ix.a().a(in$u.class, new apr<in$u>(this) {
            final /* synthetic */ MessageTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((in$u) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void a(in$u dynamicMessageTabSelection) {
                MessageThread lastActivity = this.a.g.b();
                MessageThread lastRequest = this.a.i.b();
                MessageThread lastThread = this.a.h.b();
                if (lastRequest == null && lastThread == null) {
                    this.a.viewPager.setCurrentItem(1, true);
                } else if (lastRequest != null && lastThread == null) {
                    this.a.viewPager.setCurrentItem(2, true);
                } else if (lastRequest == null && lastThread != null) {
                    this.a.viewPager.setCurrentItem(1, true);
                } else if (lastRequest != null && lastThread != null) {
                    if (lastRequest.unread_messages > 0 && lastThread.unread_messages == 0) {
                        this.a.viewPager.setCurrentItem(2, true);
                    } else if (lastRequest.unread_messages == 0 && lastThread.unread_messages > 0) {
                        this.a.viewPager.setCurrentItem(1, true);
                    } else if (lastRequest.unread_messages <= 0 || lastThread.unread_messages <= 0) {
                        this.a.viewPager.setCurrentItem(1, true);
                    } else if (((Message) lastRequest.messages.get(0)).sent_time > ((Message) lastThread.messages.get(0)).sent_time) {
                        this.a.viewPager.setCurrentItem(2, true);
                    } else {
                        this.a.viewPager.setCurrentItem(1, true);
                    }
                }
            }
        }));
        ((BaseActivity) this.d).addToSubscriptionList(ix.a().a(in$j.class, new apr<in$j>(this) {
            final /* synthetic */ MessageTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((in$j) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void a(in$j deleteThread) {
                if (deleteThread != null) {
                    this.a.g.a(deleteThread.a, deleteThread.b);
                    this.a.h.a(deleteThread.a, deleteThread.b);
                    this.a.i.a(deleteThread.a, deleteThread.b);
                }
            }
        }));
        return root;
    }

    public void onResume() {
        super.onResume();
        aou.a(this.d);
        ik.a().g().b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        ix.a().a(new in$as(2, 0, true));
        this.j = e();
    }

    public void d() {
        final View view = ((Activity) this.d).findViewById(16908290);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ MessageTabFragment b;

            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (AppState.hasMessagingShown) {
                    ((MainTabsActivity) this.b.d).setShowMessagingPopup(false);
                    return;
                }
                new BlurTask((Activity) this.b.d, ((Activity) this.b.d).findViewById(16908290), BadgeType.MESSAGE_ENABLED_TAB).execute(new Void[0]);
                AppState.hasMessagingShown = true;
                AppState.saveState(GossipApplication.a());
            }
        });
    }

    public aps e() {
        Map<String, String> params = new HashMap();
        params.put("include_messages", "1");
        return ik.a().p(params).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
            final /* synthetic */ MessageTabFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
                this.a.c = false;
            }

            public void onError(Throwable e) {
                rj.a(e);
                this.a.c = false;
            }

            public void a(NetworkData networkData) {
                if (networkData.threads != null) {
                    this.a.h.a(networkData.threads);
                    ArrayList<MessageThread> online = new ArrayList();
                    for (MessageThread thread : networkData.threads) {
                        if (thread.online == 1) {
                            online.add(thread);
                        }
                    }
                    this.a.g.a((List) online);
                    if (networkData.thread_next_page > 0) {
                        this.a.h.a(Integer.toString(networkData.thread_next_page));
                        this.a.g.a(Integer.toString(networkData.thread_next_page));
                    }
                }
                if (networkData.requests != null) {
                    this.a.i.a(networkData.requests);
                    if (networkData.request_next_page > 0) {
                        this.a.i.a(Integer.toString(networkData.request_next_page));
                    }
                }
                this.a.a(0, networkData.new_threads, networkData.new_requests);
                ix.a().a(new in$as(2, networkData.new_threads + networkData.new_requests, true));
                this.a.f();
            }
        });
    }

    public void f() {
        this.g.a();
        this.h.a();
        this.i.a();
    }

    public void a(int activeUnread, int threadUnread, int requestUnread) {
        if (this.tabBar != null) {
            int unreadDot;
            int position = this.viewPager.getCurrentItem();
            if (activeUnread <= 0 || position == 0 || position == 1) {
                unreadDot = 0;
            } else {
                unreadDot = 2130838257;
            }
            ((TextView) this.tabBar.a(0).a()).setCompoundDrawablesWithIntrinsicBounds(0, 0, unreadDot, 0);
            if (threadUnread <= 0 || position == 0 || position == 1) {
                unreadDot = 0;
            } else {
                unreadDot = 2130838257;
            }
            ((TextView) this.tabBar.a(1).a()).setCompoundDrawablesWithIntrinsicBounds(0, 0, unreadDot, 0);
            if (requestUnread <= 0 || position == 2) {
                unreadDot = 0;
            } else {
                unreadDot = 2130838257;
            }
            ((TextView) this.tabBar.a(2).a()).setCompoundDrawablesWithIntrinsicBounds(0, 0, unreadDot, 0);
        }
    }

    public void a(int disabled) {
        if (disabled == 1) {
            this.viewPager.setVisibility(8);
            this.messagingDisabled.setVisibility(0);
            this.messagesSearch.setEnabled(false);
            this.tabBar.setEnabled(false);
            return;
        }
        this.viewPager.setVisibility(0);
        this.messagingDisabled.setVisibility(8);
        this.messagesSearch.setEnabled(true);
        this.tabBar.setEnabled(true);
    }

    public void a() {
        super.a();
        ((MainTabsActivity) this.d).setShowMessagingPopup(false);
        this.j = e();
    }

    public void b() {
        if (this.messagesContainer != null) {
            this.messagesContainer.setVisibility(0);
        }
    }

    public void c() {
        this.messagesContainer.setVisibility(8);
    }
}
