package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* compiled from: ConstructorConstructor */
public final class aiz {
    private final Map<Type, aii<?>> a;

    public aiz(Map<Type, aii<?>> instanceCreators) {
        this.a = instanceCreators;
    }

    public <T> ajc<T> a(aju<T> typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        aii<T> typeCreator = (aii) this.a.get(type);
        if (typeCreator != null) {
            return new aiz$1(this, typeCreator, type);
        }
        aii<T> rawTypeCreator = (aii) this.a.get(rawType);
        if (rawTypeCreator != null) {
            return new aiz$7(this, rawTypeCreator, type);
        }
        ajc<T> defaultConstructor = a(rawType);
        if (defaultConstructor != null) {
            return defaultConstructor;
        }
        ajc<T> defaultImplementation = a(type, rawType);
        if (defaultImplementation != null) {
            return defaultImplementation;
        }
        return b(type, rawType);
    }

    private <T> ajc<T> a(Class<? super T> rawType) {
        try {
            Constructor<? super T> constructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return new aiz$8(this, constructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> ajc<T> a(Type type, Class<? super T> rawType) {
        if (Collection.class.isAssignableFrom(rawType)) {
            if (SortedSet.class.isAssignableFrom(rawType)) {
                return new aiz$9(this);
            }
            if (EnumSet.class.isAssignableFrom(rawType)) {
                return new aiz$10(this, type);
            }
            if (Set.class.isAssignableFrom(rawType)) {
                return new aiz$11(this);
            }
            if (Queue.class.isAssignableFrom(rawType)) {
                return new aiz$12(this);
            }
            return new aiz$13(this);
        } else if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(rawType)) {
                return new aiz$14(this);
            }
            if (ConcurrentMap.class.isAssignableFrom(rawType)) {
                return new aiz$2(this);
            }
            if (SortedMap.class.isAssignableFrom(rawType)) {
                return new aiz$3(this);
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(aju.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new aiz$5(this);
            }
            return new aiz$4(this);
        }
    }

    private <T> ajc<T> b(Type type, Class<? super T> rawType) {
        return new aiz$6(this, rawType, type);
    }

    public String toString() {
        return this.a.toString();
    }
}
