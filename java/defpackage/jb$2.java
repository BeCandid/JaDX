package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.becandid.candid.activities.GroupDetailsActivity;

/* compiled from: ViewUtils */
class jb$2 extends ClickableSpan {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;

    jb$2(Context context, int i, String str) {
        this.a = context;
        this.b = i;
        this.c = str;
    }

    public void onClick(View widget) {
        Intent intent = new Intent(this.a, GroupDetailsActivity.class);
        intent.putExtra("group_id", this.b);
        this.a.startActivity(intent);
    }

    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setColor(Color.parseColor(this.c));
        ds.setUnderlineText(true);
        ds.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
