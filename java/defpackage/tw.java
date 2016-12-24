package defpackage;

/* compiled from: UserMetaData */
public class tw {
    public static final tw a = new tw();
    public final String b;
    public final String c;
    public final String d;

    public tw() {
        this(null, null, null);
    }

    public tw(String id, String name, String email) {
        this.b = id;
        this.c = name;
        this.d = email;
    }

    public boolean a() {
        return this.b == null && this.c == null && this.d == null;
    }
}
