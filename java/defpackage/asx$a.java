package defpackage;

/* compiled from: SerialSubscription */
final class asx$a {
    final boolean a;
    final aps b;

    asx$a(boolean u, aps s) {
        this.a = u;
        this.b = s;
    }

    asx$a a() {
        return new asx$a(true, this.b);
    }

    asx$a a(aps s) {
        return new asx$a(this.a, s);
    }
}
