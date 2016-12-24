package defpackage;

import java.util.Queue;

/* compiled from: BaseKeyPool */
abstract class lm<T extends ls> {
    private final Queue<T> a = ri.a(20);

    protected abstract T b();

    lm() {
    }

    protected T c() {
        ls result = (ls) this.a.poll();
        if (result == null) {
            return b();
        }
        return result;
    }

    public void a(T key) {
        if (this.a.size() < 20) {
            this.a.offer(key);
        }
    }
}
