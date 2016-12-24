package com.becandid.candid.activities;

import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import defpackage.in$z;
import defpackage.ix;
import java.lang.reflect.InvocationTargetException;

public class WebViewActivity extends BaseActivity {
    String b;
    @BindView(2131624315)
    TextView mCopyLink;
    @BindView(2131624191)
    ProgressBar mProgressBar;
    @BindView(2131624314)
    TextView mTitle;
    @BindView(2131624316)
    WebView mWebView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968637);
        ButterKnife.bind(this);
        if (getIntent().hasExtra("url")) {
            this.b = getIntent().getStringExtra("url");
            this.mWebView.loadUrl(this.b);
        }
        if (getIntent().hasExtra("title")) {
            this.mTitle.setText(getIntent().getStringExtra("title"));
        }
        if (getIntent().hasExtra("show_copy_link") && getIntent().getBooleanExtra("show_copy_link", false)) {
            this.mCopyLink.setVisibility(0);
            this.mCopyLink.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WebViewActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(View v) {
                    ix.a().a(new in$z(this.a.b));
                    this.a.finish();
                }
            });
        } else {
            this.mCopyLink.setVisibility(8);
        }
        this.mProgressBar.setMax(100);
        this.mProgressBar.getProgressDrawable().setColorFilter(-16776961, Mode.SRC_IN);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setSupportMultipleWindows(true);
        this.mWebView.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ WebViewActivity a;

            {
                this.a = this$0;
            }

            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                this.a.setValue(newProgress);
            }

            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });
        this.mWebView.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ WebViewActivity a;

            {
                this.a = this$0;
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                this.a.b = url;
                return true;
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                this.a.b = url;
                this.a.mProgressBar.setVisibility(8);
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !this.mWebView.canGoBack()) {
            return super.onKeyDown(keyCode, event);
        }
        this.mWebView.goBack();
        return true;
    }

    public void onPause() {
        super.onPause();
        try {
            Class.forName("android.webkit.WebView").getMethod("onPause", (Class[]) null).invoke(this.mWebView, (Object[]) null);
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        } catch (InvocationTargetException e3) {
        } catch (IllegalAccessException e4) {
        }
    }

    public void onResume() {
        super.onResume();
        this.mWebView.onResume();
    }

    public void setValue(int progress) {
        this.mProgressBar.setProgress(progress);
    }
}
