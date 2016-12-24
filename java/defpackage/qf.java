package defpackage;

/* compiled from: RequestListener */
public interface qf<T, R> {
    boolean onException(Exception exception, T t, qy<R> qyVar, boolean z);

    boolean onResourceReady(R r, T t, qy<R> qyVar, boolean z, boolean z2);
}
