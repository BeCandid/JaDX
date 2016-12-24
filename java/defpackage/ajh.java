package defpackage;

import com.google.gson.internal.$Gson.Types;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: CollectionTypeAdapterFactory */
public final class ajh implements ais {
    private final aiz a;

    public ajh(aiz constructorConstructor) {
        this.a = constructorConstructor;
    }

    public <T> air<T> a(aih gson, aju<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type elementType = Types.a(type, rawType);
        return new ajh$a(gson, elementType, gson.a(aju.get(elementType)), this.a.a((aju) typeToken));
    }
}
