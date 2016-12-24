package defpackage;

/* compiled from: ModelCache */
public class mq<A, B> {
    private final rf<mq$a<A>, B> a;

    public mq() {
        this(250);
    }

    public mq(int size) {
        this.a = new mq$1(this, size);
    }

    public B a(A model, int width, int height) {
        Object key = mq$a.a(model, width, height);
        B result = this.a.b(key);
        key.a();
        return result;
    }

    public void a(A model, int width, int height, B value) {
        this.a.b(mq$a.a(model, width, height), value);
    }
}
