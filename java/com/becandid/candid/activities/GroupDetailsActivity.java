package com.becandid.candid.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.InviteContactsActivity.InviteFlowTypes;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Post;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.becandid.candid.util.RoundedCornersTransformation.CornerType;
import defpackage.apr;
import defpackage.aps;
import defpackage.apv;
import defpackage.hf;
import defpackage.hf$a;
import defpackage.ik;
import defpackage.in$ac;
import defpackage.in$k;
import defpackage.in$o;
import defpackage.in$r;
import defpackage.in$t;
import defpackage.ix;
import defpackage.jb;
import defpackage.rj;
import defpackage.uu$h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rx.schedulers.Schedulers;

public class GroupDetailsActivity extends PopupWithBlurBackgroundActivity implements OnMenuItemClickListener, hf$a {
    public static final int CREATE_POST_REQUEST = 888;
    private int b;
    private Group c;
    private RoundedCornersTransformation d;
    private hf e;
    @BindView(2131624175)
    TextView gdCompose;
    @BindView(2131624173)
    TextView gdHeaderName;
    @BindView(2131624176)
    TextView gdJoin;
    @BindView(2131624172)
    TextView groupEmpty;
    @BindView(2131624171)
    RecyclerView groupPosts;
    @BindView(2131624177)
    LinearLayout loadingSpinny;
    @BindView(2131624169)
    SwipeRefreshLayout mSwipeContainer;

    public static Intent startGroupDetailsActivity(Context context, int groupId) {
        Intent intent = new Intent(context, GroupDetailsActivity.class);
        intent.putExtra("group_id", groupId);
        return intent;
    }

    private aps a() {
        return ik.a().a(this.b, null).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
            final /* synthetic */ GroupDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
                this.a.mSwipeContainer.setRefreshing(false);
            }

            public void onError(Throwable e) {
                this.a.loadingSpinny.setVisibility(8);
                this.a.groupPosts.setVisibility(0);
                rj.a(e);
                this.a.mSwipeContainer.setRefreshing(false);
                ix.a().a(new in$ac());
            }

            public void onNext(NetworkData networkData) {
                if (!this.a.isStopped) {
                    if (networkData != null) {
                        this.a.c = networkData.group;
                        this.a.gdHeaderName.setText(this.a.c.group_name);
                        if (networkData.posts != null) {
                            List posts = networkData.posts;
                            this.a.a(posts);
                            this.a.e.b(this.a.c.convertToPost());
                            if (!posts.isEmpty()) {
                                this.a.e.a(Integer.toString(((Post) posts.get(posts.size() - 1)).post_id));
                            }
                        }
                    }
                    this.a.loadingSpinny.setVisibility(8);
                    this.a.groupPosts.setVisibility(0);
                }
            }
        });
    }

    protected void getRxSubscription() {
        this.mSubscription = a();
        addToSubscriptionList(this.mSubscription);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968611);
        ButterKnife.bind(this);
        this.groupPosts.setVisibility(8);
        this.groupPosts.setLayoutManager(new LinearLayoutManager(this));
        this.e = new hf(this, null);
        this.e.a((hf$a) this);
        this.groupPosts.setAdapter(this.e);
        this.loadingSpinny.setVisibility(0);
        this.groupPosts.setNestedScrollingEnabled(false);
        ItemAnimator animator = this.groupPosts.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        this.d = new RoundedCornersTransformation((Context) this, (int) (40.0f * getResources().getDisplayMetrics().density), 0, CornerType.ALL);
        this.b = getIntent().getIntExtra("group_id", 0);
        String encodedId = DataUtil.getEncodedId(getIntent().getData());
        if (encodedId != null) {
            this.b = (int) DataUtil.decodeId(encodedId);
        }
        if (AppState.isGroupMember(this.b)) {
            this.gdCompose.setVisibility(0);
        } else {
            this.gdCompose.setVisibility(8);
        }
        if (getIntent().hasExtra("group_name")) {
            this.gdHeaderName.setText(getIntent().getStringExtra("group_name"));
        }
        if (getIntent().hasExtra("group_image")) {
        }
        if (getIntent().hasExtra("group_json")) {
            this.c = (Group) DataUtil.gson.a(getIntent().getStringExtra("group_json"), Group.class);
            if (this.c.group_name != null) {
                this.gdHeaderName.setText(this.c.group_name);
            }
        }
        getRxSubscription();
        this.mSwipeContainer.setOnRefreshListener(new OnRefreshListener(this) {
            final /* synthetic */ GroupDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onRefresh() {
                this.a.getRxSubscription();
            }
        });
        busSubscribe(in$k.class, new apr<in$k>(this) {
            final /* synthetic */ GroupDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$k didCreatePost) {
                if (didCreatePost.a.group_id == this.a.b) {
                    this.a.e.a(didCreatePost.a, 1);
                    this.a.groupPosts.smoothScrollToPosition(1);
                    this.a.groupEmpty.setVisibility(8);
                    Group a = this.a.c;
                    a.num_posts++;
                    this.a.getRxSubscription();
                }
            }
        });
        busSubscribe(in$t.class, new apr<in$t>(this) {
            final /* synthetic */ GroupDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$t didUpdateGroup) {
                if (didUpdateGroup.a.group_id == this.a.b) {
                    this.a.c = didUpdateGroup.a;
                    this.a.e.b(this.a.c.convertToPost(), 0);
                    this.a.getRxSubscription();
                }
            }
        });
        busSubscribe(in$r.class, new apr<in$r>(this) {
            final /* synthetic */ GroupDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$r didRemovePost) {
                this.a.e.b(didRemovePost.a);
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.loadingSpinny.setVisibility(0);
        this.groupPosts.setVisibility(8);
        this.b = intent.getIntExtra("group_id", 0);
        a();
    }

    public void hideCurrentScreen() {
        findViewById(2131624168).setVisibility(8);
    }

    public void showCurrentScreen() {
        findViewById(2131624168).setVisibility(0);
    }

    private void a(List<Post> posts) {
        this.e.a((List) posts);
        if (posts.size() > 0) {
            this.groupEmpty.setVisibility(8);
        } else {
            this.groupEmpty.setVisibility(0);
        }
    }

    public void createPostClick(View v) {
        if (this.c != null) {
            Intent intent = new Intent(this, CreatePostActivity.class);
            intent.putExtra("group_id", this.c.group_id);
            intent.putExtra("group_name", this.c.group_name);
            startActivityForResult(intent, CREATE_POST_REQUEST);
        }
    }

    public void joinGroupClick(View view) {
        if (this.c != null) {
            ik.a().b(this.c.group_id).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                final /* synthetic */ GroupDetailsActivity a;

                {
                    this.a = this$0;
                }

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    rj.a(e);
                    Toast.makeText(this.a, "Unable to join this group", 0).show();
                }

                public void onNext(NetworkData networkData) {
                    Toast.makeText(this.a, "You have joined this group", 0).show();
                    this.a.gdCompose.setVisibility(0);
                    this.a.e.notifyItemChanged(0);
                }
            });
        }
    }

    public void leaveGroupClick(View view) {
        if (this.c != null) {
            ik.a().c(this.c.group_id).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                final /* synthetic */ GroupDetailsActivity a;

                {
                    this.a = this$0;
                }

                public void onCompleted() {
                    this.a.finish();
                }

                public void onError(Throwable e) {
                    rj.a(e);
                    Log.d("GroupDetailsActivity", e.toString());
                }

                public void onNext(NetworkData networkData) {
                    for (int i = 0; i < AppState.groups.size(); i++) {
                        if (((Group) AppState.groups.get(i)).group_id == this.a.c.group_id) {
                            AppState.groups.remove(i);
                            break;
                        }
                    }
                    ix.a().a(new in$o(this.a.c.group_id));
                    this.a.gdCompose.setVisibility(8);
                    Toast.makeText(this.a, "You have left this group", 0).show();
                }
            });
        }
    }

    public boolean onMenuItemClick(MenuItem item) {
        Log.d("GDA", "groupMenu");
        switch (item.getItemId()) {
            case 2131624838:
                leaveGroupClick(null);
                break;
            case 2131624839:
                joinGroupClick(null);
                break;
            case 2131624840:
                new Builder(this).setIconAttribute(16843605).setTitle("Delete this group?").setMessage("Are you sure you want to permanently delete this group?").setPositiveButton("Yes", new OnClickListener(this) {
                    final /* synthetic */ GroupDetailsActivity a;

                    {
                        this.a = this$0;
                    }

                    public void onClick(DialogInterface dialog, int which) {
                        new HashMap().put("group_id", Integer.toString(this.a.c.group_id));
                        ik.a().f(this.a.b).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                            final /* synthetic */ AnonymousClass8 a;

                            {
                                this.a = this$1;
                            }

                            public void onCompleted() {
                            }

                            public void onError(Throwable e) {
                                rj.a(e);
                                Log.d("DeleteGroup", e.toString());
                            }

                            public void onNext(NetworkData networkData) {
                                ix.a().a(new in$o(this.a.a.c.group_id));
                                this.a.a.finish();
                            }
                        });
                    }
                }).setNegativeButton("No", null).show();
                break;
            case 2131624841:
                new Builder(this).setTitle("Why Are You Reporting This Group?").setSingleChoiceItems(new CharSequence[]{"Pornographic", "Solicitation and Spam", "Hate Speech"}, 0, null).setPositiveButton("Report Group", new OnClickListener(this) {
                    final /* synthetic */ GroupDetailsActivity a;

                    {
                        this.a = this$0;
                    }

                    public void onClick(DialogInterface dialog, int which) {
                        String reason;
                        switch (((AlertDialog) dialog).getListView().getCheckedItemPosition()) {
                            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                                reason = "nsfw";
                                break;
                            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                                reason = "spam";
                                break;
                            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                                reason = "hate";
                                break;
                            default:
                                reason = "";
                                break;
                        }
                        ik.a().b(this.a.b, reason).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                            final /* synthetic */ AnonymousClass9 a;

                            {
                                this.a = this$1;
                            }

                            public void onCompleted() {
                            }

                            public void onError(Throwable e) {
                                rj.a(e);
                                Log.d("ReportGroup", e.toString());
                            }

                            public void onNext(NetworkData networkData) {
                                new Builder(this.a.a).setTitle("Group Reported").setMessage("This group has been reported.").setPositiveButton("OK", null).create().show();
                            }
                        });
                    }
                }).setNegativeButton("Cancel", null).create().show();
                break;
            case 2131624842:
                Intent intent = new Intent(this, CreateGroupActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("edit_group", true);
                bundle.putInt("group_id", this.c.group_id);
                bundle.putString("group_name", this.c.group_name);
                bundle.putString("group_info", this.c.about);
                bundle.putString("source_url", this.c.source_url);
                bundle.putStringArrayList("tags", (ArrayList) this.c.tags);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CREATE_POST_REQUEST) {
            if (resultCode != -1) {
                Log.e("GroupDetails", "Error on activity result");
            }
        } else if (requestCode == BaseActivity.UPSELL_GROUP && resultCode == -1 && data != null) {
            upsellChange(data.getIntExtra("upsellId", -1));
        }
    }

    public void upsellChange(int upsellId) {
        this.e.b(upsellId);
    }

    public void showContactsDialog(int upsellId, int groupId) {
        Intent intent = new Intent(this, InviteContactsActivity.class);
        intent.putExtra("invite_type", InviteFlowTypes.GROUP.toString());
        intent.putExtra("upsell_id", String.valueOf(upsellId) + "," + String.valueOf(groupId));
        intent.putExtra("groupId", groupId);
        intent.putExtra("upsellId", upsellId);
        startActivityForResult(intent, BaseActivity.UPSELL_GROUP);
    }

    public void onLoadMore(String lastDataId) {
        if (lastDataId != null && Integer.valueOf(lastDataId).intValue() > 0) {
            ik.a().a(this.b, lastDataId).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                final /* synthetic */ GroupDetailsActivity a;

                {
                    this.a = this$0;
                }

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    rj.a(e);
                    jb.a(this.a.groupPosts, this.a.e);
                }

                public void onNext(NetworkData networkData) {
                    if (networkData.posts == null || networkData.posts.isEmpty()) {
                        this.a.e.a(null);
                        return;
                    }
                    List posts = networkData.posts;
                    this.a.e.b(posts);
                    if (!posts.isEmpty()) {
                        this.a.e.a(Integer.toString(((Post) posts.get(posts.size() - 1)).post_id));
                    }
                }
            });
        }
    }

    public void onErrorRetry(String lastDataId) {
        onLoadMore(lastDataId);
    }
}
