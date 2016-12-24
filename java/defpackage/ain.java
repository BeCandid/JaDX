package defpackage;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: JsonObject */
public final class ain extends ail {
    private final LinkedTreeMap<String, ail> a = new LinkedTreeMap();

    public void a(String property, ail value) {
        if (value == null) {
            value = aim.a;
        }
        this.a.put(property, value);
    }

    public void a(String property, String value) {
        a(property, a((Object) value));
    }

    public void a(String property, Boolean value) {
        a(property, a((Object) value));
    }

    private ail a(Object value) {
        return value == null ? aim.a : new aip(value);
    }

    public Set<Entry<String, ail>> a() {
        return this.a.entrySet();
    }

    public boolean a(String memberName) {
        return this.a.containsKey(memberName);
    }

    public ail b(String memberName) {
        return (ail) this.a.get(memberName);
    }

    public aij c(String memberName) {
        return (aij) this.a.get(memberName);
    }

    public ain d(String memberName) {
        return (ain) this.a.get(memberName);
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof ain) && ((ain) o).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
