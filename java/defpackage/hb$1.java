package defpackage;

/* compiled from: ActivityAdapter */
class hb$1 implements qf<String, oh> {
    final /* synthetic */ ji a;
    final /* synthetic */ hb b;

    hb$1(hb this$0, ji jiVar) {
        this.b = this$0;
        this.a = jiVar;
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
        this.a.c.setBackground(null);
        return false;
    }
}
