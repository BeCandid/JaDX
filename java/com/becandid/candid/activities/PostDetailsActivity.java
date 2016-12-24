package com.becandid.candid.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Comment;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.DataUtil.StringTrimResult;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.TextTag;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.StickerKeyboard;
import com.becandid.candid.views.StickerKeyboard.a;
import defpackage.apr;
import defpackage.aps;
import defpackage.apv;
import defpackage.he;
import defpackage.hg;
import defpackage.hn;
import defpackage.ik;
import defpackage.in$ac;
import defpackage.in$ad;
import defpackage.in$ah;
import defpackage.in$ak;
import defpackage.in$ar;
import defpackage.in$l;
import defpackage.in$r;
import defpackage.in$s;
import defpackage.ix;
import defpackage.jb;
import defpackage.rj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class PostDetailsActivity extends PopupWithBlurBackgroundActivity implements a {
    public static final int COMMENT_EDIT = 203;
    public static final int COMMENT_INPUT_TYPE_FLAGS = 212992;
    public static final int FULLSCREEN_VIEW_REPLY = 198;
    public static final int MUTE_THREAD = 199;
    public static final int NUMBER_OF_COMMENTS_PER_PAGE = 20;
    public static HashSet<Integer> clipped;
    private Runnable A = new Runnable(this) {
        final /* synthetic */ PostDetailsActivity a;

        {
            this.a = this$0;
        }

        public void run() {
            this.a.getRxSubscription();
            this.a.w.postDelayed(this.a.A, 60000);
        }
    };
    int b;
    private String c;
    @BindView(2131624130)
    ImageView commentButton;
    @BindView(2131624276)
    EditText commentInput;
    @BindView(2131624272)
    RelativeLayout commentInputContainer;
    @BindView(2131624275)
    ImageView commentPhotoClear;
    @BindView(2131624268)
    RecyclerView commentRecyclerView;
    @BindView(2131624281)
    FrameLayout commentSpinnyContainer;
    @BindView(2131624279)
    TextView commentTextPlaceholder;
    private boolean d;
    private boolean e;
    private String f;
    private String g;
    private boolean h = false;
    private String i;
    private String j;
    private String k;
    private String l;
    private ArrayList<TextTag> m;
    @BindView(2131624269)
    View mReplyToBox;
    @BindView(2131624271)
    View mReplyToClose;
    @BindView(2131624270)
    TextView mReplyToTextHint;
    @BindView(2131624169)
    SwipeRefreshLayout mSwipeContainer;
    @BindView(2131624266)
    ImageView mutePostIcon;
    private ListPopupWindow n;
    private hg o;
    private CharSequence p = "";
    @BindView(2131624265)
    TextView postHeaderText;
    @BindView(2131624274)
    ImageView postPhoto;
    @BindView(2131624282)
    RelativeLayout postSpinnyContainer;
    private boolean q;
    private int r;
    @BindView(2131624280)
    LinearLayout relatedPostsButton;
    @BindView(2131624263)
    View root;
    private int s;
    @BindView(2131624278)
    ImageView stickerButton;
    @BindView(2131624232)
    StickerKeyboard stickerKeyboard;
    private Post t;
    private List<Comment> u;
    private he v;
    private Handler w;
    private Intent x;
    private String y;
    private final int z = 60000;

    private aps a(final String postId, final boolean scrollToBottom, final int commentId, String opColor) {
        this.relatedPostsButton.setVisibility(8);
        Map params = new HashMap();
        params.put("post_id", postId);
        if (opColor != null) {
            params.put("op_color", opColor);
        }
        return ik.a().d(params).b(Schedulers.io()).a(apv.a()).b(new apr<Post>(this) {
            final /* synthetic */ PostDetailsActivity d;

            public void onCompleted() {
                this.d.postSpinnyContainer.setVisibility(8);
                new Handler().postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = this$1;
                    }

                    public void run() {
                        if (commentId != -1) {
                            this.a.d.scrollToComment(commentId);
                        } else if (scrollToBottom) {
                            this.a.d.scrollToBottom();
                        }
                    }
                }, 200);
                this.d.mSwipeContainer.setRefreshing(false);
            }

            public void onError(Throwable e) {
                rj.a(e);
                this.d.postSpinnyContainer.setVisibility(8);
                this.d.mSwipeContainer.setRefreshing(false);
                ix.a().a(new in$ac());
            }

            public void onNext(Post post) {
                if (post == null) {
                    ix.a().a(new in$r(Integer.parseInt(postId)));
                    return;
                }
                List list;
                this.d.t = post;
                new ArrayList().add(this.d.t);
                PostDetailsActivity postDetailsActivity = this.d;
                if (post.comments != null) {
                    list = post.comments;
                } else {
                    list = null;
                }
                postDetailsActivity.u = list;
                List<Comment> tempComments = new ArrayList();
                for (Comment comment : this.d.u) {
                    comment.is_master_comment = true;
                    tempComments.add(comment);
                    for (Comment nestedComment : comment.reply_comments) {
                        nestedComment.is_master_comment = false;
                        tempComments.add(nestedComment);
                    }
                }
                this.d.u.clear();
                this.d.u.addAll(tempComments);
                List newComments = new ArrayList();
                if (this.d.u.size() <= PostDetailsActivity.NUMBER_OF_COMMENTS_PER_PAGE || this.d.v.e().size() != 0 || scrollToBottom || commentId != -1) {
                    newComments.addAll(this.d.u);
                    this.d.v.a(null);
                } else {
                    newComments.addAll(this.d.u.subList(0, PostDetailsActivity.NUMBER_OF_COMMENTS_PER_PAGE));
                    this.d.v.a("1");
                }
                this.d.v.a(newComments, this.d.t);
                if (!AppState.hasMuted && post.can_mute == 1 && this.d.j.equals("comment")) {
                    this.d.startActivityForResult(new Intent(this.d, TutorialMuteActivity.class), PostDetailsActivity.MUTE_THREAD);
                } else {
                    this.d.toggleMuteIcon();
                }
                this.d.toggleMuteIcon();
            }
        });
    }

    protected void getRxSubscription() {
        this.mSubscription = a(this.f, false, -1, this.g);
        addToSubscriptionList(this.mSubscription);
    }

    private void a(int commentId) {
        this.mSubscription = a(this.f, false, commentId, this.g);
        addToSubscriptionList(this.mSubscription);
    }

    public static void startPostDetailsActivity(int postId, Context context, String opColor) {
        Intent intent = new Intent(context, PostDetailsActivity.class);
        intent.putExtra("post_id", postId);
        intent.putExtra("op_color", opColor);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968627);
        ButterKnife.bind(this);
        clipped = new HashSet();
        this.j = AppState.config.getString("show_mute_tutorial", "none");
        this.u = new ArrayList();
        LayoutManager llmComment = new LinearLayoutManager(this);
        this.commentRecyclerView.setLayoutManager(llmComment);
        this.v = new he(this.u, this.t, this);
        this.commentRecyclerView.setAdapter(this.v);
        this.commentRecyclerView.setItemAnimator(null);
        this.commentRecyclerView.addOnScrollListener(new hn(this, (LinearLayoutManager) llmComment, this.v) {
            final /* synthetic */ PostDetailsActivity a;

            public void onLoadMore(String minPostId) {
                if (minPostId != null) {
                    List newComments = new ArrayList();
                    int currPos = this.a.v.e().size();
                    if (this.a.u.size() > currPos + PostDetailsActivity.NUMBER_OF_COMMENTS_PER_PAGE) {
                        newComments.addAll(this.a.u.subList(currPos, currPos + PostDetailsActivity.NUMBER_OF_COMMENTS_PER_PAGE));
                        this.a.v.a("1");
                    } else {
                        if (currPos < this.a.u.size()) {
                            newComments.addAll(this.a.u.subList(currPos, this.a.u.size()));
                        }
                        this.a.v.a(null);
                    }
                    this.a.v.c(newComments);
                }
            }
        });
        this.b = AppState.config.getInt("disable_group_tagging", 0);
        this.m = new ArrayList();
        if (AppState.groups == null) {
            AppState.groups = new ArrayList();
        }
        this.o = new hg(this, 2130968690, new ArrayList(AppState.groups));
        this.n = new ListPopupWindow(this);
        this.n.setAdapter(this.o);
        this.n.setAnchorView(this.commentInput);
        this.n.setAnimationStyle(0);
        this.n.setHeight(-2);
        this.n.setWidth(jb.a(150, (Context) this));
        this.n.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Group group = (Group) parent.getItemAtPosition(position);
                String[] tags = this.a.commentInput.getText().toString().split("(?=#)");
                int pos = this.a.commentInput.getSelectionStart();
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
                Iterator it = this.a.m.iterator();
                while (it.hasNext()) {
                    TextTag indexes = (TextTag) it.next();
                    if (pos < indexes.startIndex || pos > indexes.endIndex) {
                        if (indexes.startIndex > pos) {
                            indexes.startIndex += indexUpdateSize;
                            indexes.endIndex += indexUpdateSize;
                        }
                        newTags.add(indexes);
                    }
                }
                this.a.m = newTags;
                it = this.a.m.iterator();
                while (it.hasNext()) {
                    indexes = (TextTag) it.next();
                    if (indexes.startIndex > -1 && indexes.endIndex > -1) {
                        newText.setSpan(jb.a(), indexes.startIndex, indexes.endIndex, 33);
                    }
                }
                this.a.p = newText;
                this.a.commentInput.setText(newText);
                this.a.commentInput.setSelection(spannableEnd);
                this.a.commentInput.setSelection(spannableEnd + 1);
                this.a.n.dismiss();
            }
        });
        this.commentInput.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus && this.a.b == 0) {
                    jb.a(this.a.commentInput.getText(), this.a.commentInput, this.a.n, this.a.o);
                }
            }
        });
        this.commentInput.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                this.a.r = this.a.commentInput.getSelectionStart();
                this.a.s = this.a.commentInput.getSelectionEnd();
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (this.a.b == 0 && !s.toString().equals(this.a.p.toString())) {
                    int newCursorStart = this.a.commentInput.getSelectionStart();
                    ArrayList newTags = new ArrayList();
                    Iterator it = this.a.m.iterator();
                    while (it.hasNext()) {
                        TextTag indexes = (TextTag) it.next();
                        if (this.a.r <= indexes.startIndex && this.a.s <= indexes.startIndex) {
                            indexes.startIndex += count - before;
                            indexes.endIndex += count - before;
                            newTags.add(indexes);
                            this.a.q = true;
                        } else if (this.a.r <= indexes.startIndex && this.a.s > indexes.startIndex) {
                            this.a.q = true;
                        } else if (this.a.r > indexes.startIndex && this.a.r <= indexes.endIndex) {
                            this.a.q = true;
                        } else if (newCursorStart > indexes.endIndex) {
                            newTags.add(indexes);
                        } else {
                            this.a.q = true;
                        }
                    }
                    this.a.m = newTags;
                }
            }

            public void afterTextChanged(Editable s) {
                if (this.a.b == 0 && !s.toString().equals(this.a.p.toString())) {
                    this.a.p = s.toString();
                    jb.a((CharSequence) s, this.a.commentInput, this.a.n, this.a.o);
                    if (this.a.q) {
                        SpannableStringBuilder newText = new SpannableStringBuilder(s.toString());
                        Iterator it = this.a.m.iterator();
                        while (it.hasNext()) {
                            TextTag indexes = (TextTag) it.next();
                            if (indexes.startIndex > -1 && indexes.endIndex > -1) {
                                newText.setSpan(jb.a(), indexes.startIndex, indexes.endIndex, 33);
                            }
                        }
                        this.a.q = false;
                        this.a.p = newText.toString();
                        int pos = this.a.commentInput.getSelectionStart();
                        this.a.commentInput.setText(newText);
                        this.a.commentInput.setSelection(pos);
                    }
                }
                if (this.a.h) {
                    this.a.h = false;
                    this.a.commentInput.setInputType((this.a.commentInput.getInputType() & -8193) | 16384);
                }
                this.a.updatePostButton();
            }
        });
        this.stickerKeyboard.a = this;
        this.root.requestLayout();
        enableKeyboardEvents(this.root);
        busSubscribe(in$r.class, new apr<in$r>(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$r didRemovePost) {
                if (this.a.f != null && didRemovePost.a == Integer.valueOf(this.a.f).intValue()) {
                    Toast.makeText(this.a, "That post has been deleted", 0).show();
                    this.a.finish();
                }
            }
        });
        busSubscribe(in$ad.class, new apr<in$ad>(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$ad newComment) {
                if (newComment.a == Integer.valueOf(this.a.f).intValue()) {
                    if (newComment.e != null) {
                        try {
                            this.a.a(newComment.b);
                        } catch (Throwable e) {
                            rj.a(e);
                        }
                    } else if (this.a.v != null) {
                        this.a.a(newComment.b);
                    } else {
                        rj.a(new NullPointerException("commentsAdapter is NULL"));
                        return;
                    }
                }
                if (this.a.t == null) {
                    rj.a(new Exception("mPost is NULL"));
                    return;
                }
                this.a.t.can_mute = 1;
                this.a.toggleMuteIcon();
                if (!AppState.hasMuted && this.a.j.equals("comment")) {
                    this.a.startActivityForResult(new Intent(this.a, TutorialMuteActivity.class), PostDetailsActivity.MUTE_THREAD);
                }
            }
        });
        busSubscribe(in$l.class, new apr<in$l>(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$l didDeleteComment) {
                this.a.b(didDeleteComment.a);
            }
        });
        busSubscribe(in$s.class, new apr<in$s>(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rj.a(e);
            }

            public void onNext(in$s didReportComment) {
                this.a.b(didReportComment.a);
            }
        });
        this.mSwipeContainer.setOnRefreshListener(new OnRefreshListener(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onRefresh() {
                this.a.getRxSubscription();
            }
        });
        this.mutePostIcon.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                if (AppState.hasMuted || !this.a.j.equals("click")) {
                    this.a.mutePostIcon.setEnabled(false);
                    if (this.a.t.muted_post == 0) {
                        this.a.mutePost();
                        return;
                    } else if (this.a.t.muted_post == 1) {
                        this.a.unmutePost();
                        return;
                    } else {
                        return;
                    }
                }
                this.a.startActivityForResult(new Intent(this.a, TutorialMuteActivity.class), PostDetailsActivity.MUTE_THREAD);
            }
        });
        this.postHeaderText.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.scrollToTop();
            }
        });
        this.mReplyToClose.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.mReplyToBox.setVisibility(8);
                this.a.k = null;
                this.a.y = null;
            }
        });
        this.w = new Handler(getMainLooper());
    }

    private void b(int comment_id) {
        getRxSubscription();
    }

    public void hideCurrentScreen() {
        this.root.setVisibility(8);
    }

    public void showCurrentScreen() {
        this.root.setVisibility(0);
    }

    protected void onResume() {
        super.onResume();
        if (this.x == null) {
            this.f = Integer.toString(getIntent().getIntExtra("post_id", 0));
            if (getIntent().hasExtra("op_color")) {
                this.g = getIntent().getStringExtra("op_color");
            }
            boolean scrollToBottom = getIntent().getBooleanExtra("scrollToBottom", false);
            int commentId = getIntent().getIntExtra("comment_id", -1);
            this.l = getIntent().getStringExtra("feed_type");
            String encodedId = DataUtil.getEncodedId(getIntent().getData());
            if (encodedId != null) {
                this.f = String.valueOf(DataUtil.decodeId(encodedId));
            }
            this.mSubscription = a(this.f, scrollToBottom, commentId, this.g);
        } else if (this.x.getIntExtra("comment_id", -1) != -1) {
            this.x = null;
        } else {
            this.x = null;
        }
        this.w.postDelayed(this.A, 60000);
    }

    protected void onPause() {
        super.onPause();
        this.w.removeCallbacks(this.A);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void onBackPressed() {
        if (AppState.mainTabsActivity == null) {
            Intent intent = new Intent(this, MainTabsActivity.class);
            if (!AppState.config.getBoolean("messaging_turned_on", true)) {
                intent.putExtra("selected_tab", "feed");
            }
            startActivity(intent);
            finish();
            return;
        }
        try {
            super.onBackPressed();
        } catch (Throwable e) {
            rj.a(e);
            finish();
        }
    }

    public void scrollToTop() {
        if (this.commentRecyclerView != null) {
            this.commentRecyclerView.scrollToPosition(0);
        }
    }

    public void scrollToBottom() {
        if (this.k == null) {
            if (this.v.e().size() != this.u.size()) {
                this.v.a(this.u, this.t);
                this.v.a(null);
            }
            this.commentRecyclerView.scrollToPosition(this.v.e().size());
        }
    }

    public void scrollToBottomAndNotUpdateData() {
        if (this.k == null) {
            this.commentRecyclerView.scrollToPosition(this.v.e().size());
        }
    }

    public void scrollToComment(int commentId) {
        if (this.v.e().size() != this.u.size()) {
            this.v.a(this.u, this.t);
            this.v.a(null);
        }
        int entry = this.v.b(commentId);
        if (entry != -1) {
            this.commentRecyclerView.scrollToPosition(entry + 1);
        } else {
            Toast.makeText(this, 2131230814, 0).show();
        }
    }

    public void replyTo(String name, String commentId, int position) {
        this.mReplyToBox.setVisibility(0);
        this.mReplyToTextHint.setHint(jb.a("Replying to " + name));
        if (!name.startsWith("@")) {
            this.y = "@" + name;
        }
        if (!name.endsWith(" ")) {
            this.y += " ";
        }
        if (((Comment) this.u.get(position - 1)).is_master_comment && AppState.config != null && AppState.config.getInt("android_disable_at_mention_for_main_comment", 1) == 1) {
            this.y = "";
        }
        this.k = commentId;
        startComment(null);
        this.h = true;
    }

    public void startComment(View v) {
        showCommentInput();
        this.commentInput.requestFocus();
        this.commentInput.post(new Runnable(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void run() {
                this.a.openKeyboard();
            }
        });
    }

    public void showCommentInput() {
        this.commentInputContainer.setVisibility(0);
        this.commentTextPlaceholder.setVisibility(8);
        this.commentButton.setVisibility(0);
    }

    public void hideCommentInput() {
        this.commentButton.setVisibility(8);
        this.commentInputContainer.setVisibility(8);
        this.commentTextPlaceholder.setVisibility(0);
    }

    protected void keyboardOpened() {
        super.keyboardOpened();
        chooseSticker(null);
        scrollToBottom();
    }

    protected void keyboardClosed() {
        super.keyboardClosed();
        String text = this.commentInput.getText().toString().trim();
        if (!this.d && this.c == null && text.length() == 0) {
            hideCommentInput();
        }
    }

    public void chooseSticker(View v) {
        if (this.stickerKeyboard.getVisibility() == 0 || v == null) {
            this.stickerKeyboard.setVisibility(8);
            this.stickerButton.setImageResource(2130838235);
            this.stickerButton.setAlpha(0.5f);
            return;
        }
        if (this.keyboardOpen) {
            closeKeyboard();
        }
        this.stickerKeyboard.setVisibility(0);
        this.stickerButton.setImageResource(2130838236);
        this.stickerButton.setAlpha(1.0f);
    }

    public void clickSticker(String name) {
        this.i = name;
        this.postPhoto.setVisibility(0);
        this.commentPhotoClear.setVisibility(0);
        this.postPhoto.setImageDrawable(GossipApplication.a.getResources().getDrawable(GossipApplication.a.getResources().getIdentifier(name.toLowerCase(), "drawable", GossipApplication.a.getPackageName())));
        LayoutParams lp = (LayoutParams) this.postPhoto.getLayoutParams();
        lp.width = (int) (getResources().getDisplayMetrics().density * 120.0f);
        lp.height = lp.width;
        this.postPhoto.setLayoutParams(lp);
        showCommentInput();
        updatePostButton();
    }

    private void a(final HashMap<String, String> params) {
        if (params.containsKey("comment_text") || params.containsKey("sticker_name") || params.containsKey("source_url")) {
            String comment = (String) params.get("comment_text");
            if (comment != null) {
                String[] partition = comment.split(" ");
                if (partition[0].startsWith("@") && partition.length == 1 && !params.containsKey("sticker_name") && !params.containsKey("source_url")) {
                    Toast.makeText(this, "Empty comments are not allowed", 0).show();
                    return;
                }
            }
            this.commentSpinnyContainer.setVisibility(0);
            this.m.clear();
            this.commentInput.setText("");
            chooseSticker(null);
            params.put("post_id", this.f);
            this.k = null;
            ik.a().h((Map) params).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(this) {
                final /* synthetic */ PostDetailsActivity b;

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    rj.a(e);
                    this.b.mReplyToBox.setVisibility(8);
                    if (!this.b.isStopped && params.containsKey("comment_text")) {
                        this.b.commentInput.setText((CharSequence) params.get("comment_text"));
                    }
                }

                public void onNext(final NetworkData networkData) {
                    this.b.mReplyToBox.setVisibility(8);
                    if (!this.b.isStopped && networkData != null) {
                        if (networkData.success) {
                            if (networkData.comment != null) {
                                in$ad newComment = new in$ad();
                                newComment.a = Integer.valueOf(this.b.f).intValue();
                                newComment.b = networkData.comment.comment_id;
                                newComment.c = networkData.comment.comment_text;
                                newComment.d = networkData.comment;
                                newComment.e = (String) params.get("reply_to_comment_id");
                                if (newComment.e != null) {
                                    newComment.d.is_master_comment = false;
                                } else {
                                    newComment.d.is_master_comment = true;
                                }
                                ix.a().a(newComment);
                                if (networkData.update_post != null) {
                                    ix.a().a(new in$ar(networkData.update_post));
                                }
                                if (!(this.b.c == null && this.b.i == null)) {
                                    this.b.clearPhoto(null);
                                }
                                this.b.closeKeyboard();
                                this.b.commentSpinnyContainer.setVisibility(8);
                            }
                            if (AppState.config.getInt("enable_related_posts", 1) != 1 || networkData.related_posts == null || networkData.related_posts.isEmpty()) {
                                this.b.relatedPostsButton.setVisibility(8);
                                return;
                            } else if (AppState.config.getInt("enable_related_posts_pop_up", 0) == 1) {
                                this.b.relatedPostsButton.setVisibility(0);
                                this.b.relatedPostsButton.setOnClickListener(new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass16 b;

                                    public void onClick(View v) {
                                        Intent intent = new Intent(v.getContext(), RelatedPostsFeedActivity.class);
                                        intent.putExtra("related_posts", DataUtil.toJson(networkData.related_posts));
                                        this.b.b.startActivity(intent);
                                        this.b.b.relatedPostsButton.setVisibility(8);
                                    }
                                });
                                return;
                            } else if (this.b.l != null) {
                                this.b.relatedPostsButton.setVisibility(0);
                                this.b.relatedPostsButton.setOnClickListener(new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass16 b;

                                    public void onClick(View v) {
                                        AppState.relatedPosts = networkData.related_posts;
                                        ix.a().a(new in$ah(networkData.update_post.post_id, true, this.b.b.l));
                                        this.b.b.finish();
                                    }
                                });
                                return;
                            } else {
                                return;
                            }
                        }
                        Toast.makeText(this.b, networkData.error, 0).show();
                        if (params.containsKey("comment_text")) {
                            this.b.commentInput.setText((CharSequence) params.get("comment_text"));
                        }
                        this.b.commentSpinnyContainer.setVisibility(8);
                    }
                }
            });
            return;
        }
        Toast.makeText(this, "Empty comments are not allowed.", 0).show();
    }

    public void saveComment(View v) {
        HashMap params = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();
        if (this.y != null) {
            stringBuilder.append(this.y);
        }
        stringBuilder.append(this.commentInput.getText().toString());
        String commentText = stringBuilder.toString();
        int ogLen = commentText.length();
        StringTrimResult result = DataUtil.trimWithCount(commentText);
        if (result.string.length() > 0) {
            params.put("comment_text", commentText);
            this.y = null;
        }
        if (!this.m.isEmpty()) {
            String ids = "";
            Iterator it = this.m.iterator();
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
            params.put("mentioned_group_ids", ids.substring(0, ids.length() - 1));
        }
        if (this.c != null) {
            params.put("source_url", this.c);
            float width = (float) this.photoHelper.d;
            float height = (float) this.photoHelper.e;
            if (width <= 0.0f || height <= 0.0f) {
                params.put("image_width", "240");
                params.put("image_height", "160");
            } else if (((double) width) < (((double) height) * 240.0d) / 160.0d) {
                params.put("image_width", String.valueOf((int) ((160.0d * ((double) width)) / ((double) height))));
                params.put("image_height", "160");
            } else {
                params.put("image_width", "240");
                params.put("image_height", String.valueOf((int) ((240.0d * ((double) height)) / ((double) width))));
            }
        }
        if (this.i != null) {
            params.put("sticker_name", this.i);
            params.put("image_width", "120");
            params.put("image_height", "120");
        }
        if (this.k != null) {
            params.put("reply_to_comment_id", this.k);
        }
        a(params);
    }

    public void updatePostButton() {
        if (this.commentInput.getText().toString().trim().length() <= 0 && this.c == null && this.i == null) {
            this.commentButton.setImageResource(2130837648);
            return;
        }
        this.commentButton.setImageResource(2130837649);
        if (this.d) {
            this.commentButton.setImageResource(2130837648);
        }
    }

    protected void imageCaptured() {
        this.d = true;
        this.photoHelper.a();
        addToSubscriptionList(ix.a().a(in$ak.class, new apr<in$ak>(this) {
            final /* synthetic */ PostDetailsActivity a;

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
                    this.a.updatePostButton();
                    if (this.a.e) {
                        this.a.e = false;
                    }
                    Toast.makeText(this.a, this.a.getString(2131230940), 0).show();
                } else if (this.a.d) {
                    this.a.d = false;
                    this.a.c = s3UploadResponse.a.full_url;
                    if (this.a.e) {
                        this.a.e = false;
                        this.a.saveComment(null);
                    }
                    this.a.updatePostButton();
                    this.a.postPhoto.setAlpha(1.0f);
                }
            }
        }));
    }

    public void clearPhoto(View v) {
        this.postPhoto.setImageBitmap(null);
        this.d = false;
        this.c = null;
        this.postPhoto.setVisibility(8);
        this.i = null;
        this.commentPhotoClear.setVisibility(8);
        if (!this.keyboardOpen) {
            keyboardClosed();
        }
        updatePostButton();
    }

    public void choosePhoto(View cameraButton) {
        if (!this.d && this.c == null && this.i == null) {
            getPhotoHelper().choosePhoto();
        } else {
            clearPhoto(null);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
        r4 = this;
        r3 = 0;
        super.onActivityResult(r5, r6, r7);
        r4.x = r7;
        r1 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        if (r6 != r1) goto L_0x0013;
    L_0x000a:
        r1 = r4.t;
        r2 = 1;
        r1.can_mute = r2;
        r4.mutePost();
    L_0x0012:
        return;
    L_0x0013:
        r1 = r4.photoHelper;
        r1 = 901; // 0x385 float:1.263E-42 double:4.45E-321;
        if (r5 == r1) goto L_0x001f;
    L_0x0019:
        r1 = r4.photoHelper;
        r1 = 902; // 0x386 float:1.264E-42 double:4.456E-321;
        if (r5 != r1) goto L_0x0082;
    L_0x001f:
        r1 = r4.photoHelper;
        if (r1 == 0) goto L_0x0082;
    L_0x0023:
        r1 = r4.photoHelper;
        r1 = r1.f;
        if (r1 == 0) goto L_0x0082;
    L_0x0029:
        r1 = r4.photoHelper;
        r1 = r1.b;
        if (r1 == 0) goto L_0x0082;
    L_0x002f:
        r1 = r4.photoHelper;
        r1 = r1.a;
        if (r1 == 0) goto L_0x0082;
    L_0x0035:
        r1 = r4.postPhoto;
        r2 = r4.photoHelper;
        r2 = r2.f;
        r1.setImageBitmap(r2);
        r1 = r4.photoHelper;
        r1 = r1.d;
        if (r1 <= 0) goto L_0x0069;
    L_0x0044:
        r1 = r4.photoHelper;
        r1 = r1.e;
        if (r1 <= 0) goto L_0x0069;
    L_0x004a:
        r1 = r4.postPhoto;
        r0 = r1.getLayoutParams();
        r0 = (android.widget.RelativeLayout.LayoutParams) r0;
        r1 = r4.photoHelper;
        r1 = r1.d;
        r1 = (float) r1;
        r2 = r4.photoHelper;
        r2 = r2.e;
        r2 = (float) r2;
        r1 = r1 / r2;
        r2 = r0.height;
        r2 = (float) r2;
        r1 = r1 * r2;
        r1 = (int) r1;
        r0.width = r1;
        r1 = r4.postPhoto;
        r1.setLayoutParams(r0);
    L_0x0069:
        r1 = r4.postPhoto;
        r1.setVisibility(r3);
        r1 = r4.postPhoto;
        r2 = 1050253722; // 0x3e99999a float:0.3 double:5.188942835E-315;
        r1.setAlpha(r2);
        r1 = r4.commentPhotoClear;
        r1.setVisibility(r3);
        r4.showCommentInput();
        r4.imageCaptured();
        goto L_0x0012;
    L_0x0082:
        r1 = 203; // 0xcb float:2.84E-43 double:1.003E-321;
        if (r6 != r1) goto L_0x0012;
    L_0x0086:
        r1 = "";
        r4.k = r1;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.becandid.candid.activities.PostDetailsActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void toggleMuteIcon() {
        this.mutePostIcon.setEnabled(false);
        if (this.t.can_mute == 1) {
            this.mutePostIcon.setVisibility(0);
            if (this.t.muted_post == 0) {
                this.mutePostIcon.setImageDrawable(getResources().getDrawable(2130838077));
            } else {
                this.mutePostIcon.setImageDrawable(getResources().getDrawable(2130838078));
            }
            this.mutePostIcon.setEnabled(true);
            return;
        }
        this.mutePostIcon.setVisibility(8);
    }

    public void mutePost() {
        ik.a().e(Integer.toString(this.t.post_id)).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void onNext(EmptyClass emptyClass) {
                this.a.t.muted_post = 1;
                Builder builder = new Builder(this.a);
                if (!AppState.hasShownMutePopup) {
                    builder.setTitle("Muted").setMessage("You will no longer receive notifications about this post.").setPositiveButton(2131230895, null);
                    builder.create().show();
                    AppState.hasShownMutePopup = true;
                    AppState.saveState(GossipApplication.a());
                }
                this.a.toggleMuteIcon();
            }
        });
    }

    public void unmutePost() {
        ik.a().f(Integer.toString(this.t.post_id)).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(this) {
            final /* synthetic */ PostDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void onNext(EmptyClass emptyClass) {
                this.a.t.muted_post = 0;
                Builder builder = new Builder(this.a);
                if (!AppState.hasShownUnmutePopup) {
                    builder.setTitle("Unmuted Post").setMessage("You will receive notifications about this post again.").setPositiveButton(2131230895, null);
                    builder.create().show();
                    AppState.hasShownUnmutePopup = true;
                    AppState.saveState(GossipApplication.a());
                }
                this.a.toggleMuteIcon();
            }
        });
    }
}
