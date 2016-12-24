package defpackage;

import com.google.gson.internal.$Gson.Types;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory */
public final class ajo implements ais {
    private final aiz a;
    private final aig b;
    private final aja c;

    public ajo(aiz constructorConstructor, aig fieldNamingPolicy, aja excluder) {
        this.a = constructorConstructor;
        this.b = fieldNamingPolicy;
        this.c = excluder;
    }

    public boolean a(Field f, boolean serialize) {
        return ajo.a(f, serialize, this.c);
    }

    static boolean a(Field f, boolean serialize, aja excluder) {
        return (excluder.a(f.getType(), serialize) || excluder.a(f, serialize)) ? false : true;
    }

    private List<String> a(Field f) {
        return ajo.a(this.b, f);
    }

    static List<String> a(aig fieldNamingPolicy, Field f) {
        aiv serializedName = (aiv) f.getAnnotation(aiv.class);
        List<String> fieldNames = new LinkedList();
        if (serializedName == null) {
            fieldNames.add(fieldNamingPolicy.a(f));
        } else {
            fieldNames.add(serializedName.a());
            for (String alternate : serializedName.b()) {
                fieldNames.add(alternate);
            }
        }
        return fieldNames;
    }

    public <T> air<T> a(aih gson, aju<T> type) {
        Class raw = type.getRawType();
        if (Object.class.isAssignableFrom(raw)) {
            return new ajo$a(this.a.a((aju) type), a(gson, (aju) type, raw));
        }
        return null;
    }

    private ajo$b a(aih context, Field field, String name, aju<?> fieldType, boolean serialize, boolean deserialize) {
        return new ajo$1(this, name, serialize, deserialize, context, field, fieldType, ajd.a(fieldType.getRawType()));
    }

    air<?> a(aih gson, Field field, aju<?> fieldType) {
        aiu annotation = (aiu) field.getAnnotation(aiu.class);
        if (annotation != null) {
            air<?> adapter = ajj.a(this.a, gson, fieldType, annotation);
            if (adapter != null) {
                return adapter;
            }
        }
        return gson.a((aju) fieldType);
    }

    private Map<String, ajo$b> a(aih context, aju<?> type, Class<?> raw) {
        Map<String, ajo$b> result = new LinkedHashMap();
        if (!raw.isInterface()) {
            Type declaredType = type.getType();
            while (raw != Object.class) {
                for (Field field : raw.getDeclaredFields()) {
                    boolean serialize = a(field, true);
                    boolean deserialize = a(field, false);
                    if (serialize || deserialize) {
                        field.setAccessible(true);
                        Type fieldType = Types.a(type.getType(), raw, field.getGenericType());
                        List<String> fieldNames = a(field);
                        ajo$b previous = null;
                        for (int i = 0; i < fieldNames.size(); i++) {
                            String name = (String) fieldNames.get(i);
                            if (i != 0) {
                                serialize = false;
                            }
                            ajo$b replaced = (ajo$b) result.put(name, a(context, field, name, aju.get(fieldType), serialize, deserialize));
                            if (previous == null) {
                                previous = replaced;
                            }
                        }
                        if (previous != null) {
                            throw new IllegalArgumentException(declaredType + " declares multiple JSON fields named " + previous.g);
                        }
                    }
                }
                type = aju.get(Types.a(type.getType(), raw, raw.getGenericSuperclass()));
                raw = type.getRawType();
            }
        }
        return result;
    }
}
