package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.activities.WebViewActivity;
import com.becandid.candid.data.Post;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.becandid.candid.util.RoundedCornersTransformation.CornerType;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import defpackage.jb;
import defpackage.oh;
import defpackage.qk;
import defpackage.qz;
import defpackage.rj;

public class LinkPostViewHolder extends BasePostViewHolder {
    static RoundedCornersTransformation a;
    @BindView(2131624115)
    TextView mPostCaption;
    @BindView(2131624412)
    ImageView mPostImageImage;
    @BindView(2131624402)
    View mPostImageRow;
    @BindView(2131624415)
    View mPostInfoImage;
    @BindView(2131624397)
    TextView mPostLinkDesc;
    @BindView(2131624417)
    TextView mPostLinkDescImage;
    @BindView(2131624398)
    TextView mPostLinkDomain;
    @BindView(2131624418)
    TextView mPostLinkDomainImage;
    @BindView(2131624395)
    ImageView mPostLinkImage;
    @BindView(2131624394)
    View mPostLinkPlacehoder;
    @BindView(2131624414)
    View mPostLinkRow;
    @BindView(2131624396)
    TextView mPostLinkTitle;
    @BindView(2131624416)
    TextView mPostLinkTitleImage;

    public LinkPostViewHolder(View itemView, Activity context) {
        super(itemView, context);
        a = new RoundedCornersTransformation((Context) context, (int) (10.0f * context.getResources().getDisplayMetrics().density), 3, CornerType.TOP);
    }

    public LinkPostViewHolder(View itemView, Activity context, String feedType) {
        super(itemView, context, feedType);
        a = new RoundedCornersTransformation((Context) context, (int) (10.0f * context.getResources().getDisplayMetrics().density), 3, CornerType.TOP);
    }

    public static void a(LinkPostViewHolder holder, Post post) {
        String url;
        Context context = holder.f;
        BasePostViewHolder.a((BasePostViewHolder) holder, post);
        jb.a(holder.mPostImageRow, post.icon_color);
        if (post.caption == null || post.caption.isEmpty()) {
            holder.mPostCaption.setVisibility(8);
        } else {
            holder.mPostCaption.setVisibility(0);
        }
        holder.mPostLinkTitle.setText(post.og_title);
        holder.mPostLinkDesc.setText(post.og_desc);
        holder.mPostLinkDomain.setText(post.link_domain);
        final Post post2 = post;
        final LinkPostViewHolder linkPostViewHolder = holder;
        holder.mPostLinkPlacehoder.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String url = post2.link_url;
                if (url == null || url.isEmpty()) {
                    rj.a(new Exception("link url is null or empty"));
                    return;
                }
                Intent intent = new Intent(linkPostViewHolder.f, WebViewActivity.class);
                intent.putExtra("title", post2.og_title);
                intent.putExtra("url", url);
                linkPostViewHolder.f.startActivity(intent);
            }
        });
        final LinkPostViewHolder linkPostViewHolder2 = holder;
        final Post post3 = post;
        holder.mPostLinkRow.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (!(linkPostViewHolder2.f instanceof PostDetailsActivity)) {
                    PostDetailsActivity.startPostDetailsActivity(post3.post_id, linkPostViewHolder2.f, post3.icon_color);
                }
            }
        });
        if (post.thumb_url != null) {
            url = post.thumb_url;
        } else {
            url = post.source_url;
        }
        if (url == null) {
            rj.a(new Exception("thumb_url and source_url are both null"));
            holder.mPostLinkImage.setVisibility(8);
            return;
        }
        if (post.actual_height == -1 && post.actual_width == -1) {
            Display display = ((WindowManager) holder.f.getSystemService("window")).getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int imgWidth = size.x - (((int) (15.0f * (((float) holder.f.getResources().getDisplayMetrics().densityDpi) / 160.0f))) * 2);
            int imgHeight = (int) (((double) imgWidth) * 0.55d);
            post.actual_width = imgWidth;
            post.actual_height = imgHeight;
        }
        holder.mPostLinkImage.setVisibility(0);
        holder.mPostLinkImage.setLayoutParams(new LayoutParams(post.actual_width, post.actual_height));
        linkPostViewHolder2 = holder;
        GossipApplication.c.a(url).a().d().a(a).a(DiskCacheStrategy.c).a(new qz<ImageView, oh>(holder.mPostLinkImage) {
            public /* synthetic */ void onResourceReady(Object obj, qk qkVar) {
                a((oh) obj, qkVar);
            }

            public void a(oh resource, qk<? super oh> qkVar) {
                this.view.setImageDrawable(resource);
                linkPostViewHolder2.mPostImageImage.setImageDrawable(resource);
                linkPostViewHolder2.mPostImageImage.setScaleType(ScaleType.FIT_XY);
            }
        });
    }

    public void a(BasePostViewHolder viewHolder, Post post, int shareType) {
        super.a(viewHolder, post, shareType);
        LinkPostViewHolder holder = (LinkPostViewHolder) viewHolder;
        holder.mPostLinkTitleImage.setText(post.og_title);
        holder.mPostLinkDescImage.setText(post.og_desc);
        holder.mPostLinkDomainImage.setText(post.link_domain);
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(0);
        shape.setColor(jb.a);
        holder.mPostInfoImage.setBackground(shape);
    }
}
