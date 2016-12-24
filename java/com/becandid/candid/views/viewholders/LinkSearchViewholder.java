package com.becandid.candid.views.viewholders;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LinkSearchViewholder extends ViewHolder {
    @BindView(2131624518)
    public TextView linkDesc;
    @BindView(2131624519)
    public TextView linkHost;
    @BindView(2131624515)
    public ImageView linkImage;
    @BindView(2131624516)
    public ImageView linkSearchResultIcon;
    @BindView(2131624517)
    public TextView linkTitle;

    public LinkSearchViewholder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
