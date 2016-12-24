package com.becandid.candid.views.viewholders;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.data.User;
import defpackage.io;
import defpackage.jc;

public class MessagesHeaderViewHolder extends jc {
    public static io a;
    @BindView(2131624236)
    RelativeLayout messagesHeaderIconContainer;
    @BindView(2131624556)
    TextView messagesHeaderName;
    @BindView(2131624238)
    TextView messagesHeaderUserIcon;

    public MessagesHeaderViewHolder(View itemView) {
        super(itemView);
        a = io.a();
    }

    public static void a(MessagesHeaderViewHolder holder, User myInfo) {
        int color = Color.parseColor(myInfo.icon_color);
        holder.messagesHeaderUserIcon.setTextColor(color);
        TextView textView = holder.messagesHeaderUserIcon;
        io ioVar = a;
        textView.setTypeface(io.b());
        textView = holder.messagesHeaderUserIcon;
        ioVar = a;
        textView.setText(io.a(myInfo.icon_name));
        int iconWidth = holder.messagesHeaderIconContainer.getWidth();
        if (iconWidth == 0) {
            iconWidth = (int) (holder.messagesHeaderIconContainer.getResources().getDisplayMetrics().density * 30.0f);
        }
        int gradColor = (16777215 & color) | 1073741824;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(gradColor);
        gradientDrawable.setCornerRadius((float) (iconWidth / 2));
        holder.messagesHeaderIconContainer.setBackground(gradientDrawable);
        holder.messagesHeaderName.setText(myInfo.post_name);
        holder.messagesHeaderName.setTextColor(color);
    }
}
