package defpackage;

/* compiled from: RequestManager */
class jz$e implements pk$a {
    private final pt a;

    public jz$e(pt requestTracker) {
        this.a = requestTracker;
    }

    public void a(boolean isConnected) {
        if (isConnected) {
            this.a.d();
        }
    }
}
