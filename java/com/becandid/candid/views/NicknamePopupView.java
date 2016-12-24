package com.becandid.candid.views;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.User;
import defpackage.jb;

public class NicknamePopupView extends BlurLayout {
    @BindView(2131624592)
    TextView addNicknameDesc;
    MessageActivity b;
    @BindView(2131624593)
    EditText editNickname;
    @BindView(2131624079)
    ImageView mBadgeIcon;
    @BindView(2131624594)
    Button mCancelButton;
    @BindView(2131624579)
    Button mFinishBtn;
    @BindView(2131624590)
    View mMessageContainerAddNickname;
    @BindView(2131624584)
    View mMessageContainerSecondNickname;
    @BindView(2131624595)
    View mNicknameCloseButton;
    @BindView(2131624587)
    Button mNoButton;
    @BindView(2131624589)
    Button mOkButton;
    @BindView(2131624588)
    Button mYesButton;
    @BindView(2131624586)
    TextView secondNicknameDesc;

    public NicknamePopupView(Context context, String blurFileName, boolean secondNickname) {
        super(context);
        this.b = (MessageActivity) context;
        this.a = blurFileName;
        LayoutInflater.from(context).inflate(2130968711, this, true);
        ButterKnife.bind(this);
        a();
        jb.a(this.mMessageContainerSecondNickname, "#ffffff");
        jb.a(this.mMessageContainerAddNickname, "#ffffff");
        this.mNicknameCloseButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NicknamePopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.b();
            }
        });
        if (secondNickname) {
            this.b.markNicknameAlertShown();
            User targetUserInfo = this.b.getTargetUserData();
            User userData = this.b.getUserData();
            if (targetUserInfo == null || targetUserInfo.post_name == null || targetUserInfo.nickname == null) {
                b();
            } else {
                SpannableStringBuilder span = new SpannableStringBuilder(targetUserInfo.post_name);
                span.setSpan(new StyleSpan(1), 0, span.length(), 33);
                span.append(" is now " + targetUserInfo.nickname);
                span.setSpan(new StyleSpan(1), span.length() - targetUserInfo.nickname.length(), span.length(), 33);
                span.append(".");
                if (userData.nickname == null) {
                    span.append(" Want to add your own nickname?");
                } else {
                    this.mOkButton.setVisibility(0);
                    this.mOkButton.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ NicknamePopupView a;

                        {
                            this.a = this$0;
                        }

                        public void onClick(View v) {
                            this.a.b.markNicknameAlertShown();
                            this.a.b();
                        }
                    });
                    this.mYesButton.setVisibility(8);
                    this.mNoButton.setVisibility(8);
                    this.mNicknameCloseButton.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ NicknamePopupView a;

                        {
                            this.a = this$0;
                        }

                        public void onClick(View v) {
                            this.a.b();
                        }
                    });
                }
                this.secondNicknameDesc.setText(span);
            }
            this.mMessageContainerSecondNickname.setVisibility(0);
            this.mMessageContainerAddNickname.setVisibility(8);
            this.mYesButton.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NicknamePopupView a;

                {
                    this.a = this$0;
                }

                public void onClick(View v) {
                    this.a.setupNicknamePrompt();
                }
            });
            this.mNoButton.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NicknamePopupView a;

                {
                    this.a = this$0;
                }

                public void onClick(View v) {
                    this.a.b.ignoreNickname();
                    this.a.b();
                }
            });
            return;
        }
        setupNicknamePrompt();
    }

    public void setupNicknamePrompt() {
        this.mMessageContainerAddNickname.setVisibility(0);
        this.mMessageContainerSecondNickname.setVisibility(8);
        this.editNickname.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ NicknamePopupView a;

            {
                this.a = this$0;
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    this.a.mFinishBtn.setEnabled(true);
                } else {
                    this.a.mFinishBtn.setEnabled(false);
                }
            }
        });
        if (AppState.nickname != null) {
            this.editNickname.setText(AppState.nickname);
            this.editNickname.setSelection(this.editNickname.length());
        } else if (!this.b.keyboardOpen) {
            this.b.openKeyboard();
        }
        this.mFinishBtn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NicknamePopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.b.updateNickname(this.a.editNickname.getText().toString());
                this.a.b();
            }
        });
        this.mCancelButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NicknamePopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.b.ignoreNickname();
                this.a.b();
            }
        });
    }

    private void b() {
        FrameLayout badgeInfoContainer = (FrameLayout) this.b.findViewById(2131624178);
        if (badgeInfoContainer != null) {
            this.b.slideOutAnimation(badgeInfoContainer);
        }
        this.b.closingPopup();
    }
}
