package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import rx.schedulers.Schedulers;

/* compiled from: MeActivityFragment */
public class hu extends Fragment {
    private View a;
    private RecyclerView b;
    private hb c;
    private SwipeRefreshLayout d;
    private View e;
    private aps f;
    private long g;

    private aps b(boolean markRead) {
        this.g = System.currentTimeMillis();
        return ik.a().b(Boolean.toString(markRead), null).b(Schedulers.io()).a(apv.a()).b(new hu$1(this));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.a = inflater.inflate(2130968677, container, false);
        this.e = this.a.findViewById(2131624298);
        this.d = (SwipeRefreshLayout) this.a.findViewById(2131624296);
        this.d.setOnRefreshListener(new hu$2(this));
        this.b = (RecyclerView) this.a.findViewById(2131624297);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        this.b.setLayoutManager(llm);
        this.c = new hb(getContext());
        this.b.setAdapter(this.c);
        this.b.addOnItemTouchListener(new hu$3(this, getContext()));
        this.b.addOnScrollListener(new hu$4(this, llm, this.c));
        return this.a;
    }

    public void onResume() {
        super.onResume();
        this.f = b(false);
        aou.a(getContext());
    }

    public void a(boolean markRead) {
        this.b.scrollToPosition(0);
        this.f = b(markRead);
    }
}
