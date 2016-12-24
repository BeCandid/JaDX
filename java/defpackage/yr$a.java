package defpackage;

import android.content.ComponentName;
import android.content.Intent;

final class yr$a {
    private final String a;
    private final String b;
    private final ComponentName c = null;

    public yr$a(String str, String str2) {
        this.a = xz.a(str);
        this.b = xz.a(str2);
    }

    public Intent a() {
        return this.a != null ? new Intent(this.a).setPackage(this.b) : new Intent().setComponent(this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yr$a)) {
            return false;
        }
        yr$a yr_a = (yr$a) obj;
        return zc.a(this.a, yr_a.a) && zc.a(this.c, yr_a.c);
    }

    public int hashCode() {
        return zc.a(this.a, this.c);
    }

    public String toString() {
        return this.a == null ? this.c.flattenToString() : this.a;
    }
}
