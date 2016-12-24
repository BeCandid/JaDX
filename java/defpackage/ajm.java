package defpackage;

import com.google.gson.internal.$Gson.Types;
import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory */
public final class ajm implements ais {
    final boolean a;
    private final aiz b;

    public ajm(aiz constructorConstructor, boolean complexMapKeySerialization) {
        this.b = constructorConstructor;
        this.a = complexMapKeySerialization;
    }

    public <T> air<T> a(aih gson, aju<T> typeToken) {
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Type[] keyAndValueTypes = Types.b(type, Types.e(type));
        return new ajm$a(this, gson, keyAndValueTypes[0], a(gson, keyAndValueTypes[0]), keyAndValueTypes[1], gson.a(aju.get(keyAndValueTypes[1])), this.b.a((aju) typeToken));
    }

    private air<?> a(aih context, Type keyType) {
        if (keyType == Boolean.TYPE || keyType == Boolean.class) {
            return ajs.f;
        }
        return context.a(aju.get(keyType));
    }
}
