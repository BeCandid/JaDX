package com.becandid.candid.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import com.becandid.candid.activities.GroupBaseSearchActivity.QueryTextInterface;
import defpackage.aij;
import defpackage.ain;
import defpackage.apr;
import defpackage.aps;
import defpackage.apv;
import defpackage.hi;
import defpackage.ik;
import defpackage.in$z;
import defpackage.rj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class LinkSearchActivity extends GroupBaseSearchActivity {
    private List<LinkSearchResult> d;
    private aps e;

    public class LinkSearchResult {
        final /* synthetic */ LinkSearchActivity a;
        public String description;
        public String final_link_url;
        public String host;
        public String source_url;
        public String title;

        LinkSearchResult(LinkSearchActivity this$0) {
            this.a = this$0;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.d = new ArrayList();
        this.mSearchResultRecyclerView.setHasFixedSize(true);
        this.mSearchResultRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mSearchResultRecyclerView.setAdapter(new hi(this.d, this));
        this.mQueryTextInterface = new QueryTextInterface(this) {
            final /* synthetic */ LinkSearchActivity a;

            {
                this.a = this$0;
            }

            public void onQueryTextSubmit(String query) {
                this.a.a(query);
            }

            public void onQueryTextChange(String newText) {
                this.a.a(newText);
            }
        };
        busSubscribe(in$z.class, new apr<in$z>(this) {
            final /* synthetic */ LinkSearchActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
                this.a.finish();
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$z linkSeachChosen) {
                this.a.finish();
            }
        });
    }

    private void a(String query) {
        if (query.length() >= 3) {
            b(query.toString());
            return;
        }
        this.mSearchProgressBar.setVisibility(8);
        this.mSearchResultRecyclerView.setVisibility(0);
    }

    private void b(String query) {
        this.mSearchProgressBar.setVisibility(0);
        this.mSearchResultRecyclerView.setVisibility(8);
        a();
        Map params = new HashMap();
        params.put("query", query);
        if (this.e != null) {
            this.e.unsubscribe();
        }
        this.e = ik.a().k(params).b(Schedulers.io()).a(apv.a()).b(new apr<ain>(this) {
            final /* synthetic */ LinkSearchActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                this.a.mSearchProgressBar.setVisibility(8);
                this.a.mSearchResultRecyclerView.setVisibility(0);
            }

            public void onNext(ain result) {
                if (!this.a.isStopped) {
                    aij results = result.b("links").n();
                    for (int i = 0; i < results.a(); i++) {
                        this.a.a(results.a(i).m());
                    }
                    this.a.mSearchResultRecyclerView.getAdapter().notifyDataSetChanged();
                    this.a.mSearchProgressBar.setVisibility(8);
                    this.a.mSearchResultRecyclerView.setVisibility(0);
                }
            }
        });
    }

    private void a(ain entry) {
        LinkSearchResult result = new LinkSearchResult(this);
        try {
            result.host = entry.b("attribution_host").c();
            result.description = entry.b("description").c();
            result.title = entry.b("title").c();
            result.source_url = entry.b("source_url").c();
            result.final_link_url = entry.b("final_link_url").c();
            this.d.add(result);
        } catch (Exception e) {
        }
    }

    private void a() {
        this.d.clear();
        this.mSearchResultRecyclerView.getAdapter().notifyDataSetChanged();
    }
}
