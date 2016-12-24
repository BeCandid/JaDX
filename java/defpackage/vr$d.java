package defpackage;

import android.net.Uri;

/* compiled from: ImageDownloader */
class vr$d {
    Uri a;
    Object b;

    vr$d(Uri url, Object tag) {
        this.a = url;
        this.b = tag;
    }

    public int hashCode() {
        return ((this.a.hashCode() + 1073) * 37) + this.b.hashCode();
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof vr$d)) {
            return false;
        }
        vr$d compareTo = (vr$d) o;
        return compareTo.a == this.a && compareTo.b == this.b;
    }
}
