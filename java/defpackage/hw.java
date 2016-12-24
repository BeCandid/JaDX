package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.activities.BaseActivity;
import rx.schedulers.Schedulers;

/* compiled from: MeHistoryFragment */
public class hw extends Fragment implements hf$a {
    private View a;
    private RecyclerView b;
    private hf c;
    private View d;
    private SwipeRefreshLayout e;
    private aps f;

    public aps a() {
        this.c.c();
        return ik.a().g(0).b(Schedulers.io()).a(apv.a()).b(new hw$1(this));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.a = inflater.inflate(2130968679, container, false);
        this.d = this.a.findViewById(2131624476);
        this.b = (RecyclerView) this.a.findViewById(2131624475);
        this.b.setLayoutManager(new LinearLayoutManager(getContext()));
        this.c = new hf((BaseActivity) getActivity(), null);
        this.c.a((hf$a) this);
        this.b.setAdapter(this.c);
        ItemAnimator animator = this.b.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        this.e = (SwipeRefreshLayout) this.a.findViewById(2131624474);
        this.e.setOnRefreshListener(new hw$2(this));
        this.f = a();
        return this.a;
    }

    public void b() {
        this.f = a();
    }

    public void onLoadMore(String lastDataId) {
        if (lastDataId != null) {
            ik.a().g(Integer.parseInt(lastDataId)).b(Schedulers.io()).a(apv.a()).b(new hw$3(this));
        }
    }

    public void onErrorRetry(String lastDataId) {
        onLoadMore(lastDataId);
    }
}
