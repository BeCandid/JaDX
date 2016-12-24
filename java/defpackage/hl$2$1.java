package defpackage;

import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import com.becandid.candid.models.EmptySubscriber;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

/* compiled from: MessageThreadsAdapter */
class hl$2$1 implements OnMenuItemClickListener {
    final /* synthetic */ hl$2 a;

    hl$2$1(hl$2 this$1) {
        this.a = this$1;
    }

    public boolean onMenuItemClick(MenuItem item) {
        Map<String, String> params = new HashMap();
        int postId = this.a.a.post_id;
        String userName = this.a.a.target_user_info.post_name;
        params.put("post_id", Integer.toString(postId));
        params.put("post_name", userName);
        switch (item.getItemId()) {
            case 2131624854:
                if (this.a.a.is_request == 1) {
                    ik.a().s(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                } else {
                    ik.a().u(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                }
                ix.a().a(new in$j(postId, userName));
                return true;
            default:
                return false;
        }
    }
}
