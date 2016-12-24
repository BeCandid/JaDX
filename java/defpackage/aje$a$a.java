package defpackage;

/* compiled from: Streams */
class aje$a$a implements CharSequence {
    char[] a;

    aje$a$a() {
    }

    public int length() {
        return this.a.length;
    }

    public char charAt(int i) {
        return this.a[i];
    }

    public CharSequence subSequence(int start, int end) {
        return new String(this.a, start, end - start);
    }
}
