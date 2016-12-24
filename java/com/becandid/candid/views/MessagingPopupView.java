package com.becandid.candid.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.PopupWithBlurBackgroundActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.models.EmptySubscriber;
import defpackage.apv;
import defpackage.ik;
import defpackage.in$aa;
import defpackage.ix;
import defpackage.jb;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

public class MessagingPopupView extends BlurLayout {
    PopupWithBlurBackgroundActivity b;
    @BindView(2131624567)
    TextView badgeDescEnabled;
    private boolean c;
    private boolean d;
    @BindView(2131624577)
    ImageView mAutoCheckmark;
    @BindView(2131624576)
    View mAutoDeleteMsgContainer;
    @BindView(2131624079)
    ImageView mBadgeIcon;
    @BindView(2131624569)
    TextView mDisabledTextView;
    @BindView(2131624579)
    Button mFinishBtn;
    @BindView(2131624568)
    TextView mKeepEnabledTextView;
    @BindView(2131624574)
    ImageView mManualCheckmark;
    @BindView(2131624573)
    View mManualDeleteMsgContainer;
    @BindView(2131624580)
    View mMessageCloseBtn;
    @BindView(2131624570)
    View mMessageContainerDeleteMessage;
    @BindView(2131624565)
    View mMessageContainerEnabled;

    public MessagingPopupView(Context context, String blurFileName, boolean onNewMessage) {
        super(context);
        this.b = (PopupWithBlurBackgroundActivity) context;
        this.a = blurFileName;
        LayoutInflater.from(context).inflate(2130968703, this, true);
        ButterKnife.bind(this);
        a();
        jb.a(this.mMessageContainerEnabled, "#ffffff");
        if (onNewMessage) {
            this.badgeDescEnabled.setText(2131230958);
        } else {
            this.badgeDescEnabled.setText(2131230949);
        }
        this.mKeepEnabledTextView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagingPopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.mMessageContainerEnabled.setVisibility(8);
                this.a.mMessageContainerDeleteMessage.setVisibility(0);
                Map<String, String> params = new HashMap();
                params.put("messaging_disabled", "0");
                ik.a().r(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                AppState.account.messaging_disabled = 0;
                ix.a().a(new in$aa(0));
            }
        });
        this.mDisabledTextView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagingPopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                Map<String, String> params = new HashMap();
                params.put("messaging_disabled", "1");
                ik.a().r(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                AppState.account.messaging_disabled = 1;
                ix.a().a(new in$aa(1));
                this.a.b();
            }
        });
        this.mAutoDeleteMsgContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagingPopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                boolean z = true;
                if (this.a.d) {
                    this.a.setAutoState(false);
                } else {
                    this.a.setAutoState(true);
                    this.a.setManualState(false);
                    this.a.c = false;
                }
                MessagingPopupView messagingPopupView = this.a;
                if (this.a.d) {
                    z = false;
                }
                messagingPopupView.d = z;
                this.a.c();
            }
        });
        this.mManualDeleteMsgContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagingPopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                boolean z = true;
                if (this.a.c) {
                    this.a.setManualState(false);
                } else {
                    this.a.setAutoState(false);
                    this.a.setManualState(true);
                    this.a.d = false;
                }
                MessagingPopupView messagingPopupView = this.a;
                if (this.a.c) {
                    z = false;
                }
                messagingPopupView.c = z;
                this.a.c();
            }
        });
        this.mFinishBtn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagingPopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                HashMap<String, String> params = new HashMap();
                int autoDeletetion = 0;
                if (this.a.d) {
                    autoDeletetion = 1;
                }
                params.put("message_auto_deletion", Integer.toString(autoDeletetion));
                AppState.account.message_auto_deletion = autoDeletetion;
                ik.a().r(params).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                this.a.b();
            }
        });
        this.mMessageCloseBtn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagingPopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.b();
            }
        });
        this.mManualDeleteMsgContainer.performClick();
    }

    private void b() {
        FrameLayout badgeInfoContainer = (FrameLayout) this.b.findViewById(2131624178);
        if (badgeInfoContainer != null) {
            this.b.slideOutAnimation(badgeInfoContainer);
        }
    }

    private void c() {
        if (this.c || this.d) {
            this.mFinishBtn.setEnabled(true);
        } else {
            this.mFinishBtn.setEnabled(false);
        }
    }

    private void setManualState(boolean isSelected) {
        if (isSelected) {
            this.mManualDeleteMsgContainer.setBackground(getResources().getDrawable(2130837981));
            this.mManualCheckmark.setImageDrawable(getResources().getDrawable(2130837982));
            return;
        }
        this.mManualDeleteMsgContainer.setBackground(getResources().getDrawable(2130837710));
        this.mManualCheckmark.setImageDrawable(getResources().getDrawable(2130837709));
    }

    private void setAutoState(boolean isSelected) {
        if (isSelected) {
            this.mAutoDeleteMsgContainer.setBackground(getResources().getDrawable(2130837981));
            this.mAutoCheckmark.setImageDrawable(getResources().getDrawable(2130837982));
            return;
        }
        this.mAutoDeleteMsgContainer.setBackground(getResources().getDrawable(2130837710));
        this.mAutoCheckmark.setImageDrawable(getResources().getDrawable(2130837709));
    }
}
