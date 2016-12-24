package com.becandid.candid.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.Editable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.StickerKeyboard;
import com.becandid.candid.views.StickerKeyboard.a;
import com.becandid.thirdparty.BlurTask;
import com.becandid.thirdparty.BlurTask.BadgeType;
import defpackage.apr;
import defpackage.aps;
import defpackage.apv;
import defpackage.hm;
import defpackage.hn;
import defpackage.ik;
import defpackage.il;
import defpackage.in$aa;
import defpackage.in$ak;
import defpackage.in$as;
import defpackage.in$j;
import defpackage.in$x;
import defpackage.in$y;
import defpackage.io;
import defpackage.ix;
import defpackage.jb;
import defpackage.jk;
import defpackage.jp;
import defpackage.rj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import rx.schedulers.Schedulers;

public class MessageActivity extends PopupWithBlurBackgroundActivity implements a {
    final BroadcastReceiver b = new BroadcastReceiver(this) {
        final /* synthetic */ MessageActivity a;

        {
            this.a = this$0;
        }

        public void onReceive(Context context, Intent intent) {
            Bundle data = intent.getExtras();
            String userInfo = data.getString("user_info");
            if (!(data.getString("message_id") == null || data.getString("post_id") == null || userInfo == null)) {
                try {
                    int messageId = Integer.parseInt(data.getString("message_id"));
                    int postId = Integer.parseInt(data.getString("post_id"));
                    String postName = new JSONObject(userInfo).getString("post_name");
                    if (messageId != 0 && postId != 0 && Integer.toString(postId).equals(this.a.d) && postName.equals(this.a.e)) {
                        Message message = new Message();
                        message.message_id = messageId;
                        message.post_id = postId;
                        message.message = data.getString("message");
                        message.subject = data.getString("subject");
                        if (data.containsKey("image_width") && data.containsKey("image_height") && data.containsKey("source_url")) {
                            message.image_width = Integer.parseInt(data.getString("image_width"));
                            message.image_height = Integer.parseInt(data.getString("image_height"));
                            message.source_url = data.getString("source_url");
                            message.uploaded = Integer.parseInt(data.getString("uploaded"));
                        } else if (data.containsKey("sticker_name")) {
                            message.sticker_name = data.getString("sticker_name");
                        }
                        this.a.a(message);
                    }
                } catch (Throwable e) {
                    rj.a(e);
                } catch (Throwable e2) {
                    rj.a(e2);
                }
            }
            abortBroadcast();
        }
    };
    @BindView(2131624234)
    FrameLayout blockedFrameLayout;
    private io c;
    @BindView(2131624216)
    RelativeLayout contentRootView;
    private String d;
    private String e;
    private String f;
    private User g;
    private User h;
    @BindView(2131624237)
    TextView headerName;
    @BindView(2131624239)
    ImageView headerOnline;
    private boolean i;
    private boolean j;
    private String k;
    private int l;
    private String m;
    @BindView(2131624243)
    TextView mNickname;
    @BindView(2131624240)
    LinearLayout messageHeaderPostContainer;
    @BindView(2131624241)
    TextView messageHeaderPostText;
    @BindView(2131624242)
    ImageView messageHeaderRightArrow;
    @BindView(2131624238)
    TextView messageHeaderUserIcon;
    @BindView(2131624236)
    RelativeLayout messageHeaderUserIconContainer;
    @BindView(2131624225)
    EditText messageInput;
    @BindView(2131624221)
    RelativeLayout messageInputContainer;
    @BindView(2131624223)
    ImageView messagePhoto;
    @BindView(2131624226)
    ImageView messagePhotoButton;
    @BindView(2131624224)
    ImageView messagePhotoClear;
    @BindView(2131624220)
    RecyclerView messageRecycler;
    @BindView(2131624233)
    FrameLayout messageSpinnyContainer;
    @BindView(2131624217)
    SwipeRefreshLayout messageSwipeContainer;
    @BindView(2131624228)
    TextView messageTextPlaceholder;
    private boolean n = false;
    private hm o;
    private LayoutParams p;
    @BindView(2131624130)
    ImageView postButton;
    private Handler q;
    private final int r = 60000;
    @BindView(2131624231)
    TextView requestAccept;
    @BindView(2131624229)
    LinearLayout requestButtons;
    @BindView(2131624230)
    TextView requestIgnore;
    @BindView(2131624215)
    View root;
    private aps s;
    @BindView(2131624227)
    ImageView stickerButton;
    @BindView(2131624232)
    StickerKeyboard stickerKeyboard;
    private aps t;
    private Runnable u = new Runnable(this) {
        final /* synthetic */ MessageActivity a;

        {
            this.a = this$0;
        }

        public void run() {
            Map<String, String> params = new HashMap();
            if (this.a.d != null) {
                params.put("post_id", this.a.d);
            }
            if (this.a.e != null) {
                params.put("post_name", this.a.e);
            }
            ik.a().n(params).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                final /* synthetic */ AnonymousClass17 a;

                {
                    this.a = this$1;
                }

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    rj.a(e);
                }

                public void onNext(NetworkData networkData) {
                    if (!networkData.success) {
                        Toast.makeText(this.a.a, networkData.error, 0).show();
                    }
                    MessageThread thread = networkData.thread;
                    if (thread.user_info != null) {
                        this.a.a.g = thread.user_info;
                    }
                    if (thread.target_user_info != null) {
                        this.a.a.h = thread.target_user_info;
                    }
                    List data = new ArrayList();
                    if (!(thread.messages == null || thread.messages.isEmpty())) {
                        for (Message message : thread.messages) {
                            if (!this.a.a.o.b(message.message_id)) {
                                data.add(message);
                            }
                        }
                        this.a.a.o.a(0, data);
                    }
                    if (AppState.config.getInt("enable_nickname", 1) == 1 && thread.show_nickname_alert == 1 && networkData.thread.target_user_info.nickname != null && !networkData.thread.target_user_info.nickname.equals("")) {
                        this.a.a.setupNicknameAlert(networkData.thread.target_user_info.nickname);
                    }
                }
            });
            this.a.q.postDelayed(this.a.u, 60000);
        }
    };

    private void a(Message message) {
        message.sender = "other";
        this.o.a(message);
        this.messageRecycler.smoothScrollToPosition(this.o.getItemCount() - 1);
        markThreadRead();
    }

    public void markThreadRead() {
        Map<String, String> params = new HashMap();
        if (this.d != null) {
            params.put("post_id", this.d);
        }
        if (this.e != null) {
            params.put("post_name", this.e);
        }
        ik.a().w(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
    }

    public aps getDataSubscription() {
        Map<String, String> params = new HashMap();
        if (this.d != null) {
            params.put("post_id", this.d);
        }
        if (this.e != null) {
            params.put("post_name", this.e);
        }
        markThreadRead();
        return ik.a().n(params).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
                Log.d("ReadMessage", e.toString());
                this.a.messageSpinnyContainer.setVisibility(8);
                this.a.messageSwipeContainer.setRefreshing(false);
            }

            public void onNext(NetworkData networkData) {
                if (!networkData.success) {
                    Toast.makeText(this.a, networkData.error, 0).show();
                    this.a.finish();
                }
                MessageThread thread = networkData.thread;
                this.a.g = thread.user_info;
                this.a.h = thread.target_user_info;
                this.a.o.b(thread.user_info);
                this.a.o.a(thread.target_user_info);
                List<Message> data = new ArrayList();
                if (thread.messages == null || thread.messages.isEmpty()) {
                    this.a.o.a(null);
                } else {
                    data.addAll(thread.messages);
                    this.a.o.a(((Message) thread.messages.get(0)).message_id);
                }
                if (thread.thread_comment_id != null) {
                    this.a.f = thread.thread_comment_id;
                }
                this.a.o.a((List) data);
                this.a.postButton.setEnabled(true);
                this.a.setupActivityHeader(thread.target_user_info, thread.post, thread.user_info, thread);
                if (thread.target_user_info.is_blocked) {
                    this.a.setupBlockedUser();
                }
                if (thread.is_request == 1) {
                    this.a.setupRequest();
                }
                this.a.messagePhotoButton.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 a;

                    {
                        this.a = this$1;
                    }

                    public void onClick(View v) {
                        this.a.a.takePhoto();
                    }
                });
                this.a.messageSpinnyContainer.setVisibility(8);
                this.a.messageSwipeContainer.setRefreshing(false);
                if (AppState.config.getInt("enable_nickname", 1) == 1 && thread.show_nickname_alert == 1 && thread.target_user_info.nickname != null && !thread.target_user_info.nickname.equals("")) {
                    this.a.setupNicknameAlert(thread.target_user_info.nickname);
                }
            }
        });
    }

    public void getPage(String minPostId) {
        Map<String, String> params = new HashMap();
        if (this.d != null) {
            params.put("post_id", this.d);
        }
        if (this.e != null) {
            params.put("post_name", this.e);
        }
        params.put("prev_message_id", minPostId);
        ik.a().n(params).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
                Log.d("ReadMessage", e.toString());
            }

            public void onNext(NetworkData networkData) {
                if (networkData.success) {
                    MessageThread thread = networkData.thread;
                    if (thread.user_info != null) {
                        this.a.g = thread.user_info;
                    }
                    if (thread.target_user_info != null) {
                        this.a.h = thread.target_user_info;
                    }
                    if (thread.messages == null || thread.messages.isEmpty()) {
                        this.a.o.a(null);
                    } else {
                        this.a.o.c(thread.messages);
                        this.a.o.a(((Message) thread.messages.get(0)).message_id);
                    }
                    if (AppState.config.getInt("enable_nickname", 1) == 1 && thread.show_nickname_alert == 1 && networkData.thread.target_user_info.nickname != null && !networkData.thread.target_user_info.nickname.equals("")) {
                        this.a.setupNicknameAlert(networkData.thread.target_user_info.nickname);
                        return;
                    }
                    return;
                }
                Toast.makeText(this.a, networkData.error, 0).show();
            }
        });
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getIntent().getExtras();
        if (args == null) {
            finish();
            return;
        }
        if (args.containsKey("post_id")) {
            this.d = args.getString("post_id");
        }
        if (args.containsKey("user_name")) {
            this.e = args.getString("user_name");
        }
        if (args.containsKey("comment_id")) {
            this.f = args.getString("comment_id");
        }
        this.c = io.a();
        this.q = new Handler(getMainLooper());
        setContentView(2130968621);
        ButterKnife.bind(this);
        enableKeyboardEvents(this.root);
        if (AppState.account.messaging_disabled == 1) {
            this.blockedFrameLayout.setVisibility(0);
            new Builder(this).setTitle("Enable Messaging?").setMessage("You've previously disabled messaging. Do you want to enable it?").setNegativeButton(getResources().getString(2131230890), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ MessageActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(DialogInterface dialog, int which) {
                    this.a.finish();
                }
            }).setPositiveButton(getResources().getString(2131230953), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ MessageActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(DialogInterface dialog, int which) {
                    Map<String, String> params = new HashMap();
                    params.put("messaging_disabled", "0");
                    ik.a().r(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                    AppState.account.messaging_disabled = 0;
                    ix.a().a(new in$aa(0));
                    this.a.blockedFrameLayout.setVisibility(8);
                }
            }).setCancelable(false).create().show();
        }
        this.stickerKeyboard.a = this;
        LayoutManager llmMessage = new LinearLayoutManager(this);
        this.messageRecycler.setLayoutManager(llmMessage);
        ((LinearLayoutManager) llmMessage).setStackFromEnd(true);
        this.o = new hm(this);
        this.messageRecycler.setAdapter(this.o);
        this.messageRecycler.addOnScrollListener(new hn(this, (LinearLayoutManager) llmMessage, this.o, 1, 25) {
            final /* synthetic */ MessageActivity a;

            public void onLoadMore(String minPostId) {
                if (minPostId != null) {
                    this.a.getPage(minPostId);
                }
            }
        });
        ItemAnimator animator = this.messageRecycler.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        this.messageSwipeContainer.setOnRefreshListener(new OnRefreshListener(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onRefresh() {
                this.a.o.c();
                this.a.getDataSubscription();
            }
        });
        this.messageInput.addTextChangedListener(new il(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void afterTextChanged(Editable s) {
                this.a.updatePostButton();
            }
        });
        this.messageSpinnyContainer.setVisibility(0);
        addToSubscriptionList(getDataSubscription());
        this.t = ix.a().a(in$y.class, new apr<in$y>(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$y imageUploadStarted) {
                this.a.imageCaptured();
            }
        });
        addToSubscriptionList(this.t);
    }

    protected void onResume() {
        IntentFilter filter = new IntentFilter("com.becandid.candid.MESSAGING");
        filter.setPriority(2);
        registerReceiver(this.b, filter);
        this.q.postDelayed(this.u, 60000);
        ix.a().a(new in$as(2, 0, true));
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.b);
        this.q.removeCallbacks(this.u);
    }

    public void setupBlockedUser() {
        this.blockedFrameLayout.setVisibility(0);
        new Builder(this).setTitle("Unblock This Thread?").setMessage("You've previously blocked this thread. Do you want to unblock it?").setNegativeButton(getResources().getString(2131230890), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onClick(DialogInterface dialog, int which) {
                this.a.finish();
            }
        }).setPositiveButton(getResources().getString(2131230953), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onClick(DialogInterface dialog, int which) {
                Map<String, String> params = new HashMap();
                params.put("post_id", this.a.d);
                params.put("post_name", this.a.e);
                ik.a().t(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                this.a.blockedFrameLayout.setVisibility(8);
            }
        }).setCancelable(false).create().show();
    }

    public void setupNicknameAlert(String nickname) {
        this.headerName.setText(nickname);
        a(BadgeType.MESSAGE_SECOND_NICKNAME);
    }

    public void setupActivityHeader(User targetUserInfo, Post post, User myInfo, MessageThread thread) {
        int color = Color.parseColor(targetUserInfo.icon_color);
        this.messageHeaderUserIcon.setTextColor(color);
        TextView textView = this.messageHeaderUserIcon;
        io ioVar = this.c;
        textView.setTypeface(io.b());
        textView = this.messageHeaderUserIcon;
        ioVar = this.c;
        textView.setText(io.a(targetUserInfo.icon_name));
        int iconWidth = this.messageHeaderUserIconContainer.getWidth();
        if (iconWidth == 0) {
            iconWidth = (int) (this.messageHeaderUserIconContainer.getResources().getDisplayMetrics().density * 28.0f);
        }
        int gradColor = (16777215 & color) | 1073741824;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(gradColor);
        gradientDrawable.setCornerRadius((float) (iconWidth / 2));
        this.messageHeaderUserIconContainer.setBackground(gradientDrawable);
        if (targetUserInfo.online == 1) {
            this.headerOnline.setVisibility(0);
        } else {
            this.headerOnline.setVisibility(8);
        }
        jp triangle = new jp();
        triangle.setBounds(0, jb.a(1, (Context) this), jb.a(10, (Context) this), jb.a(6, (Context) this));
        triangle.a(color);
        this.headerName.setCompoundDrawables(null, null, triangle, null);
        if (AppState.config.getInt("enable_nickname", 1) != 1 || targetUserInfo.nickname == null || targetUserInfo.nickname.equals("")) {
            this.headerName.setText(targetUserInfo.post_name);
        } else {
            this.headerName.setText(targetUserInfo.nickname);
        }
        this.headerName.setTextColor(color);
        this.headerName.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                PopupMenu userMenu = new PopupMenu(this.a, v);
                userMenu.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ AnonymousClass12 a;

                    {
                        this.a = this$1;
                    }

                    public boolean onMenuItemClick(MenuItem item) {
                        Map<String, String> params = new HashMap();
                        params.put("post_id", this.a.a.d);
                        params.put("post_name", this.a.a.e);
                        switch (item.getItemId()) {
                            case 2131624855:
                                ix.a().a(new in$j(Integer.parseInt(this.a.a.d), this.a.a.e));
                                ik.a().s(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                                this.a.a.finish();
                                break;
                            case 2131624857:
                                ix.a().a(new in$j(Integer.parseInt(this.a.a.d), this.a.a.e));
                                ik.a().u(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                                this.a.a.finish();
                                break;
                        }
                        return false;
                    }
                });
                userMenu.getMenu().add(1, 2131624855, 0, 2131230878);
                userMenu.getMenu().add(1, 2131624857, 0, 2131230879);
                userMenu.show();
            }
        });
        if (post != null) {
            this.messageHeaderPostContainer.setVisibility(0);
            if (this.f != null) {
                this.messageHeaderPostText.setText("See Comment");
            } else {
                this.messageHeaderPostText.setText("See Post");
            }
            jk arrow = new jk();
            arrow.setBounds(0, jb.a(2, (Context) this), jb.a(8, (Context) this), jb.a(10, (Context) this));
            arrow.a(getResources().getColor(2131558478));
            this.messageHeaderRightArrow.setImageDrawable(arrow);
            this.messageHeaderPostContainer.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MessageActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PostDetailsActivity.class);
                    intent.putExtra("post_id", Integer.parseInt(this.a.d));
                    if (this.a.f != null) {
                        intent.putExtra("comment_id", Integer.parseInt(this.a.f));
                        intent.putExtra("scrollToBottom", true);
                    }
                    this.a.startActivity(intent);
                }
            });
        } else {
            this.messageHeaderPostContainer.setVisibility(8);
        }
        if (AppState.config.getInt("enable_nickname", 1) == 1 && myInfo.nickname != null && !myInfo.nickname.equals("")) {
            this.mNickname.setText("Chatting as " + myInfo.nickname);
            this.mNickname.setVisibility(0);
        } else if (AppState.config.getInt("enable_nickname", 1) == 1 && thread.can_add_nickname == 1) {
            this.mNickname.setText("Add Nickname");
            this.mNickname.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MessageActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(View v) {
                    MessageActivity messageActivity = this.a;
                    BadgeType badgeType = BadgeType.BADGE;
                    messageActivity.a(BadgeType.MESSAGE_ADD_NICKNAME);
                }
            });
            this.mNickname.setVisibility(0);
        } else {
            this.mNickname.setVisibility(8);
        }
    }

    public void setupRequest() {
        this.requestButtons.setVisibility(0);
        this.requestIgnore.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.requestIgnore.setEnabled(false);
                this.a.requestAccept.setEnabled(true);
                Map<String, String> params = new HashMap();
                params.put("post_id", this.a.d);
                params.put("post_name", this.a.e);
                params.put("ignore", "1");
                ik.a().v(params).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                    final /* synthetic */ AnonymousClass15 a;

                    {
                        this.a = this$1;
                    }

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rj.a(e);
                        Log.d("HandleRequest", e.toString());
                        this.a.a.requestIgnore.setEnabled(true);
                    }

                    public void onNext(NetworkData networkData) {
                        if (networkData.success) {
                            ix.a().a(new in$x(this.a.a.d, this.a.a.e, 1));
                            this.a.a.finish();
                            return;
                        }
                        this.a.a.requestIgnore.setEnabled(true);
                    }
                });
            }
        });
        this.requestAccept.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.requestIgnore.setEnabled(false);
                this.a.requestAccept.setEnabled(true);
                Map<String, String> params = new HashMap();
                params.put("post_id", this.a.d);
                params.put("post_name", this.a.e);
                params.put("ignore", "0");
                ik.a().v(params).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                    final /* synthetic */ AnonymousClass16 a;

                    {
                        this.a = this$1;
                    }

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rj.a(e);
                        Log.d("HandleRequest", e.toString());
                        this.a.a.requestIgnore.setEnabled(true);
                        this.a.a.requestAccept.setEnabled(true);
                    }

                    public void onNext(NetworkData networkData) {
                        if (networkData.success) {
                            this.a.a.requestButtons.setVisibility(8);
                            ix.a().a(new in$x(this.a.a.d, this.a.a.e, 0));
                            return;
                        }
                        this.a.a.requestIgnore.setEnabled(true);
                        this.a.a.requestAccept.setEnabled(true);
                    }
                });
            }
        });
    }

    public void scrollToBottom() {
        this.messageRecycler.smoothScrollToPosition(this.messageRecycler.getBottom());
    }

    public void startMessage(View view) {
        showMessageInput();
        this.messageInput.requestFocus();
        this.messageInput.post(new Runnable(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void run() {
                this.a.openKeyboard();
            }
        });
    }

    public void showMessageInput() {
        this.messageInputContainer.setVisibility(0);
        this.messageTextPlaceholder.setVisibility(8);
    }

    public void hideMessageInput() {
        this.messageInputContainer.setVisibility(8);
        this.messageTextPlaceholder.setVisibility(0);
    }

    protected void keyboardOpened() {
        super.keyboardOpened();
        chooseSticker(null);
        scrollToBottom();
    }

    protected void keyboardClosed() {
        super.keyboardClosed();
        String text = this.messageInput.getText().toString().trim();
        if (!this.i && this.k == null && text.length() == 0) {
            hideMessageInput();
        }
    }

    public void takePhoto() {
        if (!(!this.i && this.k == null && this.m == null)) {
            clearPhoto(null);
        }
        if (AppState.config.getInt("android_msg_image_upload", 1) == 1) {
            getPhotoHelper().choosePhoto(false);
        } else {
            getPhotoHelper().choosePhoto(true);
        }
    }

    public void clearPhoto(View v) {
        super.clearPhoto();
        this.messagePhoto.setImageBitmap(null);
        this.i = false;
        this.k = null;
        this.l = 0;
        this.messagePhoto.setVisibility(8);
        if (this.p != null) {
            this.messagePhoto.setLayoutParams(this.p);
        }
        this.m = null;
        this.messagePhotoClear.setVisibility(8);
        if (!this.keyboardOpen) {
            keyboardClosed();
        }
        updatePostButton();
        if (this.s != null) {
            this.s.unsubscribe();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            this.messagePhoto.setImageBitmap(null);
            clearPhoto();
        } else if (this.photoHelper != null && this.photoHelper.f != null && this.photoHelper.b != null && this.photoHelper.a != null) {
            this.messagePhoto.setImageBitmap(this.photoHelper.f);
            if (this.photoHelper.d > 0 && this.photoHelper.e > 0) {
                LayoutParams lp = (LayoutParams) this.messagePhoto.getLayoutParams();
                lp.width = (int) ((((float) this.photoHelper.d) / ((float) this.photoHelper.e)) * ((float) lp.height));
                this.messagePhoto.setLayoutParams(lp);
            }
            if (requestCode == 905 || requestCode == 902) {
                this.l = 1;
            }
            this.messagePhoto.setVisibility(0);
            this.messagePhoto.setAlpha(0.3f);
            this.messagePhotoClear.setVisibility(0);
            showMessageInput();
        }
    }

    protected void imageCaptured() {
        this.i = true;
        if (this.photoHelper == null) {
            rj.a(new Exception("photoHelper is NULL"));
            return;
        }
        this.photoHelper.a();
        if (!(this.s == null || this.s.isUnsubscribed())) {
            this.s.unsubscribe();
        }
        this.s = ix.a().a(in$ak.class, new apr<in$ak>(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$ak s3UploadResponse) {
                if (!s3UploadResponse.b) {
                    this.a.clearPhoto(null);
                    this.a.updatePostButton();
                    if (this.a.j) {
                        this.a.j = false;
                    }
                    Toast.makeText(this.a, this.a.getString(2131230940), 0).show();
                } else if (this.a.i) {
                    this.a.i = false;
                    this.a.k = s3UploadResponse.a.full_url;
                    if (this.a.j) {
                        this.a.j = false;
                        this.a.saveMessage(null);
                    }
                    this.a.updatePostButton();
                    this.a.messagePhoto.setAlpha(1.0f);
                }
            }
        });
        addToSubscriptionList(this.s);
    }

    public void chooseSticker(View v) {
        if (this.stickerKeyboard.getVisibility() == 0 || v == null) {
            this.stickerKeyboard.setVisibility(8);
            this.stickerButton.setImageResource(2130838235);
            this.stickerButton.setAlpha(0.5f);
            return;
        }
        if (this.keyboardOpen) {
            closeKeyboard();
        }
        this.stickerKeyboard.setVisibility(0);
        this.stickerButton.setImageResource(2130838236);
        this.stickerButton.setAlpha(1.0f);
    }

    public void clickSticker(String name) {
        this.m = name;
        this.messagePhoto.setVisibility(0);
        this.messagePhotoClear.setVisibility(0);
        this.messagePhoto.setImageDrawable(GossipApplication.a.getResources().getDrawable(GossipApplication.a.getResources().getIdentifier(name.toLowerCase(), "drawable", GossipApplication.a.getPackageName())));
        this.p = (LayoutParams) this.messagePhoto.getLayoutParams();
        LayoutParams lp = (LayoutParams) this.messagePhoto.getLayoutParams();
        lp.width = (int) (getResources().getDisplayMetrics().density * 50.0f);
        lp.height = lp.width;
        this.messagePhoto.setLayoutParams(lp);
        showMessageInput();
        updatePostButton();
    }

    public void updatePostButton() {
        if (this.messageInput.getText().toString().trim().length() <= 0 && this.k == null && this.m == null) {
            this.postButton.setImageResource(2130837648);
            return;
        }
        this.postButton.setImageResource(2130837649);
        if (this.i) {
            this.postButton.setImageResource(2130837648);
        }
    }

    public void saveMessage(View v) {
        if (!this.i) {
            Message message = new Message();
            HashMap params = new HashMap();
            String text = this.messageInput.getText().toString().trim();
            if (text.length() > 0) {
                params.put("message", text);
                message.message = text;
            }
            if (this.k != null) {
                params.put("source_url", this.k);
                message.source_url = this.k;
                params.put("uploaded", Integer.toString(this.l));
                message.uploaded = this.l;
                float width = (float) this.photoHelper.d;
                float height = (float) this.photoHelper.e;
                if (width <= 0.0f || height <= 0.0f) {
                    params.put("image_width", "240");
                    message.image_width = 240;
                    params.put("image_height", "160");
                    message.image_height = 160;
                } else if (((double) width) < (((double) height) * 240.0d) / 160.0d) {
                    params.put("image_width", String.valueOf((int) ((160.0d * ((double) width)) / ((double) height))));
                    message.image_width = (int) ((160.0d * ((double) width)) / ((double) height));
                    params.put("image_height", "160");
                    message.image_height = 160;
                } else {
                    params.put("image_width", "240");
                    message.image_width = 240;
                    params.put("image_height", String.valueOf((int) ((240.0d * ((double) height)) / ((double) width))));
                    message.image_height = (int) ((240.0d * ((double) height)) / ((double) width));
                }
            }
            if (this.m != null) {
                params.put("sticker_name", this.m);
                message.sticker_name = this.m;
                params.put("image_width", "120");
                message.image_width = 120;
                params.put("image_height", "120");
                message.image_height = 120;
            }
            a(params, message);
        }
    }

    private void a(HashMap<String, String> params, final Message message) {
        if (params.containsKey("message") || params.containsKey("sticker_name") || params.containsKey("source_url")) {
            this.messageInput.setText("");
            chooseSticker(null);
            params.put("post_id", this.d);
            message.post_id = Integer.parseInt(this.d);
            if (this.e != null) {
                params.put("post_name", this.e);
                message.user_info = new User();
                message.user_info.post_name = this.e;
            }
            if (this.f != null) {
                params.put("thread_comment_id", this.f);
            }
            params.put("send", Boolean.toString(true));
            final long messageTempId = System.currentTimeMillis();
            message.messageTempId = messageTempId;
            ik.a().o(params).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                final /* synthetic */ MessageActivity c;

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    if (this.c.s != null) {
                        this.c.s.unsubscribe();
                    }
                    if (!this.c.isStopped) {
                        Toast.makeText(this.c, e.toString(), 1).show();
                        this.c.o.a(message.messageTempId, false, false, null);
                    }
                }

                public void onNext(NetworkData networkData) {
                    if (this.c.s != null) {
                        this.c.s.unsubscribe();
                    }
                    if (!this.c.isStopped) {
                        if (!(this.c.k == null && this.c.m == null)) {
                            this.c.clearPhoto(null);
                        }
                        if (networkData == null || networkData.success) {
                            if (!(networkData == null || networkData.message == null)) {
                                this.c.o.a(messageTempId, true, false, networkData.message);
                            }
                            if (AppState.config.getInt("enable_nickname", 1) == 1 && networkData != null && networkData.show_nickname_prompt == 1) {
                                this.c.a(BadgeType.MESSAGE_ADD_NICKNAME);
                                return;
                            }
                            return;
                        }
                        Toast.makeText(this.c, networkData.error, 1).show();
                        if (networkData.error.contains("blocked") || networkData.error.contains("disabled")) {
                            this.c.o.a(messageTempId, false, true, null);
                        }
                        this.c.o.a(messageTempId, false, false, null);
                    }
                }
            });
            message.params = params;
            this.o.a(message);
            new Handler().postDelayed(new Runnable(this) {
                final /* synthetic */ MessageActivity a;

                {
                    this.a = this$0;
                }

                public void run() {
                    this.a.scrollToBottom();
                }
            }, 200);
            return;
        }
        Toast.makeText(this, "Empty messages are not allowed.", 0).show();
    }

    public void onBackPressed() {
        if (AppState.mainTabsActivity == null) {
            Intent intent = new Intent(this, MainTabsActivity.class);
            if (AppState.config.getBoolean("messaging_turned_on", true)) {
                intent.putExtra("selected_tab", "messages");
            }
            startActivity(intent);
            finish();
            return;
        }
        super.onBackPressed();
    }

    public void hideCurrentScreen() {
        this.contentRootView.setVisibility(8);
    }

    public void showCurrentScreen() {
        this.contentRootView.setVisibility(0);
    }

    public User getUserData() {
        if (this.g != null) {
            return this.g;
        }
        return null;
    }

    public User getTargetUserData() {
        if (this.h != null) {
            return this.h;
        }
        return null;
    }

    private void a(BadgeType badgeType) {
        if (!this.n) {
            this.n = true;
            new BlurTask((Activity) this, this.contentRootView, badgeType).execute(new Void[0]);
        }
    }

    public void closingPopup() {
        this.n = false;
        this.messageInput.requestFocus();
    }

    public void updateNickname(final String nickname) {
        AppState.nickname = nickname;
        AppState.saveState(this);
        ik.a().c(nickname, this.d, this.e).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
            final /* synthetic */ MessageActivity b;

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(NetworkData networkData) {
                if (networkData.success) {
                    this.b.mNickname.setVisibility(0);
                    this.b.mNickname.setText("Chatting as " + nickname);
                    this.b.mNickname.setOnClickListener(null);
                }
            }
        });
    }

    public void ignoreNickname() {
        ik.a().c(null, this.d, this.e).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void onNext(NetworkData networkData) {
                this.a.mNickname.setVisibility(0);
                this.a.mNickname.setText("Add a Nickname");
                this.a.mNickname.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass23 a;

                    {
                        this.a = this$1;
                    }

                    public void onClick(View v) {
                        new BlurTask(this.a.a, this.a.a.contentRootView, BadgeType.MESSAGE_ADD_NICKNAME).execute(new Void[0]);
                    }
                });
            }
        });
    }

    public void markNicknameAlertShown() {
        ik.a().d(this.d, this.e).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
    }
}
