package defpackage;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* compiled from: ConstructorConstructor */
class aiz$10 implements ajc<T> {
    final /* synthetic */ Type a;
    final /* synthetic */ aiz b;

    aiz$10(aiz this$0, Type type) {
        this.b = this$0;
        this.a = type;
    }

    public T a() {
        if (this.a instanceof ParameterizedType) {
            Type elementType = ((ParameterizedType) this.a).getActualTypeArguments()[0];
            if (elementType instanceof Class) {
                return EnumSet.noneOf((Class) elementType);
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
        }
        throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
    }
}
