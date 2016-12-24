package com.becandid.candid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;
import com.becandid.candid.activities.GroupBaseSearchActivity.QueryTextInterface;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.Group;
import defpackage.ho;
import defpackage.iv;
import java.util.ArrayList;
import java.util.List;

public class GroupMeSearchActivity extends GroupBaseSearchActivity {
    private ho d;
    private List<Group> e = new ArrayList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.e = (List) getIntent().getExtras().getSerializable("groups");
        this.mSearchResultRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        this.d = new ho(this);
        this.mSearchResultRecyclerView.setAdapter(this.d);
        this.mSearchResultRecyclerView.addOnItemTouchListener(new iv(this, getBaseContext()) {
            final /* synthetic */ GroupMeSearchActivity a;

            public void onItemClick(View v, int position) {
                Intent intent = new Intent(v.getContext(), GroupDetailsActivity.class);
                Group group = this.a.d.b(position);
                if (group != null) {
                    intent.putExtra("group_id", group.group_id);
                    intent.putExtra("group_name", group.group_name);
                    intent.putExtra("group_image", group.imageUrl());
                    intent.putExtra("group_json", DataUtil.toJson(group));
                    v.getContext().startActivity(intent);
                }
            }
        });
        this.mQueryTextInterface = new QueryTextInterface(this) {
            final /* synthetic */ GroupMeSearchActivity a;

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

    public ArrayList<Group> groupSearch(String keyword) {
        ArrayList<Group> results = new ArrayList();
        if (this.e == null) {
            Toast.makeText(this, "Unable to find your groups", 1).show();
            finish();
        } else {
            for (Group group : this.e) {
                String groupName = group.group_name.toLowerCase();
                if (groupName.startsWith(keyword.toLowerCase())) {
                    results.add(0, group);
                } else if (groupName.contains(keyword.toLowerCase())) {
                    results.add(group);
                }
            }
        }
        return results;
    }

    private void a(String keyWord) {
        List<Group> newGroup = groupSearch(keyWord);
        this.d.a((List) newGroup);
        if (newGroup.size() == 0) {
            this.mSearchResultRecyclerView.setVisibility(8);
            this.mSearchEmpty.setVisibility(0);
            return;
        }
        this.mSearchResultRecyclerView.setVisibility(0);
        this.mSearchEmpty.setVisibility(8);
    }
}
