package defpackage;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;

/* compiled from: PagingScrollListener */
public abstract class hn extends OnScrollListener {
    public static final int BACKWARDS = 1;
    public static final int FORWARD = 0;
    private int a = 10;
    private int b = 0;
    private boolean c = true;
    private int d = 0;
    private LinearLayoutManager e;
    private StaggeredGridLayoutManager f;
    private hd g;

    public abstract void onLoadMore(String str);

    public hn(LinearLayoutManager layoutManager, hd adapter) {
        this.g = adapter;
        this.e = layoutManager;
    }

    public hn(LinearLayoutManager layoutManager, hd adapter, int direction) {
        this.g = adapter;
        this.e = layoutManager;
        this.d = direction;
    }

    public hn(LinearLayoutManager layoutManager, hd adapter, int direction, int visibleThreshold) {
        this.g = adapter;
        this.e = layoutManager;
        this.d = direction;
        this.a = visibleThreshold;
    }

    public hn(StaggeredGridLayoutManager layoutManager, hd adapter) {
        this.g = adapter;
        this.f = layoutManager;
    }

    public void onScrolled(RecyclerView view, int dx, int dy) {
        int totalItemCount;
        int visibleItemCount = view.getChildCount();
        if (this.e != null) {
            totalItemCount = this.e.getItemCount();
        } else {
            totalItemCount = this.f.getItemCount();
        }
        if (totalItemCount < this.b) {
            this.b = 0;
            if (totalItemCount == 0) {
                this.c = true;
            }
        }
        if (this.c && totalItemCount > this.b) {
            this.c = false;
            this.b = totalItemCount;
        }
        if (this.e != null) {
            int firstVisibleItem = this.e.findFirstVisibleItemPosition();
            switch (this.d) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    if (!this.c && totalItemCount - visibleItemCount <= this.a + firstVisibleItem) {
                        onLoadMore(this.g.a());
                        this.c = true;
                        return;
                    }
                    return;
                case BACKWARDS /*1*/:
                    if (!this.c && firstVisibleItem - this.a <= 2) {
                        onLoadMore(this.g.a());
                        this.c = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        int[] firstVisibleItems = this.f.findFirstVisibleItemPositions(null);
        int min = Math.min(firstVisibleItems[0], firstVisibleItems[BACKWARDS]);
        if (!this.c && totalItemCount - visibleItemCount <= this.a + min) {
            onLoadMore(this.g.a());
            this.c = true;
        }
    }
}
