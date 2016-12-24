package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.User;

/* compiled from: MessageViewHolder */
class jh$2 implements OnMenuItemClickListener {
    final /* synthetic */ Message a;
    final /* synthetic */ Context b;
    final /* synthetic */ User c;

    jh$2(Message message, Context context, User user) {
        this.a = message;
        this.b = context;
        this.c = user;
    }

    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case 2131624851:
                ((ClipboardManager) this.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Candid Message", this.a.message));
                break;
            case 2131624852:
                GossipApplication.c.a(this.a.source_url).j().a(new jh$2$1(this));
                break;
            case 2131624853:
                int[] reasonPos = new int[]{-1};
                String[] chars = new String[]{this.b.getString(2131230893), this.b.getString(2131230928), this.b.getString(2131230855)};
                String[] reportString = new String[]{"nsfw", "spam", "hate"};
                Builder builder = new Builder(this.b);
                builder.setTitle(this.b.getString(2131230951)).setSingleChoiceItems(chars, -1, new jh$2$3(this, reasonPos)).setPositiveButton(2131230895, new jh$2$2(this, reasonPos, reportString)).setNegativeButton("Cancel", null);
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new jh$2$4(this, reasonPos));
                dialog.show();
                return true;
        }
        return false;
    }
}
