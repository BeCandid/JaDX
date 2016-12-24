package defpackage;

/* compiled from: CustomEvent */
public class ru extends rm<ru> {
    private final String c;

    public ru(String eventName) {
        if (eventName == null) {
            throw new NullPointerException("eventName must not be null");
        }
        this.c = this.a.a(eventName);
    }

    public String b() {
        return this.c;
    }

    public String toString() {
        return "{eventName:\"" + this.c + '\"' + ", customAttributes:" + this.b + "}";
    }
}
