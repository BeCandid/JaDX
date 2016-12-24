package defpackage;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.User;

/* compiled from: MessageViewHolder */
class jh$9 implements OnLongClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ Message b;
    final /* synthetic */ User c;

    jh$9(Context context, Message message, User user) {
        this.a = context;
        this.b = message;
        this.c = user;
    }

    public boolean onLongClick(View v) {
        PopupMenu messageMenu = new PopupMenu(this.a, v);
        messageMenu.setOnMenuItemClickListener(jh.b(this.b, this.a, this.c));
        messageMenu.getMenu().add(1, 2131624851, 0, 2131230873);
        messageMenu.getMenu().add(1, 2131624853, 0, 2131230874);
        messageMenu.show();
        return false;
    }
}
