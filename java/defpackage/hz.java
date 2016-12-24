package defpackage;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

/* compiled from: MessagesActiveFragment */
public class hz extends hy {
    private View f;
    private View g;
    private RecyclerView h;
    private hl i;
    private SwipeRefreshLayout j;

    public void b(String page) {
        Map<String, String> params = new HashMap();
        params.put("thread_page", page);
        params.put("include_messages", "1");
        ik.a().p(params).b(Schedulers.io()).a(apv.a()).b(new hz$1(this, page));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f = inflater.inflate(2130968681, container, false);
        this.g = this.f.findViewById(2131624482);
        this.h = (RecyclerView) this.f.findViewById(2131624481);
        LayoutManager layoutManager = new LinearLayoutManager(getContext());
        this.h.setLayoutManager(layoutManager);
        this.i = new hl(getActivity());
        this.h.setAdapter(this.i);
        this.h.addOnScrollListener(new hz$2(this, (LinearLayoutManager) layoutManager, this.i));
        ItemAnimator animator = this.h.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        this.j = (SwipeRefreshLayout) this.f.findViewById(2131624480);
        this.j.setOnRefreshListener(new hz$3(this));
        this.j.post(new hz$4(this));
        return this.f;
    }
}
