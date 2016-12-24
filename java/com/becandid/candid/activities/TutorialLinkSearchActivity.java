package com.becandid.candid.activities;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;

public class TutorialLinkSearchActivity extends BaseActivity {
    @BindView(2131624301)
    Button mContinue;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968632);
        ButterKnife.bind(this);
        this.mContinue.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TutorialLinkSearchActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                AppState.hasLinkSearched = true;
                AppState.saveState(GossipApplication.a());
                this.a.finish();
            }
        });
    }

    public void onBackPressed() {
    }
}
