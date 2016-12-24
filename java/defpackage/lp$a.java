package defpackage;

import java.util.ArrayList;
import java.util.List;

/* compiled from: GroupedLinkedMap */
class lp$a<K, V> {
    lp$a<K, V> a;
    lp$a<K, V> b;
    private final K c;
    private List<V> d;

    public lp$a() {
        this(null);
    }

    public lp$a(K key) {
        this.b = this;
        this.a = this;
        this.c = key;
    }

    public V a() {
        int valueSize = b();
        return valueSize > 0 ? this.d.remove(valueSize - 1) : null;
    }

    public int b() {
        return this.d != null ? this.d.size() : 0;
    }

    public void a(V value) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(value);
    }
}
