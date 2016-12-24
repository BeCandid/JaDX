package defpackage;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.models.EmptySubscriber;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

/* compiled from: MessageThreadsAdapter */
class hl$1 implements OnClickListener {
    final /* synthetic */ MessageThread a;
    final /* synthetic */ jc b;
    final /* synthetic */ hl c;

    hl$1(hl this$0, MessageThread messageThread, jc jcVar) {
        this.c = this$0;
        this.a = messageThread;
        this.b = jcVar;
    }

    public void onClick(View v) {
        Intent intent = new Intent(this.c.d, MessageActivity.class);
        intent.putExtra("post_id", Integer.toString(this.a.post_id));
        if (this.a.target_user_info.post_name != null) {
            intent.putExtra("user_name", this.a.target_user_info.post_name);
        }
        this.c.d.startActivity(intent);
        Map<String, String> params = new HashMap();
        params.put("post_id", Integer.toString(this.a.post_id));
        if (this.a.target_user_info.post_name != null) {
            params.put("post_name", this.a.target_user_info.post_name);
        }
        ik.a().w(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        int adapterPos = this.b.getAdapterPosition();
        if (adapterPos != -1) {
            ((MessageThread) this.c.a.get(adapterPos)).unread_messages = 0;
            this.c.notifyItemChanged(adapterPos);
        }
    }
}
