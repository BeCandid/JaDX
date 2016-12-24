package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.util.RoundedCornersTransformation;

/* compiled from: MessageThreadsAdapter */
public class hl extends hd<MessageThread> {
    private Context d;
    private io e = io.a();

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((jc) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return b(viewGroup, i);
    }

    public hl(Context context) {
        this.d = context;
    }

    public jc b(ViewGroup parent, int viewType) {
        return new jg(LayoutInflater.from(parent.getContext()).inflate(2130968700, parent, false));
    }

    public void a(jc holder, int position) {
        jg threadHolder = (jg) holder;
        MessageThread thread = (MessageThread) this.a.get(position);
        threadHolder.a.setOnClickListener(new hl$1(this, thread, holder));
        threadHolder.a.setOnLongClickListener(new hl$2(this, thread));
        int color = this.d.getResources().getColor(2131558476);
        try {
            color = Color.parseColor(thread.target_user_info.icon_color);
        } catch (NullPointerException e) {
            rk.c().a((ru) new ru("Display Messaging Thread").a("Thread", thread.toString()));
        }
        if (AppState.config.getInt("enable_nickname", 1) != 1 || thread.target_user_info.nickname == null || thread.target_user_info.nickname.equals("")) {
            threadHolder.g.setText(thread.target_user_info.post_name);
            TextView textView = threadHolder.b;
            io ioVar = this.e;
            textView.setTypeface(io.b());
            threadHolder.b.setTextSize(40.0f);
            textView = threadHolder.b;
            ioVar = this.e;
            textView.setText(io.a(thread.target_user_info.icon_name));
        } else {
            threadHolder.g.setText(thread.target_user_info.nickname);
            threadHolder.b.setTypeface(Typeface.DEFAULT_BOLD);
            threadHolder.b.setTextSize(28.0f);
            threadHolder.b.setText(thread.target_user_info.nickname.substring(0, 1));
        }
        threadHolder.g.setTextColor(color);
        threadHolder.b.setTextColor(color);
        int iconWidth = threadHolder.c.getWidth();
        if (iconWidth == 0) {
            iconWidth = jb.a(60, this.d);
        }
        int gradColor = (16777215 & color) | 1073741824;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(gradColor);
        gradientDrawable.setCornerRadius((float) (iconWidth / 2));
        threadHolder.c.setBackground(gradientDrawable);
        if (thread.online == 1) {
            threadHolder.d.setVisibility(0);
        } else {
            threadHolder.d.setVisibility(8);
        }
        threadHolder.h.setText(((Message) thread.messages.get(0)).subject);
        threadHolder.i.setText(ip.a(thread.sent_time));
        if (thread.post == null) {
            threadHolder.l.setVisibility(8);
            threadHolder.k.setVisibility(8);
            threadHolder.m.setVisibility(0);
            threadHolder.j.setBackground(this.d.getResources().getDrawable(2130838061));
            ((GradientDrawable) threadHolder.j.getBackground()).setColor(Color.parseColor("#DDDDDD"));
        } else if (thread.post.thumb_url != null) {
            threadHolder.j.setBackground(null);
            threadHolder.k.setVisibility(8);
            threadHolder.m.setVisibility(8);
            threadHolder.l.setVisibility(0);
            GossipApplication.c.a(thread.post.thumb_url).d().a(new RoundedCornersTransformation(this.d, jb.a(4, this.d), 0)).a(threadHolder.l);
        } else {
            threadHolder.l.setVisibility(8);
            threadHolder.m.setVisibility(8);
            threadHolder.k.setVisibility(0);
            threadHolder.k.setTypeface(ih.a(this.d).a("JosefinSans-SemiBold.ttf"));
            threadHolder.j.setBackground(this.d.getResources().getDrawable(2130838061));
            ((GradientDrawable) threadHolder.j.getBackground()).setColor(Color.parseColor(thread.post.icon_color));
            if (thread.post.caption != null) {
                threadHolder.k.setText(thread.post.caption);
            } else if (thread.post.og_title != null) {
                threadHolder.k.setText(thread.post.og_title);
            }
        }
        if (thread.unread_messages > 0) {
            threadHolder.a.setBackgroundColor((this.d.getResources().getColor(2131558476) & 16777215) | 268435456);
        } else {
            threadHolder.a.setBackground(this.d.getResources().getDrawable(2130838062));
        }
    }

    public MessageThread b(int position) {
        return (MessageThread) this.a.get(position);
    }

    public void a(MessageThread thread) {
        if (this.a != null) {
            this.a.add(0, thread);
            notifyItemInserted(0);
        }
    }

    public boolean a(in$ae message) {
        if (this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                MessageThread thread = (MessageThread) this.a.get(i);
                if (thread.post_id == message.b && thread.target_user_info.post_name.equals(message.d)) {
                    ((Message) thread.messages.get(0)).message = message.c;
                    ((Message) thread.messages.get(0)).subject = message.c;
                    ((Message) thread.messages.get(0)).sent_time = System.currentTimeMillis();
                    thread.unread_messages++;
                    notifyItemChanged(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean f() {
        return this.a.isEmpty();
    }

    public void c(int i) {
        this.a.remove(i);
        notifyItemRemoved(i);
    }
}
