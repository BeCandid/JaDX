package defpackage;

import android.graphics.Bitmap.Config;

/* compiled from: SizeConfigStrategy */
final class lt$a implements ls {
    private final lt$b a;
    private int b;
    private Config c;

    public lt$a(lt$b pool) {
        this.a = pool;
    }

    public void a(int size, Config config) {
        this.b = size;
        this.c = config;
    }

    public void a() {
        this.a.a(this);
    }

    public String toString() {
        return lt.b(this.b, this.c);
    }

    public boolean equals(Object o) {
        if (!(o instanceof lt$a)) {
            return false;
        }
        lt$a other = (lt$a) o;
        if (this.b != other.b) {
            return false;
        }
        if (this.c == null) {
            if (other.c != null) {
                return false;
            }
        } else if (!this.c.equals(other.c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.b * 31) + (this.c != null ? this.c.hashCode() : 0);
    }
}
