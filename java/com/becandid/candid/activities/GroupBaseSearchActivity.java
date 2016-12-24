package com.becandid.candid.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import defpackage.ej;
import defpackage.ej$e;

public class GroupBaseSearchActivity extends BaseActivity {
    SearchView b;
    MenuItem c;
    public QueryTextInterface mQueryTextInterface;
    @BindView(2131624165)
    View mSearchEmpty;
    @BindView(2131624167)
    View mSearchProgressBar;
    @BindView(2131624164)
    RecyclerView mSearchResultRecyclerView;

    public interface QueryTextInterface {
        void onQueryTextChange(String str);

        void onQueryTextSubmit(String str);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968610);
        ButterKnife.bind(this);
        setSupportActionBar((Toolbar) findViewById(2131624081));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131689476, menu);
        this.c = menu.findItem(2131624844);
        this.b = (SearchView) ej.a(this.c);
        this.c.expandActionView();
        this.b.requestFocus();
        this.b.setQueryHint("Search ...");
        this.b.setOnQueryTextListener(new OnQueryTextListener(this) {
            final /* synthetic */ GroupBaseSearchActivity a;

            {
                this.a = this$0;
            }

            public boolean onQueryTextSubmit(String query) {
                if (this.a.mQueryTextInterface != null) {
                    this.a.mQueryTextInterface.onQueryTextSubmit(query);
                }
                this.a.b.clearFocus();
                return true;
            }

            public boolean onQueryTextChange(String newText) {
                if (this.a.mQueryTextInterface != null) {
                    this.a.mQueryTextInterface.onQueryTextChange(newText);
                }
                return false;
            }
        });
        ej.a(this.c, new ej$e(this) {
            final /* synthetic */ GroupBaseSearchActivity a;

            {
                this.a = this$0;
            }

            public boolean onMenuItemActionExpand(MenuItem item) {
                return false;
            }

            public boolean onMenuItemActionCollapse(MenuItem item) {
                this.a.finish();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void onBackPressed() {
        if (this.b == null || this.c == null || this.c.isActionViewExpanded()) {
            super.onBackPressed();
        } else {
            finish();
        }
    }
}
