package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.models.EmptySubscriber;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

/* compiled from: MessageViewHolder */
class jh$2$2 implements OnClickListener {
    final /* synthetic */ int[] a;
    final /* synthetic */ String[] b;
    final /* synthetic */ jh$2 c;

    jh$2$2(jh$2 this$0, int[] iArr, String[] strArr) {
        this.c = this$0;
        this.a = iArr;
        this.b = strArr;
    }

    public void onClick(DialogInterface dialog, int which) {
        if (this.a[0] >= 0) {
            Map<String, String> params = new HashMap();
            params.put("message_id", Integer.toString(this.c.a.message_id));
            params.put("reason", this.b[this.a[0]]);
            ik.a().q(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
            params = new HashMap();
            params.put("post_id", Integer.toString(this.c.a.post_id));
            params.put("post_name", this.c.c.post_name);
            ik.a().s(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
            ix.a().a(new in$j(this.c.a.post_id, this.c.c.post_name));
            ((BaseActivity) this.c.b).finish();
        }
    }
}
