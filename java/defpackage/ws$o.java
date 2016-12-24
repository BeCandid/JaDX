package defpackage;

/* compiled from: LikeActionController */
class ws$o implements Runnable {
    private String a;
    private String b;

    ws$o(String cacheKey, String controllerJson) {
        this.a = cacheKey;
        this.b = controllerJson;
    }

    public void run() {
        ws.b(this.a, this.b);
    }
}
