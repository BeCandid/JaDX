package defpackage;

/* compiled from: WireFormat */
public final class ty {
    static final int a = ty.a(1, 3);
    static final int b = ty.a(1, 4);
    static final int c = ty.a(2, 0);
    static final int d = ty.a(3, 2);

    public static int a(int fieldNumber, int wireType) {
        return (fieldNumber << 3) | wireType;
    }
}
