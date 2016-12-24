package defpackage;

import android.graphics.drawable.Drawable;

/* compiled from: Target */
public interface qy<R> extends pp {
    qd getRequest();

    void getSize(qw qwVar);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Exception exception, Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, qk<? super R> qkVar);

    void setRequest(qd qdVar);
}
