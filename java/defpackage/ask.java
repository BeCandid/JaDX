package defpackage;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: RxJavaPlugins */
public class ask {
    static final ash a = new ask$1();
    private static final ask b = new ask();
    private final AtomicReference<ash> c = new AtomicReference();
    private final AtomicReference<asi> d = new AtomicReference();
    private final AtomicReference<asl> e = new AtomicReference();

    public static ask a() {
        return b;
    }

    ask() {
    }

    public ash b() {
        if (this.c.get() == null) {
            Object impl = ask.a(ash.class, System.getProperties());
            if (impl == null) {
                this.c.compareAndSet(null, a);
            } else {
                this.c.compareAndSet(null, (ash) impl);
            }
        }
        return (ash) this.c.get();
    }

    public asi c() {
        if (this.d.get() == null) {
            Object impl = ask.a(asi.class, System.getProperties());
            if (impl == null) {
                this.d.compareAndSet(null, asj.a());
            } else {
                this.d.compareAndSet(null, (asi) impl);
            }
        }
        return (asi) this.d.get();
    }

    static Object a(Class<?> pluginClass, Properties props) {
        String classSimpleName = pluginClass.getSimpleName();
        String pluginPrefix = "rxjava.plugin.";
        String implementingClass = props.getProperty("rxjava.plugin." + classSimpleName + ".implementation");
        if (implementingClass == null) {
            String classSuffix = ".class";
            String implSuffix = ".impl";
            for (Entry<Object, Object> e : props.entrySet()) {
                String key = e.getKey().toString();
                if (key.startsWith("rxjava.plugin.") && key.endsWith(".class") && classSimpleName.equals(e.getValue().toString())) {
                    String implKey = "rxjava.plugin." + key.substring(0, key.length() - ".class".length()).substring("rxjava.plugin.".length()) + ".impl";
                    implementingClass = props.getProperty(implKey);
                    if (implementingClass == null) {
                        throw new RuntimeException("Implementing class declaration for " + classSimpleName + " missing: " + implKey);
                    }
                }
            }
        }
        if (implementingClass == null) {
            return null;
        }
        try {
            return Class.forName(implementingClass).asSubclass(pluginClass).newInstance();
        } catch (ClassCastException e2) {
            throw new RuntimeException(classSimpleName + " implementation is not an instance of " + classSimpleName + ": " + implementingClass);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException(classSimpleName + " implementation class not found: " + implementingClass, e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException(classSimpleName + " implementation not able to be instantiated: " + implementingClass, e4);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(classSimpleName + " implementation not able to be accessed: " + implementingClass, e5);
        }
    }

    public asl d() {
        if (this.e.get() == null) {
            Object impl = ask.a(asl.class, System.getProperties());
            if (impl == null) {
                this.e.compareAndSet(null, asl.d());
            } else {
                this.e.compareAndSet(null, (asl) impl);
            }
        }
        return (asl) this.e.get();
    }
}
