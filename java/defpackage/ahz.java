package defpackage;

import com.google.firebase.iid.FirebaseInstanceId;

public class ahz {
    private final FirebaseInstanceId a;

    private ahz(FirebaseInstanceId firebaseInstanceId) {
        this.a = firebaseInstanceId;
    }

    public static ahz a() {
        return new ahz(FirebaseInstanceId.a());
    }

    public String b() {
        return this.a.c();
    }
}
