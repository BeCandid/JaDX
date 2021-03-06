package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Post;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.becandid.candid.util.RoundedCornersTransformation.CornerType;
import defpackage.apf;
import defpackage.im;
import defpackage.jc;
import defpackage.qk;
import defpackage.qv;

public class GroupHeaderHolder extends jc {
    @BindView(2131624386)
    TextView groupAbout;
    @BindView(2131624376)
    RelativeLayout groupHeader;
    @BindView(2131624379)
    ImageView groupImage;
    @BindView(2131624380)
    TextView groupJoin;
    @BindView(2131624381)
    TextView groupLeave;
    @BindView(2131624377)
    ImageView groupMenu;
    @BindView(2131624387)
    TextView groupStats;

    public GroupHeaderHolder(View itemView, Activity activity) {
        super(itemView, activity);
    }

    public void a(final GroupHeaderHolder groupHeaderHolder, final Post post) {
        int[] tagIds = new int[]{2131624383, 2131624384, 2131624385};
        for (int i = 0; i < tagIds.length; i++) {
            TextView tagView = (TextView) this.groupHeader.findViewById(tagIds[i]);
            if (i < post.tags.size()) {
                tagView.setText(apf.a((String) post.tags.get(i)));
                tagView.setVisibility(0);
            } else {
                tagView.setVisibility(8);
            }
        }
        this.groupAbout.setText(post.about);
        this.groupAbout.setMaxLines(AppState.config.getInt("max_group_desc_lines", 7));
        StringBuilder sb = new StringBuilder(50);
        sb.append(post.num_posts + " POST");
        if (post.num_posts.intValue() != 1) {
            sb.append("S");
        }
        sb.append("  |  ");
        sb.append(post.num_members + " MEMBER");
        if (post.num_members.intValue() != 1) {
            sb.append("S");
        }
        if (post.num_friends.intValue() > 1) {
            sb.append("  |  " + post.num_friends + " FRIENDS");
        }
        this.groupStats.setText(sb.toString());
        this.groupImage.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ GroupHeaderHolder b;

            public void onGlobalLayout() {
                GossipApplication.c.a(post.imageUrl()).j().a().a(17301613).a(new qv<Bitmap>(this, this.b.groupImage.getWidth(), this.b.groupImage.getHeight()) {
                    final /* synthetic */ AnonymousClass1 a;

                    public /* synthetic */ void onResourceReady(Object obj, qk qkVar) {
                        a((Bitmap) obj, qkVar);
                    }

                    public void a(Bitmap resource, qk<? super Bitmap> qkVar) {
                        this.a.b.groupImage.setImageBitmap((Bitmap) new RoundedCornersTransformation(this.a.b.f, (int) (60.0f * this.a.b.f.getResources().getDisplayMetrics().density), 0, CornerType.ALL).a(resource, this.a.b.groupImage.getWidth(), this.a.b.groupImage.getHeight()).b());
                        Bitmap bg = im.a(resource, this.a.b.groupHeader.getWidth(), this.a.b.groupHeader.getHeight());
                        if (bg != null) {
                            this.a.b.groupHeader.setBackground(new BitmapDrawable(bg));
                        }
                    }
                });
            }
        });
        if (post.isMember() && post.moderator.intValue() != 1) {
            this.groupLeave.setVisibility(0);
            this.groupJoin.setVisibility(8);
        } else if (post.isMember()) {
            this.groupJoin.setVisibility(8);
            this.groupLeave.setVisibility(8);
        } else {
            this.groupJoin.setVisibility(0);
            this.groupLeave.setVisibility(8);
        }
        this.groupJoin.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupHeaderHolder a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.groupJoin.setVisibility(8);
                this.a.groupLeave.setVisibility(0);
                if (this.a.f instanceof GroupDetailsActivity) {
                    ((GroupDetailsActivity) this.a.f).joinGroupClick(v);
                }
            }
        });
        this.groupLeave.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupHeaderHolder a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.groupLeave.setVisibility(8);
                this.a.groupJoin.setVisibility(0);
                if (this.a.f instanceof GroupDetailsActivity) {
                    ((GroupDetailsActivity) this.a.f).leaveGroupClick(v);
                }
            }
        });
        this.groupMenu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupHeaderHolder c;

            public void onClick(View view) {
                PopupMenu groupPopupMenu = new PopupMenu(view.getContext(), view);
                groupPopupMenu.setOnMenuItemClickListener((OnMenuItemClickListener) groupHeaderHolder.f);
                if (post.moderator.intValue() == 1 && post.num_posts.intValue() == 0) {
                    groupPopupMenu.getMenu().add(1, 2131624840, 0, 2131230827);
                    groupPopupMenu.getMenu().add(1, 2131624842, 0, 2131230835);
                } else if (post.moderator.intValue() == 1) {
                    groupPopupMenu.getMenu().add(1, 2131624842, 0, 2131230835);
                } else {
                    groupPopupMenu.getMenu().add(1, 2131624841, 0, 2131230913);
                }
                groupPopupMenu.show();
            }
        });
        this.groupHeader.measure(MeasureSpec.makeMeasureSpec(this.f.getResources().getDisplayMetrics().widthPixels, 1073741824), 0);
    }
}
