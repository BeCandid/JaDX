package defpackage;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* compiled from: Excluder */
public final class aja implements ais, Cloneable {
    public static final aja a = new aja();
    private double b = -1.0d;
    private int c = 136;
    private boolean d = true;
    private boolean e;
    private List<aie> f = Collections.emptyList();
    private List<aie> g = Collections.emptyList();

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    protected aja a() {
        try {
            return (aja) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public <T> air<T> a(aih gson, aju<T> type) {
        Class rawType = type.getRawType();
        boolean skipSerialize = a(rawType, true);
        boolean skipDeserialize = a(rawType, false);
        if (skipSerialize || skipDeserialize) {
            return new aja$1(this, skipDeserialize, skipSerialize, gson, type);
        }
        return null;
    }

    public boolean a(Field field, boolean serialize) {
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if (this.b != -1.0d && !a((aiw) field.getAnnotation(aiw.class), (aix) field.getAnnotation(aix.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.e) {
            ait annotation = (ait) field.getAnnotation(ait.class);
            if (annotation == null || (serialize ? !annotation.a() : !annotation.b())) {
                return true;
            }
        }
        if (!this.d && b(field.getType())) {
            return true;
        }
        if (a(field.getType())) {
            return true;
        }
        List<aie> list = serialize ? this.f : this.g;
        if (!list.isEmpty()) {
            aif fieldAttributes = new aif(field);
            for (aie exclusionStrategy : list) {
                if (exclusionStrategy.a(fieldAttributes)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(Class<?> clazz, boolean serialize) {
        if (this.b != -1.0d && !a((aiw) clazz.getAnnotation(aiw.class), (aix) clazz.getAnnotation(aix.class))) {
            return true;
        }
        if (!this.d && b(clazz)) {
            return true;
        }
        if (a((Class) clazz)) {
            return true;
        }
        for (aie exclusionStrategy : serialize ? this.f : this.g) {
            if (exclusionStrategy.a((Class) clazz)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Class<?> clazz) {
        return !Enum.class.isAssignableFrom(clazz) && (clazz.isAnonymousClass() || clazz.isLocalClass());
    }

    private boolean b(Class<?> clazz) {
        return clazz.isMemberClass() && !c(clazz);
    }

    private boolean c(Class<?> clazz) {
        return (clazz.getModifiers() & 8) != 0;
    }

    private boolean a(aiw since, aix until) {
        return a(since) && a(until);
    }

    private boolean a(aiw annotation) {
        if (annotation == null || annotation.a() <= this.b) {
            return true;
        }
        return false;
    }

    private boolean a(aix annotation) {
        if (annotation == null || annotation.a() > this.b) {
            return true;
        }
        return false;
    }
}
