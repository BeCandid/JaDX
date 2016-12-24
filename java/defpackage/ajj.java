package defpackage;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory */
public final class ajj implements ais {
    private final aiz a;

    public ajj(aiz constructorConstructor) {
        this.a = constructorConstructor;
    }

    public <T> air<T> a(aih gson, aju<T> targetType) {
        aiu annotation = (aiu) targetType.getRawType().getAnnotation(aiu.class);
        if (annotation == null) {
            return null;
        }
        return ajj.a(this.a, gson, targetType, annotation);
    }

    static air<?> a(aiz constructorConstructor, aih gson, aju<?> fieldType, aiu annotation) {
        air<?> typeAdapter;
        Class<?> value = annotation.a();
        if (air.class.isAssignableFrom(value)) {
            typeAdapter = (air) constructorConstructor.a(aju.get((Class) value)).a();
        } else if (ais.class.isAssignableFrom(value)) {
            typeAdapter = ((ais) constructorConstructor.a(aju.get((Class) value)).a()).a(gson, fieldType);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
        }
        if (typeAdapter != null) {
            return typeAdapter.a();
        }
        return typeAdapter;
    }
}
