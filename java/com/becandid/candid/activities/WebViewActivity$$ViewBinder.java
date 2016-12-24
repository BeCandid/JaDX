package com.becandid.candid.activities;

import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import defpackage.uu$d;

public class WebViewActivity$$ViewBinder<T extends WebViewActivity> implements ViewBinder<T> {

    /* compiled from: WebViewActivity$$ViewBinder */
    public static class InnerUnbinder<T extends WebViewActivity> implements Unbinder {
        private T a;

        protected InnerUnbinder(T target) {
            this.a = target;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            unbind(this.a);
            this.a = null;
        }

        protected void unbind(T target) {
            target.mWebView = null;
            target.mTitle = null;
            target.mProgressBar = null;
            target.mCopyLink = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.mWebView = (WebView) finder.castView((View) finder.findRequiredView(source, 2131624316, "field 'mWebView'"), 2131624316, "field 'mWebView'");
        target.mTitle = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624314, "field 'mTitle'"), 2131624314, "field 'mTitle'");
        target.mProgressBar = (ProgressBar) finder.castView((View) finder.findRequiredView(source, uu$d.progress_bar, "field 'mProgressBar'"), uu$d.progress_bar, "field 'mProgressBar'");
        target.mCopyLink = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624315, "field 'mCopyLink'"), 2131624315, "field 'mCopyLink'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
