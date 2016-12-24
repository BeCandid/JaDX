package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.ContentEditActivity;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.activities.InviteContactsActivity;
import com.becandid.candid.activities.InviteContactsActivity.InviteFlowTypes;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.TextTag;
import com.becandid.candid.models.NetworkData;
import com.becandid.thirdparty.BlurTask;
import com.becandid.thirdparty.BlurTask.BadgeType;
import com.facebook.FacebookException;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.SharePhotoContent.a;
import com.facebook.share.widget.ShareDialog;
import defpackage.apr;
import defpackage.apv;
import defpackage.bb;
import defpackage.ik;
import defpackage.in$al;
import defpackage.in$n;
import defpackage.in$p;
import defpackage.in$q;
import defpackage.in$r;
import defpackage.io;
import defpackage.ix;
import defpackage.iy;
import defpackage.jb;
import defpackage.jc;
import defpackage.jp;
import defpackage.rj;
import defpackage.uj$a;
import defpackage.uk;
import defpackage.wq$a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import rx.schedulers.Schedulers;

public abstract class BasePostViewHolder extends jc {
    private static String a;
    @BindView(2131624751)
    LinearLayout mCommentPostBadge;
    @BindView(2131624793)
    public TextView mCommentPostBtnOgImage;
    @BindView(2131624749)
    LinearLayout mCommentPostContainer;
    @BindView(2131624752)
    TextView mCommentPostText;
    @BindView(2131624789)
    View mFalseRumorContainerOgImage;
    @BindView(2131624790)
    ImageView mFalseRumorIconOgImage;
    @BindView(2131624791)
    public TextView mFalseRumorTextOgImage;
    @BindView(2131624267)
    View mFooter;
    @BindView(2131624760)
    TextView mFooterCommentIcon;
    @BindView(2131624763)
    ImageView mFooterCommentImage;
    @BindView(2131624761)
    ImageView mFooterCommentModIcon;
    @BindView(2131624757)
    View mFooterCommentSnippet;
    @BindView(2131624764)
    TextView mFooterCommentText;
    @BindView(2131624762)
    TextView mFooterCommentTimestamp;
    @BindView(2131624758)
    TextView mFooterCommentValue;
    @BindView(2131624264)
    View mHeader;
    @BindView(2131624783)
    public TextView mLikePostBtnOgImage;
    @BindView(2131624741)
    LinearLayout mLikeRumorPostBadge;
    @BindView(2131624737)
    LinearLayout mLikeRumorPostContainer;
    @BindView(2131624739)
    ImageView mLikeRumorPostIcon;
    @BindView(2131624742)
    TextView mLikeRumorPostText;
    @BindView(2131624755)
    LinearLayout mMessagePostContainer;
    @BindView(2131624769)
    public TextView mPostAuthor;
    @BindView(2131624115)
    TextView mPostCaption;
    @BindView(2131624411)
    TextView mPostCaptionOgImage;
    @BindView(2131624401)
    LinearLayout mPostContainer;
    @BindView(2131624779)
    public TextView mPostGroup;
    @BindView(2131624776)
    public FrameLayout mPostGroupContainer;
    @BindView(2131624778)
    public View mPostGroupMenu;
    @BindView(2131624777)
    RelativeLayout mPostGroupMenuContainer;
    @BindView(2131624795)
    TextView mPostGroupOgImage;
    @BindView(2131624770)
    View mPostHeaderBadge;
    @BindView(2131624772)
    FrameLayout mPostHeaderBadgeDot;
    @BindView(2131624773)
    TextView mPostHeaderBadgeScore;
    @BindView(2131624771)
    TextView mPostHeaderBadgeText;
    @BindView(2131624766)
    public TextView mPostIcon;
    @BindView(2131624413)
    View mPostImageFooter;
    @BindView(2131624767)
    public ImageView mPostModIcon;
    @BindView(2131624768)
    View mPostPopupAction;
    @BindView(2131624797)
    LinearLayout mPostRelated;
    @BindView(2131624400)
    View mPostRelatedBar;
    @BindView(2131624800)
    LinearLayout mPostRelatedBottom;
    @BindView(2131624801)
    View mPostRumorAlert;
    @BindView(2131624802)
    ImageView mPostRumorAlertDrawable;
    @BindView(2131624803)
    TextView mPostRumorAlertText;
    @BindView(2131624408)
    View mPostShareOgImage;
    @BindView(2131624774)
    public TextView mPostTimestamp;
    @BindView(2131624804)
    View mPostTrending;
    @BindView(2131624805)
    ImageView mPostTrendingDrawable;
    @BindView(2131624806)
    TextView mPostTrendingText;
    @BindView(2131624191)
    ProgressBar mProgressBar;
    @BindView(2131624746)
    TextView mRumorFalseText;
    @BindView(2131624740)
    TextView mRumorTrueText;
    @BindView(2131624753)
    FrameLayout mShareButton;
    @BindView(2131624754)
    ImageView mShareIcon;
    @BindView(2131624784)
    View mTrueRumorContainerOgImage;
    @BindView(2131624785)
    ImageView mTrueRumorIconOgImage;
    @BindView(2131624786)
    public TextView mTrueRumorTextOgImage;
    @BindView(2131624788)
    public TextView mUnlikePostBtnOgImage;
    @BindView(2131624747)
    LinearLayout mUnlikeRumorPostBadge;
    @BindView(2131624743)
    LinearLayout mUnlikeRumorPostContainer;
    @BindView(2131624745)
    ImageView mUnlikeRumorPostIcon;
    @BindView(2131624748)
    TextView mUnlikeRumorPostText;
    @BindView(2131624775)
    ImageView reportFlag;

    public BasePostViewHolder(View itemView, Activity activity) {
        super(itemView, activity);
    }

    public BasePostViewHolder(View itemView, Activity activity, String feedType) {
        super(itemView, activity);
        a = feedType;
    }

    public static void a(BasePostViewHolder holder, Post post) {
        LayoutParams layoutParams;
        final Post post2;
        final BasePostViewHolder basePostViewHolder;
        holder.d(post, holder);
        holder.b(post, holder);
        holder.c(post, holder);
        holder.a(post, holder);
        final Handler handler = new Handler(holder.f.getMainLooper());
        double screenSize = jb.b(holder.f);
        if (post.rumor == 1) {
            holder.mLikeRumorPostIcon.setImageDrawable(holder.f.getResources().getDrawable(2130838196));
            holder.mUnlikeRumorPostIcon.setImageDrawable(holder.f.getResources().getDrawable(2130838195));
            holder.mRumorTrueText.setVisibility(0);
            holder.mRumorFalseText.setVisibility(0);
            if (screenSize > 4.5d) {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(jb.a(53, holder.f), 0, 0, 0);
                layoutParams.gravity = 16;
                holder.mLikeRumorPostBadge.setLayoutParams(layoutParams);
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(jb.a(58, holder.f), 0, 0, 0);
                layoutParams.gravity = 16;
                holder.mUnlikeRumorPostBadge.setLayoutParams(layoutParams);
                holder.mLikeRumorPostBadge.setBackground(null);
                holder.mUnlikeRumorPostBadge.setBackground(null);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(jb.a(48, holder.f), jb.a(8, holder.f), 0, 0);
                holder.mLikeRumorPostBadge.setLayoutParams(layoutParams);
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(jb.a(53, holder.f), jb.a(8, holder.f), 0, 0);
                holder.mUnlikeRumorPostBadge.setLayoutParams(layoutParams);
                holder.mLikeRumorPostBadge.setBackground(holder.f.getResources().getDrawable(2130837991));
                holder.mUnlikeRumorPostBadge.setBackground(holder.f.getResources().getDrawable(2130837991));
            }
            int opinionValue = post.opinion_value;
            int whiteColor = Color.parseColor("#FFFFFF");
            int redColor = Color.parseColor("#FF0000");
            int greenColor = Color.parseColor("#00FF00");
            if (opinionValue == 1) {
                holder.mLikeRumorPostIcon.setColorFilter(greenColor);
                holder.mUnlikeRumorPostIcon.setColorFilter(whiteColor);
            } else if (opinionValue == -1) {
                holder.mLikeRumorPostIcon.setColorFilter(whiteColor);
                holder.mUnlikeRumorPostIcon.setColorFilter(redColor);
            } else {
                holder.mLikeRumorPostIcon.setColorFilter(whiteColor);
                holder.mUnlikeRumorPostIcon.setColorFilter(whiteColor);
            }
            holder.mLikeRumorPostText.setText(Integer.toString(post.num_true));
            holder.mUnlikeRumorPostText.setText(Integer.toString(post.num_false));
            post2 = post;
            basePostViewHolder = holder;
            holder.mLikeRumorPostContainer.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    int opinionValue = post2.opinion_value;
                    Post post;
                    if (opinionValue == 1) {
                        basePostViewHolder.a(basePostViewHolder.mLikeRumorPostIcon, post2.num_true, basePostViewHolder.mLikeRumorPostText, false);
                        post2.opinion_value = 0;
                        post = post2;
                        post.num_true--;
                    } else {
                        if (opinionValue == -1) {
                            basePostViewHolder.b(basePostViewHolder.mUnlikeRumorPostIcon, post2.num_false, basePostViewHolder.mUnlikeRumorPostText, false);
                            post = post2;
                            post.num_false--;
                        }
                        basePostViewHolder.a(basePostViewHolder.mLikeRumorPostIcon, post2.num_true, basePostViewHolder.mLikeRumorPostText, true);
                        post2.opinion_value = 1;
                        post = post2;
                        post.num_true++;
                    }
                    basePostViewHolder.a(post2.post_id, post2.opinion_value, 1, (Activity) basePostViewHolder.f);
                }
            });
            post2 = post;
            basePostViewHolder = holder;
            holder.mUnlikeRumorPostContainer.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    int opinionValue = post2.opinion_value;
                    Post post;
                    if (opinionValue == -1) {
                        basePostViewHolder.b(basePostViewHolder.mUnlikeRumorPostIcon, post2.num_false, basePostViewHolder.mUnlikeRumorPostText, false);
                        post2.opinion_value = 0;
                        post = post2;
                        post.num_false--;
                    } else {
                        if (opinionValue == 1) {
                            basePostViewHolder.a(basePostViewHolder.mLikeRumorPostIcon, post2.num_true, basePostViewHolder.mLikeRumorPostText, false);
                            post = post2;
                            post.num_true--;
                        }
                        basePostViewHolder.b(basePostViewHolder.mUnlikeRumorPostIcon, post2.num_false, basePostViewHolder.mUnlikeRumorPostText, true);
                        post2.opinion_value = -1;
                        post = post2;
                        post.num_false++;
                    }
                    basePostViewHolder.a(post2.post_id, post2.opinion_value, 1, (Activity) basePostViewHolder.f);
                }
            });
        } else {
            holder.mRumorTrueText.setVisibility(8);
            holder.mRumorFalseText.setVisibility(8);
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            holder.mLikeRumorPostContainer.setLayoutParams(layoutParams);
            holder.mUnlikeRumorPostContainer.setLayoutParams(layoutParams);
            holder.mCommentPostContainer.setLayoutParams(layoutParams);
            if (screenSize > 4.5d) {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(jb.a(28, holder.f), 0, 0, 0);
                layoutParams.gravity = 16;
                holder.mLikeRumorPostBadge.setLayoutParams(layoutParams);
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(jb.a(30, holder.f), 0, 0, 0);
                layoutParams.gravity = 16;
                holder.mUnlikeRumorPostBadge.setLayoutParams(layoutParams);
                holder.mLikeRumorPostBadge.setBackground(null);
                holder.mUnlikeRumorPostBadge.setBackground(null);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(jb.a(22, holder.f), jb.a(8, holder.f), 0, 0);
                holder.mLikeRumorPostBadge.setLayoutParams(layoutParams);
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(jb.a(24, holder.f), jb.a(8, holder.f), 0, 0);
                holder.mUnlikeRumorPostBadge.setLayoutParams(layoutParams);
                holder.mLikeRumorPostBadge.setBackground(holder.f.getResources().getDrawable(2130837991));
                holder.mUnlikeRumorPostBadge.setBackground(holder.f.getResources().getDrawable(2130837991));
            }
            int likeValue = post.like_value;
            if (likeValue == 1) {
                holder.mLikeRumorPostIcon.setImageDrawable(holder.f.getResources().getDrawable(2130838006));
                holder.mUnlikeRumorPostIcon.setImageDrawable(holder.f.getResources().getDrawable(2130838008));
            } else if (likeValue == -1) {
                holder.mLikeRumorPostIcon.setImageDrawable(holder.f.getResources().getDrawable(2130838010));
                holder.mUnlikeRumorPostIcon.setImageDrawable(holder.f.getResources().getDrawable(2130838007));
            } else {
                holder.mLikeRumorPostIcon.setImageDrawable(holder.f.getResources().getDrawable(2130838010));
                holder.mUnlikeRumorPostIcon.setImageDrawable(holder.f.getResources().getDrawable(2130838008));
            }
            post2 = post;
            basePostViewHolder = holder;
            holder.mLikeRumorPostContainer.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    int likeValue = post2.like_value;
                    Post post;
                    if (likeValue == 1) {
                        basePostViewHolder.a(basePostViewHolder.mLikeRumorPostIcon, basePostViewHolder.mLikeRumorPostText, basePostViewHolder.f, false);
                        post2.like_value = 0;
                        post = post2;
                        post.num_likes--;
                    } else {
                        if (likeValue == -1) {
                            basePostViewHolder.b(basePostViewHolder.mUnlikeRumorPostIcon, basePostViewHolder.mUnlikeRumorPostText, basePostViewHolder.f, false);
                            post = post2;
                            post.num_dislikes--;
                        }
                        basePostViewHolder.a(basePostViewHolder.mLikeRumorPostIcon, basePostViewHolder.mLikeRumorPostText, basePostViewHolder.f, true);
                        post = post2;
                        post.num_likes++;
                        post2.like_value = 1;
                    }
                    basePostViewHolder.a(post2.post_id, post2.like_value, 0, (Activity) basePostViewHolder.f);
                }
            });
            post2 = post;
            basePostViewHolder = holder;
            holder.mUnlikeRumorPostContainer.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    int likeValue = post2.like_value;
                    Post post;
                    if (likeValue == -1) {
                        basePostViewHolder.b(basePostViewHolder.mUnlikeRumorPostIcon, basePostViewHolder.mUnlikeRumorPostText, basePostViewHolder.f, false);
                        post2.like_value = 0;
                        post = post2;
                        post.num_dislikes--;
                    } else {
                        if (likeValue == 1) {
                            basePostViewHolder.a(basePostViewHolder.mLikeRumorPostIcon, basePostViewHolder.mLikeRumorPostText, basePostViewHolder.f, false);
                            post = post2;
                            post.num_likes--;
                        }
                        basePostViewHolder.b(basePostViewHolder.mUnlikeRumorPostIcon, basePostViewHolder.mUnlikeRumorPostText, basePostViewHolder.f, true);
                        post = post2;
                        post.num_dislikes++;
                        post2.like_value = -1;
                    }
                    basePostViewHolder.a(post2.post_id, post2.like_value, 0, (Activity) basePostViewHolder.f);
                }
            });
        }
        if (screenSize > 4.5d) {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(jb.a(28, holder.f), 0, 0, 0);
            layoutParams.gravity = 16;
            holder.mCommentPostBadge.setLayoutParams(layoutParams);
            holder.mCommentPostBadge.setBackground(null);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(jb.a(22, holder.f), jb.a(8, holder.f), 0, 0);
            holder.mCommentPostBadge.setLayoutParams(layoutParams);
            holder.mCommentPostBadge.setBackground(holder.f.getResources().getDrawable(2130837991));
        }
        if (post.related_to_post > 0) {
            holder.mPostRelatedBar.setVisibility(0);
            if (post.first_related_post == 1) {
                holder.mPostRelated.setVisibility(0);
                holder.mPostRelatedBottom.setVisibility(8);
            } else if (post.last_related_post == 1) {
                holder.mPostRelated.setVisibility(8);
                holder.mPostRelatedBottom.setVisibility(0);
            } else {
                holder.mPostRelated.setVisibility(8);
                holder.mPostRelatedBottom.setVisibility(8);
            }
        } else {
            holder.mPostRelatedBar.setVisibility(8);
            holder.mPostRelated.setVisibility(8);
            holder.mPostRelatedBottom.setVisibility(8);
        }
        final BasePostViewHolder basePostViewHolder2 = holder;
        final Post post3 = post;
        holder.mCommentPostContainer.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (!(basePostViewHolder2.f instanceof PostDetailsActivity)) {
                    Intent intent = new Intent(v.getContext(), PostDetailsActivity.class);
                    intent.putExtra("post_id", post3.post_id);
                    intent.putExtra("op_color", post3.icon_color);
                    if (BasePostViewHolder.a != null) {
                        intent.putExtra("feed_type", BasePostViewHolder.a);
                    }
                    v.getContext().startActivity(intent);
                }
            }
        });
        basePostViewHolder2 = holder;
        post3 = post;
        holder.mShareButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (AppState.config.getInt("enable_share_post", 0) == 1) {
                    PopupMenu popupMenu = new PopupMenu(basePostViewHolder2.f, v);
                    popupMenu.getMenuInflater().inflate(2131689482, popupMenu.getMenu());
                    popupMenu.show();
                    popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                        final /* synthetic */ AnonymousClass17 a;

                        {
                            this.a = this$0;
                        }

                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case 2131624865:
                                    basePostViewHolder2.a(basePostViewHolder2, post3, iy.a);
                                    return true;
                                case 2131624866:
                                    basePostViewHolder2.a(basePostViewHolder2, post3, 1989);
                                    return true;
                                case 2131624867:
                                    Intent intent = new Intent(basePostViewHolder2.f, InviteContactsActivity.class);
                                    intent.putExtra("invite_type", InviteFlowTypes.POST.toString());
                                    if (post3.thats_me == 1) {
                                        intent.putExtra("upsell_id", "-7," + String.valueOf(post3.post_id));
                                    } else {
                                        intent.putExtra("upsell_id", "-3," + String.valueOf(post3.post_id));
                                    }
                                    basePostViewHolder2.f.startActivity(intent);
                                    return true;
                                case 2131624868:
                                    iy.a(basePostViewHolder2.f, post3.share_info.url, "Share Link");
                                    return true;
                                default:
                                    return false;
                            }
                        }
                    });
                    return;
                }
                Toast.makeText(basePostViewHolder2.f, "Sharing is not available", 0).show();
            }
        });
        if (post.thats_me != 1) {
            holder.mMessagePostContainer.setVisibility(0);
            post2 = post;
            basePostViewHolder = holder;
            holder.mMessagePostContainer.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (post2.messaging_blocked != null) {
                        new Builder(basePostViewHolder.f).setMessage(post2.messaging_blocked).setPositiveButton(2131230895, null).show();
                    } else if (post2.messaging_disabled != null) {
                        new Builder(basePostViewHolder.f).setMessage(post2.messaging_disabled).setPositiveButton(2131230895, null).show();
                    } else {
                        Intent intent = new Intent(basePostViewHolder.f, MessageActivity.class);
                        intent.putExtra("post_id", Integer.toString(post2.post_id));
                        intent.putExtra("user_name", post2.user_name);
                        basePostViewHolder.f.startActivity(intent);
                    }
                }
            });
        } else {
            holder.mMessagePostContainer.setVisibility(8);
        }
        basePostViewHolder2 = holder;
        post3 = post;
        holder.mPostPopupAction.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                final Context context = basePostViewHolder2.f;
                PopupMenu popupMenu = new PopupMenu(basePostViewHolder2.f, v);
                popupMenu.getMenuInflater().inflate(2131689481, popupMenu.getMenu());
                if (post3.thats_me == 1) {
                    if (post3.caption == null || post3.caption.equals("")) {
                        popupMenu.getMenu().getItem(0).setVisible(false);
                    } else {
                        popupMenu.getMenu().getItem(0).setVisible(true);
                    }
                    popupMenu.getMenu().getItem(1).setVisible(true);
                    popupMenu.getMenu().getItem(2).setVisible(false);
                    popupMenu.getMenu().getItem(3).setVisible(false);
                    popupMenu.getMenu().getItem(4).setVisible(false);
                } else {
                    popupMenu.getMenu().getItem(0).setVisible(false);
                    popupMenu.getMenu().getItem(1).setVisible(false);
                    if (!AppState.config.getBoolean("messaging_turned_on", true) || post3.thats_me == 1) {
                        popupMenu.getMenu().getItem(2).setVisible(false);
                    } else {
                        popupMenu.getMenu().getItem(2).setVisible(true);
                    }
                    popupMenu.getMenu().getItem(3).setVisible(true);
                    popupMenu.getMenu().getItem(4).setVisible(true);
                }
                if (post3.can_mute == 1 && post3.muted_post == 0) {
                    popupMenu.getMenu().getItem(5).setVisible(true);
                    popupMenu.getMenu().getItem(6).setVisible(false);
                } else if (post3.can_mute == 1 && post3.muted_post == 1) {
                    popupMenu.getMenu().getItem(5).setVisible(false);
                    popupMenu.getMenu().getItem(6).setVisible(true);
                }
                popupMenu.show();
                final Builder builder = new Builder(context);
                popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ AnonymousClass19 c;

                    public boolean onMenuItemClick(MenuItem item) {
                        Intent intent;
                        switch (item.getItemId()) {
                            case 2131624858:
                                intent = new Intent(context, ContentEditActivity.class);
                                intent.putExtra("caption", post3.caption);
                                intent.putExtra("post_id", post3.post_id);
                                if (post3.mentioned_groups_info != null) {
                                    intent.putExtra("group_tags", post3.mentioned_groups_info);
                                }
                                context.startActivity(intent);
                                return true;
                            case 2131624859:
                                builder.setTitle(2131230796).setPositiveButton(2131230953, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$1;
                                    }

                                    public void onClick(DialogInterface dialog, int which) {
                                        ik.a().a(post3, null).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(this) {
                                            final /* synthetic */ AnonymousClass2 a;

                                            {
                                                this.a = this$2;
                                            }

                                            public /* synthetic */ void onNext(Object obj) {
                                                a((EmptyClass) obj);
                                            }

                                            public void onCompleted() {
                                                ix.a().a(new in$r(post3.post_id));
                                                Context context = GossipApplication.a().getApplicationContext();
                                                Toast.makeText(context, context.getResources().getString(2131230957), 0).show();
                                            }

                                            public void onError(Throwable e) {
                                                String error = e.getLocalizedMessage();
                                            }

                                            public void a(EmptyClass emptyClass) {
                                                String has = emptyClass.toString();
                                            }
                                        });
                                    }
                                }).setNegativeButton(2131230890, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$1;
                                    }

                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                                builder.create().show();
                                return true;
                            case 2131624860:
                                if (post3.messaging_blocked != null) {
                                    new Builder(context).setMessage(post3.messaging_blocked).setPositiveButton(2131230895, null).show();
                                    return true;
                                } else if (post3.messaging_disabled != null) {
                                    new Builder(context).setMessage(post3.messaging_disabled).setPositiveButton(2131230895, null).show();
                                    return true;
                                } else {
                                    intent = new Intent(context, MessageActivity.class);
                                    intent.putExtra("post_id", Integer.toString(post3.post_id));
                                    intent.putExtra("user_name", post3.user_name);
                                    context.startActivity(intent);
                                    return true;
                                }
                            case 2131624861:
                                builder.setTitle(2131230910).setMessage(2131230909).setPositiveButton(2131230953, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$1;
                                    }

                                    public void onClick(DialogInterface dialog, int which) {
                                        ik.a().b(post3, context.getString(2131230856)).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(this) {
                                            final /* synthetic */ AnonymousClass3 a;

                                            {
                                                this.a = this$2;
                                            }

                                            public /* synthetic */ void onNext(Object obj) {
                                                a((EmptyClass) obj);
                                            }

                                            public void onCompleted() {
                                                ix.a().a(new in$r(post3.post_id));
                                                Context context = GossipApplication.a().getApplicationContext();
                                                Toast.makeText(context, context.getResources().getString(2131230960), 0).show();
                                            }

                                            public void onError(Throwable e) {
                                            }

                                            public void a(EmptyClass emptyClass) {
                                            }
                                        });
                                    }
                                }).setNegativeButton(2131230890, null);
                                builder.create().show();
                                return true;
                            case 2131624862:
                                final int[] reasonPos = new int[]{-1};
                                final String[] chars = new String[]{context.getString(2131230893), context.getString(2131230928), context.getString(2131230855), context.getString(2131230894)};
                                builder.setTitle(2131230952).setSingleChoiceItems(chars, -1, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 b;

                                    public void onClick(DialogInterface dialog, int which) {
                                        reasonPos[0] = which;
                                        ((AlertDialog) dialog).getButton(-1).setEnabled(true);
                                    }
                                }).setPositiveButton(2131230895, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 c;

                                    public void onClick(DialogInterface dialog, int which) {
                                        if (reasonPos[0] < 0) {
                                            Log.d("BPVH", "No reason selected");
                                        } else {
                                            ik.a().b(post3, chars[reasonPos[0]]).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(this) {
                                                final /* synthetic */ AnonymousClass5 a;

                                                {
                                                    this.a = this$2;
                                                }

                                                public /* synthetic */ void onNext(Object obj) {
                                                    a((EmptyClass) obj);
                                                }

                                                public void onCompleted() {
                                                    ix.a().a(new in$r(post3.post_id));
                                                    Context context = GossipApplication.a().getApplicationContext();
                                                    Toast.makeText(context, context.getResources().getString(2131230960), 0).show();
                                                }

                                                public void onError(Throwable e) {
                                                }

                                                public void a(EmptyClass emptyClass) {
                                                }
                                            });
                                        }
                                    }
                                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$1;
                                    }

                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                                AlertDialog dialog = builder.create();
                                dialog.setOnShowListener(new OnShowListener(this) {
                                    final /* synthetic */ AnonymousClass1 b;

                                    public void onShow(DialogInterface dialog) {
                                        if (reasonPos[0] < 0) {
                                            ((AlertDialog) dialog).getButton(-1).setEnabled(false);
                                        }
                                    }
                                });
                                dialog.show();
                                return true;
                            case 2131624863:
                                ik.a().e(Integer.toString(post3.post_id)).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$1;
                                    }

                                    public /* synthetic */ void onNext(Object obj) {
                                        a((EmptyClass) obj);
                                    }

                                    public void onCompleted() {
                                    }

                                    public void onError(Throwable e) {
                                    }

                                    public void a(EmptyClass emptyClass) {
                                        builder.setTitle("Muted").setMessage("You will no longer receive notifications about this post.").setPositiveButton(2131230895, null);
                                        builder.create().show();
                                        post3.muted_post = 1;
                                        if (context instanceof PostDetailsActivity) {
                                            ((PostDetailsActivity) context).toggleMuteIcon();
                                        }
                                    }
                                });
                                return true;
                            case 2131624864:
                                ik.a().f(Integer.toString(post3.post_id)).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$1;
                                    }

                                    public /* synthetic */ void onNext(Object obj) {
                                        a((EmptyClass) obj);
                                    }

                                    public void onCompleted() {
                                    }

                                    public void onError(Throwable e) {
                                    }

                                    public void a(EmptyClass emptyClass) {
                                        builder.setTitle("Unmuted Post").setMessage("You will receive notifications about this post again.").setPositiveButton(2131230895, null);
                                        builder.create().show();
                                        post3.muted_post = 0;
                                        if (context instanceof PostDetailsActivity) {
                                            ((PostDetailsActivity) context).toggleMuteIcon();
                                        }
                                    }
                                });
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });
        int disableGroupTagging = AppState.config.getInt("disable_group_tagging", 0);
        String textCaption = post.caption;
        boolean seeMore = false;
        if (textCaption != null) {
            Spannable spannable;
            int start;
            Spannable spannableString = new SpannableString(textCaption);
            if (!((holder.f instanceof PostDetailsActivity) || AppState.expandedPostIds == null || AppState.expandedPostIds.contains(Integer.valueOf(post.post_id)))) {
                spannable = jb.a(textCaption, Color.parseColor("#99FFFFFF"));
                if (spannable.toString().endsWith("See More")) {
                    seeMore = true;
                    holder.mPostCaption.setText(spannable);
                    post2 = post;
                    holder.mPostCaption.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            handler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass20 a;

                                {
                                    this.a = this$0;
                                }

                                public void run() {
                                    AppState.expandedPostIds.add(Integer.valueOf(post2.post_id));
                                    ix.a().a(new in$al(post2.post_id));
                                }
                            });
                        }
                    });
                }
            }
            ArrayList<TextTag> tagIndexes = new ArrayList();
            if (disableGroupTagging == 0 && post.mentioned_groups_info != null) {
                for (String group : post.mentioned_groups_info.split(";")) {
                    String[] indices = group.split(",");
                    if (indices.length != 3) {
                        break;
                    }
                    tagIndexes.add(new TextTag(Integer.parseInt(indices[1]), Integer.parseInt(indices[2]), Integer.parseInt(indices[0])));
                }
            }
            DataUtil.sortTextTags(tagIndexes, 0, tagIndexes.size() - 1);
            int index = 0;
            while (!tagIndexes.isEmpty()) {
                TextTag currTag = (TextTag) tagIndexes.remove(0);
                if (currTag.startIndex >= spannable.length() || currTag.endIndex > spannable.length() || currTag.startIndex < 0 || currTag.endIndex <= 0 || (spannable.toString().endsWith("See More") && currTag.endIndex > spannable.length())) {
                    break;
                }
                start = index;
                if (start > spannable.length()) {
                    break;
                }
                while (index < currTag.startIndex) {
                    index++;
                }
                if (index > spannable.length()) {
                    index = spannable.length();
                }
                if (index > -1 && start > -1 && index - start > 0 && !(holder.f instanceof PostDetailsActivity) && !seeMore) {
                    spannable.setSpan(jb.a("#ffffff", post.post_id, holder.f, seeMore, post.icon_color), start, index, 33);
                }
                try {
                    if (currTag.startIndex > -1 && currTag.endIndex > -1) {
                        spannable.setSpan(jb.a("#ffffff", currTag.groupId, holder.f), currTag.startIndex, currTag.endIndex, 33);
                        index = currTag.endIndex + 1;
                    }
                } catch (Throwable e) {
                    rj.a(e);
                }
            }
            start = index;
            while (index < spannable.length()) {
                index++;
            }
            if (index > -1 && start > -1 && index - start > 0 && !(holder.f instanceof PostDetailsActivity) && !seeMore) {
                spannable.setSpan(jb.a("#ffffff", post.post_id, holder.f, seeMore, post.icon_color), start, index, 33);
            }
            if (!((holder.f instanceof PostDetailsActivity) || seeMore)) {
                holder.mPostCaption.setTextIsSelectable(false);
            }
            holder.mPostCaption.setMovementMethod(LinkMovementMethod.getInstance());
            holder.mPostCaption.setText(spannable);
            return;
        }
        holder.mPostCaption.setText(textCaption);
    }

    private void a(int postId, int likeValue, int isRumor, final Activity context) {
        ik.a().b(Integer.toString(postId), Integer.toString(likeValue), Integer.toString(isRumor)).b(Schedulers.io()).b(new apr<Post>(this) {
            final /* synthetic */ BasePostViewHolder b;

            public /* synthetic */ void onNext(Object obj) {
                a((Post) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void a(Post post) {
                ix.a().a(new in$q(post, context));
            }
        });
    }

    public void a(Post post, BasePostViewHolder holder) {
        int numLikes = post.num_likes;
        int numDislikes = post.num_dislikes;
        holder.mCommentPostText.setText(Integer.toString(post.num_comments));
        holder.mLikeRumorPostText.setText(Integer.toString(numLikes));
        holder.mUnlikeRumorPostText.setText(Integer.toString(numDislikes));
        String commentText = post.comment_text;
        String commentIcon = post.comment_icon_name;
        int commentImgHeight = post.comment_image_height;
        int commentImgWidth = post.comment_image_width;
        String commentSourceUrl = post.comment_source_url;
        String commentTimestamp = post.comment_time_ago;
        String commentStickerName = post.comment_sticker_name;
        int commentValue = post.num_comments;
        int commentIsCandidMod = post.comment_is_candid_mod;
        if (commentValue <= 1) {
            holder.mFooterCommentValue.setVisibility(8);
        } else {
            holder.mFooterCommentValue.setVisibility(0);
            holder.mFooterCommentValue.setText(String.format(holder.f.getString(2131230906), new Object[]{Integer.toString(commentValue)}));
        }
        if (commentIcon == null || commentIcon.isEmpty()) {
            holder.mFooterCommentSnippet.setVisibility(8);
        } else {
            holder.mFooterCommentSnippet.setVisibility(0);
            a(post.icon_color, commentIcon, commentText, commentTimestamp, commentSourceUrl, commentImgWidth, commentImgHeight, commentStickerName, holder, commentIsCandidMod, post.post_id);
        }
        jb.a(holder.mFooter);
    }

    public void a(final String icon_color, String commentIcon, String commentText, String commentTimestamp, String commentSourceUrl, int commentImgWidth, int commentImgHeight, String commentStickerName, BasePostViewHolder holder, int isMod, int post_id) {
        if (isMod == 1) {
            holder.mFooterCommentModIcon.setVisibility(0);
            holder.mFooterCommentIcon.setVisibility(8);
        } else {
            holder.mFooterCommentIcon.setVisibility(0);
            a(commentIcon, Color.parseColor(icon_color), holder.mFooterCommentIcon, holder.f, 25);
            holder.mFooterCommentModIcon.setVisibility(8);
        }
        holder.mFooterCommentTimestamp.setText(commentTimestamp);
        if (commentText == null || commentText.isEmpty()) {
            holder.mFooterCommentText.setVisibility(8);
        } else {
            holder.mFooterCommentText.setVisibility(0);
            holder.mFooterCommentText.setText(commentText);
        }
        boolean hasImage = (commentImgHeight == -1 || commentImgWidth == -1 || commentSourceUrl == null || commentSourceUrl.isEmpty()) ? false : true;
        boolean hasSticker = (commentImgHeight == -1 || commentImgWidth == -1 || commentStickerName == null) ? false : true;
        float density = holder.f.getResources().getDisplayMetrics().density;
        if (hasImage) {
            holder.mFooterCommentImage.setVisibility(0);
            holder.mFooterCommentImage.setLayoutParams(new LinearLayout.LayoutParams((int) (((float) commentImgWidth) * density), (int) (((float) commentImgHeight) * density)));
            GossipApplication.c.a(commentSourceUrl).d().a(holder.mFooterCommentImage);
        } else if (hasSticker) {
            holder.mFooterCommentImage.setVisibility(0);
            holder.mFooterCommentImage.setLayoutParams(new LinearLayout.LayoutParams((int) (((float) commentImgWidth) * density), (int) (((float) commentImgHeight) * density)));
            holder.mFooterCommentImage.setImageDrawable(GossipApplication.a.getResources().getDrawable(GossipApplication.a.getResources().getIdentifier(commentStickerName.toLowerCase(), "drawable", GossipApplication.a.getPackageName())));
        } else {
            holder.mFooterCommentImage.setVisibility(8);
        }
        final int i = post_id;
        holder.mFooterCommentSnippet.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BasePostViewHolder c;

            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PostDetailsActivity.class);
                intent.putExtra("post_id", i);
                intent.putExtra("op_color", icon_color);
                if (BasePostViewHolder.a != null) {
                    intent.putExtra("feed_type", BasePostViewHolder.a);
                }
                this.c.f.startActivity(intent);
            }
        });
    }

    private void b(Post post, BasePostViewHolder holder) {
        int color = Color.parseColor(post.icon_color);
        if (post.trending != 1 || post.rumor == 1) {
            holder.mPostTrending.setVisibility(8);
            return;
        }
        holder.mPostTrending.setVisibility(0);
        holder.mPostTrendingDrawable.setColorFilter(color);
        holder.mPostTrendingText.setTextColor(color);
    }

    private void c(Post post, BasePostViewHolder holder) {
        int color = Color.parseColor(post.icon_color);
        if (post.rumor == 1) {
            holder.mPostRumorAlert.setVisibility(0);
            holder.mPostRumorAlertDrawable.setColorFilter(color);
            holder.mPostRumorAlertText.setTextColor(color);
            return;
        }
        holder.mPostRumorAlert.setVisibility(8);
    }

    private void d(Post post, BasePostViewHolder holder) {
        final BasePostViewHolder basePostViewHolder;
        final Post post2;
        String icon = post.icon_name;
        int color = Color.parseColor(post.icon_color);
        if (post.is_candid_mod == 1) {
            holder.mPostIcon.setVisibility(8);
            holder.mPostModIcon.setVisibility(0);
            basePostViewHolder = holder;
            holder.mPostModIcon.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BasePostViewHolder b;

                public void onClick(View v) {
                    if (!AppState.blurTaskCalledOnFlight) {
                        AppState.blurTaskCalledOnFlight = true;
                        new BlurTask((Activity) basePostViewHolder.f, ((Activity) basePostViewHolder.f).findViewById(16908290), BadgeType.MOD, basePostViewHolder.f.getString(2131230884), basePostViewHolder.f.getString(2131230933)).execute(new Void[0]);
                    }
                }
            });
        } else {
            a(icon, color, holder.mPostIcon, holder.f, 40);
            if (AppState.config.getBoolean("messaging_turned_on", true) && post.thats_me != 1) {
                post2 = post;
                holder.mPostIcon.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ BasePostViewHolder b;

                    public void onClick(View v) {
                        if (post2.messaging_blocked != null) {
                            new Builder(this.b.f).setMessage(post2.messaging_blocked).setPositiveButton(2131230895, null).show();
                        } else if (post2.messaging_disabled != null) {
                            new Builder(this.b.f).setMessage(post2.messaging_disabled).setPositiveButton(2131230895, null).show();
                        } else if (AppState.hasMessagedFromAlert) {
                            Intent intent = new Intent(this.b.f, MessageActivity.class);
                            intent.putExtra("post_id", Integer.toString(post2.post_id));
                            if (post2.user_name != null) {
                                intent.putExtra("user_name", post2.user_name);
                            }
                            this.b.f.startActivity(intent);
                        } else {
                            new Builder(this.b.f).setTitle("Message User?").setMessage("Would you like to send this user a message?").setNegativeButton(this.b.f.getResources().getString(2131230890), null).setPositiveButton(this.b.f.getResources().getString(2131230953), new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass5 a;

                                {
                                    this.a = this$1;
                                }

                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(this.a.b.f, MessageActivity.class);
                                    intent.putExtra("post_id", Integer.toString(post2.post_id));
                                    if (post2.user_name != null) {
                                        intent.putExtra("user_name", post2.user_name);
                                    }
                                    this.a.b.f.startActivity(intent);
                                }
                            }).create().show();
                            AppState.hasMessagedFromAlert = true;
                            AppState.saveState(GossipApplication.a());
                        }
                    }
                });
                holder.mPostModIcon.setVisibility(8);
            }
        }
        holder.mPostAuthor.setText(post.user_name);
        Drawable triangle = new jp();
        triangle.a(Color.parseColor("#ffffff"));
        int width = jb.a(10, this.f);
        int height = jb.a(6, this.f);
        int lower = jb.a(1, this.f);
        triangle.setBounds(0, lower, width, height);
        holder.mPostAuthor.setCompoundDrawables(null, null, triangle, null);
        holder.mPostTimestamp.setText(post.post_time_ago);
        holder.mPostGroup.setText(post.group_name);
        holder.mPostGroup.setTextColor(color);
        post2 = post;
        holder.mPostGroup.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BasePostViewHolder b;

            public void onClick(View v) {
                if (!(this.b.f instanceof GroupDetailsActivity)) {
                    Intent intent = new Intent(this.b.f, GroupDetailsActivity.class);
                    intent.putExtra("group_id", post2.group_id);
                    this.b.f.startActivity(intent);
                }
            }
        });
        post2 = post;
        holder.mPostGroupContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BasePostViewHolder b;

            public void onClick(View v) {
                if (!(this.b.f instanceof GroupDetailsActivity)) {
                    Intent intent = new Intent(this.b.f, GroupDetailsActivity.class);
                    intent.putExtra("group_id", post2.group_id);
                    this.b.f.startActivity(intent);
                }
            }
        });
        Drawable triangleGroup = new jp();
        triangleGroup.a(color);
        triangleGroup.setBounds(0, lower, width, height);
        holder.mPostGroupMenu.setBackground(triangleGroup);
        basePostViewHolder = holder;
        final Post post3 = post;
        holder.mPostGroupMenuContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BasePostViewHolder c;

            public void onClick(View view) {
                PopupMenu groupPopupMenu = new PopupMenu(view.getContext(), view);
                boolean join;
                if (basePostViewHolder.f instanceof GroupDetailsActivity) {
                    groupPopupMenu.setOnMenuItemClickListener((OnMenuItemClickListener) this.c.f);
                    join = true;
                    if (AppState.groups != null) {
                        for (Group group : AppState.groups) {
                            if (group.group_id == post3.group_id) {
                                if (group.moderator != 1) {
                                    groupPopupMenu.getMenu().add(1, 2131624838, 0, 2131230867);
                                    groupPopupMenu.getMenu().add(1, 2131624841, 0, 2131230913);
                                    join = false;
                                } else {
                                    groupPopupMenu.getMenu().add(1, 2131624842, 0, 2131230835);
                                    if (group.num_posts == 0) {
                                        groupPopupMenu.getMenu().add(1, 2131624840, 0, 2131230827);
                                    }
                                }
                            }
                        }
                    }
                    if (join) {
                        if (join) {
                            groupPopupMenu.getMenu().add(1, 2131624839, 0, 2131230862);
                        }
                        groupPopupMenu.getMenu().add(1, 2131624841, 0, 2131230913);
                    }
                    groupPopupMenu.show();
                    return;
                }
                groupPopupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ AnonymousClass8 a;

                    {
                        this.a = this$1;
                    }

                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case 2131624837:
                                basePostViewHolder.f.startActivity(GroupDetailsActivity.startGroupDetailsActivity(basePostViewHolder.f, post3.group_id));
                                break;
                            case 2131624838:
                                ik.a().c(post3.group_id).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$2;
                                    }

                                    public /* synthetic */ void onNext(Object obj) {
                                        a((NetworkData) obj);
                                    }

                                    public void onCompleted() {
                                    }

                                    public void onError(Throwable e) {
                                        rj.a(e);
                                        Log.d("GroupPopupLeave", e.toString());
                                    }

                                    public void a(NetworkData networkData) {
                                        for (int i = 0; i < AppState.groups.size(); i++) {
                                            if (((Group) AppState.groups.get(i)).group_id == post3.group_id) {
                                                AppState.groups.remove(i);
                                                break;
                                            }
                                        }
                                        ix.a().a(new in$p(post3.group_id, post3.post_id));
                                    }
                                });
                                break;
                            case 2131624839:
                                ik.a().b(post3.group_id).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$2;
                                    }

                                    public /* synthetic */ void onNext(Object obj) {
                                        a((NetworkData) obj);
                                    }

                                    public void onCompleted() {
                                    }

                                    public void onError(Throwable e) {
                                        rj.a(e);
                                        Log.d("GroupPopupLeave", e.toString());
                                    }

                                    public void a(NetworkData networkData) {
                                        if (networkData.success) {
                                            ix.a().a(new in$n(networkData.group.group_id, post3.post_id));
                                        }
                                    }
                                });
                                break;
                        }
                        return false;
                    }
                });
                groupPopupMenu.getMenu().add(1, 2131624837, 0, 2131230853);
                join = true;
                if (AppState.groups != null) {
                    for (Group group2 : AppState.groups) {
                        if (group2.group_id == post3.group_id) {
                            if (group2.moderator != 1) {
                                groupPopupMenu.getMenu().add(1, 2131624838, 0, 2131230867);
                                join = false;
                            }
                        }
                    }
                }
                if (join) {
                    groupPopupMenu.getMenu().add(1, 2131624839, 0, 2131230862);
                }
                groupPopupMenu.show();
            }
        });
        if (post.thats_me == 1) {
            holder.reportFlag.setVisibility(8);
        } else {
            holder.reportFlag.setVisibility(0);
            post2 = post;
            holder.reportFlag.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BasePostViewHolder b;

                public void onClick(View v) {
                    Builder builder = new Builder(this.b.f);
                    final int[] reasonPos = new int[]{-1};
                    final String[] chars = new String[]{this.b.f.getString(2131230893), this.b.f.getString(2131230928), this.b.f.getString(2131230855), this.b.f.getString(2131230894)};
                    builder.setTitle(2131230952).setSingleChoiceItems(chars, -1, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass9 b;

                        public void onClick(DialogInterface dialog, int which) {
                            reasonPos[0] = which;
                            ((AlertDialog) dialog).getButton(-1).setEnabled(true);
                        }
                    }).setPositiveButton(2131230895, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass9 c;

                        public void onClick(DialogInterface dialog, int which) {
                            if (reasonPos[0] < 0) {
                                Log.d("BPVH", "No reason selected");
                            } else {
                                ik.a().b(post2, chars[reasonPos[0]]).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(this) {
                                    final /* synthetic */ AnonymousClass2 a;

                                    {
                                        this.a = this$2;
                                    }

                                    public /* synthetic */ void onNext(Object obj) {
                                        a((EmptyClass) obj);
                                    }

                                    public void onCompleted() {
                                        ix.a().a(new in$r(post2.post_id));
                                        Context context = GossipApplication.a().getApplicationContext();
                                        Toast.makeText(context, context.getResources().getString(2131230960), 0).show();
                                    }

                                    public void onError(Throwable e) {
                                    }

                                    public void a(EmptyClass emptyClass) {
                                    }
                                });
                            }
                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass9 a;

                        {
                            this.a = this$1;
                        }

                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.setOnShowListener(new OnShowListener(this) {
                        final /* synthetic */ AnonymousClass9 b;

                        public void onShow(DialogInterface dialog) {
                            if (reasonPos[0] < 0) {
                                ((AlertDialog) dialog).getButton(-1).setEnabled(false);
                            }
                        }
                    });
                    dialog.show();
                }
            });
        }
        if (post.quality_score != 0.0f || post.is_friend == 1 || post.thats_me == 1 || post.is_candid_mod == 1) {
            final String score = new DecimalFormat("#").format((double) post.quality_score);
            holder.mPostHeaderBadge.setVisibility(0);
            String badgeText = "";
            if (post.is_candid_mod == 1) {
                badgeText = "MOD";
            } else if (post.thats_me == 1) {
                badgeText = "YOU";
            } else if (post.is_friend == 1) {
                badgeText = "FRIEND";
            }
            holder.mPostHeaderBadgeText.setText(badgeText);
            holder.mPostHeaderBadgeText.setTextColor(color);
            if (post.quality_score != 0.0f) {
                holder.mPostHeaderBadgeScore.setVisibility(0);
                holder.mPostHeaderBadgeScore.setText(score);
                holder.mPostHeaderBadgeScore.setTextColor(color);
                if (badgeText.isEmpty()) {
                    holder.mPostHeaderBadgeDot.setVisibility(8);
                } else {
                    holder.mPostHeaderBadgeDot.setVisibility(0);
                    Drawable drawable = holder.f.getResources().getDrawable(2130837707);
                    drawable.setColorFilter(color, Mode.SRC_IN);
                    holder.mPostHeaderBadgeDot.setBackground(drawable);
                }
            } else {
                holder.mPostHeaderBadgeScore.setVisibility(8);
                holder.mPostHeaderBadgeDot.setVisibility(8);
            }
            if (post.quality_score != 0.0f) {
                basePostViewHolder = holder;
                holder.mPostHeaderBadge.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ BasePostViewHolder c;

                    public void onClick(View v) {
                        if (!AppState.blurTaskCalledOnFlight) {
                            AppState.blurTaskCalledOnFlight = true;
                            new BlurTask((Activity) basePostViewHolder.f, ((Activity) basePostViewHolder.f).findViewById(16908290), score, BadgeType.POST_QUALITY_SCORE, basePostViewHolder.f.getString(2131230905), basePostViewHolder.f.getString(2131230931)).execute(new Void[0]);
                        }
                    }
                });
                return;
            }
            holder.mPostHeaderBadge.setOnClickListener(null);
            return;
        }
        holder.mPostHeaderBadge.setVisibility(8);
    }

    private void a(String icon, int color, TextView mPostIcon, Context context, int iconSize) {
        io candidAnimals = io.a();
        mPostIcon.setTypeface(io.b());
        mPostIcon.setTextColor(color);
        mPostIcon.setText(io.a(icon));
        mPostIcon.setTextSize(1, (float) iconSize);
        int iconWidth = mPostIcon.getWidth();
        if (iconWidth == 0) {
            iconWidth = (int) (mPostIcon.getResources().getDisplayMetrics().density * 40.0f);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(context.getResources().getColor(17170443));
        gradientDrawable.setCornerRadius((float) (iconWidth / 2));
        mPostIcon.setBackground(gradientDrawable);
        mPostIcon.getBackground().setAlpha(192);
        mPostIcon.setVisibility(0);
    }

    private void a(ImageView image, TextView text, Context context, boolean state) {
        int currCount = Integer.parseInt(text.getText().toString());
        if (state) {
            image.setImageDrawable(context.getResources().getDrawable(2130838006));
            text.setText(Integer.toString(currCount + 1));
            return;
        }
        image.setImageDrawable(context.getResources().getDrawable(2130838010));
        text.setText(Integer.toString(currCount - 1));
    }

    private void b(ImageView image, TextView text, Context context, boolean state) {
        int currCount = Integer.parseInt(text.getText().toString());
        if (state) {
            image.setImageDrawable(context.getResources().getDrawable(2130838007));
            text.setText(Integer.toString(currCount + 1));
            return;
        }
        image.setImageDrawable(context.getResources().getDrawable(2130838008));
        text.setText(Integer.toString(currCount - 1));
    }

    private void a(ImageView icon, int count, TextView text, boolean state) {
        if (state) {
            icon.setColorFilter(Color.parseColor("#00FF00"));
            text.setText(Integer.toString(count + 1));
            return;
        }
        icon.setColorFilter(Color.parseColor("#FFFFFF"));
        text.setText(Integer.toString(count - 1));
    }

    private void b(ImageView icon, int count, TextView text, boolean state) {
        if (state) {
            icon.setColorFilter(Color.parseColor("#FF0000"));
            text.setText(Integer.toString(count + 1));
            return;
        }
        icon.setColorFilter(Color.parseColor("#FFFFFF"));
        text.setText(Integer.toString(count - 1));
    }

    public void a(BasePostViewHolder holder, Post post, int shareType) {
        holder.mPostShareOgImage.setVisibility(4);
        if (post.rumor == 1) {
            holder.mTrueRumorContainerOgImage.setVisibility(0);
            holder.mFalseRumorContainerOgImage.setVisibility(0);
            holder.mLikePostBtnOgImage.setVisibility(8);
            holder.mUnlikePostBtnOgImage.setVisibility(8);
            int whiteColor = Color.parseColor("#FFFFFF");
            holder.mTrueRumorIconOgImage.setColorFilter(whiteColor);
            holder.mFalseRumorIconOgImage.setColorFilter(whiteColor);
            holder.mTrueRumorTextOgImage.setText("True " + Integer.toString(post.num_true));
            holder.mFalseRumorTextOgImage.setText("False " + Integer.toString(post.num_false));
        } else {
            holder.mTrueRumorContainerOgImage.setVisibility(8);
            holder.mFalseRumorContainerOgImage.setVisibility(8);
            holder.mLikePostBtnOgImage.setVisibility(0);
            holder.mUnlikePostBtnOgImage.setVisibility(0);
            holder.mLikePostBtnOgImage.setText(Integer.toString(post.num_likes));
            holder.mUnlikePostBtnOgImage.setText(Integer.toString(post.num_dislikes));
        }
        holder.mCommentPostBtnOgImage.setText(Integer.toString(post.num_comments));
        holder.mPostCaptionOgImage.setText(post.caption);
        holder.mPostGroupOgImage.setText(post.group_name);
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(0);
        shape.setColor(jb.a);
        holder.mPostImageFooter.setBackground(shape);
        final ShareDialog shareDialog = new ShareDialog((Activity) this.f);
        shareDialog.a(uj$a.a(), new uk<wq$a>(this) {
            final /* synthetic */ BasePostViewHolder a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onSuccess(Object obj) {
                a((wq$a) obj);
            }

            public void a(wq$a result) {
            }

            public void onError(FacebookException error) {
            }

            public void onCancel() {
            }
        });
        ViewTreeObserver viewTreeObserver = holder.mPostShareOgImage.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            final int i = shareType;
            final BasePostViewHolder basePostViewHolder = holder;
            final Post post2 = post;
            viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ BasePostViewHolder e;

                public void onGlobalLayout() {
                    if (this.e.mPostShareOgImage != null) {
                        View v = this.e.mPostShareOgImage;
                        this.e.mPostShareOgImage.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Config.ARGB_8888);
                        Canvas c = new Canvas(bitmap);
                        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
                        v.draw(c);
                        if (bitmap != null) {
                            if (i == iy.a) {
                                if (shareDialog != null) {
                                    SharePhotoContent content = new a().a(new SharePhoto.a().a(bitmap).c()).a();
                                    ShareDialog shareDialog = shareDialog;
                                    if (ShareDialog.a(SharePhotoContent.class)) {
                                        shareDialog.b(content);
                                    }
                                }
                            } else if (i == 1989) {
                                iy.a().a(bitmap);
                                iy.a().a(basePostViewHolder.f);
                                if (post2.share_info != null) {
                                    iy.a().a(post2.share_info.url);
                                }
                                if (bb.checkSelfPermission(basePostViewHolder.f, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                                    ActivityCompat.requestPermissions((Activity) basePostViewHolder.f, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1989);
                                } else {
                                    iy.a().b();
                                }
                            }
                        }
                        basePostViewHolder.mPostShareOgImage.setVisibility(8);
                    }
                }
            });
        }
    }
}
