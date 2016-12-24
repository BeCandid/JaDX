package com.becandid.candid.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.data.Post;
import defpackage.aih;
import defpackage.aju;
import defpackage.hf;
import java.lang.reflect.Type;
import java.util.List;

public class RelatedPostsFeedActivity extends BaseActivity {
    private List<Post> b;
    private hf c;
    @BindView(2131624284)
    RecyclerView feedRecycler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968628);
        ButterKnife.bind(this);
        if (!getIntent().hasExtra("related_posts")) {
            finish();
        }
        Type type = new aju<List<Post>>(this) {
            final /* synthetic */ RelatedPostsFeedActivity a;

            {
                this.a = this$0;
            }
        }.getType();
        this.b = (List) new aih().a(getIntent().getStringExtra("related_posts"), type);
        for (Post post : this.b) {
            post.related_to_post = 0;
        }
        this.c = new hf(this, null);
        this.feedRecycler.setAdapter(this.c);
        this.feedRecycler.setLayoutManager(new LinearLayoutManager(this));
        this.c.a(this.b);
    }
}
