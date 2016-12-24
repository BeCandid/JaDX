package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.data.Post;
import defpackage.ih;
import defpackage.jb;

public class TextPostViewHolder extends BasePostViewHolder {
    @BindView(2131624115)
    TextView mPostCaption;
    @BindView(2131624420)
    LinearLayout mPostCaptionPlaceholder;
    @BindView(2131624411)
    TextView mPostImageCaption;
    @BindView(2131624795)
    TextView mPostImageGroup;
    @BindView(2131624408)
    View mPostShareImage;
    @BindView(2131624419)
    View mPostTextRow;

    public TextPostViewHolder(View itemView, Activity context) {
        super(itemView, context);
    }

    public TextPostViewHolder(View itemView, Activity context, String feedType) {
        super(itemView, context, feedType);
    }

    public void a(BasePostViewHolder holder, Post post, int shareType) {
        super.a(holder, post, shareType);
        this.mPostShareImage.setVisibility(4);
        GradientDrawable shape = new GradientDrawable();
        if (post.icon_color != null) {
            shape.setColor(Color.parseColor(post.icon_color));
        }
        this.mPostShareImage.setBackground(shape);
        this.mPostImageCaption.setTypeface(ih.a(holder.f).a("JosefinSans-SemiBold.ttf"));
    }

    public static void a(TextPostViewHolder holder, Post post) {
        BasePostViewHolder.a((BasePostViewHolder) holder, post);
        jb.a(holder.mPostTextRow, post.icon_color);
        holder.mPostCaption.setTypeface(ih.a(holder.f).a("JosefinSans-SemiBold.ttf"));
    }
}
