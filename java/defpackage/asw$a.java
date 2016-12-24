package defpackage;

/* compiled from: MultipleAssignmentSubscription */
final class asw$a {
    final boolean a;
    final aps b;

    asw$a(boolean u, aps s) {
        this.a = u;
        this.b = s;
    }

    asw$a a() {
        return new asw$a(true, this.b);
    }

    asw$a a(aps s) {
        return new asw$a(this.a, s);
    }
}
