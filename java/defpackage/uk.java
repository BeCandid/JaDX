package defpackage;

import com.facebook.FacebookException;

/* compiled from: FacebookCallback */
public interface uk<RESULT> {
    void onCancel();

    void onError(FacebookException facebookException);

    void onSuccess(RESULT result);
}
