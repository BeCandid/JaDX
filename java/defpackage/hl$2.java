package defpackage;

import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.becandid.candid.data.MessageThread;

/* compiled from: MessageThreadsAdapter */
class hl$2 implements OnLongClickListener {
    final /* synthetic */ MessageThread a;
    final /* synthetic */ hl b;

    hl$2(hl this$0, MessageThread messageThread) {
        this.b = this$0;
        this.a = messageThread;
    }

    public boolean onLongClick(View v) {
        PopupMenu popupMenu = new PopupMenu(this.b.d, v);
        popupMenu.getMenuInflater().inflate(2131689479, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new hl$2$1(this));
        return true;
    }
}
