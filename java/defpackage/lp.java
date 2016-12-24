package defpackage;

import java.util.HashMap;
import java.util.Map;

/* compiled from: GroupedLinkedMap */
class lp<K extends ls, V> {
    private final lp$a<K, V> a = new lp$a();
    private final Map<K, lp$a<K, V>> b = new HashMap();

    lp() {
    }

    public void a(K key, V value) {
        lp$a<K, V> entry = (lp$a) this.b.get(key);
        if (entry == null) {
            entry = new lp$a(key);
            b(entry);
            this.b.put(key, entry);
        } else {
            key.a();
        }
        entry.a((Object) value);
    }

    public V a(K key) {
        lp$a entry = (lp$a) this.b.get(key);
        if (entry == null) {
            entry = new lp$a(key);
            this.b.put(key, entry);
        } else {
            key.a();
        }
        a(entry);
        return entry.a();
    }

    public V a() {
        for (lp$a<K, V> last = this.a.b; !last.equals(this.a); last = last.b) {
            V removed = last.a();
            if (removed != null) {
                return removed;
            }
            lp.d(last);
            this.b.remove(last.c);
            ((ls) last.c).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean hadAtLeastOneItem = false;
        for (lp$a<K, V> current = this.a.a; !current.equals(this.a); current = current.a) {
            hadAtLeastOneItem = true;
            sb.append('{').append(current.c).append(':').append(current.b()).append("}, ");
        }
        if (hadAtLeastOneItem) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append(" )").toString();
    }

    private void a(lp$a<K, V> entry) {
        lp.d(entry);
        entry.b = this.a;
        entry.a = this.a.a;
        lp.c(entry);
    }

    private void b(lp$a<K, V> entry) {
        lp.d(entry);
        entry.b = this.a.b;
        entry.a = this.a;
        lp.c(entry);
    }

    private static <K, V> void c(lp$a<K, V> entry) {
        entry.a.b = entry;
        entry.b.a = entry;
    }

    private static <K, V> void d(lp$a<K, V> entry) {
        entry.b.a = entry.a;
        entry.a.b = entry.b;
    }
}
