package com.becandid.candid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.fragments.GroupInfoFragment;
import com.becandid.candid.fragments.GroupNameFragment;
import com.becandid.candid.fragments.GroupTagsFragment;
import defpackage.apr;
import defpackage.in$ab;
import defpackage.in$at;
import defpackage.ix;
import defpackage.rj;
import java.util.HashSet;
import java.util.Set;

public class CreateGroupActivity extends BaseActivity {
    private Set<String> b;
    private String c;
    private String d;
    private String e;
    private boolean f = true;
    private boolean g = false;
    private Bundle h;
    @BindView(2131624107)
    FrameLayout mPlaceholder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968606);
        ButterKnife.bind(this);
        this.h = getIntent().getExtras();
        if (this.h == null) {
            this.h = new Bundle();
        }
        setSupportActionBar((Toolbar) findViewById(2131624081));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (this.h.containsKey("edit_group")) {
            ((TextView) findViewById(2131624082)).setText("Edit Group");
        }
        if (this.mPlaceholder != null) {
            if (savedInstanceState == null) {
                GroupNameFragment groupNameFragment = new GroupNameFragment();
                groupNameFragment.setArguments(this.h);
                getSupportFragmentManager().beginTransaction().add(2131624107, groupNameFragment).commit();
            } else {
                return;
            }
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(2130837589);
        ix.a().a(in$at.class, new apr<in$at>(this) {
            final /* synthetic */ CreateGroupActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$at uploadImage) {
                this.a.setGroupSourceUrl(uploadImage.a);
                Fragment fragment = this.a.getSupportFragmentManager().findFragmentById(2131624107);
                if (fragment != null && (fragment instanceof GroupTagsFragment) && ((GroupTagsFragment) fragment).c()) {
                    ((GroupTagsFragment) fragment).b();
                }
            }
        });
        ix.a().a(in$ab.class, new apr<in$ab>(this) {
            final /* synthetic */ CreateGroupActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$ab networkError) {
                Fragment fragment = this.a.getSupportFragmentManager().findFragmentById(2131624107);
                if (fragment == null || !(fragment instanceof GroupTagsFragment)) {
                    this.a.setmGroupPhotoFailedToUpload(true);
                } else {
                    ((GroupTagsFragment) fragment).d();
                }
            }
        });
    }

    public boolean onSupportNavigateUp() {
        getSupportFragmentManager().popBackStack();
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = getSupportFragmentManager().findFragmentById(2131624107);
        if (fragment != null && (fragment instanceof GroupInfoFragment)) {
            setGroupPhotoSkipped(false);
            ((GroupInfoFragment) fragment).a();
        }
    }

    public void onPhotoChosen(String url, int width, int height) {
        super.onPhotoChosen(url, width, height);
        Fragment fragment = getSupportFragmentManager().findFragmentById(2131624107);
        if (fragment != null && (fragment instanceof GroupInfoFragment)) {
            setGroupPhotoSkipped(false);
            ((GroupInfoFragment) fragment).a();
            setGroupSourceUrl(url);
        }
    }

    public boolean addTag(String tag) {
        if (this.b == null) {
            this.b = new HashSet();
        }
        if (this.b.contains(tag.toLowerCase())) {
            this.b.remove(tag.toLowerCase());
            return true;
        } else if (this.b.size() >= 3) {
            return false;
        } else {
            this.b.add(tag);
            return true;
        }
    }

    public boolean isTagsEmpty() {
        return this.b.size() == 0;
    }

    public void resetTags() {
        if (this.b != null) {
            this.b.clear();
        }
    }

    public void setGroupName(String mGroupName) {
        this.c = mGroupName;
    }

    public void setGroupAbout(String mGroupAbout) {
        this.d = mGroupAbout;
    }

    public void setGroupSourceUrl(String mGroupSourceUrl) {
        this.e = mGroupSourceUrl;
    }

    public void setGroupPhotoSkipped(boolean skipped) {
        this.f = skipped;
    }

    public boolean isGroupPhotoSkipped() {
        return this.f;
    }

    public String getmGroupName() {
        return this.c;
    }

    public String getmGroupAbout() {
        return this.d;
    }

    public String getmGroupSourceUrl() {
        return this.e;
    }

    public boolean ismGroupPhotoFailedToUpload() {
        return this.g;
    }

    public void setmGroupPhotoFailedToUpload(boolean mGroupPhotoFailedToUpload) {
        this.g = mGroupPhotoFailedToUpload;
    }

    public String getGroupTags() {
        StringBuilder sb = new StringBuilder();
        for (String append : this.b) {
            sb.append(append);
            sb.append(',');
        }
        return sb.toString();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
                    return false;
                }
                setResult(0);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onResume() {
        super.onResume();
    }
}
