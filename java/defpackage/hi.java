package defpackage;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.LinkSearchActivity.LinkSearchResult;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.becandid.candid.util.RoundedCornersTransformation.CornerType;
import com.becandid.candid.views.viewholders.LinkSearchViewholder;
import java.util.List;

/* compiled from: LinkSearchAdapter */
public class hi extends Adapter<LinkSearchViewholder> {
    private List<LinkSearchResult> a;
    private RoundedCornersTransformation b;
    private Activity c;

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((LinkSearchViewholder) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public hi(List<LinkSearchResult> linkSearchResults, Activity context) {
        this.a = linkSearchResults;
        this.c = context;
        this.b = new RoundedCornersTransformation((Context) context, (int) (10.0f * context.getResources().getDisplayMetrics().density), 0, CornerType.ALL);
    }

    public LinkSearchViewholder a(ViewGroup parent, int viewType) {
        return new LinkSearchViewholder(LayoutInflater.from(parent.getContext()).inflate(2130968692, parent, false));
    }

    public void a(LinkSearchViewholder holder, int position) {
        LinkSearchResult currLink = (LinkSearchResult) this.a.get(position);
        holder.linkTitle.setText(currLink.title);
        holder.linkDesc.setText(currLink.description);
        holder.linkHost.setText(currLink.host);
        GossipApplication.c.a(currLink.source_url).a().a(17301613).a(this.b).a(holder.linkImage);
        holder.itemView.setOnClickListener(new hi$1(this, currLink));
        holder.linkSearchResultIcon.setOnClickListener(new hi$2(this, currLink));
    }

    public int getItemCount() {
        return this.a.size();
    }
}
