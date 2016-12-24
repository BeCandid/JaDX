package defpackage;

import com.google.gson.internal.$Gson.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: ArrayTypeAdapter */
class ajg$1 implements ais {
    ajg$1() {
    }

    public <T> air<T> a(aih gson, aju<T> typeToken) {
        Type type = typeToken.getType();
        if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        Type componentType = Types.g(type);
        return new ajg(gson, gson.a(aju.get(componentType)), Types.e(componentType));
    }
}
