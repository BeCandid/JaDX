package defpackage;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.data.Message;
import rx.schedulers.Schedulers;

/* compiled from: MessageViewHolder */
class jh$4 implements OnClickListener {
    final /* synthetic */ jh a;
    final /* synthetic */ Message b;
    final /* synthetic */ Context c;
    final /* synthetic */ hm d;

    jh$4(jh jhVar, Message message, Context context, hm hmVar) {
        this.a = jhVar;
        this.b = message;
        this.c = context;
        this.d = hmVar;
    }

    public void onClick(View v) {
        this.a.g.setEnabled(false);
        this.a.i.setEnabled(false);
        this.a.h.setEnabled(false);
        if (this.b.params != null) {
            ik.a().o(this.b.params).b(Schedulers.io()).a(apv.a()).b(new jh$4$1(this));
        }
    }
}
