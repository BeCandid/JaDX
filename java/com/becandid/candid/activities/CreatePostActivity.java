package com.becandid.candid.activities;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Typeface;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.DataUtil.StringTrimResult;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.TextTag;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.AlwaysOnAutoCompleteView;
import com.venmo.view.TooltipView;
import defpackage.apr;
import defpackage.aps;
import defpackage.apv;
import defpackage.hg;
import defpackage.ik;
import defpackage.in$ah;
import defpackage.in$ak;
import defpackage.in$k;
import defpackage.in$y;
import defpackage.in$z;
import defpackage.ix;
import defpackage.iz;
import defpackage.jb;
import defpackage.qk;
import defpackage.qq;
import defpackage.rj;
import defpackage.uu$h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.exceptions.CompositeException;
import rx.schedulers.Schedulers;

public class CreatePostActivity extends BaseActivity implements OnClickListener {
    public static final int ADD_LINK_REQUEST = 1002;
    public static final int CREATE_GROUP_FOR_POST = 1001;
    public static final int TUTORIAL_LINK_SEARCH = 1004;
    public static final int TUTORIAL_POST = 1003;
    final Runnable b = new Runnable(this) {
        final /* synthetic */ CreatePostActivity a;

        {
            this.a = this$0;
        }

        public void run() {
            this.a.tooltipView.setVisibility(8);
        }
    };
    private String c;
    @BindView(2131624125)
    View camBtn;
    @BindView(2131624113)
    View createGroupButton;
    private boolean d;
    private int e;
    private boolean f = true;
    @BindView(2131624129)
    TextView friendMarker;
    @BindView(2131624128)
    SwitchCompat friendSwitch;
    private Handler g;
    @BindView(2131624110)
    AlwaysOnAutoCompleteView groupNameSelector;
    private String h;
    private hg i;
    private int j;
    private ArrayList<TextTag> k;
    private ListPopupWindow l;
    @BindView(2131624118)
    RelativeLayout linkContainer;
    private hg m;
    @BindView(2131624109)
    View mRootView;
    private CharSequence n = "";
    private int o;
    private int p;
    @BindView(2131624130)
    Button postButton;
    @BindView(2131624115)
    EditText postCaption;
    @BindView(2131624114)
    ScrollView postContent;
    @BindView(2131624117)
    ImageView postPhoto;
    @BindView(2131624131)
    View postSpinny;
    private boolean q;
    private Map<String, String> r;
    private boolean s;
    private aps t;
    @BindView(2131624124)
    TooltipView tooltipView;
    private String u;
    @BindView(2131624127)
    View webSearchBtn;

    public void backNavClick(View backNav) {
        onBackPressed();
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("json", "{\"cancelled\": 1}");
        setResult(0, intent);
        super.onBackPressed();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.e = 0;
        if (f() > 4.5d) {
            setContentView(2130968607);
        } else {
            setContentView(2130968608);
        }
        ButterKnife.bind(this);
        enableKeyboardEvents(this.mRootView);
        this.camBtn.setOnClickListener(this);
        this.webSearchBtn.setOnClickListener(this);
        b();
        this.groupNameSelector.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (parent != null) {
                    this.a.a(this.a.b(((Group) parent.getItemAtPosition(position)).group_name));
                }
            }
        });
        this.groupNameSelector.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void onFocusChange(View v, boolean hasFocus) {
                if (v.getWindowVisibility() == 0) {
                    if (hasFocus) {
                        this.a.groupNameSelector.showDropDown();
                    } else {
                        this.a.groupNameSelector.dismissDropDown();
                    }
                }
            }
        });
        this.groupNameSelector.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.groupNameSelector.showDropDown();
            }
        });
        this.groupNameSelector.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.d("CPA", "group action: " + actionId);
                if (actionId != 5 && (event == null || event.getAction() != 1 || event.getKeyCode() != 66)) {
                    return false;
                }
                Group group = this.a.a(this.a.groupNameSelector.getText().toString());
                if (group == null) {
                    return true;
                }
                this.a.a(group);
                return true;
            }
        });
        this.groupNameSelector.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                String prefix = s.toString();
                if (this.a.i != null) {
                    List<Group> groups = this.a.i.a(prefix);
                    if (groups.size() == 1) {
                        Group group = (Group) groups.get(0);
                        if (group != null) {
                            this.a.a(group);
                        }
                    }
                }
            }
        });
        float oneDp = getResources().getDisplayMetrics().density;
        this.groupNameSelector.setDropDownHeight((int) (140.0f * oneDp));
        this.groupNameSelector.setDropDownVerticalOffset((int) (-11.0f * oneDp));
        if (getIntent().hasExtra("group_name") && getIntent().hasExtra("group_id")) {
            int intentGroupId = getIntent().getIntExtra("group_id", 0);
            try {
                for (Group group : AppState.groups) {
                    if (group.group_id == intentGroupId) {
                        a(group);
                    }
                }
            } catch (NullPointerException e) {
                rj.a(new Exception("groups ARE NULL: " + AppState.groups));
            }
        }
        this.j = AppState.config.getInt("disable_group_tagging", 0);
        this.k = new ArrayList();
        if (AppState.groups == null) {
            AppState.groups = new ArrayList();
        }
        this.m = new hg(this, 2130968690, new ArrayList(AppState.groups));
        this.l = new ListPopupWindow(this);
        this.l.setAdapter(this.m);
        this.l.setAnchorView(this.postCaption);
        this.l.setAnimationStyle(0);
        this.l.setHeight(-2);
        this.l.setWidth(jb.a(150, (Context) this));
        this.l.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Group group = (Group) parent.getItemAtPosition(position);
                String[] tags = this.a.postCaption.getText().toString().split("(?=#)");
                int pos = this.a.postCaption.getSelectionStart();
                int size = 0;
                int spannableEnd = 0;
                CharSequence newText = new SpannableStringBuilder("");
                ArrayList newTags = new ArrayList();
                int indexUpdateSize = 0;
                for (String sub : tags) {
                    int substringStart = size;
                    size += sub.length();
                    if (substringStart >= pos || pos > size) {
                        newText.append(sub);
                    } else {
                        int spannableStart = newText.length();
                        newText.append("#" + group.group_name);
                        indexUpdateSize = (group.group_name.length() + 1) - (pos - spannableStart);
                        spannableEnd = newText.length();
                        newText.append(" ");
                        newText.append(sub.substring(pos - substringStart));
                        newTags.add(new TextTag(spannableStart, spannableEnd, group.group_id));
                    }
                }
                Iterator it = this.a.k.iterator();
                while (it.hasNext()) {
                    TextTag indexes = (TextTag) it.next();
                    if (pos <= indexes.startIndex || pos > indexes.endIndex) {
                        if (indexes.startIndex > pos) {
                            indexes.startIndex += indexUpdateSize;
                            indexes.endIndex += indexUpdateSize;
                        }
                        newTags.add(indexes);
                    }
                }
                this.a.k = newTags;
                it = this.a.k.iterator();
                while (it.hasNext()) {
                    indexes = (TextTag) it.next();
                    if (indexes.startIndex > -1 && indexes.endIndex > -1) {
                        newText.setSpan(jb.a(), indexes.startIndex, indexes.endIndex, 33);
                    }
                }
                this.a.n = newText;
                this.a.postCaption.setText(newText);
                this.a.postCaption.setSelection(spannableEnd + 1);
                this.a.l.dismiss();
            }
        });
        this.postCaption.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus && this.a.j == 0) {
                    jb.a(this.a.postCaption.getText(), this.a.postCaption, this.a.l, this.a.m);
                }
            }
        });
        this.postCaption.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                this.a.o = this.a.postCaption.getSelectionStart();
                this.a.p = this.a.postCaption.getSelectionEnd();
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (this.a.j == 0 && !s.toString().equals(this.a.n.toString())) {
                    int newCursorStart = this.a.postCaption.getSelectionStart();
                    ArrayList newTags = new ArrayList();
                    Iterator it = this.a.k.iterator();
                    while (it.hasNext()) {
                        TextTag indexes = (TextTag) it.next();
                        if (this.a.o <= indexes.startIndex && this.a.p <= indexes.startIndex) {
                            indexes.startIndex += count - before;
                            indexes.endIndex += count - before;
                            newTags.add(indexes);
                            this.a.q = true;
                        } else if (this.a.o <= indexes.startIndex && this.a.p > indexes.startIndex) {
                            this.a.q = true;
                        } else if (this.a.o > indexes.startIndex && this.a.o <= indexes.endIndex) {
                            this.a.q = true;
                        } else if (newCursorStart > indexes.endIndex) {
                            newTags.add(indexes);
                        } else {
                            this.a.q = true;
                        }
                    }
                    this.a.k = newTags;
                }
            }

            public void afterTextChanged(Editable s) {
                if (this.a.j == 0 && !s.toString().equals(this.a.n.toString())) {
                    this.a.n = s.toString();
                    jb.a((CharSequence) s, this.a.postCaption, this.a.l, this.a.m);
                    if (this.a.q) {
                        SpannableStringBuilder newText = new SpannableStringBuilder(s.toString());
                        Iterator it = this.a.k.iterator();
                        while (it.hasNext()) {
                            TextTag indexes = (TextTag) it.next();
                            if (indexes.startIndex > -1 && indexes.endIndex > -1) {
                                newText.setSpan(jb.a(), indexes.startIndex, indexes.endIndex, 33);
                            }
                        }
                        this.a.q = false;
                        this.a.n = newText.toString();
                        int pos = this.a.postCaption.getSelectionStart();
                        this.a.postCaption.setText(newText);
                        this.a.postCaption.setSelection(pos);
                    }
                }
                if (!this.a.s) {
                    this.a.c();
                }
            }
        });
        a();
        this.friendMarker.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.friendSwitch.toggle();
            }
        });
        this.friendSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                this.a.f = isChecked;
                this.a.a(this.a.f);
            }
        });
        this.g = new Handler(getMainLooper());
        this.mRootView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.enableKeyboardEvents(this.a.mRootView);
            }
        });
        if (!AppState.hasPosted) {
            this.friendSwitch.setVisibility(0);
            this.friendMarker.setVisibility(0);
            startActivityForResult(new Intent(this, TutorialPostActivity.class), TUTORIAL_POST);
        } else if (!AppState.hasLinkSearched) {
            startActivityForResult(new Intent(this, TutorialLinkSearchActivity.class), TUTORIAL_LINK_SEARCH);
        }
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        addToSubscriptionList(ix.a().a(in$y.class, new apr<in$y>(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$y imageUploadStarted) {
                if (this.a.photoHelper != null && this.a.photoHelper.f != null && this.a.photoHelper.b != null && this.a.photoHelper.a != null) {
                    this.a.postPhoto.setImageBitmap(this.a.photoHelper.f);
                    if (this.a.photoHelper.d > 0 && this.a.photoHelper.e > 0) {
                        this.a.e();
                    }
                    this.a.findViewById(2131624116).setVisibility(0);
                    this.a.postPhoto.setAlpha(0.3f);
                    this.a.imageCaptured();
                }
            }
        }));
        busSubscribe(in$z.class, new apr<in$z>(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$z linkSeachChosen) {
                String linkUrl = linkSeachChosen.a;
                this.a.s = false;
                this.a.postCaption.setText(linkUrl);
            }
        });
        if ("android.intent.action.SEND".equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                a(intent);
            } else if (type.startsWith("image/")) {
                b(intent);
            }
        }
    }

    void a(Intent intent) {
        String sharedText = intent.getStringExtra("android.intent.extra.TEXT");
        if (sharedText != null) {
            this.s = false;
            this.postCaption.setText(sharedText);
        }
    }

    void b(Intent intent) {
        Uri imageUri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        try {
            if (this.photoHelper == null) {
                this.photoHelper = getPhotoHelper();
            }
            File file = this.photoHelper.a(imageUri);
            this.photoHelper.a(file.getAbsolutePath(), Uri.fromFile(file), 902);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onResume() {
        super.onResume();
    }

    private void a() {
        if (AppState.account == null || AppState.account.num_fb_friends + AppState.account.num_phone_friends < 1) {
            this.friendSwitch.setVisibility(8);
            this.friendMarker.setVisibility(8);
            return;
        }
        this.friendSwitch.setVisibility(0);
        this.friendMarker.setVisibility(0);
    }

    protected void keyboardOpened() {
        super.keyboardOpened();
        this.groupNameSelector.setDropDownHeight(this.postContent.getHeight());
        if (this.groupNameSelector.isFocused()) {
            this.groupNameSelector.showDropDown();
        }
    }

    private void a(boolean showFriendMarker) {
        this.g.removeCallbacks(this.b);
        this.tooltipView.setVisibility(0);
        if (showFriendMarker) {
            this.tooltipView.setText(getString(2131230961));
        } else {
            this.tooltipView.setText(getString(2131230962));
        }
        this.g.postDelayed(this.b, 5000);
    }

    private void b() {
        if (AppState.groups == null) {
            ik.a().b().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                final /* synthetic */ CreatePostActivity a;

                {
                    this.a = this$0;
                }

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    if (!this.a.isStopped) {
                        Toast.makeText(this.a, e.toString(), 1).show();
                    }
                }

                public void onNext(NetworkData networkData) {
                    if (!this.a.isStopped) {
                        this.a.b();
                    }
                }
            });
            return;
        }
        this.i = new hg(this, 2130968690, new ArrayList(AppState.groups));
        this.groupNameSelector.setThreshold(0);
        this.groupNameSelector.setAdapter(this.i);
    }

    private Group a(String prefix) {
        if (this.i != null) {
            return this.i.b(prefix);
        }
        return null;
    }

    private Group b(String prefix) {
        for (Group group : AppState.groups) {
            if (group.group_name.equals(prefix)) {
                return group;
            }
        }
        return null;
    }

    private void a(Group group) {
        if (group != null) {
            Log.d("CPA", "Choose group: " + group.group_name);
            this.e = group.group_id;
            this.groupNameSelector.setVisibility(8);
            this.createGroupButton.setVisibility(8);
            findViewById(2131624111).setVisibility(0);
            ((TextView) findViewById(2131624112)).setText(group.group_name);
            this.postCaption.requestFocus();
        } else {
            this.e = 0;
            findViewById(2131624111).setVisibility(8);
            this.groupNameSelector.setVisibility(0);
            this.createGroupButton.setVisibility(0);
            this.groupNameSelector.setText("");
            this.groupNameSelector.requestFocus();
        }
        updatePostButton();
    }

    @OnClick({2131624111})
    public void clearChosenGroup(View v) {
        a(null);
    }

    public void createGroupClick(View v) {
        Log.d("CPA", "Create group?");
        Intent intent = new Intent(this, CreateGroupActivity.class);
        intent.putExtra("for_post", true);
        startActivityForResult(intent, CREATE_GROUP_FOR_POST);
    }

    private void c() {
        String[] lineString = this.postCaption.getText().toString().trim().split("\n");
        updatePostButton();
        if (lineString.length > 0) {
            String lastStr = lineString[lineString.length - 1];
            if (lastStr != null) {
                String[] spaceString = lastStr.split(" ");
                if (spaceString.length > 0) {
                    String lastSpaceStr = spaceString[spaceString.length - 1];
                    if (lastSpaceStr != null && iz.a(lastSpaceStr) && !lastSpaceStr.equals(this.h)) {
                        this.h = lastSpaceStr;
                        addToSubscriptionList(ik.a().d(lastSpaceStr).b(Schedulers.io()).a(apv.a()).b(new apr<Map<String, String>>(this) {
                            final /* synthetic */ CreatePostActivity a;

                            {
                                this.a = this$0;
                            }

                            public void onCompleted() {
                            }

                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }

                            public void onNext(Map<String, String> stringStringMap) {
                                if (stringStringMap != null) {
                                    this.a.s = true;
                                    this.a.r = stringStringMap;
                                    this.a.a(this.a.r);
                                    this.a.postCaption.setText("");
                                }
                            }
                        }));
                    }
                }
            }
        }
    }

    public void updatePostButton() {
        String text = this.postCaption.getText().toString().trim();
        if (this.e == 0 || (text.length() <= 0 && this.c == null && this.r == null)) {
            this.postButton.setSelected(false);
            return;
        }
        this.postButton.setSelected(true);
        if (this.d) {
            this.postButton.setSelected(false);
        }
    }

    public void savePost(View localPostButton) {
        if (this.e == 0) {
            new Builder(this).setTitle("Please select a group").setPositiveButton(2131230895, null).create().show();
        } else if (!this.d) {
            String text = this.postCaption.getText().toString().trim();
            if (text.length() <= 0 && this.c == null && this.r == null) {
                new Builder(this).setTitle("Blank posts are not allowed").setPositiveButton(2131230895, null).create().show();
                return;
            }
            this.mRootView.setAlpha(0.3f);
            this.postSpinny.setVisibility(0);
            Post post = new Post();
            post.group_id = this.e;
            if (!this.f) {
                post.friends_disabled = 1;
            }
            if (text.length() > 0) {
                int ogLen = this.postCaption.getText().toString().length();
                StringTrimResult result = DataUtil.trimWithCount(this.postCaption.getText().toString());
                if (result.string.length() > 0) {
                    post.caption = result.string;
                }
                if (!this.k.isEmpty()) {
                    String ids = "";
                    Iterator it = this.k.iterator();
                    while (it.hasNext()) {
                        TextTag tag = (TextTag) it.next();
                        int lenToEnd = (ogLen - 1) - tag.endIndex;
                        tag.startIndex -= result.trimmedStart;
                        tag.endIndex -= result.trimmedStart;
                        if (result.trimmedEnd >= lenToEnd) {
                            tag.endIndex = result.string.length();
                        }
                        ids = ids + tag.toString() + ";";
                    }
                    post.mentioned_groups_info = ids.substring(0, ids.length() - 1);
                }
            }
            if (this.c != null) {
                post.source_url = this.c;
                if (this.photoHelper != null) {
                    post.width = this.photoHelper.d;
                    post.height = this.photoHelper.e;
                    post.image_hash = this.photoHelper.c;
                }
            }
            a(post, this.r);
        }
    }

    private void a(Post post, Map<String, String> linkMap) {
        if (this.t != null) {
            this.t.unsubscribe();
        }
        this.t = ik.a().createPost(post, linkMap).b(Schedulers.io()).a(apv.a()).b(d());
        addToSubscriptionList(this.t);
    }

    private apr<NetworkData> d() {
        return new apr<NetworkData>(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                if (e instanceof CompositeException) {
                    for (Throwable thrower : ((CompositeException) e).a()) {
                        Log.d("CPA", thrower.toString());
                    }
                }
                rj.a(e);
                new Handler().postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass17 a;

                    {
                        this.a = this$1;
                    }

                    public void run() {
                        this.a.a.postSpinny.setVisibility(8);
                        this.a.a.mRootView.setAlpha(1.0f);
                    }
                }, 500);
            }

            public void onNext(NetworkData data) {
                final NetworkData networkData;
                if (data.success) {
                    final Post post = data.post;
                    if (data.server_message != null) {
                        networkData = data;
                        new Builder(this.a).setTitle(data.server_message.title).setMessage(data.server_message.message).setPositiveButton(2131230895, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass17 c;

                            public void onClick(DialogInterface dialog, int which) {
                                ik.a().k(networkData.server_message.message_type).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                                ix.a().a(new in$k(post));
                                new Handler().postDelayed(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass4 a;

                                    {
                                        this.a = this$2;
                                    }

                                    public void run() {
                                        this.a.c.a.postSpinny.setVisibility(8);
                                        this.a.c.a.mRootView.setAlpha(1.0f);
                                    }
                                }, 500);
                                Intent intent = new Intent();
                                intent.putExtra("json", DataUtil.toJson(post));
                                this.c.a.setResult(-1, intent);
                                intent = new Intent(this.c.a.getBaseContext(), InviteContactsActivity.class);
                                intent.putExtra("post", DataUtil.toJson(post));
                                this.c.a.startActivity(intent);
                                this.c.a.finish();
                            }
                        }).create().show();
                        return;
                    }
                    if (AppState.groups != null) {
                        for (Group group : AppState.groups) {
                            if (group.group_id == post.group_id) {
                                AppState.groups.remove(group);
                                AppState.groups.add(0, group);
                                break;
                            }
                        }
                    }
                    if (!(AppState.config.getInt("enable_related_posts", 1) != 1 || data.related_posts == null || data.related_posts.isEmpty())) {
                        ix.a().a(new in$ah(data.post.post_id, false, null));
                    }
                    if (this.a.photoHelper != null) {
                        post.localBitmapPath = this.a.photoHelper.a;
                    }
                    ix.a().a(new in$k(post));
                    new Handler().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass17 a;

                        {
                            this.a = this$1;
                        }

                        public void run() {
                            this.a.a.postSpinny.setVisibility(8);
                            this.a.a.mRootView.setAlpha(1.0f);
                        }
                    }, 500);
                    Intent intent = new Intent();
                    intent.putExtra("json", DataUtil.toJson(post));
                    this.a.setResult(-1, intent);
                    intent = new Intent(this.a.getBaseContext(), InviteContactsActivity.class);
                    intent.putExtra("post", DataUtil.toJson(post));
                    intent.putExtra("link_image_path", this.a.u);
                    this.a.startActivity(intent);
                    this.a.finish();
                } else if (data.same_link_found == 1) {
                    String[] items = new String[]{"Join The Conversation", "Create A New Post"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
                    TextView titleText = new TextView(this.a.getApplicationContext());
                    titleText.setText(data.error);
                    titleText.setTextSize(1, 16.0f);
                    titleText.setTypeface(Typeface.defaultFromStyle(1));
                    titleText.setTextColor(this.a.getResources().getColor(17170444));
                    titleText.setGravity(17);
                    int dp5 = jb.a(5, this.a.getApplicationContext());
                    ListAdapter itemList = new ArrayAdapter(this.a.getApplicationContext(), 2130968749, items);
                    titleText.setPadding(dp5, dp5, dp5, 0);
                    networkData = data;
                    builder.setCustomTitle(titleText).setAdapter(itemList, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass17 b;

                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                                    dialog.dismiss();
                                    Intent intent = new Intent(this.b.a, PostDetailsActivity.class);
                                    intent.putExtra("post_id", networkData.post.post_id);
                                    this.b.a.startActivity(intent);
                                    this.b.a.finish();
                                    return;
                                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                                    dialog.dismiss();
                                    Map newLinkInfo = new HashMap();
                                    newLinkInfo.putAll(this.b.a.r);
                                    newLinkInfo.put("insist_posting", "1");
                                    this.b.a.a(networkData.post, newLinkInfo);
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.setCancelable(false);
                    dialog.show();
                } else {
                    Toast.makeText(this.a, data.error, 1).show();
                    new Handler().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass17 a;

                        {
                            this.a = this$1;
                        }

                        public void run() {
                            this.a.a.postSpinny.setVisibility(8);
                            this.a.a.mRootView.setAlpha(1.0f);
                        }
                    }, 500);
                }
            }
        };
    }

    protected void imageCaptured() {
        this.d = true;
        this.photoHelper.a();
        addToSubscriptionList(ix.a().a(in$ak.class, new apr<in$ak>(this) {
            final /* synthetic */ CreatePostActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$ak s3UploadResponse) {
                if (!s3UploadResponse.b) {
                    this.a.clearPhoto(null);
                    Toast.makeText(this.a, this.a.getString(2131230940), 0).show();
                } else if (this.a.d) {
                    this.a.d = false;
                    this.a.c = s3UploadResponse.a.full_url;
                    this.a.postPhoto.setAlpha(1.0f);
                } else {
                    return;
                }
                this.a.updatePostButton();
            }
        }));
    }

    public void clearPhoto(View v) {
        this.c = null;
        this.d = false;
        this.postPhoto.setImageBitmap(null);
        findViewById(2131624116).setVisibility(8);
        updatePostButton();
    }

    public void choosePhoto() {
        getPhotoHelper().choosePhoto();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CREATE_GROUP_FOR_POST) {
            if (resultCode == -1) {
                a((Group) data.getSerializableExtra("group"));
            }
        } else if (requestCode == ADD_LINK_REQUEST) {
            if (data != null && data.hasExtra("link_info")) {
                try {
                    a((Map) data.getSerializableExtra("link_info"));
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
        } else if (requestCode == TUTORIAL_POST || requestCode == TUTORIAL_LINK_SEARCH) {
            a();
            this.groupNameSelector.requestFocus();
            openKeyboard();
        }
    }

    private void a(Map<String, String> info) {
        if (info.containsKey("type") && ((String) info.get("type")).equals("video")) {
            info.put("type", "link");
        }
        if (info.containsKey("type") && ((String) info.get("type")).equals("image")) {
            this.c = (String) info.get("source_url");
            GossipApplication.c.a(this.c).j().a(new qq(this, this.postPhoto) {
                final /* synthetic */ CreatePostActivity a;

                public void onResourceReady(Bitmap resource, qk<? super Bitmap> glideAnimation) {
                    super.onResourceReady(resource, glideAnimation);
                    if (resource != null && resource.getWidth() > 0) {
                        this.a.photoHelper = this.a.getPhotoHelper();
                        this.a.photoHelper.d = resource.getWidth();
                        this.a.photoHelper.e = resource.getHeight();
                        this.a.photoHelper.c = this.a.photoHelper.a(resource);
                        try {
                            this.a.u = Environment.getExternalStorageDirectory() + "/temp_link_img.png";
                            this.a.a(resource, new File(this.a.u), 100);
                            jb.b(this.a.u, new ExifInterface(this.a.u).getAttributeInt("Orientation", 1));
                        } catch (Throwable e) {
                            rj.a(e);
                        }
                        this.a.e();
                    }
                }
            });
            findViewById(2131624116).setVisibility(0);
            updatePostButton();
            return;
        }
        this.r = info;
        this.linkContainer.setVisibility(0);
        ((TextView) this.linkContainer.findViewById(2131624120)).setText((CharSequence) this.r.get("title"));
        String description = this.r.containsKey("description") ? (String) this.r.get("description") : "";
        TextView descView = (TextView) this.linkContainer.findViewById(2131624121);
        if (description.length() > 0) {
            descView.setText(description);
            descView.setVisibility(0);
        } else {
            descView.setVisibility(8);
        }
        ((TextView) this.linkContainer.findViewById(2131624122)).setText((CharSequence) this.r.get("attribution_host"));
        String source_url = this.r.containsKey("source_url") ? (String) this.r.get("source_url") : null;
        ImageView linkImage = (ImageView) this.linkContainer.findViewById(2131624119);
        if (source_url == null || source_url.length() <= 0) {
            linkImage.setVisibility(8);
        } else {
            GossipApplication.c.a(source_url).a().a(linkImage);
            linkImage.setVisibility(0);
        }
        updatePostButton();
    }

    private void e() {
        LayoutParams lp = (LayoutParams) this.postPhoto.getLayoutParams();
        lp.width = (int) ((((float) this.photoHelper.d) / ((float) this.photoHelper.e)) * ((float) lp.height));
        this.postPhoto.setLayoutParams(lp);
    }

    public void onClick(View v) {
        if (v.getId() == 2131624125) {
            choosePhoto();
        } else if (v.getId() == 2131624127) {
            startActivity(new Intent(this, LinkSearchActivity.class));
        }
    }

    @OnClick({2131624126})
    public void chooseLink(ImageView button) {
        Log.d("CPA", "add a link");
        startActivityForResult(new Intent(this, AddLinkActivity.class), ADD_LINK_REQUEST);
    }

    @OnClick({2131624123})
    public void clearLink(ImageView button) {
        this.linkContainer.setVisibility(8);
        this.r = null;
    }

    private double f() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int dens = dm.densityDpi;
        return Math.sqrt(Math.pow(((double) width) / ((double) dm.xdpi), 2.0d) + Math.pow(((double) height) / ((double) dm.ydpi), 2.0d));
    }

    private void a(Bitmap bm, File file, int quality) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        bm.compress(CompressFormat.PNG, quality, fos);
        fos.flush();
        fos.close();
    }
}
