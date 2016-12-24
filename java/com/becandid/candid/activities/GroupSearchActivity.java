package com.becandid.candid.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.becandid.candid.activities.GroupBaseSearchActivity.QueryTextInterface;
import com.becandid.candid.data.AppState;
import defpackage.aij;
import defpackage.ain;
import defpackage.apr;
import defpackage.aps;
import defpackage.apv;
import defpackage.hh;
import defpackage.ik;
import defpackage.iv;
import defpackage.rj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class GroupSearchActivity extends GroupBaseSearchActivity {
    private List<GroupSearchResult> d;
    private aps e;

    public class GroupSearchResult {
        final /* synthetic */ GroupSearchActivity a;
        public String firstTag;
        public int groupId;
        public String groupName;
        public String thumbUrl;

        GroupSearchResult(GroupSearchActivity this$0) {
            this.a = this$0;
        }

        public String toString() {
            return "groupName: " + this.groupName + ", groupId: " + Integer.toString(this.groupId);
        }
    }

    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        this.d = new ArrayList();
        this.mSearchResultRecyclerView.setHasFixedSize(true);
        this.mSearchResultRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mSearchResultRecyclerView.addOnItemTouchListener(new iv(this, this) {
            final /* synthetic */ GroupSearchActivity a;

            public void onItemClick(View v, int position) {
                try {
                    this.a.startActivity(GroupDetailsActivity.startGroupDetailsActivity(this.a.getBaseContext(), ((GroupSearchResult) this.a.d.get(position)).groupId));
                } catch (Throwable e) {
                    rj.a(e);
                }
            }
        });
        this.mSearchResultRecyclerView.setAdapter(new hh(this.d, this));
        this.mQueryTextInterface = new QueryTextInterface(this) {
            final /* synthetic */ GroupSearchActivity a;

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
    }

    private void a(String query) {
        if (query.length() >= 3) {
            b(query.toString());
            return;
        }
        this.mSearchProgressBar.setVisibility(8);
        this.mSearchResultRecyclerView.setVisibility(0);
    }

    private void b(String searchQuery) {
        this.mSearchProgressBar.setVisibility(0);
        this.mSearchResultRecyclerView.setVisibility(8);
        a();
        Map params = new HashMap();
        params.put("query", searchQuery);
        if (AppState.location != null) {
            params.put("location", AppState.location.getLatitude() + "," + AppState.location.getLongitude() + "@" + (AppState.location.hasAccuracy() ? Float.valueOf(AppState.location.getAccuracy()) : "50"));
        }
        a(params);
    }

    private void a(Map<String, String> params) {
        if (this.e != null) {
            this.e.unsubscribe();
        }
        this.e = ik.a().j((Map) params).b(Schedulers.io()).a(apv.a()).b(new apr<ain>(this) {
            final /* synthetic */ GroupSearchActivity a;

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
                    aij results = result.b("groups").n();
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
        GroupSearchResult result = new GroupSearchResult(this);
        try {
            result.groupName = entry.b("group_name").c();
            result.groupId = entry.b("group_id").g();
            result.firstTag = entry.b("first_tag").c();
            result.thumbUrl = entry.b("thumb_url").c();
            this.d.add(result);
        } catch (Exception e) {
        }
    }

    private void a() {
        this.d.clear();
        this.mSearchResultRecyclerView.getAdapter().notifyDataSetChanged();
    }
}
