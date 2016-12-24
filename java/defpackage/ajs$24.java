package defpackage;

/* compiled from: TypeAdapters */
class ajs$24 implements ais {
    ajs$24() {
    }

    public <T> air<T> a(aih gson, aju<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
            return null;
        }
        if (!rawType.isEnum()) {
            rawType = rawType.getSuperclass();
        }
        return new ajs$a(rawType);
    }
}
