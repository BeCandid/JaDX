package defpackage;

import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.activities.LinkSearchActivity.LinkSearchResult;

/* compiled from: LinkSearchAdapter */
class hi$2 implements OnClickListener {
    final /* synthetic */ LinkSearchResult a;
    final /* synthetic */ hi b;

    hi$2(hi this$0, LinkSearchResult linkSearchResult) {
        this.b = this$0;
        this.a = linkSearchResult;
    }

    public void onClick(View v) {
        ix.a().a(new in$z(this.a.final_link_url));
        this.b.c.finish();
    }
}
