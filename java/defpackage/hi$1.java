package defpackage;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.activities.LinkSearchActivity.LinkSearchResult;
import com.becandid.candid.activities.WebViewActivity;

/* compiled from: LinkSearchAdapter */
class hi$1 implements OnClickListener {
    final /* synthetic */ LinkSearchResult a;
    final /* synthetic */ hi b;

    hi$1(hi this$0, LinkSearchResult linkSearchResult) {
        this.b = this$0;
        this.a = linkSearchResult;
    }

    public void onClick(View v) {
        Intent intent = new Intent(this.b.c, WebViewActivity.class);
        intent.putExtra("title", "Web Result");
        intent.putExtra("url", this.a.final_link_url);
        intent.putExtra("show_copy_link", true);
        this.b.c.startActivity(intent);
    }
}
