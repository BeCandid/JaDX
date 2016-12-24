package defpackage;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.becandid.candid.data.MessageThread;
import java.util.List;

/* compiled from: BaseMessagesFragment */
public class hy extends Fragment {
    protected View a;
    protected View b;
    protected RecyclerView c;
    protected hl d;
    protected SwipeRefreshLayout e;

    public void a(List<MessageThread> threads) {
        if (this.d != null) {
            this.d.a((List) threads);
        }
        this.e.setRefreshing(false);
    }

    public void a() {
        if (this.d.d()) {
            this.c.setVisibility(0);
            this.b.setVisibility(8);
            return;
        }
        this.c.setVisibility(8);
        this.b.setVisibility(0);
    }

    public void a(String page) {
        if (this.d != null) {
            this.d.a(page);
        }
    }

    public void a(MessageThread thread) {
        if (this.d != null) {
            this.d.a(thread);
            a();
        }
    }

    public boolean a(in$ae message) {
        if (this.d != null) {
            return this.d.a(message);
        }
        return false;
    }

    public MessageThread b() {
        if (this.d != null) {
            return (MessageThread) this.d.b();
        }
        return null;
    }

    public void a(int post_id, String post_name) {
        if (!this.d.f()) {
            for (int i = 0; i < this.d.getItemCount(); i++) {
                MessageThread thread = this.d.b(i);
                if (thread != null) {
                    try {
                        if (thread.post_id == post_id && thread.other_user_post_name.equals(post_name)) {
                            this.d.c(i);
                            return;
                        }
                    } catch (NullPointerException e) {
                        rk.c().a((ru) new ru("Display Messaging Thread").a("Thread", thread.toString()));
                    }
                }
            }
        }
    }
}
