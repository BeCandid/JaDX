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
import com.becandid.candid.data.Post;
import rx.schedulers.Schedulers;

/* compiled from: MePostsFragment */
public class hx extends Fragment implements hf$a {
    private View a;
    private RecyclerView b;
    private hf c;
    private View d;
    private SwipeRefreshLayout e;
    private aps f;

    public aps a() {
        this.c.c();
        return ik.a().h(0).b(Schedulers.io()).a(apv.a()).b(new hx$1(this));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.a = inflater.inflate(2130968680, container, false);
        this.d = this.a.findViewById(2131624185);
        this.b = (RecyclerView) this.a.findViewById(2131624478);
        this.b.setLayoutManager(new LinearLayoutManager(getContext()));
        this.c = new hf((BaseActivity) getActivity(), null);
        this.c.a((hf$a) this);
        this.b.setAdapter(this.c);
        ItemAnimator animator = this.b.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        this.e = (SwipeRefreshLayout) this.a.findViewById(2131624169);
        this.e.setOnRefreshListener(new hx$2(this));
        this.f = a();
        return this.a;
    }

    public void b() {
        this.f = a();
    }

    public void a(Post post) {
        if (this.c != null) {
            this.c.b(post);
            this.d.setVisibility(8);
        }
    }

    public void a(int postId) {
        if (this.c != null) {
            this.c.b(postId);
            if (this.c.getItemCount() <= 0) {
                this.d.setVisibility(0);
            }
        }
    }

    public void onLoadMore(String lastDataId) {
        if (lastDataId != null) {
            ik.a().h(Integer.parseInt(lastDataId)).b(Schedulers.io()).a(apv.a()).b(new hx$3(this));
        }
    }

    public void onErrorRetry(String lastDataId) {
        onLoadMore(lastDataId);
    }
}
