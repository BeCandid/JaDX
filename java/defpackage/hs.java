package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.becandid.candid.data.AppState;
import rx.schedulers.Schedulers;

/* compiled from: FeedFragment */
public class hs extends Fragment implements hf$a {
    private View a;
    private hf b;
    private String c;
    private aps d;
    private RecyclerView e;
    private SwipeRefreshLayout f;
    private View g;
    private Handler h;
    private final int i = 60000;
    private long j;
    private Runnable k = new hs$7(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args.containsKey("feed_type")) {
            this.c = args.getString("feed_type");
        }
        this.h = new Handler(Looper.getMainLooper());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.a = inflater.inflate(2130968669, container, false);
        this.g = this.a.findViewById(uu$d.progress_bar);
        this.e = (RecyclerView) this.a.findViewById(2131624425);
        this.e.setLayoutManager(new LinearLayoutManager(getContext()));
        this.b = new hf((BaseActivity) getContext(), this.c);
        this.b.a((hf$a) this);
        this.e.setAdapter(this.b);
        ItemAnimator animator = this.e.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        this.f = (SwipeRefreshLayout) this.a.findViewById(2131624169);
        this.f.setOnRefreshListener(new hs$1(this));
        this.d = a(this.c, 0);
        ((BaseActivity) getActivity()).addToSubscriptionList(this.d);
        ((BaseActivity) getActivity()).addToSubscriptionList(ix.a().a(in$k.class, new hs$2(this)));
        ((BaseActivity) getActivity()).addToSubscriptionList(ix.a().a(in$p.class, new hs$3(this)));
        ((BaseActivity) getActivity()).addToSubscriptionList(ix.a().a(in$n.class, new hs$4(this)));
        ((BaseActivity) getActivity()).addToSubscriptionList(ix.a().a(in$o.class, new hs$5(this)));
        ((BaseActivity) getActivity()).addToSubscriptionList(ix.a().a(in$ah.class, new hs$6(this)));
        return this.a;
    }

    public void a() {
        this.h.postDelayed(this.k, 60000);
        if (AppState.account != null && AppState.account.unread_feed_count > 0) {
            this.d = a(this.c, 0);
        }
    }

    private apr b() {
        return new hs$8(this);
    }

    private aps a(String feedType, int relatedPostsPostId) {
        if (this.b != null) {
            return ik.a().a(feedType, null, this.b.b(feedType), relatedPostsPostId).b(Schedulers.io()).a(apv.a()).b(b());
        }
        rj.a(new Exception("Feed Adapter is NULL"));
        return null;
    }

    public void a(int relatedPostsPostId) {
        AppState.expandedPostIds.clear();
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        if (this.g != null) {
            this.g.setVisibility(0);
        }
        if (this.d != null) {
            this.d.unsubscribe();
        }
        this.d = a(this.c, relatedPostsPostId);
    }

    private void a(in$k didCreatePost) {
        try {
            this.b.b(didCreatePost.a);
            this.e.smoothScrollToPosition(0);
        } catch (Throwable e) {
            rj.a(e);
        }
    }

    public void b(int upsellId) {
        this.b.b(upsellId);
    }

    public void onResume() {
        super.onResume();
        if (this.j == 0 || (System.currentTimeMillis() - this.j) / 60000 <= ((long) AppState.config.getInt("refresh_timeout", 5))) {
            a();
        } else {
            a(0);
        }
    }

    public void onPause() {
        super.onPause();
        this.h.removeCallbacks(this.k);
        this.j = System.currentTimeMillis();
    }

    public void onLoadMore(String lastDataId) {
        if (lastDataId != null) {
            ik.a().a(this.c, lastDataId, this.b.b(this.c), 0).b(Schedulers.io()).a(apv.a()).b(new hs$9(this));
        }
    }

    public void onErrorRetry(String lastDataId) {
        onLoadMore(lastDataId);
    }
}
