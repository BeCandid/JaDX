package defpackage;

/* compiled from: AdvertisingInfoProvider */
class aln$1 extends als {
    final /* synthetic */ alm a;
    final /* synthetic */ aln b;

    aln$1(aln aln, alm alm) {
        this.b = aln;
        this.a = alm;
    }

    public void a() {
        alm infoToStore = this.b.e();
        if (!this.a.equals(infoToStore)) {
            akx.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
            this.b.b(infoToStore);
        }
    }
}
