package defpackage;

/* compiled from: MessageViewHolder */
class jh$10 implements qf<String, oh> {
    final /* synthetic */ jh a;

    jh$10(jh jhVar) {
        this.a = jhVar;
    }

    public /* synthetic */ boolean onException(Exception exception, Object obj, qy qyVar, boolean z) {
        return a(exception, (String) obj, qyVar, z);
    }

    public /* synthetic */ boolean onResourceReady(Object obj, Object obj2, qy qyVar, boolean z, boolean z2) {
        return a((oh) obj, (String) obj2, qyVar, z, z2);
    }

    public boolean a(Exception e, String model, qy<oh> qyVar, boolean isFirstResource) {
        return false;
    }

    public boolean a(oh resource, String model, qy<oh> qyVar, boolean isFromMemoryCache, boolean isFirstResource) {
        this.a.i.setBackground(null);
        return false;
    }
}
