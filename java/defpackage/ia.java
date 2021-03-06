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
import com.becandid.candid.activities.BaseActivity;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

/* compiled from: MessagesRequestsFragment */
public class ia extends hy {
    public void b(String page) {
        Map<String, String> params = new HashMap();
        params.put("request_page", page);
        params.put("include_messages", "1");
        ik.a().p(params).b(Schedulers.io()).a(apv.a()).b(new ia$1(this, page));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.a = inflater.inflate(2130968682, container, false);
        this.b = this.a.findViewById(2131624486);
        this.c = (RecyclerView) this.a.findViewById(2131624485);
        LayoutManager layoutManager = new LinearLayoutManager(getContext());
        this.c.setLayoutManager(layoutManager);
        this.d = new hl((BaseActivity) getActivity());
        this.c.setAdapter(this.d);
        this.c.addOnScrollListener(new ia$2(this, (LinearLayoutManager) layoutManager, this.d));
        ItemAnimator animator = this.c.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        this.e = (SwipeRefreshLayout) this.a.findViewById(2131624484);
        this.e.setOnRefreshListener(new ia$3(this));
        this.e.post(new ia$4(this));
        return this.a;
    }
}
