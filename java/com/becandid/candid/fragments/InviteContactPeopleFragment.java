package com.becandid.candid.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.becandid.candid.activities.InviteContactsActivity;
import com.becandid.candid.data.Post;
import com.becandid.candid.views.viewholders.ImagePostViewHolder;
import com.becandid.candid.views.viewholders.LinkPostViewHolder;
import com.becandid.candid.views.viewholders.TextPostViewHolder;
import defpackage.aih;
import defpackage.rj;
import defpackage.uu$h;

public class InviteContactPeopleFragment extends Fragment {
    int a = -1;
    int b = -1;
    int c = -1;
    int d = -1;
    Runnable e = new Runnable(this) {
        final /* synthetic */ InviteContactPeopleFragment a;

        {
            this.a = this$0;
        }

        public void run() {
            this.a.a();
        }
    };
    private Unbinder f;
    private Bundle g;
    private Handler h;
    @BindView(2131624466)
    FrameLayout mEntirePostSnippet;
    @BindView(2131624463)
    ImageView mPostPlaceholder;
    @BindView(2131624462)
    ImageView mPostPreview;
    @BindView(2131624461)
    FrameLayout mPostSnippet;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r9, android.view.ViewGroup r10, android.os.Bundle r11) {
        /*
        r8 = this;
        r4 = 0;
        r5 = -1;
        r6 = 2130968675; // 0x7f040063 float:1.754601E38 double:1.0528384147E-314;
        r3 = r9.inflate(r6, r10, r4);
        r6 = butterknife.ButterKnife.bind(r8, r3);
        r8.f = r6;
        r6 = r8.getArguments();
        r8.g = r6;
        r6 = new android.os.Handler;
        r7 = r8.getActivity();
        r7 = r7.getMainLooper();
        r6.<init>(r7);
        r8.h = r6;
        r6 = r8.g;
        r7 = "post";
        r0 = r6.getString(r7);
        r6 = r8.g;
        r7 = "link_image_path";
        r2 = r6.getString(r7);
        if (r0 == 0) goto L_0x0058;
    L_0x0036:
        r8.a(r0, r2);
    L_0x0039:
        r4 = 2131624464; // 0x7f0e0210 float:1.8876108E38 double:1.0531624175E-314;
        r4 = r3.findViewById(r4);
        r5 = new com.becandid.candid.fragments.InviteContactPeopleFragment$2;
        r5.<init>(r8);
        r4.setOnClickListener(r5);
        r4 = 2131624465; // 0x7f0e0211 float:1.887611E38 double:1.053162418E-314;
        r4 = r3.findViewById(r4);
        r5 = new com.becandid.candid.fragments.InviteContactPeopleFragment$3;
        r5.<init>(r8);
        r4.setOnClickListener(r5);
        return r3;
    L_0x0058:
        r6 = r8.mPostPlaceholder;
        r6.setVisibility(r4);
        r6 = r8.g;
        r7 = "invite_type";
        r1 = r6.getString(r7);
        if (r1 == 0) goto L_0x007a;
    L_0x0067:
        r6 = r1.hashCode();
        switch(r6) {
            case 2493632: goto L_0x00b5;
            case 69076575: goto L_0x00be;
            default: goto L_0x006e;
        };
    L_0x006e:
        r4 = r5;
    L_0x006f:
        switch(r4) {
            case 0: goto L_0x00c8;
            case 1: goto L_0x00d1;
            default: goto L_0x0072;
        };
    L_0x0072:
        r4 = r8.mPostPlaceholder;
        r6 = 2130838034; // 0x7f020212 float:1.7281039E38 double:1.0527738695E-314;
        r4.setImageResource(r6);
    L_0x007a:
        r4 = r8.g;
        r6 = "groupId";
        r4 = r4.getInt(r6, r5);
        r8.c = r4;
        r4 = r8.getActivity();
        r4 = r4 instanceof com.becandid.candid.activities.InviteContactsActivity;
        if (r4 == 0) goto L_0x0097;
    L_0x008c:
        r4 = r8.getActivity();
        r4 = (com.becandid.candid.activities.InviteContactsActivity) r4;
        r6 = r8.c;
        r4.setGroupId(r6);
    L_0x0097:
        r4 = r8.g;
        r6 = "upsellId";
        r4 = r4.getInt(r6, r5);
        r8.d = r4;
        r4 = r8.getActivity();
        r4 = r4 instanceof com.becandid.candid.activities.InviteContactsActivity;
        if (r4 == 0) goto L_0x0039;
    L_0x00a9:
        r4 = r8.getActivity();
        r4 = (com.becandid.candid.activities.InviteContactsActivity) r4;
        r5 = r8.d;
        r4.setUpsellId(r5);
        goto L_0x0039;
    L_0x00b5:
        r6 = "Post";
        r6 = r1.equals(r6);
        if (r6 == 0) goto L_0x006e;
    L_0x00bd:
        goto L_0x006f;
    L_0x00be:
        r4 = "Group";
        r4 = r1.equals(r4);
        if (r4 == 0) goto L_0x006e;
    L_0x00c6:
        r4 = 1;
        goto L_0x006f;
    L_0x00c8:
        r4 = r8.mPostPlaceholder;
        r6 = 2130838033; // 0x7f020211 float:1.7281037E38 double:1.052773869E-314;
        r4.setImageResource(r6);
        goto L_0x007a;
    L_0x00d1:
        r4 = r8.mPostPlaceholder;
        r6 = 2130838035; // 0x7f020213 float:1.728104E38 double:1.05277387E-314;
        r4.setImageResource(r6);
        goto L_0x007a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.becandid.candid.fragments.InviteContactPeopleFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    private void a() {
        this.mEntirePostSnippet.setDrawingCacheEnabled(true);
        this.mEntirePostSnippet.buildDrawingCache();
        Bitmap bitmap = this.mEntirePostSnippet.getDrawingCache();
        if (bitmap != null) {
            if (this.a == -1 && this.b == -1) {
                int totalHeight = this.mEntirePostSnippet.getHeight();
                int totalWidth = this.mEntirePostSnippet.getWidth();
                this.a = this.mPostSnippet.getHeight();
                this.b = (this.a * totalWidth) / totalHeight;
            }
            Drawable drawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, this.b, this.a, true));
            LayoutParams layoutParams = new LayoutParams(this.b, this.a);
            layoutParams.addRule(3, 2131624444);
            layoutParams.addRule(2, 2131624448);
            layoutParams.addRule(14);
            this.mPostSnippet.setLayoutParams(layoutParams);
            this.mPostPreview.setImageDrawable(drawable);
            this.mEntirePostSnippet.setVisibility(8);
        }
    }

    @OnClick({2131624464})
    public void inviteAll(View v) {
        ((InviteContactsActivity) getActivity()).inviteAll(v);
    }

    @OnClick({2131624465})
    public void chooseContacts(View v) {
        ((InviteContactsActivity) getActivity()).chooseContacts(v);
    }

    private void a(String data, String linkImagePath) {
        Post post = (Post) new aih().a(data, Post.class);
        if (post == null) {
            rj.a(new Throwable("post object is null in setup post preview"));
            getActivity().finish();
            return;
        }
        this.c = post.group_id;
        if (getActivity() instanceof InviteContactsActivity) {
            ((InviteContactsActivity) getActivity()).setGroupId(this.c);
        }
        String type = post.type;
        Context context = getContext();
        boolean z = true;
        switch (type.hashCode()) {
            case 3321850:
                if (type.equals("link")) {
                    z = true;
                    break;
                }
                break;
            case 100313435:
                if (type.equals("image")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                ImagePostViewHolder imageHolder = new ImagePostViewHolder(LayoutInflater.from(context).inflate(2130968665, null, false), getActivity(), true);
                if (post.localBitmapPath == null) {
                    post.localBitmapPath = linkImagePath;
                }
                ImagePostViewHolder.a(imageHolder, post);
                this.mEntirePostSnippet.addView(imageHolder.itemView);
                break;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                LinkPostViewHolder linkHolder = new LinkPostViewHolder(LayoutInflater.from(context).inflate(2130968666, null, false), getActivity());
                LinkPostViewHolder.a(linkHolder, post);
                this.mEntirePostSnippet.addView(linkHolder.itemView);
                break;
            default:
                TextPostViewHolder textHolder = new TextPostViewHolder(LayoutInflater.from(context).inflate(2130968667, null, false), getActivity());
                TextPostViewHolder.a(textHolder, post);
                this.mEntirePostSnippet.addView(textHolder.itemView);
                break;
        }
        this.mEntirePostSnippet.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ InviteContactPeopleFragment a;

            {
                this.a = this$0;
            }

            public void onGlobalLayout() {
                this.a.mEntirePostSnippet.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.a.mEntirePostSnippet.requestLayout();
                this.a.h.post(this.a.e);
            }
        });
    }

    @OnClick({2131624445})
    public void onContactClose() {
        getActivity().finish();
    }

    public void onResume() {
        super.onResume();
        if (this.mPostPlaceholder.getVisibility() != 0) {
            ViewTreeObserver entirePostSnippetVTO = this.mEntirePostSnippet.getViewTreeObserver();
            if (entirePostSnippetVTO.isAlive()) {
                entirePostSnippetVTO.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                    final /* synthetic */ InviteContactPeopleFragment a;

                    {
                        this.a = this$0;
                    }

                    public void onGlobalLayout() {
                        if (this.a.mEntirePostSnippet != null) {
                            this.a.mEntirePostSnippet.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            this.a.h.postDelayed(this.a.e, 3000);
                        }
                    }
                });
            }
        }
    }

    public void onPause() {
        super.onPause();
        this.h.removeCallbacks(this.e);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f.unbind();
    }
}
