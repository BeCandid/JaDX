package defpackage;

/* compiled from: SignUpEvent */
public class sk extends rz<sk> {
    public sk a(String signUpMethod) {
        this.c.a("method", signUpMethod);
        return this;
    }

    public sk a(boolean signUpSucceeded) {
        this.c.a("success", Boolean.toString(signUpSucceeded));
        return this;
    }

    String b() {
        return "signUp";
    }
}
