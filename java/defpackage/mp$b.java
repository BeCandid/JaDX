package defpackage;

/* compiled from: LazyHeaders */
final class mp$b implements mo {
    private final String a;

    mp$b(String value) {
        this.a = value;
    }

    public String a() {
        return this.a;
    }

    public String toString() {
        return "StringHeaderFactory{value='" + this.a + '\'' + '}';
    }

    public boolean equals(Object o) {
        if (!(o instanceof mp$b)) {
            return false;
        }
        return this.a.equals(((mp$b) o).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
