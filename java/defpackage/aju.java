package defpackage;

import com.google.gson.internal.$Gson.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TypeToken */
public class aju<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    public aju() {
        this.type = aju.getSuperclassTypeParameter(getClass());
        this.rawType = Types.e(this.type);
        this.hashCode = this.type.hashCode();
    }

    aju(Type type) {
        this.type = Types.d((Type) aiy.a((Object) type));
        this.rawType = Types.e(this.type);
        this.hashCode = this.type.hashCode();
    }

    static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (!(superclass instanceof Class)) {
            return Types.d(((ParameterizedType) superclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    @Deprecated
    public boolean isAssignableFrom(Type from) {
        if (from == null) {
            return false;
        }
        if (this.type.equals(from)) {
            return true;
        }
        if (this.type instanceof Class) {
            return this.rawType.isAssignableFrom(Types.e(from));
        }
        if (this.type instanceof ParameterizedType) {
            return aju.isAssignableFrom(from, (ParameterizedType) this.type, new HashMap());
        }
        if (this.type instanceof GenericArrayType) {
            boolean z = this.rawType.isAssignableFrom(Types.e(from)) && aju.isAssignableFrom(from, (GenericArrayType) this.type);
            return z;
        }
        throw aju.buildUnexpectedTypeError(this.type, Class.class, ParameterizedType.class, GenericArrayType.class);
    }

    @Deprecated
    public boolean isAssignableFrom(aju<?> token) {
        return isAssignableFrom(token.getType());
    }

    private static boolean isAssignableFrom(Type from, GenericArrayType to) {
        Type toGenericComponentType = to.getGenericComponentType();
        if (!(toGenericComponentType instanceof ParameterizedType)) {
            return true;
        }
        Type t = from;
        if (from instanceof GenericArrayType) {
            t = ((GenericArrayType) from).getGenericComponentType();
        } else if (from instanceof Class) {
            Class<?> classType = (Class) from;
            while (classType.isArray()) {
                classType = classType.getComponentType();
            }
            Object t2 = classType;
        }
        return aju.isAssignableFrom(t, (ParameterizedType) toGenericComponentType, new HashMap());
    }

    private static boolean isAssignableFrom(Type from, ParameterizedType to, Map<String, Type> typeVarMap) {
        if (from == null) {
            return false;
        }
        if (to.equals(from)) {
            return true;
        }
        Class<?> clazz = Types.e(from);
        ParameterizedType ptype = null;
        if (from instanceof ParameterizedType) {
            ptype = (ParameterizedType) from;
        }
        if (ptype != null) {
            Type[] tArgs = ptype.getActualTypeArguments();
            TypeVariable<?>[] tParams = clazz.getTypeParameters();
            for (int i = 0; i < tArgs.length; i++) {
                Type arg = tArgs[i];
                TypeVariable<?> var = tParams[i];
                while (arg instanceof TypeVariable) {
                    arg = (Type) typeVarMap.get(((TypeVariable) arg).getName());
                }
                typeVarMap.put(var.getName(), arg);
            }
            if (aju.typeEquals(ptype, to, typeVarMap)) {
                return true;
            }
        }
        for (Type itype : clazz.getGenericInterfaces()) {
            if (aju.isAssignableFrom(itype, to, new HashMap(typeVarMap))) {
                return true;
            }
        }
        return aju.isAssignableFrom(clazz.getGenericSuperclass(), to, new HashMap(typeVarMap));
    }

    private static boolean typeEquals(ParameterizedType from, ParameterizedType to, Map<String, Type> typeVarMap) {
        if (!from.getRawType().equals(to.getRawType())) {
            return false;
        }
        Type[] fromArgs = from.getActualTypeArguments();
        Type[] toArgs = to.getActualTypeArguments();
        for (int i = 0; i < fromArgs.length; i++) {
            if (!aju.matches(fromArgs[i], toArgs[i], typeVarMap)) {
                return false;
            }
        }
        return true;
    }

    private static AssertionError buildUnexpectedTypeError(Type token, Class<?>... expected) {
        StringBuilder exceptionMessage = new StringBuilder("Unexpected type. Expected one of: ");
        for (Class<?> clazz : expected) {
            exceptionMessage.append(clazz.getName()).append(", ");
        }
        exceptionMessage.append("but got: ").append(token.getClass().getName()).append(", for type token: ").append(token.toString()).append('.');
        return new AssertionError(exceptionMessage.toString());
    }

    private static boolean matches(Type from, Type to, Map<String, Type> typeMap) {
        return to.equals(from) || ((from instanceof TypeVariable) && to.equals(typeMap.get(((TypeVariable) from).getName())));
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object o) {
        return (o instanceof aju) && Types.a(this.type, ((aju) o).type);
    }

    public final String toString() {
        return Types.f(this.type);
    }

    public static aju<?> get(Type type) {
        return new aju(type);
    }

    public static <T> aju<T> get(Class<T> type) {
        return new aju(type);
    }
}
